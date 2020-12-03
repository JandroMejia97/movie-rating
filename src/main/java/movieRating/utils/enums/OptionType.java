package main.java.movieRating.utils.enums;

public enum OptionType {
    CINCO(5),
    DIEZ(10),
    VEINTE(20),
    CIEN(100),
    MIL(1000),
    TODOS(Integer.MAX_VALUE, "TODOS");

    private final int value;
    private final String key;

    OptionType(Integer value) {
        this.value = value;
        this.key = value.toString();
    }

    OptionType(int value, String key) {
        this.value = value;
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key;
    }
}
