package ladysnake.illuminations.mixin;

import ladysnake.illuminations.common.Illuminations;
import ladysnake.illuminations.common.init.IlluminationsBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.LanternBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.TaskPriority;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(LivingEntity.class)
public abstract class LanternLivingEntityMixin extends Entity {
    // make compiler happy 😊
    private LanternLivingEntityMixin(EntityType<?> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void tick(CallbackInfo callback) {
        LivingEntity livingEntity = (LivingEntity)(Object) this;
        if (livingEntity instanceof PlayerEntity) {
            if (((PlayerEntity)livingEntity).getMainHandStack().getItem() == Items.LANTERN) {
                if (livingEntity.world.getBlockState(livingEntity.getBlockPos()).isAir()) {
                    BlockPos blockPos = livingEntity.getBlockPos();
                    livingEntity.world.setBlockState(blockPos, IlluminationsBlocks.GLOWING_AIR.getDefaultState());
                    world.getBlockTickScheduler().schedule(blockPos, IlluminationsBlocks.GLOWING_AIR, 1);
                }
            }
        }
    }
}