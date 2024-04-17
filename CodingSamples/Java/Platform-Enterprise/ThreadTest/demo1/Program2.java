class Program {

    private static String user;

    private static void handleJob(int jid) {
        System.out.printf("Thread<%x> has accepted job<%d> for %s%n", Thread.currentThread().hashCode(), jid, user);
        Activity.perform(jid);
        System.out.printf("Thread<%x> has finished job<%d> for %s%n", Thread.currentThread().hashCode(), jid, user);
    }

    public static void main(String[] args) throws Exception {
        Thread child = new Thread(() -> {
            user = "Jack";
            handleJob(1);
        });
        child.start();
        user = "Jill";
        handleJob(2);
    }
}
