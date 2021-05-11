package kata.supermarket.discount;

import java.math.BigDecimal;

public class BuyOneGetOneDiscount implements Discount {
    @Override
    public BigDecimal apply(BigDecimal pricePerUnit, BigDecimal quantityOfItems) {
        if (quantityOfItems.intValue() % 2 == 0) {
            return pricePerUnit.multiply(quantityOfItems.divide(new BigDecimal("2")));
        }
        return pricePerUnit.multiply(quantityOfItems);
    }
}
