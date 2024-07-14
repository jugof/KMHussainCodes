#include "banner3.h"
#include <cstdio>

//A reference type (T&) automatically addresses the value of
//the variable with which it is initialized and automatically
//indirects to this value where ever it is used. A reference
//type parameter declared with 'const' qualifier treats the
//addressed argument as read-only
double Buy(const Banner& info, int copies)
{
	float discount = Banner::BulkDiscount(copies);
	//info.Resize(0, 0);
	return (1 - discount / 100) * copies * info.Price(); 
}

int main(void)
{
	int count;
	printf("Number of copies: ");
	scanf("%d", &count);

	Banner a; //activating banner with default constructor
	printf("Total payment for standard banner: %.2f\n", Buy(a, count)); 

	Banner b(30, 8); //activating banner with parameterized constructor
	printf("Total payment for custom banner  : %.2f\n", Buy(b, count)); 
}

