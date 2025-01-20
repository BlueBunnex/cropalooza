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

public class ModItems {

    public static final Item SUSPICIOUS_SUBSTANCE = register(
            new Item.Settings().food(new FoodComponent(2, 0.4f, false)),
            "suspicious_substance"
    );

    public static void init() {}

    public static Item register(Item.Settings itemSettings, String path) {

        RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Cropalooza.MOD_ID, path));
        Item item = new Item(itemSettings.registryKey(registryKey));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> itemGroup.add(item));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }
}
