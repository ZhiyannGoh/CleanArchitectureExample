package org.example.adapters.http;

import org.example.application.ICommonProductInputBoundary;
import org.example.application.models.CommonProductRequestModel;
import org.example.application.models.CommonProductResponseModel;
import org.example.exceptions.CommonProductException;

public class CommonProductRegisterController {

    ICommonProductInputBoundary inputBoundary;

    public CommonProductRegisterController(ICommonProductInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public CommonProductResponseModel create(CommonProductRequestModel commonProductRequestModel) throws CommonProductException{
        return this.inputBoundary.create(commonProductRequestModel);
    }

}
