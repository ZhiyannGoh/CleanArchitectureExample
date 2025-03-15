package org.example.domain.products;

import org.example.domain.ITechnicalProduct;

public class TechnicalProduct implements ITechnicalProduct {

    private static final int MINIMUM_CHARACTER_LIMIT = 6;

    private String id;
    private String name;
    private String description;
    private double price;
    private String technicalInformation;
    private String instructionManual;

    public TechnicalProduct(String id, String name, String description, double price, String technicalInformation, String instructionManual) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.technicalInformation = technicalInformation;
        this.instructionManual = instructionManual;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isNameValid() {
        return name != null && name.length() >= MINIMUM_CHARACTER_LIMIT;
    }

    @Override
    public String getTechnicalInformation() {
        return technicalInformation;
    }

    @Override
    public String getInstructionManual() {
        return instructionManual;
    }

    @Override
    public boolean technicalInformationIsValid() {
        return technicalInformation.isEmpty();
    }
}
