struct Rectangle
{
    public float Length { get; init; } //property can only be set in initializer

    public float Breadth { get; init; }

    public double Area()
    {
        return Length * Breadth;
    }

    public override string ToString()
    {
        //return string.Format("{0} x {1}", Length, Breadth);
        return $"{Length} x {Breadth}"; //string interpolation
    }
}