package com.example.legacy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 複雑で巨大なメソッドを持つレガシーなインボイス計算サービス
 * 高いサイクロマティック複雑度を持つ
 */
public class ComplexInvoiceService {

    public static class InvoiceItem {
        private String itemId;
        private String category;
        private double unitPrice;
        private int quantity;
        private boolean isTaxable;
        private boolean isDiscountable;

        public InvoiceItem(String itemId, String category, double unitPrice, int quantity, boolean isTaxable,
                boolean isDiscountable) {
            this.itemId = itemId;
            this.category = category;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
            this.isTaxable = isTaxable;
            this.isDiscountable = isDiscountable;
        }

        // Getters
        public String getItemId() {
            return itemId;
        }

        public String getCategory() {
            return category;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public int getQuantity() {
            return quantity;
        }

        public boolean isTaxable() {
            return isTaxable;
        }

        public boolean isDiscountable() {
            return isDiscountable;
        }
    }

    public static class CalculationResult {
        public BigDecimal totalAmount;
        public BigDecimal taxAmount;
        public BigDecimal discountAmount;
        public List<String> errorMessages = new ArrayList<>();
        public boolean success;
    }

    /**
     * 請求金額計算を行う巨大なメソッド
     * 複雑なビジネスロジック、多数の分岐、ネストされたループを含む
     */
    public CalculationResult calculateInvoice(SimpleCustomerData customer, List<InvoiceItem> items, String regionCode,
            boolean isExpedited, LocalDate processingDate) {
        CalculationResult result = new CalculationResult();
        BigDecimal subTotal = BigDecimal.ZERO;
        BigDecimal totalTax = BigDecimal.ZERO;
        BigDecimal totalDiscount = BigDecimal.ZERO;
        result.success = true;

        // 入力検証ブロック（ガード節になっていないためネストが深くなる）
        if (customer != null) {
            if (items != null && !items.isEmpty()) {
                if (regionCode != null && !regionCode.isEmpty()) {

                    // 顧客ランク判定ロジック
                    int customerTier = 0; // 0: Standard, 1: Silver, 2: Gold
                    if (customer.getEmail() != null && customer.getEmail().endsWith("@partner.com")) {
                        customerTier = 2;
                    } else if (customer.getFirstName() != null && customer.getFirstName().startsWith("VIP")) {
                        customerTier = 1;
                    }

                    // メインのアイテム処理ループ
                    for (int i = 0; i < items.size(); i++) {
                        InvoiceItem item = items.get(i);

                        // アイテム検証
                        if (item.getQuantity() <= 0) {
                            result.errorMessages
                                    .add("Item " + item.getItemId() + " (Index: " + i + ") has invalid quantity.");
                            continue; // 次のアイテムへ
                        }

                        if (item.getUnitPrice() < 0) {
                            result.success = false;
                            result.errorMessages.add("Critical Error: Negative price for item " + item.getItemId());
                            break; // 処理中断
                        }

                        BigDecimal itemBasePrice = BigDecimal.valueOf(item.getUnitPrice())
                                .multiply(BigDecimal.valueOf(item.getQuantity()));

                        // 割引計算ロジック
                        BigDecimal itemDiscount = BigDecimal.ZERO;
                        if (item.isDiscountable()) {
                            // 複雑な条件分岐
                            if (customerTier == 2) {
                                itemDiscount = itemBasePrice.multiply(new BigDecimal("0.15")); // 15% OFF
                            } else if (customerTier == 1) {
                                if (itemBasePrice.compareTo(new BigDecimal("1000")) > 0) {
                                    itemDiscount = itemBasePrice.multiply(new BigDecimal("0.10"));
                                } else {
                                    itemDiscount = itemBasePrice.multiply(new BigDecimal("0.05"));
                                }
                            } else {
                                // Standard customer logic
                                if (processingDate.getDayOfWeek() == DayOfWeek.FRIDAY
                                        && "ELECTRONICS".equals(item.getCategory())) {
                                    itemDiscount = itemBasePrice.multiply(new BigDecimal("0.02")); // Fancy Friday
                                                                                                   // discount
                                } else if (item.getQuantity() >= 10) {
                                    itemDiscount = itemBasePrice.multiply(new BigDecimal("0.03")); // Bulk discount
                                }
                            }

                            // 季節性割引（ハードコード）
                            if (processingDate.getMonthValue() == 12 && "GIFT".equals(item.getCategory())) {
                                itemDiscount = itemDiscount.add(itemBasePrice.multiply(new BigDecimal("0.05")));
                            }
                        }

                        // 割引の上限チェック
                        if (itemDiscount.compareTo(itemBasePrice.multiply(new BigDecimal("0.5"))) > 0) {
                            itemDiscount = itemBasePrice.multiply(new BigDecimal("0.5"));
                        }

                        BigDecimal priceAfterDiscount = itemBasePrice.subtract(itemDiscount);
                        totalDiscount = totalDiscount.add(itemDiscount);

                        // 税計算ロジック
                        BigDecimal itemTax = BigDecimal.ZERO;
                        if (item.isTaxable()) {
                            double taxRate = 0.0;
                            // 地域別税率スイッチング
                            switch (regionCode) {
                                case "JP":
                                    taxRate = 0.10;
                                    // 軽減税率
                                    if ("FOOD".equals(item.getCategory())) {
                                        taxRate = 0.08;
                                    }
                                    break;
                                case "US_CA":
                                    taxRate = 0.0725;
                                    break;
                                case "US_NY":
                                    taxRate = 0.088; // 簡易値
                                    if (priceAfterDiscount.compareTo(new BigDecimal("110")) < 0
                                            && "CLOTHING".equals(item.getCategory())) {
                                        taxRate = 0.0; // 免税措置
                                    }
                                    break;
                                case "EU_DE":
                                    taxRate = 0.19;
                                    break;
                                default:
                                    taxRate = 0.05; // Default international
                            }

                            itemTax = priceAfterDiscount.multiply(BigDecimal.valueOf(taxRate));

                            // 税計算の端数処理ルール
                            if (regionCode.startsWith("JP")) {
                                itemTax = itemTax.setScale(0, RoundingMode.DOWN);
                            } else {
                                itemTax = itemTax.setScale(2, RoundingMode.HALF_UP);
                            }
                        }

                        totalTax = totalTax.add(itemTax);
                        subTotal = subTotal.add(priceAfterDiscount);
                    }

                    // 急ぎ便の追加料金
                    if (isExpedited) {
                        BigDecimal expeditedFee = new BigDecimal("500");
                        // ゴールド会員は無料
                        if (customerTier == 2) {
                            expeditedFee = BigDecimal.ZERO;
                        } else if (subTotal.compareTo(new BigDecimal("10000")) > 0) {
                            expeditedFee = expeditedFee.multiply(new BigDecimal("0.5"));
                        }
                        subTotal = subTotal.add(expeditedFee);
                    }

                    // 最終集計
                    if (result.success) {
                        result.totalAmount = subTotal.add(totalTax);
                        result.taxAmount = totalTax;
                        result.discountAmount = totalDiscount;
                    }

                } else {
                    result.success = false;
                    result.errorMessages.add("Invalid region code");
                }
            } else {
                result.success = false;
                result.errorMessages.add("Item list cannot be empty");
            }
        } else {
            result.success = false;
            result.errorMessages.add("Customer cannot be null");
        }

        // 謎のレガシーロジック（値を丸めて文字列変換してから戻す等）
        if (result.totalAmount != null && customer != null) {
            // ログ出力用文字列生成（実際にはログに出すが、ここでは処理の一部として残っている）
            String logSummary = "CALC_END: " + customer.getEmail() + " | " + result.totalAmount;
            if (logSummary.length() > 200) {
                // 異常に長い場合は何かフラグを立てる（副作用のあるロジック例）
                System.out.println("Warning: Suspiciously large log entry");
            }
        }

        return result;
    }
}
