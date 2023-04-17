package com.bebrikmods.nazarweaponary.registry;

import com.bebrikmods.nazarweaponary.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //Items
    public static final Item RUBY = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS).fireproof().rarity(Rarity.UNCOMMON).maxCount(16));
    public static final Item SAPPHIRE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS).fireproof().rarity(Rarity.UNCOMMON).maxCount(16));

    //Block Items
    public static final BlockItem RUBY_BLOCK = new BlockItem(ModBlocks.RUBY_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));

    //modid:itemName
    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, "sapphire"), SAPPHIRE);
        Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
    }

}
