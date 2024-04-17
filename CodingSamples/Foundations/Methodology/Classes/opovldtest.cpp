#include "interval.h"
#include <cstdio>

int main(void)
{
	Interval i(5, 40);
	i.Print();

	Interval j(2, 85);
	j.Print();

	Interval k = i + j; //i.operator+(j)
	k.Print();

	Interval l = k;
	l.Print();
}

