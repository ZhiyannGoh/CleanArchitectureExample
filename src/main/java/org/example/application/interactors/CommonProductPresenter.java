package org.example.application.interactors;

import org.example.application.ICommonProductPresenter;
import org.example.application.models.CommonProductResponseModel;
import org.example.domain.IProduct;
import org.example.domain.products.CommonProduct;
import org.example.exceptions.CommonProductException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CommonProductPresenter implements ICommonProductPresenter {

    private static final String DATE_DISPLAY_FORMAT = "yyyy-MM-dd";

    @Override
    public void prepareError(CommonProductException commonProductException) {
        throw commonProductException;
    }

    @Override
    public CommonProductResponseModel prepareSuccess(IProduct iProduct) {
        CommonProductResponseModel commonProductResponseModel = new CommonProductResponseModel(iProduct.getId(),
                iProduct.getName(), iProduct.getDescription(),
                iProduct.getPrice(), getDisplayFormat((CommonProduct) iProduct));
        commonProductResponseModel.setMetadata(getMetadataInformation());
        return commonProductResponseModel;
    }

    private List<String> getMetadataInformation() {
        // TODO: Can be method to get metadata from some configuration
        return new ArrayList<>();
    }

    private static String getDisplayFormat(CommonProduct commonProduct) {
        Instant instant = Instant.ofEpochMilli(commonProduct.getCreatedAt());
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_DISPLAY_FORMAT);
        return localDate.format(formatter);
    }
}
