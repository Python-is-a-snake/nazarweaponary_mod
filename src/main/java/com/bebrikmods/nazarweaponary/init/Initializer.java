package com.bebrikmods.nazarweaponary.init;

import com.bebrikmods.nazarweaponary.entities.blocks.RubyBlock;
import com.bebrikmods.nazarweaponary.entities.items.AmethystItem;
import com.bebrikmods.nazarweaponary.entities.items.RubyItem;
import com.bebrikmods.nazarweaponary.entities.items.SapphireItem;
import com.bebrikmods.nazarweaponary.init.registrators.BlockRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;
import java.util.List;

public class Initializer implements ModInitializer{
    /*
    TO CREATE NEW ITEM/BLOCK:
        1)CREATE CLASS
        2)ADD NAME TO assets..lang
        3)ADD ITEM_ID.json TO assets..models.item OR assets..models.block
        4)ADD TEXTURE TO assets..textures.items OR assets..textures.blocks
        5 OPT.) ADD RECIPES TO data..recipes
        6)ADD block_name.json TO data..loot_tables - CREATES LOOT DROP TABLES (from mining block)
     */
    public static final String MOD_ID = "nazarweaponary";

    public static final Item SAPPHIRE = new SapphireItem("sapphire");
    public static final Item RUBY = new RubyItem("ruby");
    public static final Block RUBY_BLOCK = new RubyBlock("ruby_block");
    public static final Item AMETHYST = new AmethystItem("amethyst");

    private static ConfiguredFeature<?, ?> OVERWORLD_WOOL_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    Initializer.RUBY_BLOCK.getDefaultState(),
                    9)); // vein size

    public static PlacedFeature OVERWORLD_WOOL_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_WOOL_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(30), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))// height
            ));

    public  void onInitialize() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("nazarweaponary", "overworld_wool_ore"), OVERWORLD_WOOL_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("nazarweaponary", "overworld_ruby_blocks"),
                OVERWORLD_WOOL_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("nazarweaponary", "overworld_ruby_blocks")));


        ItemRegistrator.registerAllItems();
        BlockRegistrator.registerAllBlocks();
    }





}
