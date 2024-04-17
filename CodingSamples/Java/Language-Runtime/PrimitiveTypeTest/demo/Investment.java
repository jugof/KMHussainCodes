class Investment {

    //a method declared with 'public' modifier is visible outside of its declaring class
    //a method declared with 'static' modified can be called directly on the declaring class
    public static double futureValue(double installment, int duration, boolean risk) {
        double i = risk ? 0.08 : 0.06;
        return (installment / i) * (Math.pow(1 + i, duration) - 1);
    }
}
