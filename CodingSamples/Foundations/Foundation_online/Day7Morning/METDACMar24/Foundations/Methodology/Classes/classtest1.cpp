#include "banner1.h"
#include <cstdio>

int main(void)
{
	Banner a;	//activation - using default constructor
	printf("Price of standard banner: %.2f\n", a.Price()); 

	Banner b;
	float w, h;
	printf("Dimensions of custom banner: ");
	scanf("%f%f", &w, &h);
	b.Resize(w, h); //binding - Banner::Resize(&b, w, h)
	printf("Price of custom rectangular banner: %.2f\n", b.Price());
	b.Triangulate(true);
	printf("Price of custom triangular banner : %.2f\n", b.Price());
}

