package modfest.valar.tropical.common.world.dim;

import modfest.valar.tropical.TropicalMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.HashSet;

public class TeleportPlacementHandler
{
    public static void enterDimension(Entity entity, ServerWorld previousWorld, ServerWorld newWorld)
    {
        if (newWorld.dimension.getType() == TropicalMod.TROPICAL_DIMENSION)
        {
            BlockPos spawnPos = new BlockPos(0, 100, 0);
            entity.setPositionAndAngles(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), 0, 0);
        }
    }

    public static void leaveDimension(Entity entity, ServerWorld previousWorld, ServerWorld newWorld){
        BlockPos spawnLocation = getBedLocation((PlayerEntity) entity, newWorld);

        if (spawnLocation == null) {
            spawnLocation = newWorld.getSpawnPos();
        }

        setEntityLocation(entity, spawnLocation);
    }


    public static BlockPos getBedLocation(PlayerEntity player, ServerWorld world) {
        BlockPos bedLocation = player.getSpawnPosition();
        if (bedLocation == null) {
            return null;
        }
        //method_7288 = getBedSpawn
        BlockPos bedSpawnLocation = PlayerEntity.method_7288(world, bedLocation, false);
        return bedSpawnLocation;
    }

    public static void setEntityLocation(Entity entity, BlockPos pos) {
        if (entity instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity) entity).networkHandler.teleportRequest(pos.getX(), pos.getY(), pos.getZ(), 0, 0, new HashSet<>());
            ((ServerPlayerEntity) entity).networkHandler.syncWithPlayerPosition();
        } else {
            entity.setPositionAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
        }
    }
}
