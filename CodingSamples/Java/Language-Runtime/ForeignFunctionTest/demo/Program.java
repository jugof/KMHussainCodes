//allow referencing of public static members of the
//specified type without type qualification
import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.Arena;
import java.lang.foreign.SymbolLookup;

class Program {

    public static void main(String[] args) throws Throwable {
        long lower = Long.parseLong(args[0]);
        long upper = Long.parseLong(args[1]);
        var lib = SymbolLookup.libraryLookup("./libprimes.so", Arena.global());
        var primesCountHandle = NativeLibraryHelper.importFunction(lib, JAVA_INT, "primes_count", JAVA_LONG, JAVA_LONG);
        int n = (int)primesCountHandle.invoke(lower, upper);
        System.out.printf("Number of Primes = %d%n", n);
        var primesFetchHandle = NativeLibraryHelper.importFunction(lib, JAVA_LONG, "primes_fetch", JAVA_LONG, JAVA_INT, ADDRESS);
        long[] primes;
        try(var section = Arena.ofConfined()){
            var nums = section.allocate(JAVA_LONG, 5);
            primesFetchHandle.invoke(lower, 5, nums);
            primes = nums.toArray(JAVA_LONG);
        }
        System.out.println("First five primes");
        for(long prime : primes)
            System.out.println(prime);
    }
}
