#include <cstdio>

//default argument which appears at the end of parameter-list
//is automatically passed by the compiler if it is not passed
//by the caller
extern long Compute(int, int, short = 1);

int main(void)
{
	int l, u;

	printf("Lower and Upper Limits: ");
	scanf("%d%d", &l, &u);

	try
	{
		printf("First computation result : %ld\n", Compute(l, u));
		printf("Second computation result: %ld\n", Compute(l, u, 2));
		printf("Second computation result: %ld\n", Compute(l, u, -1));
	}
	catch(int e)
	{
		printf("Error - Invalid upper limit: %d\n", e);
	}
	catch(...)
	{
		puts("Error - Invalid step!");
	}
	puts("Goodbye.");
}


