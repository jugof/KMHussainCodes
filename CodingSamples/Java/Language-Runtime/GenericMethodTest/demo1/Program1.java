class Program {

    public static void main(String[] args) {
        SimpleStack<String> a = new SimpleStack<String>();
        a.push("Monday");
        a.push("Tuesday");
        a.push("Wednesday");
        a.push("Thursday");
        a.push("Friday");
        //a.push(12.34);
        while(!a.empty())
            System.out.println(a.pop());
        System.out.println("----------------------");
        SimpleStack<Interval> b = new SimpleStack<>();
        b.push(new Interval(4, 31));
        b.push(new Interval(6, 12));
        b.push(new Interval(5, 23));
        b.push(new Interval(3, 54));
        while(!b.empty())
            System.out.println(b.pop());
    }
}