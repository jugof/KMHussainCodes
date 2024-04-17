import taxation.Supervisor;
import taxation.TaxPayer;
import taxation.Worker;

class Program {

    //static inner member (nested) class
    static class Auditor {

        public Auditor() {
            System.out.println("Auditor - acquring resources");
        }

        public void audit(String id, TaxPayer person) {
            if(id.length() < 4)
                throw new IllegalArgumentException("Invalid ID");
            double payment = person.incomeTax() + 500;
            System.out.printf("Total tax payment: %.2f%n", payment);
        }

        public void close() {
            System.out.println("Auditor - releasing resources");
        }
    }

    private static void process(String name, int count) {
        TaxPayer t = name.equals("jack") ? new Supervisor(count) : new Worker(count);
        Auditor a = new Auditor();
        a.audit(name, t);
        a.close();
    }

    public static void main(String[] args) {
        try{
            String m = args[0].toLowerCase();
            int n = Integer.parseInt(args[1]);
            process(m, n);
        }catch(Exception e){
            System.out.printf("Error: %s%n", e);
        }
    }
}