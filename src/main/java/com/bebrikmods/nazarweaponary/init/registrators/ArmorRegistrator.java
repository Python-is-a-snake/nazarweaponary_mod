package com.bebrikmods.nazarweaponary.init.registrators;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;

public class ArmorRegistrator {

    public static ArmorItem registerArmor(String path, ArmorItem armorItem){
        ItemRegistrator.addItem(path, armorItem);
        return armorItem;
    }
}
