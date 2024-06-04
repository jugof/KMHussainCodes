#include <iostream>
#include <string>

using namespace std;

/*
double Select(int index, double first, double second)
{
	if(index % 2)
		return first;
	return second;
}

string Select(int index, string first, string second)
{
	if(index % 2)
		return first;
	return second;
}
*/

template<typename T> //a function template with type-parameter T
T Select(int index, T first, T second)
{
	if(index % 2)
		return first;
	return second;
}

int main(void)
{
	int count;
	cout << "Count: ";
	cin >> count;

	//compiler will generate templated Select with T=double
	double sd = Select<double>(count, 45.6, 32.1); 
	cout << "Selected double value = " << sd << endl;

	//compiler will generate templated Select with T=string
	string ss = Select<string>(count, "Monday", "Tuesday");
	cout << "Selected string value = " << ss << endl;

	//double sd = Select<double>(count, 34.5, "Friday");
}

