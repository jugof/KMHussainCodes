#include "series1.h"
#include <cstdio>
#include <cmath>

double Compute(Series::Sequence* seq, int count)
{
	double sum = 0;

	for(int i = 0; i < count; ++i)
	{
		double term = seq->Next();
		sum += term * term;
	}

	return sqrt(sum / count);
}

int main(void)
{
	int n;
	printf("Number of terms: ");
	scanf("%d", &n);

	Series::LinearSequence a(2, 5);
	Series::PowerSequence b(2);

	printf("First computation result for linear-sequence : %.3lf\n", Compute(&a, n));
	printf("First computation result for power-sequence  : %.3lf\n", Compute(&b, n));
	printf("Second computation result for linear-sequence: %.3lf\n", Compute(&a, n));
	printf("Second computation result for power-sequence : %.3lf\n", Compute(&b, n));
}

