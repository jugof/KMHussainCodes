#include <string>

class Interval
{
public:
	Interval(int m, int s)
	{
		min = m + s / 60;
		sec = s % 60;
	}

	int Time() const
	{
		return 60 * min + sec;
	}

	std::string AsString() const
	{
		if(sec < 10)
			return std::to_string(min) + ":0" + std::to_string(sec);
		return std::to_string(min) + ":" + std::to_string(sec);
	}

	bool operator>(const Interval& rhs) const
	{
		int t1 = Time();
		int t2 = rhs.Time();
		return t1 > t2;
	}
private:
	int min, sec;
};

