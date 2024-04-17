class Program {

    private static double safeScheme(int y) {
        return y < 3 ? 6 : 7.5;
    }

    public static void main(String[] args) {
        double p = Double.parseDouble(args[0]);
        int n = Integer.parseInt(args[1]);
        var myinv = new Investment(p, n);
        //passing method-reference
        System.out.printf("Future value in risk-free investment: %.2f%n", myinv.futureValue(Program::safeScheme));
        int m = 9;
        //passing lambda-expression: (arguments) -> {expression-body}, such an expression
        //is converted by the compiler into a method-reference by implementing the
        //corresponding method, any local variable of outer method that appears in the
        //body of lambda-expression is captured by copy which makes it effectively final
        System.out.printf("Future value in high-risk investment: %.2f%n", myinv.futureValue(y -> m + 0.25 * y));
    }
}