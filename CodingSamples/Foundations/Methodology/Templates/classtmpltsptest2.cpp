#include <iostream>
#include <string>

using namespace std;

template<typename I, typename V>
class IndexedValue
{
public:
	IndexedValue(const I& idx, const V& val) : index(idx), value(val)
	{
	}

	void Print() const
	{
		cout << "(" << index << ") => " << value << endl;
	}
private:
	I index;
	V value;
};

template<> //full specialization of IndexedValue class template
class IndexedValue<string, bool>
{
public:
	IndexedValue(const string& idx, bool val) : index(idx)
	{
		value = val ? "yes" : "no";
	}

	void Print() const
	{
		cout << "Is " << index << " : " << value << endl;
	}
private:
	string index;
	string value;
};

template<typename V> //partial specialization of IndexedValue class template
class IndexedValue<int, V>
{
public:
	IndexedValue(const V& val) : value(val)
	{
		static int count = 0;
		index = ++count;
	}

	void Print() const
	{
		cout << "[" << index << "] => " << value << endl;
	}
private:
	int index;
	V value;
};

int main(void)
{
	IndexedValue<string, double> a("Jack", 32.1);
	a.Print();

	IndexedValue<int, string> b("Monday");
	b.Print();

	IndexedValue<int, string> c("Tuesday");
	c.Print();

	IndexedValue<string, bool> d("Holiday", true);
	d.Print();
}

