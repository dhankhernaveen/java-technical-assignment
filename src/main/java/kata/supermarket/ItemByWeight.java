package kata.supermarket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemByWeight implements Item {

    private WeighedProduct product;
    private BigDecimal weightInKilos;

    @Override
    public BigDecimal price() {
        return product.getPricePerKilo().multiply(weightInKilos).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal discountedPrice() {
        return product.getDiscount().apply(product.getPricePerKilo(), weightInKilos);
    }

}
