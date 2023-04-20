package com.bebrikmods.nazarweaponary.init.generators;

import com.bebrikmods.nazarweaponary.entities.blocks.SapphireOre;
import com.bebrikmods.nazarweaponary.init.Initializer;
import com.bebrikmods.nazarweaponary.init.registrators.BlockRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.NoSuchElementException;

public class LangProvider extends FabricLanguageProvider {

    public LangProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        for(String key : BlockRegistrator.MOD_BLOCKS.keySet()){
            Block currentBlock = BlockRegistrator.MOD_BLOCKS.get(key);
            translationBuilder.add(currentBlock, "#NW# " + currentBlock.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2"));
        }

        for(String key : ItemRegistrator.MOD_ITEM.keySet()){
            Item currentItem = ItemRegistrator.MOD_ITEM.get(key);
            if(currentItem instanceof BlockItem){
                continue;
            }
            translationBuilder.add(currentItem, "#NW# " + currentItem.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2"));
        }
    }

}
