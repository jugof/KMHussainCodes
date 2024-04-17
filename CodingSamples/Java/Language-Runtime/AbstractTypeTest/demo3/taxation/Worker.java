package taxation;

public class Worker implements TaxPayer {
    
    private int jobs;

    public Worker(int count) {
        jobs = count;
    }

    public double annualIncome() {
        return 180000 + 500 * jobs;
    }

}
