package domain;

import org.example.domain.IProduct;
import org.example.domain.products.CommonProduct;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CommonProductTest {

    @Test
    public void testCommonProductWhenStringIsInvalidThenReturnFalse() {
        IProduct product = new CommonProduct("Abc", "Name", "Description", 0.5d, Instant.now().toEpochMilli());
        assertFalse(product.isNameValid());
    }

}
