namespace DemoApp;

class Activity
{
    public static long Perform(int amount)
    {
        long count = amount;
        int future = Environment.TickCount + 100 * amount;
        while(Environment.TickCount < future);
        return count * amount;
    }
}
