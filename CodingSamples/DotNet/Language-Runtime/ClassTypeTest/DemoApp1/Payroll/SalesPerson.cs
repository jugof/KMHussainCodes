namespace Payroll
{
    //SalesPerson is derived class of Employee (base class)
    class SalesPerson : Employee
    {
        //automatic property
        public double Sales { get; set; }

        public SalesPerson(int h, float r, double s) : base(h, r)
        {
            Sales = s;
        }

        //a method declared with 'override' keyword overrides 
        //a virtual method of base class with matching declaration
        public override double Income()
        {
            double amount = base.Income();
            if(Sales >= 20000)
                amount += 0.05 * Sales;
            return amount;
        }
    }
}