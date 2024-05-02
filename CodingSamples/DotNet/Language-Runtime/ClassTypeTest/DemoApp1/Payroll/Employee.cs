namespace Payroll
{
    class Employee
    {
        private int hours;
        private float rate;

        public Employee(int h, float r)
        {
            hours = h;
            rate = r;
        }

        //parameterless contructor
        public Employee() : this(0, 0) {}

        //a property provides accessor (get/set) methods for a field
        //so that they can be used in an expression with a syntax
        //similar to direct accessing that field 
        public int Hours
        {
            get
            {
                return hours;
            }

            set
            {
                hours = value;
            }
        }

        public float HourlyRate
        {
            get { return rate; }
            set { rate = value; }
        }

        //a method declared with 'virtual' keyword can be
        //overridden in the derived class
        public virtual double Income()
        {
            double amount = hours * rate;
            int ot = hours - 180;
            if(ot > 0)
                amount += 50 * ot;
            return amount;
        }
    }
}