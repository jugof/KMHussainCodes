package payroll;

//defining SalesPerson as a sub-class of Employee (super-class)
public class SalesPerson extends Employee {
    
    private double sales;

    public SalesPerson(int h, float r, double s) {
        super(h, r);
        sales = s;
    }

    //read-only property for sales
    public double getSales() {
        return sales;
    }

    //overriding method - defining method whose name matches 
    //with a method in the super-class and has same list of
    //parameter types
    public double income() {
        double amount = super.income(); //calling same method of super-class
        if(sales >= 20000)
            amount += 0.05 * sales;
        return amount;
    }
}
