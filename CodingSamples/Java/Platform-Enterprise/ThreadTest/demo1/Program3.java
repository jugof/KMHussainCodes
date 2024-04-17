class Program {

    private static ThreadLocal<String> user = new ThreadLocal<>();

    private static void handleJob(int jid) {
        System.out.printf("Thread<%x> has accepted job<%d> for %s%n", Thread.currentThread().hashCode(), jid, user.get());
        Activity.perform(jid);
        System.out.printf("Thread<%x> has finished job<%d> for %s%n", Thread.currentThread().hashCode(), jid, user.get());
    }

    public static void main(String[] args) throws Exception {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 1;
        Thread child = new Thread(() -> {
            user.set("Jack");
            handleJob(n);
        });
        if(n > 5)
            child.setDaemon(true);
            //make child a background thread so that JVM doesn't
            //have to wait for it to exit
        child.start();
        user.set("Jill");
        handleJob(2);
    }
}
