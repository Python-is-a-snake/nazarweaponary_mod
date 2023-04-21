package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.SapphireToolMaterial;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

public class SapphireSword extends ModSword {
    public SapphireSword(String path, StatusEffect... statusEffects) {
        super(new SapphireToolMaterial(), 5, -1.0F, statusEffects);
        ItemRegistrator.addItem(path, this);
    }
}
