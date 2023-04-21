package com.bebrikmods.nazarweaponary.entities.tools.armor_materials;

import com.bebrikmods.nazarweaponary.init.Initializer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public enum ModArmorMaterial implements ArmorMaterial {
    /* ========================== VANILLA VALUES ==========================
    LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f,
            0.0f, () -> Ingredient.ofItems(Items.LEATHER)),
    DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, () -> Ingredient.ofItems(Items.DIAMOND)),
     */
    RUBY("ruby_armor_material",
            40,                            // DURABILITY MULTIPLAYER
            new int[]{4, 8, 10, 5},                      // BOOTS, LEGGINGS, CHESTPLATE, HELMET
            20,                                          // ENCHANTABILITY
            SoundEvents.BLOCK_AMETHYST_BLOCK_STEP,       // EQUIP SOUND
            2.0F,                                        // TOUGHNESS
            0.5F,                                        // KNOCKBACK RESISTANCE
            Ingredient.ofItems(Initializer.RUBY),        // REPAIR INGREDIENT
            new int[]{13, 15, 16, 11});                  // BASE DURABILITY

    //private static final int[] BASE_DURABILITY;
    private final int[] baseDurability;
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Ingredient ingredient;

//    static {
//        BASE_DURABILITY = new int[]{13, 15, 16, 11};
//    }

    private ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts,
                             int enchantability, SoundEvent equipSound, float toughness,
                             float knockbackResistance, Ingredient ingredient, int[] baseDurability) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.ingredient = ingredient;
        this.baseDurability = baseDurability;
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return baseDurability[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.ingredient;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
