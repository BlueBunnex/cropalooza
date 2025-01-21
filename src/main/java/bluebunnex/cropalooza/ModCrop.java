package bluebunnex.cropalooza;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModCrop {

    public static final ModCrop STRAWBERRY = new ModCrop("strawberry", 2, 0.4f);

    public final Item cropItem; // both a food and a seed
    public final Block cropBlock;

    public ModCrop(String path, int nutrition, float saturation) {

        Identifier id = Identifier.of(Cropalooza.MOD_ID, path);

        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);

        cropBlock = new CropBlock(
                AbstractBlock.Settings
                        .create()
                        .registryKey(blockKey)
                        .sounds(BlockSoundGroup.CROP)
                        .noCollision()
                        .ticksRandomly()
                        .breakInstantly()
                        .pistonBehavior(PistonBehavior.DESTROY)
        );

        cropItem = new BlockItem(
                cropBlock,
                new Item.Settings()
                        .food(new FoodComponent(nutrition, saturation, false))
                        .registryKey(itemKey)
        );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> itemGroup.add(cropItem));

        Registry.register(Registries.BLOCK, blockKey.getValue(), cropBlock);
        Registry.register(Registries.ITEM, itemKey.getValue(), cropItem);
    }

    public static void init() {}
}
