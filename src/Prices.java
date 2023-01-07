public class Prices {
    private final Float cottonPrice;
    private final Float spongePrice;
    private final Float microfiberPrice;

    public Prices() {
        this.cottonPrice = Misc.getFloat("Enter price of the cotton mops: ");
        this.spongePrice = Misc.getFloat("Enter price of the sponge mops: ");
        this.microfiberPrice = Misc.getFloat("Enter price of the microfiber mops: ");
    }

    public void showPrices() {
        Misc.showMessage("Dozen Mops Price List: " +
                "\nCotton mop: $" + this.cottonPrice +
                "\nSponge mop: $" + this.spongePrice +
                "\nMicrofiber mop: $" + this.microfiberPrice);
    }

    public Float getCottonPrice() {
        return this.cottonPrice;
    }

    public Float getSpongePrice() {
        return this.spongePrice;
    }

    public Float getMicrofiberPrice() {
        return this.microfiberPrice;
    }
}
