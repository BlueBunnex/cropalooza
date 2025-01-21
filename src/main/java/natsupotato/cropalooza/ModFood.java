package natsupotato.cropalooza;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModFood {

    public static final Item MARSHMALLOW = register("marshmallow", 2, 0.4f);
    public static final Item MARSHMALLOW_ROASTED = register("marshmallow_roasted", 3, 1f);

    public static void init() {}

    public static Item register(String path, int nutrition, float saturation) {

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Cropalooza.MOD_ID, path));

        Item item = new Item(
                new Item.Settings()
                        .food(new FoodComponent(nutrition, saturation, false))
                        .registryKey(itemKey)
        );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> itemGroup.add(item));

        Registry.register(Registries.ITEM, itemKey.getValue(), item);

        return item;
    }
}
