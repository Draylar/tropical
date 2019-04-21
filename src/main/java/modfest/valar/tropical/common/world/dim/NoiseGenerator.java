package modfest.valar.tropical.common.world.dim;

public interface NoiseGenerator
{
    long getSeed();

    double eval(double x, double y);
    double eval(double x, double y, double z);
}
