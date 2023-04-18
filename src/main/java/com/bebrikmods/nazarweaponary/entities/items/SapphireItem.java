package com.bebrikmods.nazarweaponary.entities.items;

import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;

public class SapphireItem extends Item {
    private String path;

    public SapphireItem(String path) {
        super(new FabricItemSettings().group(ItemGroup.MATERIALS).fireproof().rarity(Rarity.UNCOMMON).maxCount(64));
        this.path = path;
        ItemRegistrator.addItem(path, this);
    }

}
