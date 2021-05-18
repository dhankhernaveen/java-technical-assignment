package kata.supermarket.discount;

import java.math.BigDecimal;

public class BuyXForY implements Discount {

    private BigDecimal quantity;
    private BigDecimal discountedPrice;

    public BuyXForY(BigDecimal quantity, BigDecimal discountedPrice) {
        this.quantity = quantity;
        this.discountedPrice = discountedPrice;
    }

    // this needs change for more than 3 items - we ran out of time
    @Override
    public BigDecimal apply(BigDecimal pricePerUnit, BigDecimal quantityOfItems) {
        if(quantityOfItems.intValue() >= quantity.intValue()){
            BigDecimal actual = pricePerUnit.multiply(quantityOfItems);
         //   BigDecimal discount = actual.divide(quantityOfItems);
            BigDecimal discountPrice = quantity.multiply(discountedPrice);
            return actual.subtract(discountPrice);
        }
        return BigDecimal.ZERO;
    }
}
