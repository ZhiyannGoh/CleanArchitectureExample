package org.example.adapters;

import org.example.domain.IProduct;

/**
 *
 */
public interface IProductRegisterGateway {
    boolean existsById(String id);

    void save(IProduct iProduct);
}
