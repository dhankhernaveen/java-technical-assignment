package kata.supermarket.discount;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BuyXForYTest {

    BuyXForY buyXForY;

    @ParameterizedTest
    @CsvSource({
            "10,3,15",
            "10,1,0",
            "10,2,0",
            "10,5,15"
    })
    void shouldCalculateDiscount(BigDecimal price, BigDecimal quantity, BigDecimal expectedDiscount){
        buyXForY =new BuyXForY(new BigDecimal(3),new BigDecimal("5"));
        BigDecimal actualDiscount = buyXForY.apply(price, quantity);
        assertEquals(expectedDiscount,actualDiscount);
    }

}