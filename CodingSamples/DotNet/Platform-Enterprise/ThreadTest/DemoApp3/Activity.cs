namespace DemoApp;

class Activity
{
    public static void Perform(int amount)
    {
        int future = Environment.TickCount + 1000 * amount;
        while(Environment.TickCount < future);
    }
}