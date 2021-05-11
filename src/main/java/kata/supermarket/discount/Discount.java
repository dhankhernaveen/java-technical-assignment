package kata.supermarket.discount;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal apply(BigDecimal pricePerUnit, BigDecimal quantityOfItems);
}
