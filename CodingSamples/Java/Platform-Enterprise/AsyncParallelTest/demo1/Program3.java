import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

class Program {
    
    static class Computation {

        private long start = System.currentTimeMillis();

        public long compute(int lower, int upper) {
            return IntStream.range(lower, upper + 1)
                        .parallel() //split the stream so each part
                                    //can be processed by a separate core
                        .mapToLong(Activity::perform)
                        .sum();
        }

        public CompletableFuture<Long> computeAsync(int lower, int upper) {
            return CompletableFuture.supplyAsync(() -> compute(lower, upper));
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
        var job = c.computeAsync(1, n)
                    .thenAccept(r -> {
                        System.out.println("Done!");
                        System.out.printf("Result = %d, computed in %.3f seconds.%n", r, c.time());
                    });
        while(!job.isDone()){
            System.out.print(".");
            Thread.sleep(500);
        }
                    
    }
}
