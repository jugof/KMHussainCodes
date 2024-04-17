import java.util.*;

class Program {

    public static void main(String[] args) {
        if(args.length == 0){
            SimpleStack<String> a = new SimpleStack<>();
            a.push("Monday");
            a.push("Tuesday");
            a.push("Wednesday");
            a.push("Thursday");
            a.push("Friday");
            for(var i = a.iterator(); i.hasNext();) 
                System.out.println(i.next());
            /*
            while(!a.empty())
                System.out.println(a.pop());
            */
            System.out.println("--------------------");
            SimpleStack<Double> b = new SimpleStack<>();
            b.push(92.1); 
            b.push(47.3);
            b.push(64.3);
            b.push(71.4);
            for(double d : b)
                System.out.println(d);
        }
        else{
            //Collection<Interval> store = new ArrayList<>();
            //Collection<Interval> store = new LinkedList<>();
            //Collection<Interval> store = new HashSet<>();
            Collection<Interval> store = new TreeSet<>();
            for(String arg : args){
                int t = Integer.parseInt(arg);
                store.add(new Interval(0, t));
            }
            for(Interval i : store)
                System.out.println(i);
        }
    }
}
