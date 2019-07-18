package modfest.valar.tropical.util.noise;

import java.util.function.DoubleFunction;

import modfest.valar.common.noise.NoiseGenerator;
import modfest.valar.common.noise.OpenSimplexNoise;

public class TweakableOctaveNoiseGenerator implements Cloneable, NoiseGenerator, DoubleFunction<TweakableOctaveNoiseGenerator>
{
    private SingleNoiseGenerator[] generators;

    public static final double INITIAL_SCALE = 1D;

    private final long seed;
    private final int octaves;
    
    private double appliedDouble = 1;
    
    public TweakableOctaveNoiseGenerator(long seed, int octaves)
    {
        this.seed = seed;
        this.octaves = octaves;
        
        generators = new SingleNoiseGenerator[octaves];

        for (int i = 0; i < octaves; ++i)
            generators[i] = new SingleNoiseGenerator(seed, INITIAL_SCALE / Math.pow(2, i), 1D / (i + 1D));
    }

    @Override
    public double eval(double x, double y)
    {
        double d0 = 0D;

        for (SingleNoiseGenerator generator : generators)
            d0 += generator.eval(x, y);

        return d0;
    }

    @Override
    public double eval(double x, double y, double z)
    {
        double d0 = 0D;

        for (SingleNoiseGenerator generator : generators)
            d0 += generator.eval(x, y, z);

        return d0;
    }

    @Override
    public long getSeed()
    {
        return this.seed;
    }

    public int getOctaveCount()
    {
        return this.octaves;
    }

    public static class SingleNoiseGenerator implements NoiseGenerator, DoubleFunction<SingleNoiseGenerator>
    {
        private final long seed;
        private double scale, amplitude;

        private final OpenSimplexNoise parent;

        public SingleNoiseGenerator(long seed, double scale, double amplitude)
        {
            this.seed = seed;
            this.scale = scale;
            this.amplitude = amplitude;
            
            this.parent = new OpenSimplexNoise(seed);
        }

        @Override
        public long getSeed()
        {
            return this.seed;
        }

        @Override
        public double eval(double x, double y)
        {
            return amplitude * this.parent.eval(x / scale, y / scale);
        }

        @Override
        public double eval(double x, double y, double z)
        {
            return amplitude * this.parent.eval(x / scale, y / scale, z / scale);
        }

        @Override
        public SingleNoiseGenerator apply(double value)
        {
            this.scale = value;
            return this;
        }
    }

    @Override
    public TweakableOctaveNoiseGenerator apply(double arg0)
    {
        for (int i = 0; i < octaves; ++i)
            generators[i] = generators[i].apply(arg0 / Math.pow(2, i));
        
        this.appliedDouble = arg0;
        
        return this;
    }
    
    public TweakableOctaveNoiseGenerator tweak(double arg0)
    {
        for (int i = 0; i < octaves; ++i)
            generators[i] = generators[i].apply((arg0 * this.appliedDouble) / Math.pow(2, i));
        
        this.appliedDouble *= arg0;
        
        return this;
    }
    
    @Override
    public TweakableOctaveNoiseGenerator clone()
    {
    	return new TweakableOctaveNoiseGenerator(this.getSeed(), this.octaves).apply(this.appliedDouble);
    }
    
    public TweakableOctaveNoiseGenerator clone(long seedOffset)
    {
    	return new TweakableOctaveNoiseGenerator(this.getSeed() + seedOffset, this.octaves).apply(this.appliedDouble);
    }

}
