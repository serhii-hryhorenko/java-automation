package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class SecureRandomExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] randomBytes1 = new byte[16];
        secureRandom.nextBytes(randomBytes1);

        SecureRandom secureRandom2 = SecureRandom.getInstance("NativePRNG");
        byte[] randomBytes2 = new byte[16];
        secureRandom2.nextBytes(randomBytes2);

        SecureRandom secureRandom3 = SecureRandom.getInstance("DRBG");
        byte[] randomBytes3 = new byte[16];
        secureRandom3.nextBytes(randomBytes3);

        System.out.println("SHA1PRNG: " + toString(randomBytes1));
        System.out.println("NativePRNG: " + toString(randomBytes2));
        System.out.println("DRBG: " + toString(randomBytes3));

        try (FileWriter writer = new FileWriter("hashes.txt", true)) {
            writer.write("SHA1PRNG: " + Arrays.toString(randomBytes1) + "\n");
            writer.write("NativePRNG: " + Arrays.toString(randomBytes2) + "\n");
            writer.write("DRBG: " + Arrays.toString(randomBytes3) + "\n");
        }
    }

    private static String toString(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
