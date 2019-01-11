package ladysnake.illuminations.common.items;

import ladysnake.illuminations.common.entities.WillOWispEntity;
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

    public WillOWispItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stackInHand = player.getStackInHand(hand);
        if (!player.abilities.creativeMode) {
            stackInHand.subtractAmount(1);
        }

        if (!player.isSneaking()) world.playSound((PlayerEntity)null, player.x, player.y, player.z, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            WillOWispEntity wispSpawned = new WillOWispEntity(world, player);
            if (!player.isSneaking()) {
                wispSpawned.beingThrown = true;
                wispSpawned.calculateVelocity(player, player.pitch, player.yaw, 0.0F, 1.5F, 1.0F);
            }
            world.spawnEntity(wispSpawned);
        }

        return new TypedActionResult(ActionResult.SUCCESS, stackInHand);
    }



}
