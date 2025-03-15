package org.example.domain;

public interface ICommonProductFactory {
    IProduct create(String id, String name, String description, double price);
}
