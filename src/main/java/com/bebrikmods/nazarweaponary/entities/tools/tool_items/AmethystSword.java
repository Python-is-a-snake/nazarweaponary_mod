package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.AmethystToolMaterial;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.StatusEffectRegistrator;

public class AmethystSword extends ModSword{
    public AmethystSword(String path) {
        super(new AmethystToolMaterial(), 5, -1.0F, StatusEffectRegistrator.MOD_EFFECTS.get("exp"));
        ItemRegistrator.addItem(path, this);
    }
}
