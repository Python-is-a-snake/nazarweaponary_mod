package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.SapphireToolMaterial;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Rarity;

public class SapphireSword extends ModSword {

    public SapphireSword(String path) {
        super(new SapphireToolMaterial(), 5, -1.0F, StatusEffects.SPEED);
        ItemRegistrator.addItem(path, this);
    }

}
