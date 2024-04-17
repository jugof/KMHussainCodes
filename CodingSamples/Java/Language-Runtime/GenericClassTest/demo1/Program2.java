class Program {

    private static void printStack(SimpleStack<?> store) {
        while(!store.empty())
            System.out.println(store.pop());  
        //store.push("Holiday");      
    }


    public static void main(String[] args) {
        SimpleStack<String> a = new SimpleStack<String>();
        a.push("Monday");
        a.push("Tuesday");
        a.push("Wednesday");
        a.push("Thursday");
        a.push("Friday");
        printStack(a);
        System.out.println("----------------------");
        SimpleStack<Interval> b = new SimpleStack<>();
        b.push(new Interval(4, 31));
        b.push(new Interval(6, 12));
        b.push(new Interval(5, 23));
        b.push(new Interval(3, 54));
        printStack(b);
    }
}