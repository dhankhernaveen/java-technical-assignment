package kata.supermarket;

import kata.supermarket.discount.BuyOneGetOneDiscount;
import kata.supermarket.discount.BuyThreeGetOneFree;
import kata.supermarket.discount.BuyTwoForOnePoundDiscount;
import kata.supermarket.discount.BuyXForY;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight(),
                buyOneGetOneDiscount(),
                buyTwoItemsForAPound(),
                buyThreeKitkatAndGetOneFree(),
                buyThreeBountyAndNothingIsFree(),
                buyThreeKitKatAtDiscountedPrice(),
                buyKitkatWithoutDiscount()
               // ,buyMultipleKitKats() - ran out of time
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments buyOneGetOneDiscount() {
        return Arguments.of("buy one get one only applied when offer is valid ", "17.50",
                Arrays.asList(
                        new Product(new BigDecimal("2.50"), new BuyOneGetOneDiscount()).totalUnits(6),
                        new Product(new BigDecimal("10.0"), new BuyOneGetOneDiscount()).totalUnits(1)
                ));
    }

    private static Arguments buyTwoItemsForAPound() {
        return Arguments.of("buy two at One only applied when offer is valid ", "3.00",
                Arrays.asList(
                        new Product(new BigDecimal("2.50"), new BuyTwoForOnePoundDiscount()).totalUnits(6)
                ));
    }

    private static Arguments buyThreeKitkatAndGetOneFree() {
        return Arguments.of("buy three 3 at price of 2 ", "20.00",
                Arrays.asList(
                        new Product(new BigDecimal("10"), new BuyThreeGetOneFree("Kitkat")).totalUnits(3)
                ));
    }

    private static Arguments buyThreeKitKatAtDiscountedPrice() {
        return Arguments.of("buy three 3 at ", "15.00",
                Arrays.asList(
                        new Product(new BigDecimal("10"), new BuyXForY(new BigDecimal(3),new BigDecimal(("5")))).totalUnits(3)
                ));
    }
    private static Arguments buyKitkatWithoutDiscount() {
        return Arguments.of("buy three 2 at ", "20.00",
                Arrays.asList(
                        new Product(new BigDecimal("10"), new BuyXForY(new BigDecimal(3),new BigDecimal(("5")))).totalUnits(2)
                ));
    }

    private static Arguments buyMultipleKitKats() {
        return Arguments.of("buy kitkats  at ", "35.00",
                Arrays.asList(
                        new Product(new BigDecimal("10"), new BuyXForY(new BigDecimal(3),new BigDecimal(("5")))).totalUnits(5)
                ));
    }

    private static Arguments buyThreeBountyAndNothingIsFree() {
        return Arguments.of("buy three 3 bounty at full price ", "30.00",
                Arrays.asList(
                        new Product(new BigDecimal("10"), new BuyThreeGetOneFree("bounty")).totalUnits(3)
                ));
    }


    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49")).totalUnits(1);
    }

    private static Item aPackOfDigestives() {
        return new Product(new BigDecimal("1.55")).totalUnits(1);
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(new BigDecimal("4.99"));
    }

    private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(new BigDecimal("2.99"));
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }
}