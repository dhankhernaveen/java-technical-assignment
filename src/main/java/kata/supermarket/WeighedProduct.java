package kata.supermarket;

import kata.supermarket.discount.Discount;
import kata.supermarket.discount.ZeroDiscount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeighedProduct {

    private BigDecimal pricePerKilo;
    private Discount discount;

    public WeighedProduct(final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
        this.discount = new ZeroDiscount();
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
}
