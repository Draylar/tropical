package modfest.valar.tropical.common.world.feature;

import java.util.Random;

import modfest.valar.tropical.util.gen.BlockGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;

public class BeachSpikeFeature extends AbstractTropicalTreeFeature
{

	public BeachSpikeFeature()
	{
		super(false, 3, 5);
		
		this.setBeachFeature();
		this.setStoneResistant();
	}

	@Override
	protected void generateBlocks(ModifiableTestableWorld world, BlockGenerator generator, int height, Random rand,
			BlockPos pos)
	{
		for (int i = 0; i < height; ++i)
		{
			boolean b = i < height - 3;
			
			int k0 = b ? -1 : 0;
			
			int k1 = b ? (rand.nextInt(3) - 1) : 0;
			int k2 = b ? (rand.nextInt(3) - 1) : 0;
			
			for (int x = 0 + k1 + k0; x < 2 + k1; ++x)
				for (int z = 0 + k0 + k2; z < 2 + k2; ++z)
					generator.setBlock(pos.add(x, i, z), rand.nextBoolean() ? Blocks.STONE.getDefaultState() : Blocks.COBBLESTONE.getDefaultState(), true);
		}
		
		int x = rand.nextInt(2);
		int z = rand.nextInt(2);
		
		generator.setBlock(pos.add(x, height, z), rand.nextBoolean() ? Blocks.STONE.getDefaultState() : Blocks.COBBLESTONE.getDefaultState(), true);
	}

}
