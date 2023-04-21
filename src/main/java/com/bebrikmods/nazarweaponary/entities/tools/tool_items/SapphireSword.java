package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.SapphireToolMaterial;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.minecraft.entity.effect.StatusEffects;

public class SapphireSword extends ModSword {
    public SapphireSword(String path, StatusEffects... statusEffects) {
        super(new SapphireToolMaterial(), 5, -1.0F);
        ItemRegistrator.addItem(path, this);
    }
}
