using Payroll;

class Program
{
    private static void Recruit(Employee emp, int days)
    {
        emp.Hours = 8 * days; //emp.set_Hours(8 * days)
        emp.HourlyRate = days <= 20 ? 47 : 53;
    }

    private static double Tax(Employee emp)
    {
        double i = emp.Income();
        return i > 10000 ? 0.15 * (i - 10000) : 0; 
    }

    private static double Bonus(Employee? emp)
    {
        if(emp is null || emp is SalesPerson)
            return 0;
        return 0.25 * emp.Income();
    }

    static void Main(string[] args)
    {
        Employee jack = new Employee();
        Recruit(jack, 23);
        Console.WriteLine("Jack's Income is {0:0.00}, Tax is {1:0.00} and Bonus is {2:0.00}", jack.Income(), Tax(jack), Bonus(jack));
        SalesPerson jill = new SalesPerson(jack.Hours, jack.HourlyRate, 68000);
        Console.WriteLine("Jill's Income is {0:0.00}, Tax is {1:0.00} and Bonus is {2:0.00}", jill.Income(), Tax(jill), Bonus(jill));
        Bonus(null);
        //Tax(null);
    }
}