long Compute(int lower, int upper, short step)
{
	long result = 0;

	if(upper < lower)
		throw upper; //exit the function with an exception of int type

	if(step <= 0)
		throw step;

	for(int value = lower; value <= upper; value += step)
	{
		result += value * value;
	}

	return result;
}

