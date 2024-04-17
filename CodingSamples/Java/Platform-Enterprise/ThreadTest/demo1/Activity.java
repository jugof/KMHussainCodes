class Activity {
    
    public static void perform(int count) {
        long future = System.currentTimeMillis() + 1000 * count;
        while(System.currentTimeMillis() < future);
    }
}
