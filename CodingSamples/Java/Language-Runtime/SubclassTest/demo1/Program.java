//ask compiler to expand Employee to payroll.Employee
import payroll.Employee;
import payroll.SalesPerson;

class Program {

    private static double tax(Employee emp) {
        double i = emp.income();
        return i > 10000 ? 0.15 * (i - 10000) : 0;
    }

    private static double bonus(Employee emp) {
        if(emp instanceof SalesPerson)
            return 0;
        return 1.25 * emp.income();
    }

    public static void main(String[] args) {
        Employee jack = new Employee();
        jack.setHours(186);
        jack.setRate(52);
        SalesPerson jill = new SalesPerson(186, 52, 64000);
        System.out.printf("Jack's income is %.2f, tax is %.2f and bonus is %.2f%n", jack.income(), tax(jack), bonus(jack));
        System.out.printf("Jill's income is %.2f, tax is %.2f and bonus is %.2f%n", jill.income(), tax(jill), bonus(jill));
    }
}
