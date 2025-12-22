package com.example.legacy.util;

public class StringUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String toUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String truncate(String str, int length) {
        if (str == null) {
            return null;
        }
        if (str.length() <= length) {
            return str;
        }
        return str.substring(0, length);
    }
}
