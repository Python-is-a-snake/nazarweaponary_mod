package com.bebrikmods.nazarweaponary.registry;

import com.bebrikmods.nazarweaponary.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings
            .of(Material.STONE, MapColor.BRIGHT_RED)
            .requiresTool()
            .strength(1f, 0.2f)
            .sounds(BlockSoundGroup.METAL));

//    public static void registerBlocks(){
//        Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
//    }

}
