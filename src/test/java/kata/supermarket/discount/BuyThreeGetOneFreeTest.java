package kata.supermarket.discount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BuyThreeGetOneFreeTest {

    BuyThreeGetOneFree buyThreeGetOneFree;

    @ParameterizedTest
    @CsvSource({
            "10,1,0,A",
            "10,2,0,A",
            "10,3,0,A",
            "10,10,0,A",
            "10,1,0,Kitkat",
            "10,2,0,Kitkat",
            "10,3,10,Kitkat",
            "10,10,30,Kitkat"
    })
    void shouldCalculateDiscount(BigDecimal actualPrice, BigDecimal quantity, BigDecimal expectedDiscount, String productType){
        buyThreeGetOneFree = new BuyThreeGetOneFree(productType);
        BigDecimal actualDiscount = buyThreeGetOneFree.apply(actualPrice, quantity);
        assertEquals(expectedDiscount,actualDiscount);
    }
}