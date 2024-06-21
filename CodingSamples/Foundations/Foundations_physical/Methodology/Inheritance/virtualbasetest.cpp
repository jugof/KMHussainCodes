#include "boards2.h"
#include <iostream>

using namespace std;

int main(void)
{
	RectangularBoard first(93, 15);
	cout << "Price of first board : "
		 << first.Price()
		 << endl;

	CircularBoard second(18);
	cout << "Price of second board: "
		 << second.Price()
		 << endl;

	DiscoBoard third(93, 18);
	cout << "Price of third board : "
		 << third.Price()
		 << endl;
}


