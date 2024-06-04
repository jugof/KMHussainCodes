enum Geometry { Rectangular, Triangular, Elliptical };

class Banner
{
public:
	Banner(float length=20, float breadth=5)
	{
		width = length;
		height = breadth;
		shape = Geometry::Rectangular;
	}
	
	void Resize(float w, float h) 
	{
		width = w; 
		height = h; 
	}

	//overloaded member function defined in same class with same name
	//but with different list of parameter types
	void Resize(float w)
	{
		width = height = w;
	}

	void Triangulate(bool yes)
	{
		shape = yes ? Geometry::Triangular : Geometry::Rectangular;
	}

	void Reshape(Geometry g)
	{
		shape = g;
	}

	//a virtual member function can be overridden in the derived class 
	virtual double Price() const
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

	static float BulkDiscount(int copies)
	{
		return copies < 10 ? 0 : 15;
	}


private:
	float width, height;
	Geometry shape;
};


//defining HardBanner as a derived(sub) class of Banner (base class)
class HardBanner : public Banner
{
public:
	//the derived class constructor must call a constructor of the
	//base class so that the inherited fields are properly initialized
	HardBanner(float length, float breadth, float hardness) : Banner(length, breadth)
	{
		thickness = hardness;
	}

	//overriding member function by re-defining virtual member function
	//of base class in the derived class with exactly same declaration
	double Price() const
	{
		return Banner::Price() * (1 + 0.5 * thickness);
	}
private:
	float thickness;
};

