package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.RubyToolMaterial;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RubySword extends ModSword{
    public RubySword(String path, StatusEffects... statusEffects) {
        super(new RubyToolMaterial(), 5, -1.0F);
        ItemRegistrator.addItem(path, this);
    }
}
