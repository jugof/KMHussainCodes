using System.Runtime.InteropServices;

unsafe class Primes
{
    [DllImport("primes", EntryPoint = "primes_count")]
    public extern static int CountBetween(ulong first, ulong last);

    struct PrimesRange
    {
        public ulong Start;
        public int Count;
    }

    [DllImport("primes", EntryPoint = "primes_fetch")]
    private extern static ulong FetchSelected(PrimesRange* range, ulong* store, delegate*<ulong, int> select);

    //Span<T> offers a common abstraction for a memory block on heap or on stack
    public static void FetchSelected(ulong start, int count, Span<ulong> store)
    {
        PrimesRange range = new() { Start = start, Count = count };
        PrimesRange* pRange = &range;
        fixed(ulong* pStore = &store[0])
        {
            FetchSelected(pRange, pStore, null);
        }
    }
}