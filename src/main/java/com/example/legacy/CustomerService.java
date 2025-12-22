package com.example.legacy;

// import javax.xml.bind.JAXBContext;
// import javax.xml.bind.JAXBException;
// import javax.xml.bind.Marshaller;
// import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * レガシーな顧客管理サービス
 * JDK 8時代のコードで、削除されたJAXB APIを使用している
 */
public class CustomerService {

    private List<Customer> customers = new ArrayList<>();

    /**
     * 顧客を追加する
     */
    public void addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (customer.getId() == null || customer.getId().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be empty");
        }
        customers.add(customer);
    }

    /**
     * IDで顧客を検索する（複雑な処理の例）
     */
    public Customer findCustomerById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }

        return null;
    }

    /**
     * アクティブな顧客のみを取得（複雑度テスト用）
     */
    public List<Customer> getActiveCustomers() {
        List<Customer> activeCustomers = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.isActive()) {
                if (customer.getBalance() > 0) {
                    activeCustomers.add(customer);
                } else if (customer.isPremium()) {
                    activeCustomers.add(customer);
                }
            }
        }

        return activeCustomers;
    }

    /**
     * 顧客情報をXMLに変換する（削除されたJAXB APIを使用）
     * これがターゲットメソッドとして選ばれるはず
     * JDK 21では動作しないためコメントアウト
     */
    /*
     * public String exportCustomerToXml(Customer customer) throws JAXBException {
     * if (customer == null) {
     * throw new IllegalArgumentException("Customer cannot be null");
     * }
     * 
     * JAXBContext context = JAXBContext.newInstance(Customer.class);
     * Marshaller marshaller = context.createMarshaller();
     * marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
     * 
     * StringWriter writer = new StringWriter();
     * marshaller.marshal(customer, writer);
     * 
     * return writer.toString();
     * }
     */

    /**
     * 顧客の総数を取得（シンプルなメソッド）
     */
    public int getCustomerCount() {
        return customers.size();
    }

    /**
     * すべての顧客をクリア
     */
    public void clearAllCustomers() {
        customers.clear();
    }

    // 内部クラス：顧客データ
    public static class Customer {
        private String id;
        private String name;
        private boolean active;
        private double balance;
        private boolean premium;

        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
            this.active = true;
            this.balance = 0.0;
            this.premium = false;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public boolean isPremium() {
            return premium;
        }

        public void setPremium(boolean premium) {
            this.premium = premium;
        }
    }
}
