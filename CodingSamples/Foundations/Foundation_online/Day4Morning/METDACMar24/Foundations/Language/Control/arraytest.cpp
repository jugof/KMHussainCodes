#include <cstdio>

//a global array identified by year with 12 elements of int type
//specified in the initializer (right-hand side)
int year[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

int main(void)
{
	int month;

	printf("Month[1-12]: ");
	scanf("%d", &month);

	int days = year[month - 1];
	double amount = days * (days + 1) / 2.0;

	printf("Total Amount: %.2lf\n", amount);
}

