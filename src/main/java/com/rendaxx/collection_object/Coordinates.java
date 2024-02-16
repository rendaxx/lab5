package com.rendaxx.collection_object;

public record Coordinates(Double x, Double y) {
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
