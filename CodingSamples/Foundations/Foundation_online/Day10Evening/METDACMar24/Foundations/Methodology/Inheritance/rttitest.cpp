#include "series2.h"
#include <cstdio>
#include <cmath>

//ask compiler to qualify names of symbols declared in Series namespace
using namespace Series;

double Compute(Sequence* seq, int count)
{
	double sum = 0;

	//using dynamic_cast for side-casting Sequence* to Resetable*
	//dynamic_cast uses runtime type information (RTTI) from v-table
	//to examine if the source pointer (seq) points to an instance
	//which is compatible with the target type (Resetable*) and if
	//so it returns a pointer of target type otherwise it retuns nullptr
	Resetable* r = dynamic_cast<Resetable*>(seq);
	if(r != nullptr)
		r->Reset();		

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

	LinearSequence a(2, 5);
	PowerSequence b(2);

	printf("First computation result for linear-sequence : %.3lf\n", Compute(&a, n));
	printf("First computation result for power-sequence  : %.3lf\n", Compute(&b, n));
	printf("Second computation result for linear-sequence: %.3lf\n", Compute(&a, n));
	printf("Second computation result for power-sequence : %.3lf\n", Compute(&b, n));
}

