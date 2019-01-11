package ladysnake.illuminations.common.items;

import ladysnake.illuminations.common.entities.WillOWispEntity;
import ladysnake.illuminations.common.init.IlluminationsEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WillOWispItem extends Item {
    public EntityType entityType;

    public WillOWispItem(EntityType entityType, Settings settings) {
        super(settings);
        this.entityType = entityType;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stackInHand = player.getStackInHand(hand);
        if (!player.abilities.creativeMode) {
            stackInHand.subtractAmount(1);
        }

        if (!player.isSneaking()) world.playSound((PlayerEntity)null, player.x, player.y, player.z, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            WillOWispEntity entitySpawned = new WillOWispEntity(entityType, world, player);
            if (!player.isSneaking()) {
                entitySpawned.beingThrown = true;
                entitySpawned.calculateVelocity(player, player.pitch, player.yaw, 0.0F, 1.5F, 1.0F);
            }
            world.spawnEntity(entitySpawned);
        }

        return new TypedActionResult(ActionResult.SUCCESS, stackInHand);
    }



}
