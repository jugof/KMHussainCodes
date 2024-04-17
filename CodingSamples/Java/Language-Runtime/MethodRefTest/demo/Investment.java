//this class produces 'immutable' objects as it does
//not provide any method to change the state of an instance
//once it is initialized
class Investment {

    private final double installment;
    private final int duration;

    public Investment(double amount, int years) {
        installment = amount;
        duration = years;
    }

    public double installment() {
        return installment;
    }

    public int duration() {
        return duration;
    }

    public double futureValue(InterestRate rate) {
        double i = rate.forPeriod(duration) / 100;
        return (installment / i) * (Math.pow(1 + i, duration) - 1);
    }
}
