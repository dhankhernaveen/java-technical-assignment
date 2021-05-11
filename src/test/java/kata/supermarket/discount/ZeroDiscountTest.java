package kata.supermarket.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class ZeroDiscountTest {

    @InjectMocks
    private ZeroDiscount zeroDiscount;

    @Test
    void shouldReturnDefaultValue() {
        BigDecimal anyValue = new BigDecimal("12.11");
        BigDecimal actualValue = zeroDiscount.apply(anyValue, anyValue);
        Assertions.assertEquals(new BigDecimal("0"), actualValue);
    }

}