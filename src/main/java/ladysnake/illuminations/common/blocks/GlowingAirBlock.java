package ladysnake.illuminations.common.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.EntityContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

import java.util.Random;

public class GlowingAirBlock extends AirBlock {
    public GlowingAirBlock(Settings block$Settings_1) {
        super(block$Settings_1);
    }

    @Override
    public void onScheduledTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1) {
        System.out.println("Called");
        world_1.setBlockState(blockPos_1, Blocks.AIR.getDefaultState());
    }

    @Override
    public boolean isAir(BlockState blockState_1) {
        return false;
    }
}
