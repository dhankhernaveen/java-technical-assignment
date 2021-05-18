package kata.supermarket.discount;

import java.math.BigDecimal;

public class BuyThreeGetOneFree implements Discount {

    private String productType;

    public BuyThreeGetOneFree(String productType) {
        this.productType = productType;
    }

    @Override
    public BigDecimal apply(BigDecimal pricePerUnit, BigDecimal quantityOfItems) {
        if ("Kitkat".equals(productType)) {
            int unitsDiscounted = quantityOfItems.intValue() / 3;
            return pricePerUnit.multiply(new BigDecimal(unitsDiscounted));
        }
        return BigDecimal.ZERO;
    }
}
