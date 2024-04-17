#include <iostream>
#include <string>
#include <vector>
#include <set>
#include <functional>

using namespace std;

int main(void)
{
	//vector is a standard sequential container in which the position
	//of element is determined by the time of its addition
	vector<int> a;
	a.push_back(451);
	a.push_back(682);
	a.push_back(813);
	a.push_back(964);
	a.push_back(705);
	a.push_back(536);
	a.push_back(427);
	a.push_back(218);
	//a.push_back("April");
	cout << "All integers in the vector" << endl;
	//vector supports standard iterator which it returns through
	//begin() and end() members and a standard iterator implements
	//!=, ++ and * operators
	for(vector<int>::iterator i = a.begin(); i != a.end(); ++i)
		cout << *i << endl;
	
	//set is a standard associative container in which the position
	//of element is determined by its properties
	//set<string> b;
	set<string, greater<string> > b;
	b.insert("Sunday");
	b.insert("Monday");
	b.insert("Tuesday");
	b.insert("Wednesday");
	b.insert("Thursday");
	b.insert("Friday");
	b.insert("Saturday");
	b.insert("Sunday");
	cout << "All strings in the set" << endl;
	for(set<string>::iterator i = b.begin(); i != b.end(); ++i)
		cout << *i << endl;
}

