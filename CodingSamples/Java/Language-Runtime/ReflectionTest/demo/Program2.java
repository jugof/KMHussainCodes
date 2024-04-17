import java.lang.reflect.Method;

import finance.*;

class Program {

    public static void main(String[] args) throws Exception {
        double p = Double.parseDouble(args[0]);
        Class<?> c = Class.forName("finance." + args[1]);
        Object policy = c.getConstructor().newInstance(); //dynamic activation
        Method scheme = c.getMethod(args[2], double.class, int.class);
        int m = 10;
        for(int n = 1; n <= m; ++n){
            double r = (double)scheme.invoke(policy, p, n); //late binding
            double emi = Loans.monthlyInstallment(p, n, r);
            System.out.printf("%-6d%20.2f%n", n, emi);
        }
    }
}
