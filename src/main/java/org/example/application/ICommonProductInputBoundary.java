package org.example.application;

import org.example.application.models.CommonProductRequestModel;
import org.example.application.models.CommonProductResponseModel;

/**
 * Exposes unique functionality (use case) to the outer layer
 */
public interface ICommonProductInputBoundary {
    CommonProductResponseModel create(CommonProductRequestModel requestModel);
}
