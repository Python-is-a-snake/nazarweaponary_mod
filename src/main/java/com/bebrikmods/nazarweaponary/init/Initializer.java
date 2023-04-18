package com.bebrikmods.nazarweaponary.init;

import com.bebrikmods.nazarweaponary.entities.blocks.RubyOre;
import com.bebrikmods.nazarweaponary.entities.blocks.SapphireOre;
import com.bebrikmods.nazarweaponary.entities.items.AmethystItem;
import com.bebrikmods.nazarweaponary.entities.items.RubyItem;
import com.bebrikmods.nazarweaponary.entities.items.SapphireItem;
import com.bebrikmods.nazarweaponary.entities.tools.tool_items.RubyToolSword;
import com.bebrikmods.nazarweaponary.init.registrators.BlockRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
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
    public static final Block SAPPHIRE_BLOCK = new SapphireOre("sapphire_ore");

    public static final Item RUBY = new RubyItem("ruby");
    public static final Block RUBY_BLOCK = new RubyOre("ruby_ore");
    public static final Item AMETHYST = new AmethystItem("amethyst");
    public static final Item RUBY_SWORD = new RubyToolSword("ruby_sword");

    private static ConfiguredFeature<?, ?> OVERWORLD_RUBY_BLOCK_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    Initializer.RUBY_BLOCK.getDefaultState(),
                    5)); // vein size

    public static PlacedFeature OVERWORLD_RUBY_BLOCK_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_RUBY_BLOCK_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(5), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))// height
            ));

    public  void onInitialize() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("nazarweaponary", "overworld_wool_ore"), OVERWORLD_RUBY_BLOCK_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("nazarweaponary", "overworld_ruby_blocks"),
                OVERWORLD_RUBY_BLOCK_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("nazarweaponary", "overworld_ruby_blocks")));


        ItemRegistrator.registerAllItems();
        BlockRegistrator.registerAllBlocks();
    }





}
