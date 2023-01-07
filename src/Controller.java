import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Boolean execute = Boolean.TRUE;
    private final Map<Integer, Mop> mops;

    private final Prices prices;

    public Controller() {
        this.mops = new HashMap<>();
        this.prices = new Prices();
    }

    public void start() {
        while (execute) {
            this.prices.showPrices();
            Integer option = this.getOption();
            this.addMop(option, new Mop(
                    Misc.getInteger("Enter the number of dozens of mops: "),
                    this.getPrice(option),
                    option
            ));

            Misc.showMessage("Total price: " + this.mops.get(option).calculateTotalPrice());
            this.execute = this.getContinueExecution().equals("Y");
        }
    }

    private void addMop(Integer id, Mop mop) {
        this.mops.put(id, mop);
    }

    private Float getPrice(Integer option) {
        Map<Integer, Float> prices = Map.of(
                10, this.prices.getCottonPrice(),
                20, this.prices.getSpongePrice(),
                30, this.prices.getMicrofiberPrice());
        return prices.get(option);
    }

    private Integer getOption() {
        Integer option = Misc.getInteger("Please enter the number of the type of mop you wish to purchase: \n10. Cotton mop \n20. Sponge mop \n30. Microfiber mop");
        if (validateOption(option)) {
            Misc.showMessage("[ERROR]: Wrong option!");
            return getOption();
        }
        return option;
    }

    private Boolean validateOption(Integer option) {
        return  validateOption10(option) && validateOption20(option) && validateOption30(option);
    }

    private Boolean validateOption10(Integer option) {
        return option != 10;
    }

    private Boolean validateOption20(Integer option) {
        return option != 20;
    }

    private Boolean validateOption30(Integer option) {
        return option != 30;
    }

    private String getContinueExecution() {
        String option = Misc.getString("Do you want to continue shopping? [Y / N]").toUpperCase().trim().substring(0, 1);
        if (validateContinueExecution(option)) {
            Misc.showMessage("[ERROR]: Wrong option!");
            return getContinueExecution();
        }
        return option;
    }

    private Boolean validateContinueExecution(String option) {
        return !option.equals("Y") && !option.equals("N");
    }
}
