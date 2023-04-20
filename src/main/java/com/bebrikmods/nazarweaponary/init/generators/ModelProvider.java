package com.bebrikmods.nazarweaponary.init.generators;

import com.bebrikmods.nazarweaponary.init.Initializer;
import com.bebrikmods.nazarweaponary.init.registrators.BlockRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

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
            Item currentItem = ItemRegistrator.MOD_ITEM.get(key);

            if(currentItem instanceof BlockItem){
                itemModelGenerator.register(currentItem, new Model(Optional.of(new Identifier(Initializer.MOD_ID, "block/" + key)), Optional.empty()));

            } else if (currentItem instanceof SwordItem) {
                // Create a new model object with the desired parent
                //Model swordModel = new Model(Optional.of(new Identifier("nazarweaponary", "item/" + key)), Optional.of(new Identifier("minecraft:item/handheld")));
                itemModelGenerator.register(currentItem, Models.HANDHELD);
            } else {
                itemModelGenerator.register(currentItem, Models.GENERATED);
            }
        }
    }
}
