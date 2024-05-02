//C# supports top-level statements (in Exe type project) which
//are copied by the compiler into the Main method of 
//auto-generated Program class

using Banking;

Account jack = Banker.OpenCurrentAccount();
jack.Deposit(20000);
Account jill = Banker.OpenSavingsAccount();
jill.Deposit(15000);
try
{
    double payment = double.Parse(args[0]);
    Banker.Transfer(jill, jack, payment);
    Console.WriteLine("Funds transferred.");
}
catch(InsufficientFundsException)
{
    Console.WriteLine("Transfer failed due to lack of funds!");
}
catch(Exception ex)
{
    Console.WriteLine("Error: {0}", ex.Message);
}
Console.WriteLine("Jack's Account ID is {0} and Balance is {1:0.00}", jack.Id, jack.Balance);
Console.WriteLine("Jill's Account ID is {0} and Balance is {1:0.00}", jill.Id, jill.Balance);
