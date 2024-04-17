class Program {

    private static <T> T select(int index, T first, T second) {
        if((index % 2) == 1)
            return first;
        return second;
    }

    private static <T extends Comparable<T>> T select(T first, T second) {
        if(first.compareTo(second) > 0)
            return first;
        return second;
    }

    public static void main(String[] args) {
        if(args.length > 0){
            int s = Integer.parseInt(args[0]);
            String ss = select(s, "Monday", "Tuesday");
            System.out.printf("Selected String value = %s%n", ss);
            //when a primitive type value is converted to a reference
            //type, the compiler creates an instance of the wrapper
            //class of that primitive type, this implicit conversion
            //is called auto-boxing 
            double sd = select(s, 43.5, 32.6);
            System.out.printf("Selected double value = %s%n", sd);
            //double ssd = select(s, "Jack", 2.3);
            //System.out.printf("Selected int value = %s%n", ssd);
        }else{
            String ss = select("Monday", "Tuesday");
            System.out.printf("Selected String value = %s%n", ss);
            double sd = select(43.5, 32.6);
            System.out.printf("Selected double value = %s%n", sd);  
            Interval si = select(new Interval(3, 45), new Interval(2, 30));
            System.out.printf("Selected Interval value = %s%n", si);
        }
    }
}