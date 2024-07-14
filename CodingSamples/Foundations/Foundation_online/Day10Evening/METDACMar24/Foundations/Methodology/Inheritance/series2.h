namespace Series
{
	class Sequence
	{
	public:
		virtual double Next() = 0;
	protected: 
		double current;
	};

	class Resetable
	{
	public:
		virtual void Reset() = 0;
	};

	class LinearSequence : public Sequence
	{
	public:
		LinearSequence(double, double);
		double Next();
	private:
		double step;
	};

	//multiple-inheritance
	class PowerSequence : public Sequence, public Resetable
	{
	public:
		PowerSequence(double);
		double Next();
		void Reset();
	private:
		double factor;
	};
}

