package application;

import org.example.adapters.gateway.CommonProductH2RegisterGateway;
import org.example.application.ICommonProductPresenter;
import org.example.application.interactors.CommonProductInputBoundary;
import org.example.application.models.CommonProductRequestModel;
import org.example.application.models.CommonProductResponseModel;
import org.example.domain.ICommonProductFactory;
import org.example.domain.IProduct;
import org.example.domain.products.CommonProduct;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommonProductBoundaryTest {

    @InjectMocks
    CommonProductInputBoundary interactor;

    @Mock
    ICommonProductPresenter presenterMock;

    @Mock
    ICommonProductFactory factoryMock;

    @Mock
    CommonProductH2RegisterGateway gatewayMock;

    @Mock
    CommonProduct commonProductMock;

    @BeforeAll
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateWhenIdDoesNotExistAndNameIsValidThenReturnSuccessfully() {

        long epochInMilli = 1740478072098L;
        String id = "SOME_ID";
        String name = "SOME_NAME";
        String description = "SOME_DESCRIPTION";
        double price = 2.0;

        CommonProductRequestModel requestModelSpy = spy(CommonProductRequestModel.class);
        requestModelSpy.setId(id);
        requestModelSpy.setName(name);
        requestModelSpy.setDescription(description);
        requestModelSpy.setPrice(price);

        doReturn(requestModelSpy.getId()).when(commonProductMock).getId();
        doReturn(requestModelSpy.getName()).when(commonProductMock).getName();
        doReturn(requestModelSpy.getDescription()).when(commonProductMock).getDescription();
        doReturn(requestModelSpy.getPrice()).when(commonProductMock).getPrice();
        when(commonProductMock.getCreatedAt()).thenReturn(epochInMilli);

        when(factoryMock.create(anyString(), anyString(), anyString(), anyDouble())).thenReturn(commonProductMock);
        when(gatewayMock.existsById(anyString())).thenReturn(false);

        CommonProductResponseModel commonProductResponseModel = interactor.create(requestModelSpy);

        verify(gatewayMock, atMostOnce()).save(any(IProduct.class));

        assertEquals(commonProductResponseModel.getId(), id);
        assertEquals(commonProductResponseModel.getName(), name);
        assertEquals(commonProductResponseModel.getDescription(), description);
        assertEquals(commonProductResponseModel.getPrice(), 2.0);
        assertEquals(commonProductResponseModel.getCreatedAt(), "2025-02-25");
    }

}
