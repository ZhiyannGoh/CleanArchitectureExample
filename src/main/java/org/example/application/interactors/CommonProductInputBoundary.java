package org.example.application.interactors;

import org.example.adapters.IProductRegisterGateway;
import org.example.application.ICommonProductPresenter;
import org.example.application.ICommonProductInputBoundary;
import org.example.adapters.gateway.CommonProductH2RegisterGateway;
import org.example.application.models.CommonProductRequestModel;
import org.example.application.models.CommonProductResponseModel;
import org.example.domain.ICommonProductFactory;
import org.example.domain.IProduct;
import org.example.exceptions.CommonProductException;

public class CommonProductInputBoundary implements ICommonProductInputBoundary {
    ICommonProductPresenter presenter;
    ICommonProductFactory factory;
    IProductRegisterGateway gateway;

    public CommonProductInputBoundary(ICommonProductPresenter presenter, ICommonProductFactory factory, CommonProductH2RegisterGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }

    /**
     * @param requestModel Incoming product request from client
     * @return {@link CommonProductResponseModel} the response the creation
     */
    @Override
    public CommonProductResponseModel create(CommonProductRequestModel requestModel) throws CommonProductException {

        IProduct commonProduct = factory.create(requestModel.getId(), requestModel.getName(),
                requestModel.getDescription(), requestModel.getPrice());

        if (commonProduct.isNameValid()) {
            presenter.prepareError(new CommonProductException("Name validation failed"));
        }

        if (gateway.existsById(requestModel.getId())) {
            presenter.prepareError(new CommonProductException("Product with id " + requestModel.getId()));
        }

        gateway.save(commonProduct);

        return presenter.prepareSuccess(commonProduct);
    }
}
