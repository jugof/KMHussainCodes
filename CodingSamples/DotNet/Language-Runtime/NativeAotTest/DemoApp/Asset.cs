using System.Runtime.InteropServices;

namespace DemoApp;

public static class Asset
{
    [UnmanagedCallersOnly(EntryPoint = "asset_future_price")]
    public static double FuturePrice(double cost, int life, int after, bool syd)
    {
        double drop = 1.0 / life;
        double loss = syd ? drop * after * (2 * life - after + 1) / (life + 1)
                          : 1 - Math.Pow(1 - 2 * drop, after);
        return cost * (1 - loss);
    }
}

