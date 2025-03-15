package org.example.adapters.gateway;

import org.example.adapters.IProductRegisterGateway;
import org.example.adapters.db.CommonProductRepository;
import org.example.adapters.db.models.CommonProductEntityModel;
import org.example.domain.IProduct;
import org.example.domain.products.CommonProduct;

public class CommonProductH2RegisterGateway implements IProductRegisterGateway {

    CommonProductRepository repository;

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    @Override
    public void save(IProduct iProduct) {
        CommonProductEntityModel commonProductEntityModel = new CommonProductEntityModel(iProduct.getId(),
                iProduct.getName(), iProduct.getDescription(),
                iProduct.getPrice(), ((CommonProduct) iProduct).getCreatedAt());
        repository.save(commonProductEntityModel);
    }
}
