#include <cstdio>

class Interval
{
public:
	Interval(int m, int s)
	{
		id = ++count;
		min = m + s / 60;
		sec = s % 60;
	}

	//copy constructor is used to initialize an instance
	//from other object assigned to it
	Interval(const Interval& other)
	{
		id = ++count;
		min = other.min;
		sec = other.sec;
	}

	int Time() const
	{
		return 60 * min + sec;
	}

	void Print() const
	{
		printf("Interval<%d> = %d:%02d\n", id, min, sec);
	}

	//overloading + operator
	Interval operator+(const Interval& rhs) const
	{
		return Interval(min + rhs.min, sec + rhs.sec);
	}

private:
	int id, min, sec;
	//value of static member variable is shared by all instances 
	static int count; 
};

//allocating memory for static member variable
int Interval::count = 0;

