package ladysnake.illuminations.common.init;

import ladysnake.illuminations.common.Illuminations;
import ladysnake.illuminations.common.items.WillOWispItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class IlluminationsItems {

    public static Item WILL_O_WISP;
    public static Item FIRE_SPIRIT;

    public static void init() {
        WILL_O_WISP = registerItem(new WillOWispItem(IlluminationsEntities.WILL_O_WISP, new Item.Settings().itemGroup(ItemGroup.MISC)), "will_o_wisp");
        FIRE_SPIRIT = registerItem(new WillOWispItem(IlluminationsEntities.FIRE_SPIRIT, new Item.Settings().itemGroup(ItemGroup.MISC)), "fire_spirit");
    }

    public static Item registerItem(Item item, String name) {
        Registry.register(Registry.ITEM, Illuminations.MOD_ID + ":" + name, item);
        return item;
    }

}