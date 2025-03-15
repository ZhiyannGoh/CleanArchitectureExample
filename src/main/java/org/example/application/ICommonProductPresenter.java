package org.example.application;

import org.example.application.models.CommonProductResponseModel;
import org.example.domain.IProduct;
import org.example.exceptions.CommonProductException;

public interface ICommonProductPresenter {

    void prepareError(CommonProductException commonProductException);

    CommonProductResponseModel prepareSuccess(IProduct iProduct);

}
