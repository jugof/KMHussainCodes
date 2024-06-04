#include <cstdio>
#include <cmath>

int Compute(int upper) //_Z7Computei
{
	puts("Performing simple computation...");
	return upper * (upper + 1) / 2;
}

//function overloading - defining a function whose name matches
//with the name of an existing function but with a different
//list of parameter types
double Compute(int upper, float degree) //_Z7Computeif
{
	double result = 0;

	puts("Performing complex computation...");
	for(int value = 1; value <= upper; ++value)
	{
		result += pow(value, degree);
	}

	return result;
}

int main(void)
{
	int count;
	printf("Count: ");
	scanf("%d", &count);
	printf("Result = %d\n", Compute(count));

	float level;
	printf("Level: ");
	scanf("%f", &level);
	printf("Result = %lf\n", Compute(count, level));
}

