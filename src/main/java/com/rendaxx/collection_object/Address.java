package com.rendaxx.collection_object;

public record Address(String street, String zipCode) {

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
