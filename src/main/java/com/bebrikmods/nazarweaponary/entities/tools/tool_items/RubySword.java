package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.RubyToolMaterial;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

public class RubySword extends ModSword{
    public RubySword(String path, StatusEffect... statusEffects) {
        super(new RubyToolMaterial(), 5, -1.0F, statusEffects);
        ItemRegistrator.addItem(path, this);
    }
}
