package com.bebrikmods.nazarweaponary.init.generators;

import com.bebrikmods.nazarweaponary.init.Initializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.util.registry.Registry;
import java.util.Arrays;

public class OreGenerator {
    private final ConfiguredFeature<?, ?> configuredFeature;
    private final PlacedFeature placedFeature;

    public OreGenerator(String oreName, Block oreBlock, int veinCount, int veinSize, int maxHeight) {

        this.configuredFeature = new ConfiguredFeature(Feature.ORE,
                new OreFeatureConfig(
                        OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, oreBlock.getDefaultState(), veinSize));

        this.placedFeature = new PlacedFeature(
                RegistryEntry.of(configuredFeature),
                Arrays.asList(
                        CountPlacementModifier.of(veinCount), // number of veins per chunk
                        SquarePlacementModifier.of(), // spreading horizontally
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(maxHeight))// height
                ));
        register(oreName);
    }

    public void register(String oreName){
        Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(Initializer.MOD_ID, "overworld_"+oreName.toLowerCase()+"_ore"),
                configuredFeature);

        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Initializer.MOD_ID, "overworld_"+oreName.toLowerCase()+"_ore"),
                placedFeature);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(Initializer.MOD_ID, "overworld_"+oreName.toLowerCase()+"_ore")));
    }


}