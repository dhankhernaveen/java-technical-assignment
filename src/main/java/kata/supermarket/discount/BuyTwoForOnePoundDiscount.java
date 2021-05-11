package kata.supermarket.discount;

import java.math.BigDecimal;

public class BuyTwoForOnePoundDiscount implements Discount {

    @Override
    public BigDecimal apply(BigDecimal pricePerUnit, BigDecimal quantityOfItems) {
        if (quantityOfItems.intValue() % 2 == 0) {
            int quantity = quantityOfItems.intValue() / 2;
            BigDecimal actualPrice = pricePerUnit.multiply(quantityOfItems);
            return actualPrice.subtract(BigDecimal.valueOf(quantity));
        }
        return BigDecimal.ZERO;
    }
}
