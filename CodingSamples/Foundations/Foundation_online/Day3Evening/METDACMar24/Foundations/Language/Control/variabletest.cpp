#include <cstdio>

//global variable (of float type) are visible in all statement-blocks
//of the program
float width, height;

int main(void)
{
	//local variable (of 16-bit int type) is only visible in the 
	//statement block (encolsed within {}) in which it is defined
	short int count;

	printf("Dimensions of Banner: ");
	scanf("%f%f", &width, &height);
	printf("Number of Banners: ");
	scanf("%hd", &count);

	double payment = count * width * height * 0.80;
	printf("Total payment = %.2lf\n", payment);
}

