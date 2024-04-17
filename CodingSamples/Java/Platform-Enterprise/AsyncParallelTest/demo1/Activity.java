class Activity {
    
    public static long perform(int count) {
        long future = System.currentTimeMillis() + 100 * count;
        while(System.currentTimeMillis() < future);
        return count * count;
    }
}
