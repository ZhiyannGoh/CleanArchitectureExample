package org.example.domain.products.factory;

import org.example.domain.ICommonProductFactory;
import org.example.domain.IProduct;
import org.example.domain.products.CommonProduct;

import java.time.Instant;

/**
 * Provide stable abstractions, and isolate product creation
 */
public class CommonProductFactory implements ICommonProductFactory {
    @Override
    public IProduct create(String id, String name, String description, double price) {
        return new CommonProduct(id, name, description, price, Instant.now().toEpochMilli());
    }
}
