#include <cstdio>

int main(void)
{
	float width, height;
	short count;

	printf("Dimensions of Banner: ");
	scanf("%f%f", &width, &height);
	printf("Number of Banners: ");
	scanf("%hd", &count);

	double area = width * height;
	if(width > height)
	{
		printf("Total payment for landscape banner: %.2lf\n", count * area * 0.80); 
	}
	else
	{
		printf("Total payment for potrait banner: %.2lf\n", count * area * 0.75); 
	}
	puts("Goodbye.");
}

