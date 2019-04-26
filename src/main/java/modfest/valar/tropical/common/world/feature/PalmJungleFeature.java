package modfest.valar.tropical.common.world.feature;

import java.util.Random;

import modfest.valar.tropical.util.gen.BlockGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;

public class PalmJungleFeature extends AbstractPalmFeature
{

	public PalmJungleFeature(boolean notify)
	{
		super(notify, 8);
	}

	@Override
	protected void generateBlocks(ModifiableTestableWorld world, BlockGenerator generator, int height, Random rand,
			BlockPos pos)
	{
		int bendDirection = rand.nextInt(4);

		//Leaves
		BlockPos leavesOrigin = pos.add(2 * getBendX(bendDirection), height, 2 * getBendZ(bendDirection));
		
		generator.setBlock(leavesOrigin, LEAVES, true);
		
		for (int n = -2; n < 3; ++n)
		{
			if (n == 0) continue;
			
			int k = Math.abs(n) == 2 ? -1 : 0;
			
			for (int y = k; y < 1; ++y)
			{
				generator.setBlock(leavesOrigin.add(n, y, 0), LEAVES, true);
				generator.setBlock(leavesOrigin.add(0, y, n), LEAVES, true);
			}
		}

		//Log
		for (int i = 0; i < height; ++i)
		{
			generator.setBlock(getBend(pos, i, bendDirection), LOG, false);
		}

		//TODO Coconut
	}

	private BlockPos getBend(BlockPos pos, int up, int direction)
	{
		if (up > 0)
		{
			if (up > 3)
				return pos.add(2 * getBendX(direction), up, 2 * getBendZ(direction));
			else
				return pos.add(1 * getBendX(direction), up, 1 * getBendZ(direction));
		}
		else return pos.up(up);
	}

	private int getBendZ(int d)
	{
		if (d == 0)
			return 1;
		else if (d == 2)
			return -1;
		else return 0;
	}

	private int getBendX(int d)
	{
		if (d == 1)
			return 1;
		else if (d == 3)
			return -1;
		else return 0;
	}

}
