#include "interval.h"
#include <iostream>
#include <string>

using namespace std;

template<typename T>
T Select(T first, T second)
{
	cout << "Using generic Select..." << endl;
	if(first > second)
		return first;
	return second;
}

template<> //explicit specialization of Select function template for T=int
int Select(int first, int second)
{
	cout << "Using specialized Select..." << endl;
	return first * bool(first / second) + second * bool(second / first);
}

int main(void)
{

	//type-inference from arguments can be used to call a 
	//templated function like an ordinary function
	double sd = Select(32.1, 45.6); //Select<double>(45.6, 32.1)
	cout << "Selected double value = " << sd << endl;

	string ss = Select(string("Monday"), string("Tuesday"));
	cout << "Selected string value = " << ss << endl;

	Interval si = Select(Interval(3, 45), Interval(4, 65));
	cout << "Selected Interval value = " << si.AsString() << endl;

	int st = Select(245, 197); 
	cout << "Selected integer value = " << st << endl;
}


