package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String input = "Hello, World";

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

        System.out.println("MD5: " + hashString(md5, input));
        System.out.println("SHA-1: " + hashString(sha1, input));
        System.out.println("SHA-256: " + hashString(sha256, input));

        try (FileWriter writer = new FileWriter("hashes.txt", true)) {
            writer.write("MD5: " + hashString(md5, input) + "\n");
            writer.write("SHA-1: " + hashString(sha1, input) + "\n");
            writer.write("SHA-256: " + hashString(sha256, input) + "\n");
        }
    }

    private static String hashString(MessageDigest md, String input) {
        byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));

        return new String(hash, StandardCharsets.UTF_8);
    }
}
