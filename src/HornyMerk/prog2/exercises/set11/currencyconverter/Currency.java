package HornyMerk.prog2.exercises.set11.currencyconverter;

public enum Currency {
    USD(0.887399),
    EUR(1),
    GBP(1.10713),
    AUD(0.612301),
    JPY(0.00831031);

    private double euroConversionRate;

    Currency(double euroConversionRate) {
        this.euroConversionRate = euroConversionRate;
    }

    public double getEuroConversionRate() {
        return euroConversionRate;
    }
}
