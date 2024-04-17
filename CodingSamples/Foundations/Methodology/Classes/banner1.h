class Banner
{
public:
	//Constructor of a class initializes each of its new instance.
	//It is a function whose name matches with the name of the class
	//and it is declared without a return type. A constructor declared
	//without any parameter or all optional parameters is called a
	//default constructor and such a constructor is automatically defined
	//for a class which does not explicitly define any constructor
	Banner()
	{
		width = 20;
		height = 5;
		triangular = false;
	}
	
	//a method automatically receives a 'this' argument which points to 
	//the instance refered by the object on which the method is called
	//void Banner::Resize(Banner* this, float w, float h)
	void Resize(float w, float h) 
	{
		width = w; //this[0].width = w;
		height = h; //this[0].height = h;
	}

	void Triangulate(bool yes)
	{
		triangular = yes;
	}

	//a const method does not change the state of the object
	//on which it is called i.e it treats the instance addressed
	//by this argument as read-only
	//double Banner::Price(const Banner* this)
	double Price() const
	{
		float k = triangular ? 0.5 : 1.0;
		float rate = width <= height ? 0.75 : 0.80;
		return k * width * height * rate;
	}
private:
	float width, height;
	bool triangular;
};

