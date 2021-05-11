package kata.supermarket.discount;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BuyOneGetOneDiscountTest {

    @InjectMocks
    BuyOneGetOneDiscount buyOneGetOneDiscount;

    @ParameterizedTest
    @CsvSource({
            "10,1,10",
            "10,2,10",
            "10,3,30",
            "10,4,20"
    })
    void shouldCalculateCorrectDiscount(BigDecimal price, BigDecimal quantity, BigDecimal expectedDiscountedPrice) {
        BigDecimal actualPrice = buyOneGetOneDiscount.apply(price, quantity);
        assertEquals(expectedDiscountedPrice, actualPrice);
    }


}