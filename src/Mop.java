import java.util.List;
import java.util.Map;

public class Mop {
    private final Integer quantity;
    private final Float price;
    private final List<Float> discounts;
    private final MopType type;

    public Mop(Integer quantity, Float price, Integer type) {
        this.quantity = quantity;
        this.price = price;
        this.type = this.toMopType(type);
        this.discounts = this.toDiscounts(this.type);
    }

    public Float calculateTotalPrice() {
        return this.discounts.size() == 2
                ? calculateTotalPriceTwoDiscounts()
                : calculateTotalPriceOneDiscount();
    }

    private Float calculateTotalPriceTwoDiscounts() {
        float totalPrice = this.price * this.quantity;
        if (validateQuantityRangeDouble(quantity, getLowerLimit(), getUpperLimit())) {
            totalPrice *= calculateDiscount(this.discounts.get(0));
        } else if (validateQuantityRange(quantity, getUpperLimit())) {
            totalPrice *= calculateDiscount(this.discounts.get(1));
        }
        return totalPrice;
    }

    private Float calculateTotalPriceOneDiscount() {
        float totalPrice = price * quantity;
        if (validateQuantityRange(quantity, getLowerLimit())) {
            totalPrice *= calculateDiscount(this.discounts.get(0));
        }
        return totalPrice;
    }

    private MopType toMopType(Integer type) {
        Map<Integer, MopType> types = Map.of(
                10, MopType.COTTON,
                20, MopType.SPONGE,
                30, MopType.MICROFIBER);
        return types.get(type);
    }

    private List<Float> toDiscounts(MopType type) {
        Map<MopType, List<Float>> discountOptions = Map.of(
                MopType.COTTON, List.of(10.72f, 20.25f),
                MopType.SPONGE, List.of(15.25f, 20.15f),
                MopType.MICROFIBER, List.of(20.2f));
        return discountOptions.get(type);
    }

    private Boolean validateQuantityRangeDouble(Integer quantity, Integer lowerLimit, Integer upperLimit) {
        return quantity > lowerLimit && quantity <= upperLimit;
    }

    private Boolean validateQuantityRange(Integer quantity, Integer upperLimit) {
        return quantity > upperLimit;
    }

    private Float calculateDiscount(Float discount) {
        return 1 - discount / 100;
    }

    private Integer getLowerLimit() {
        Map<MopType, Integer> limitOptions = Map.of(
                MopType.COTTON, 18,
                MopType.SPONGE, 14,
                MopType.MICROFIBER, 12);
        return limitOptions.get(this.type);
    }

    private Integer getUpperLimit() {
        Map<MopType, Integer> limitOptions = Map.of(
                MopType.COTTON, 30,
                MopType.SPONGE, 28);
        return limitOptions.get(this.type);
    }
}
