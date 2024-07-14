#include <cstdio>

double BannerPrice(float, float, int); //forward declaration of function

int main(void)
{
	float width, height;
	short count;

	printf("Dimensions of Banner: ");
	scanf("%f%f", &width, &height);
	printf("Number of Banners: ");
	scanf("%hd", &count);

	double rpayment = BannerPrice(width, height, count);
	printf("Total payment for regular banner: %.2lf\n", rpayment);
	double bpayment = BannerPrice(width + 1, height + 1, count);
	printf("Total payment for bordered banner: %.2lf\n", bpayment);

}

//function definition
double BannerPrice(float w, float h, int n)
{
	float rate = n < 10 ? 0.80 : 0.75;
	return n * w * h * rate;
}

