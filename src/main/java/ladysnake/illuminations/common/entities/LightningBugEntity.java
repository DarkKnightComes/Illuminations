package ladysnake.illuminations.common.entities;

import ladysnake.illuminations.common.init.IlluminationsEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnType;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

public class LightningBugEntity extends FireflyEntity {

    public LightningBugEntity(EntityType<? extends LightningBugEntity> type, World world) {
        super(type, world);

        this.scaleModifier = 0.1F + new Random().nextFloat() * 0.15F;
        this.colorModifier = 0.5F + new Random().nextFloat() * 0.5F;
        this.alpha = 1F;

        this.canDespawn = true;
        this.isAttractedByLight = true;
    }

    public LightningBugEntity(World world, double x, double y, double z) {
        this(IlluminationsEntities.LIGHTNING_BUG, world);
        this.setPosition(x, y, z);
    }

    @Override
    public boolean canSpawn(IWorld world, SpawnType spawnType) {
        return !this.world.isDaylight() && this.world.isThundering();
    }

}
