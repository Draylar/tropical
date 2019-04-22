package modfest.valar.tropical.util.noise;

public interface NoiseGenerator
{
    long getSeed();

    double eval(double x, double y);
    double eval(double x, double y, double z);
}
