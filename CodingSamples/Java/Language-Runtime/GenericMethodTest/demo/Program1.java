class Program {

    private static String select(int index, String first, String second) {
        if((index % 2) == 1)
            return first;
        return second;
    }

    private static double select(int index, double first, double second) {
        if((index % 2) == 1)
            return first;
        return second;
    }

    public static void main(String[] args) {
        if(args.length > 0){
            int s = Integer.parseInt(args[0]);
            String ss = select(s, "Monday", "Tuesday");
            System.out.printf("Selected String value = %s%n", ss);
            double sd = select(s, 43.5, 32.6);
            System.out.printf("Selected double value = %s%n", sd);
            //int si = select(s, "Jack", 2.3);
        }
    }
}