class Investment {

    private double installment;
    private int duration;
    private RiskLevel risk;

    public Investment(double amount, int years) {
        installment = amount;
        duration = years;
        risk = RiskLevel.NONE;
    }

    public void allowRisk(boolean yes) {
        risk = yes ? RiskLevel.LOW : RiskLevel.NONE;
    }

    //method overloading - defining a method whose name matches
    //with an existing method of its class but has different
    //list of parameter types
    public void allowRisk(RiskLevel level) {
        risk = level;
    }

    public double totalPayment() {
        return installment * duration;
    }

    public double futureValue() {
        double i;
        switch(risk) {
            case HIGH:
                i = 0.12;
                break;
            case LOW:
                i = 0.08;
                break;
            default:
                i = 0.06;
        }
        return (installment / i) * (Math.pow(1 + i, duration) - 1); 
    }

}
