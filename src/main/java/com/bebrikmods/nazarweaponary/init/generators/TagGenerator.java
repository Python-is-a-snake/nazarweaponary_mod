package com.bebrikmods.nazarweaponary.init.generators;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class TagGenerator extends FabricTagProvider<Item> {
    public TagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, Registry.ITEM);  // for versions 1.19.2 and below, use Registry.ITEM
    }

    @Override
    protected void generateTags() {

    }
}
