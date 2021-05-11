package kata.supermarket;

import kata.supermarket.discount.Discount;
import kata.supermarket.discount.ZeroDiscount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private BigDecimal pricePerUnit;
    private Discount discount;

    public Product(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        this.discount = new ZeroDiscount();
    }

    public Item totalUnits(Integer units) {
        return new ItemByUnit(this, BigDecimal.valueOf(units));
    }

}
