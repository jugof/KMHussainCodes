using System.Reflection;
using Finance;
using RateFunc = System.Func<double, int, double>;

double p = double.Parse(args[0]);
Type t = Type.GetType($"Finance.{args[1]},FinLib", true);
object policy = Activator.CreateInstance(t);
MethodInfo scheme = t.GetMethod(args[2]);
RateFunc rf = scheme.CreateDelegate<RateFunc>(policy);
MaxDurationAttribute md = scheme.GetCustomAttribute<MaxDurationAttribute>();
int m = md?.Limit ?? 10; //md != null ? md.Limit : 10;
for(int n = 1; n <= m; ++n)
{
    double r = rf(p, n);
    double emi = Loans.GetMonthlyInstallment(p, n, r);
    Console.WriteLine("{0, -6}{1, 12:0.00}", n, emi);
}
