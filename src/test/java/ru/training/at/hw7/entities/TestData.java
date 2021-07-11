package ru.training.at.hw7.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {
    private final int[] summary;
    private final String[] elements;
    private final String color;
    private final String metals;
    private final String[] vegetables;

    public TestData(int[] summary, String[] elements, String color, String metals, String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public String getExpectedResult() {
        List<String> result = new ArrayList<>();
        result.add("Summary: " + Arrays.stream(summary).sum());
        result.add("Elements: " + Arrays.stream(elements).reduce((s1, s2) -> s1 + ", " + s2).get());
        result.add("Color: " + color);
        result.add("Metal: " + metals);
        result.add("Vegetables: " + Arrays.stream(vegetables).reduce((s1, s2) -> s1 + ", " + s2).get());

        return result.stream().reduce((s1, s2) -> s1 + "; " + s2).get();
    }

    public int[] getSummary() {
        return summary;
    }

    public String[] getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }
}
