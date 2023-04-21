package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.FragileGlassToolMaterial;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FragileGlassSword extends ModSword{
    public FragileGlassSword(String path, StatusEffects... statusEffects) {
        super(new FragileGlassToolMaterial(), 3, -2.0F);
        ItemRegistrator.addItem(path, this);
    }

}
