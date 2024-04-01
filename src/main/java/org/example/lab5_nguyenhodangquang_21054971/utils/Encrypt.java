package org.example.lab5_nguyenhodangquang_21054971.utils;

public class Encrypt {
    public static String encrypt(String message) {
        return new StringBuilder(message).reverse().toString();
    }

    public static String decrypt(String message) {
        return new StringBuilder(message).reverse().toString();
    }
}
