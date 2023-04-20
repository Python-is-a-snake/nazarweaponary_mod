package com.bebrikmods.nazarweaponary.entities.items;

import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;

public class SwordHandlerItem extends Item {
    public SwordHandlerItem(String path) {
        super(new FabricItemSettings().group(ItemGroup.COMBAT).fireproof().rarity(Rarity.UNCOMMON).maxCount(64));
        ItemRegistrator.addItem(path, this);
    }
}
