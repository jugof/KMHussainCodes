//A namespace is named scope containing related symbols (functions, classes, etc.)
//grouped together to avoid collisions between their names and names of
//other symbols not belonging to their group. A symbol S defined within
//a namespace N must is identified by its qualified name of N::S outside
//of N
namespace Series
{
	//A class that contains a pure virtual member function is called
	//an abstract data type (ADT) because it cannot be used for 
	//activating new instances. Such a class can only be used for
	//declaring a pointer or a reference.
	class Sequence
	{
	public:
		//A pure virtual member function is not implemented by the 
		//class in which it is declared
		virtual double Next() = 0;
	protected: //members in this block are visible in derived classes
		double current;
	};

	//A class derived from an ADT must override all pure virtual functions
	//it inherits otherwise it will also be treated as an ADT
	class LinearSequence : public Sequence
	{
	public:
		LinearSequence(double, double);
		double Next();
	private:
		double step;
	};

	class PowerSequence : public Sequence
	{
	public:
		PowerSequence(double);
		double Next();
	private:
		double factor;
	};
}

