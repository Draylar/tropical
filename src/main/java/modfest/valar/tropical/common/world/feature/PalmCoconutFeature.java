package modfest.valar.tropical.common.world.feature;

import java.util.Random;
import java.util.Set;

import modfest.valar.tropical.util.gen.BlockGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableIntBoundingBox;
import net.minecraft.world.ModifiableTestableWorld;

public class PalmCoconutFeature extends AbstractPalmFeature
{

	public PalmCoconutFeature(boolean notify)
	{
		super(notify, 6);
	}

	@Override
	protected void generateBlocks(ModifiableTestableWorld world, BlockGenerator generator, int height, Random rand,
			BlockPos pos)
	{
		int bendDirection = rand.nextInt(4);

		//Leaves
		BlockPos leavesOrigin = pos.add(2 * getBendX(bendDirection), height, 2 * getBendZ(bendDirection));

		generator.setBlock(leavesOrigin, LEAVES, true);

		for (int x = -1; x < 2; ++x)
			for (int z = -1; z < 2; ++z)
				if (x != 0 || z != 0)
					generator.setBlock(leavesOrigin.add(x, -1, z), LEAVES, true);

		for (int y = -3; y <= 0; ++y)
		{
			if (y == -1) continue;
			
			int k = (y == -3) ? 2 : 1;
			
			for (int i = k; i <= 2; ++i)
			{
				generator.setBlock(leavesOrigin.add(i, y, 0), LEAVES, true);
				generator.setBlock(leavesOrigin.add(-i, y, 0), LEAVES, true);
				generator.setBlock(leavesOrigin.add(0, y, i), LEAVES, true);
				generator.setBlock(leavesOrigin.add(0, y, -i), LEAVES, true);
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
			if (up > 2)
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

	@Override
	protected boolean generate(Set<BlockPos> set, ModifiableTestableWorld modifiableTestableWorld, Random random, BlockPos blockPos, MutableIntBoundingBox mutableIntBoundingBox)
	{
		return false;
	}
}
