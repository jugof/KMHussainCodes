#include "interval.h"
#include <iostream>
#include <string>

using namespace std;

template<typename Element> //class template with substitutable Element type
class Selector
{
public:
	Selector(const Element& f, const Element& s) : first(f), second(s)
	{
		//first = f;
		//second = s;
	}

	Element Select(int index) const
	{
		if(index % 2)
			return first;
		return second;
	}
private:
	Element first, second;
};

int main(void)
{
	int count;
	cout << "Count: ";
	cin >> count;

	//compiler will generate templated Selector class with Element=double
	Selector<double> a(48.3, 27.9);
	cout << "Selected double value = " << a.Select(count) << endl;

	Selector<string> b("Monday", "Tuesday");
	cout << "Selected string value = " << b.Select(count) << endl;

	Selector<Interval> c(Interval(3, 45), Interval(4, 65));
	cout << "Selected Interval value = " << c.Select(count).AsString() << endl;

};
