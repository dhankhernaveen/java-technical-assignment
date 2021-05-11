package kata.supermarket.discount;

import java.math.BigDecimal;

public class ZeroDiscount implements Discount {

    @Override
    public BigDecimal apply(BigDecimal pricePerUnit, BigDecimal quantityOfItems) {
        return BigDecimal.ZERO;
    }
}