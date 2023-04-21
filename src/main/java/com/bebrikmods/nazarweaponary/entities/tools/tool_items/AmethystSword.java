package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.AmethystToolMaterial;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.minecraft.entity.effect.StatusEffects;

public class AmethystSword extends ModSword{
    public AmethystSword(String path, StatusEffects... statusEffects) {
        super(new AmethystToolMaterial(), 5, -1.0F);
        ItemRegistrator.addItem(path, this);
    }
}
