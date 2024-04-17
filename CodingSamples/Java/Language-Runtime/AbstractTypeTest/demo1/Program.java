import banking.*;

class Program {

    public static void main(String[] args) {
        var jack = Banker.openCurrentAccount();
        jack.deposit(20000);
        var jill = Banker.openSavingsAccount();
        jill.deposit(15000);
        try{
            double payment = Double.parseDouble(args[0]);
            jill.transfer(payment, jack);
            System.out.println("Payment succeeded.");
        }catch(InsufficientFundsException e){
            System.out.println("Transfer failed due to lack of funds!");
        }catch(Exception e){
            System.out.printf("Error: %s%n", e);
        }
        
        System.out.printf("Jack's Account ID is %d and Balance is %.2f%n", jack.id(), jack.balance());
        System.out.printf("Jill's Account ID is %d and Balance is %.2f%n", jill.id(), jill.balance());
    }
}