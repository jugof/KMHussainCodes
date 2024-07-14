#include "banner0.h"
#include <cstdio>

int main(void)
{
	float w, h;

	printf("Price of standard banner: %.2f\n", BannerPrice(20, 5, false));
	printf("Dimensions of custom banner: ");
	scanf("%f%f", &w, &h);
	printf("Price of custom rectangular banner: %.2f\n", BannerPrice(w, h, false));
	printf("Price of custom triangular banner : %.2f\n", BannerPrice(w, h, true));
}

