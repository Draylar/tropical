package modfest.valar.tropical.util.properties;

public class MathUtils
{
	public static double sigmoid(double in, double scale, double offset, double xScale, double xOffset)
	{
		return scale * (1D / (
				1D + Math.exp(
						-((in + xOffset) * xScale)
				)
			)
		) + offset;
	}
}
