class Program {

    static class SafeScheme implements InterestRate {

        public double forPeriod(int y) {
            return y < 3 ? 6 : 7.5;
        }
    }

    public static void main(String[] args) {
        double p = Double.parseDouble(args[0]);
        int n = Integer.parseInt(args[1]);
        var myinv = new Investment(p, n);
        System.out.printf("Future value in risk-free investment: %.2f%n", myinv.futureValue(new SafeScheme()));
    }
}