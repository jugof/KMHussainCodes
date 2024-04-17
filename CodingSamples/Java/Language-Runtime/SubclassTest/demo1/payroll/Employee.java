package payroll;

public class Employee {
    
    private int hours;
    private float rate;

    public Employee(int h, float r) {
        hours = h;
        rate = r;
    }

    //paremeterless constructor
    public Employee() {
        this(180, 50); //calling another constructor of this class
    }

    //exposing hours field as a property using 
    //accessor (get/set) methods
    public int getHours() {
        return hours;
    }

    public void setHours(int value) {
        hours = value;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float value) {
        rate = value;
    }

    public double income() {
        double amount = hours * rate;
        int ot = hours - 180;
        if(ot > 0)
            amount += 50 * ot;
        return amount;
    }
}
