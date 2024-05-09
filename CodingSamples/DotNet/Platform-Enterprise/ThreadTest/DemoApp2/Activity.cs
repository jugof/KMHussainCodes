namespace DemoApp;

class Activity
{
    public const int Credit = 1;

    public const int Debit = -1;

    public static int Perform(int amount, int balance, int op)
    {
        int future = Environment.TickCount + amount / 100;
        while(Environment.TickCount < future);
        return balance + op * amount;
    }
}