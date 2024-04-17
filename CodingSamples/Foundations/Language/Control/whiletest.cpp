#include <cstdio>

int main(void)
{
	long num;

	printf("Positive Integer: ");
	scanf("%ld", &num);

	long sum = 0;

	while(num > 0)
	{
		sum += num % 10; // sum = sum + num % 10
		num /= 10; // num = num / 10
	}

	printf("Sum of digits = %ld\n", sum);

}

