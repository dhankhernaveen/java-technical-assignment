package kata.supermarket.discount;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BuyTwoForOnePoundDiscountTest {
    @InjectMocks
    BuyTwoForOnePoundDiscount buyTwoForOnePoundDiscount;

    @ParameterizedTest
    @CsvSource({
            "0.75,2,0.50",
            "0.75,4,1.00",
            "2,2,3"
    })
    void shouldCalculateCorrectDiscount(BigDecimal price, BigDecimal quantity, BigDecimal expectedDiscountedPrice) {
        BigDecimal actualPrice = buyTwoForOnePoundDiscount.apply(price, quantity);
        assertEquals(expectedDiscountedPrice, actualPrice);
    }

}