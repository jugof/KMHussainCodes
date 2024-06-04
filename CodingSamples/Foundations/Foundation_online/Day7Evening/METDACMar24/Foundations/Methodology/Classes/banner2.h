enum Geometry { Rectangular, Triangular, Elliptical };

class Banner
{
public:
	Banner()
	{
		width = 20;
		height = 5;
		shape = Geometry::Rectangular;
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
private:
	float width, height;
	Geometry shape;
};

