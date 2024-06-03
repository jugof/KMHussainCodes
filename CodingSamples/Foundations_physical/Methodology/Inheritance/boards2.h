#include <iostream>

class Signboard
{
public:

	Signboard()
	{
		std::cout << "Preparing sign-board..." << std::endl;		
	}

	virtual double Area() const = 0;

	double Price() const
	{
		return 1.25 * Area();
	}
protected:
	int id;
};

//a class with virtual base is prepared to share the virtual base
//sub-object within an instance of its derived class
class RectangularBoard : public virtual Signboard
{
public:
	RectangularBoard(float l, float b)
	{
		id = 1;
		length = l;
		breadth = b;
	}

	double Area() const
	{
		return length * breadth;
	}
private:
	float length, breadth;
};

class CircularBoard : public virtual Signboard
{
public:
	CircularBoard(float d)
	{
		id = 2;
		diameter = d;
	}

	double Area() const
	{
		float r = diameter / 2;
		return 3.14 * r * r;
	}
private:
	float diameter;
};


class DiscoBoard : public RectangularBoard, public CircularBoard
{
	public:
		DiscoBoard(float l, float b) : RectangularBoard(l, b), CircularBoard(b)
		{
		}

		double Area() const
		{
			return RectangularBoard::Area() + CircularBoard::Area();
		}

};

