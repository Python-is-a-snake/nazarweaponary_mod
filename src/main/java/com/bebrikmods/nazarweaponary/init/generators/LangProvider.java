package com.bebrikmods.nazarweaponary.init.generators;

import com.bebrikmods.nazarweaponary.init.registrators.BlockRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.StatusEffectRegistrator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class LangProvider extends FabricLanguageProvider {

    public LangProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator, "en_us");
    }
    private static final String PREFIX = "#NW# " ;

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        for(String key : BlockRegistrator.MOD_BLOCKS.keySet()){
            Block currentBlock = BlockRegistrator.MOD_BLOCKS.get(key);
            translationBuilder.add(currentBlock,
                    PREFIX + currentBlock.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2"));
        }

        for(String key : ItemRegistrator.MOD_ITEM.keySet()){
            Item currentItem = ItemRegistrator.MOD_ITEM.get(key);
            if(currentItem instanceof ArmorItem || currentItem instanceof BlockItem){
                continue; // Lang files (or tags) collision here
            }
            translationBuilder.add(currentItem,
                    PREFIX + currentItem.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2"));
        }

        for(String key: StatusEffectRegistrator.MOD_EFFECTS.keySet()){
            StatusEffect currentStatusEffect = StatusEffectRegistrator.MOD_EFFECTS.get(key);
            translationBuilder.add(currentStatusEffect,
                    PREFIX + currentStatusEffect.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2"));
        }

    }
}
