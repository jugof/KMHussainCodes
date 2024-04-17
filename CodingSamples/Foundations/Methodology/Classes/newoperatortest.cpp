#include "banner3.h"
#include <cstdio>

int main(void)
{
	{
		//automatic activation of an instance on stack memory
		//such an instance is deactivated automatically when
		//its identifier goes out of scope (when } closes)
		Banner a; 
		printf("Price of first banner: %.2f\n", a.Price());
	}
	//dynamic activation of an instance on heap memory using
	//new operator which return the address of this instance
	//such an instance must be explicitly deactivated using
	//the delete operator
	Banner* b = new Banner(30, 8); 
	printf("Price of second banner: %.2f\n", b->Price());
	delete b; 

	int n;
	printf("Number of other banners: ");
	scanf("%d", &n);
	//dynamially activating (through default constructor) instances 
	//in an array using new[] operator which returns the address of
	//the first instance
	Banner* other = new Banner[n];
	for(int i = 0; i < n; ++i)
	{
		other[i].Resize(20 + 3 * i, 5 + 2 * i);
		printf("%d\t%.2f\n", i + 1, other[i].Price());
	}
	delete[] other; //deactivating all instances of array using delete[]
}


