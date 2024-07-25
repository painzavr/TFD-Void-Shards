package org.example;

public enum Type {
    NonAttribute("Нестихийный"),
    Chill("Холод"),
    Electricity("Электричество"),
    Fire("Горение"),
    Toxin("Яд");

    private final String name;

    Type(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
