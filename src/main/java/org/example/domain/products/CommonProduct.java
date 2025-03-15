package org.example.domain.products;

import org.example.domain.IProduct;

public class CommonProduct extends BaseProduct implements IProduct {
    private static final int MINIMUM_CHARACTER_LIMIT = 5;

    public CommonProduct(String id, String name, String description, double price, long createdAt) {
        super(id, name, description, price, createdAt);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    public long getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    public boolean isNameValid() {
        String name = super.getName();
        return name != null && name.length() >= MINIMUM_CHARACTER_LIMIT;
    }
}
