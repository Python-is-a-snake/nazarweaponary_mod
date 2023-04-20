package com.bebrikmods.nazarweaponary.init.generators;

import com.bebrikmods.nazarweaponary.init.Initializer;
import com.bebrikmods.nazarweaponary.init.registrators.BlockRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for(String key : BlockRegistrator.MOD_BLOCKS.keySet()){
            blockStateModelGenerator.registerSimpleCubeAll(BlockRegistrator.MOD_BLOCKS.get(key));
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for(String key : ItemRegistrator.MOD_ITEM.keySet()){
            itemModelGenerator.register(ItemRegistrator.MOD_ITEM.get(key), Models.GENERATED);
        }
    }
}
