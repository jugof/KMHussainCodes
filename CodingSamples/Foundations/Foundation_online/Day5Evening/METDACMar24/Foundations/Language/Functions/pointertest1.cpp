#include <cstdio>

double Average(double first, double second, double* deviation)
{
	//deviation[0] = first > second ? (first - second) / 2 : (second - first) / 2;
	*deviation = first > second ? (first - second) / 2 : (second - first) / 2;
	return (first + second) / 2;
}

double Average(double first, double second, double third)
{
	return (first + second + third) / 3;
}

int main(void)
{
	double a, b, c, d;

	printf("Enter two values: ");
	scanf("%lf%lf", &b, &c);

	a = Average(b, c, &d);
	printf("Average is %lf with a deviation of %lf\n", a, d);
}

