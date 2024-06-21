#include <cstdio>

enum Geometry { Rectangular, Triangular, Elliptical };

class Banner
{
public:
	Banner(float length=20, float breadth=5)
	{
		width = length;
		height = breadth;
		shape = Geometry::Rectangular;
		puts("Banner instance activated");
	}
	
	void Resize(float w, float h) 
	{
		width = w; 
		height = h; 
	}

	void Triangulate(bool yes)
	{
		shape = yes ? Geometry::Triangular : Geometry::Rectangular;
	}

	void Reshape(Geometry g)
	{
		shape = g;
	}

	double Price() const
	{
		float rate = width <= height ? 0.75 : 0.80;
		float k;
		switch(shape)
		{
		case Geometry::Triangular:
			k = 0.5;
			break;
		case Geometry::Elliptical:
			k = 0.785;
			break;
		default:
			k = 1.0;
		};
		return k * width * height * rate;
	}

	//a destructor is called just before an instance is deactivated(is removed
	//from memory or it goes out of scope), it is defined to remove any
	//side effect of the constructor
	~Banner()
	{
		puts("Banner instance deactivated");
	}

private:
	float width, height;
	Geometry shape;
};

