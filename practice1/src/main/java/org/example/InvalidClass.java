package org.example;

public class InvalidClass {
    private final int id;
    private final String name;

    public InvalidClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return id + name.length();
    }
}
