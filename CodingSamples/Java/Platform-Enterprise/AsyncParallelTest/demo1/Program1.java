import java.util.stream.IntStream;

class Program {
    
    static class Computation {

        private long start = System.currentTimeMillis();

        public long compute(int lower, int upper) {
            return IntStream.range(lower, upper + 1)
                        .mapToLong(Activity::perform)
                        .sum();
        }

        public double time() {
            long interval = System.currentTimeMillis() - start;
            return interval / 1000.0;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(args[0]);
        System.out.print("Computing...");
        var c = new Computation();
        var r = c.compute(1, n);
        System.out.println("Done!");
        System.out.printf("Result = %d, computed in %.3f seconds.%n", r, c.time());       
    }
}
