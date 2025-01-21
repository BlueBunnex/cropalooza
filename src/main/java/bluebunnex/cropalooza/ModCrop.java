package bluebunnex.cropalooza;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModCrop {

    public static final ModCrop STRAWBERRY = new ModCrop("strawberry");

    public final Item drop;
    public final Item seed;
    public final Item block;

    public ModCrop(String path) {

        Item.Settings itemSettings = new Item.Settings().food(new FoodComponent(2, 0.4f, false));

        seed = null;
        block = null;

        RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Cropalooza.MOD_ID, path));
        Item item = new Item(itemSettings.registryKey(registryKey));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> itemGroup.add(item));

        drop = Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    // https://docs.fabricmc.net/develop/blocks/first-block

    public static void init() {}
}
