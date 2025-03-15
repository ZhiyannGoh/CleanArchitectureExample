package org.example.adapters.db.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "common_product")
public class CommonProductEntityModel {
    @Id
    String id;
    String name;
    String description;
    double price;
    long createdAt;

    public CommonProductEntityModel(String id, String name, String description, double price, long createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
    }
}
