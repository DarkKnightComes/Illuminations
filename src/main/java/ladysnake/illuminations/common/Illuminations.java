package ladysnake.illuminations.common;

import ladysnake.illuminations.common.init.IlluminationsEntities;
import ladysnake.illuminations.common.init.IlluminationsItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;

public class Illuminations implements ModInitializer {
    public static final String MOD_ID = "illuminations";

    @Override
    public void onInitialize() {
        IlluminationsEntities.init();
        IlluminationsItems.init();
    }

    public static Item getWillOWispItemFromEntity(EntityType entityType) {
        if (entityType == IlluminationsEntities.WILL_O_WISP) return IlluminationsItems.WILL_O_WISP;
        else if (entityType == IlluminationsEntities.FIRE_SPIRIT) return IlluminationsItems.FIRE_SPIRIT;
        else return null;
    }

}

