class Investment {

    //instance field - value will be separately stored in each instance
    private double installment;
    private int duration;
    private boolean risk;

    //constructor is called for initializing instance in the memory,
    //if a class that does not explicitly define a constructor, a 
    //parameterless constructor is implicitly defined for it
    public Investment(double amount, int years) {
        installment = amount;
        duration = years;
        risk = false;
    }

    //instance method - it can only be called on object, recieves
    //a hidden 'this' argument which refers to the instance on
    //which it is called
    public void allowRisk(boolean yes) {
        risk = yes;
    }

    public double totalPayment() {
        return installment * duration;
    }

    public double futureValue() {
        double i = risk ? 0.08 : 0.06;
        return (installment / i) * (Math.pow(1 + i, duration) - 1); 
    }

}
