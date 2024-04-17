class Activity {
    
    public static int perform(int balance, int amount, int op) {
        long future = System.currentTimeMillis() + amount / 100;
        while(System.currentTimeMillis() < future);
        return balance + op * amount;
    }
}
