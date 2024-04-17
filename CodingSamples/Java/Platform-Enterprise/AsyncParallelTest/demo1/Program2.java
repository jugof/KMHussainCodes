import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

class Program {
    
    static class Computation {

        private long start = System.currentTimeMillis();

        public long compute(int lower, int upper) {
            return IntStream.range(lower, upper + 1)
                        .mapToLong(Activity::perform)
                        .sum();
        }

        public CompletableFuture<Long> computeAsync(int lower, int upper) {
            //the supplied expression will be evaluated by a worker thread
            //enabling the caller thread to resume execution and obtain
            //the result of evaluation in future once the worker has 
            //completed the operation
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
