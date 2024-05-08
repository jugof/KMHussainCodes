ulong l = ulong.Parse(args[0]);
ulong u = ulong.Parse(args[1]);
Console.WriteLine("Number of Primes: {0}", Primes.CountBetween(l, u));
if(args.Length > 2)
{
    int n = int.Parse(args[2]);
    Span<ulong> primes = n > 8 ? new ulong[n] : stackalloc ulong[n];
    Primes.FetchSelected(l, n, primes);
    Console.WriteLine("First {0} selected primes", n);
    foreach(ulong p in primes)
        Console.WriteLine(p);
}