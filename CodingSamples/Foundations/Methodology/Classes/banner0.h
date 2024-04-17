double BannerPrice(float width, float height, bool triangular)
{
	float k = triangular ? 0.5 : 1.0;

	return 0.80 * k * width * height;
}

