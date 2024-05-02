//primary constructor with positional parameters which are
//available through out the class
class Interval(int min, int sec)
{
    //read-only property can only be set in internal initializer
    public int Minutes { get; } = min + sec / 60;

    public int Seconds { get; } = osec % 60;

    public int Time()
    {
        return 60 * min + sec;
    }

    public static Interval operator+(Interval lhs, Interval rhs)
    {
        return new Interval(lhs.Minutes + rhs.Minutes, lhs.Seconds + rhs.Seconds);
    }

    public override string ToString()
    {
        if(Seconds < 10)
            return Minutes + ":0" + Seconds;
        return Minutes + ":" + Seconds;
    }

    public override int GetHashCode()
    {
        return Minutes + Seconds;
    }

    public override bool Equals(object other)
    {
        if(other is Interval that)
            return (this.Minutes == that.Minutes) && (this.Seconds == that.Seconds);
        return false;
    }
}