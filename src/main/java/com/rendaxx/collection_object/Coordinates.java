package com.rendaxx.collection_object;

public record Coordinates(Float x, Double y) {
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
