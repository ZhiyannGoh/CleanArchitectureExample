package org.example.application.models;

import java.util.List;

public class CommonProductResponseModel {
    String id;
    String name;
    String description;
    double price;
    String createdAt;
    List<String> metadata;

    public CommonProductResponseModel(String id, String name, String description, double price, String createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setMetadata(List<String> metadata) {
        this.metadata = metadata;
    }
}
