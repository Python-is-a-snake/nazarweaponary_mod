package com.bebrikmods.nazarweaponary.entitys.items;

import com.bebrikmods.nazarweaponary.init.registrators.MyItemRegistrator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;

public class RubyItem extends Item {
    private String path;

    public RubyItem(String path) {
        super(new FabricItemSettings().group(ItemGroup.MATERIALS).fireproof().rarity(Rarity.UNCOMMON).maxCount(64));
        this.path = path;
        MyItemRegistrator.addItem(path, this);
    }

}