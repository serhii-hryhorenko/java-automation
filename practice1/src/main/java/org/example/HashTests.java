package org.example;

import java.util.Map;

public class HashTests {
    public static void main(String[] args) {
        Map<ValidClass, String> correctMap = Map.of(
                new ValidClass(1, "Alice"), "Alice",
                new ValidClass(2, "Robert"), "Bob"
        );
        System.out.println("ValidClass map: " + correctMap);

        Map<InvalidClass, String> invalidMap = Map.of(
                new InvalidClass(1, "Jane"), "Alice",
                new InvalidClass(2, "Bob"), "Robert"
        );
        System.out.println("IncorrectClass map: " + invalidMap);
    }
}