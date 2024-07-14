#include <cstdio>

void Swap(long* first, long* second)
{
	long third = *first;

	*first = *second;
	*second = third;
}

int main(void)
{
	long x = 43, y = 56;

	printf("Original values: %ld, %ld\n", x, y);
	Swap(&x, &y);
	printf("Swapped values : %ld, %ld\n", x, y);
}

