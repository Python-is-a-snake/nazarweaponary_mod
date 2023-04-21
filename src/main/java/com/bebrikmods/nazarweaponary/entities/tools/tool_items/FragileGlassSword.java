package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.FragileGlassToolMaterial;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;


public class FragileGlassSword extends ModSword{
    public FragileGlassSword(String path, StatusEffect... statusEffects) {
        super(new FragileGlassToolMaterial(), 3, -2.0F, statusEffects);
        ItemRegistrator.addItem(path, this);
    }

}
