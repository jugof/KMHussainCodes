#include <cstdio>

int main(void)
{
	long lower, upper;

	printf("Lower and Upper Limits: ");
	scanf("%ld%ld", &lower, &upper);

	long result = 0;
	for(long num = lower; num <= upper; ++num)
	{
		result += num * num;
	}

	printf("Computation result = %ld\n", result);

}

