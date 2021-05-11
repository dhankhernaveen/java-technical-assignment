package kata.supermarket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class ItemByUnit implements Item {

    private final Product product;
    private final BigDecimal numberOfUnits;

    @Override
    public BigDecimal price() {
        return product.getPricePerUnit().multiply(numberOfUnits);
    }

    @Override
    public BigDecimal discountedPrice() {
        return product.getDiscount().apply(product.getPricePerUnit(), numberOfUnits);
    }
}
