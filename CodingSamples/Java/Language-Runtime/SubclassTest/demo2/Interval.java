//A Java class that does not explicitly extend another class
//implicitly extends java.lang.Object which is common root
//of Java inheritance model
class Interval {
    
    private int min;
    private int sec;

    public Interval(int m, int s) {
        min = m + s / 60;
        sec = s % 60;
    }

    public int minutes() {
        return min;
    }

    public int seconds() {
        return sec;
    }

    public int time() {
        return 60 * min + sec;
    }

    //overriding toString() method of java.lang.Object
    //to return string representation of this instance
    public String toString() {
        if(sec < 10)
            return min + ":0" + sec;
        return min + ":" + sec;
    }

    //overriding toString() method of java.lang.Object to return
    //an integer which has a different value for instances with
    //different states
    public int hashCode() {
        return min + sec;
    }

    //overriding equals method of java.lang.Object to return true only if the
    //state of this instance matches with the state of other instance
    public boolean equals(Object other) {
        if(other instanceof Interval){
            Interval that = (Interval) other; //explicit down-casting of Object to Interval
            return (min == that.min) && (sec == that.sec);
        }
        return false;
    }

}
