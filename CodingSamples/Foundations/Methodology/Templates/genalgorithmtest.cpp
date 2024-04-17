#include <iostream>
#include <string>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

bool IsOdd(int k)
{
	return k % 2;
}

int main(void)
{
	vector<int> a;
	a.push_back(451);
	a.push_back(682);
	a.push_back(813);
	a.push_back(964);
	a.push_back(705);
	a.push_back(536);
	a.push_back(427);
	a.push_back(218);
	cout << "All integers in the vector" << endl;
	//for-each style loop (modern C++) can be used with 
	//any container that provides standard iterator
	for(int n : a)
		cout << n << endl;
	cout << "Number of odd integers: "
		 << count_if(a.begin(), a.end(), IsOdd:) //standard algorithm
		 << endl;
	
	set<string> b;
	b.insert("Sunday");
	b.insert("Monday");
	b.insert("Tuesday");
	b.insert("Wednesday");
	b.insert("Thursday");
	b.insert("Friday");
	b.insert("Saturday");
	b.insert("Sunday");
	cout << "All strings in the set" << endl;
	for(string s : b)
		cout << s << endl;
	int min;
	cout << "Minimum size: ";
	cin >> min;
	cout << "Number of big strings: "
		 //passing lambda-expression (anonymous function in modern C++) 
		 //[capture-list](argument-list){ return expression; }
		 << count_if(b.begin(), b.end(), [min](string t){ return t.size() >= min; })
		 << endl;
}

