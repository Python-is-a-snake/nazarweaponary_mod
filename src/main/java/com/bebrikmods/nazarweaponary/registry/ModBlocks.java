package com.bebrikmods.nazarweaponary.registry;

import com.bebrikmods.nazarweaponary.TutorialMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL, MapColor.BRIGHT_RED)
            .requiresTool()
            .strength(5.0f, 6.0f)
            .sounds(BlockSoundGroup.METAL));

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
    }
}
