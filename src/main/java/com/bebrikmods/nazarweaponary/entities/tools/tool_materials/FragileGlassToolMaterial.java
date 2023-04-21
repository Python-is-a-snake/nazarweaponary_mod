package com.bebrikmods.nazarweaponary.entities.tools.tool_materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FragileGlassToolMaterial implements ToolMaterial {

    @Override
    public int getDurability() {
        return 10;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1.0F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems();
    }
}
