package com.bebrikmods.nazarweaponary.init;

import com.bebrikmods.nazarweaponary.entities.blocks.RubyOre;
import com.bebrikmods.nazarweaponary.entities.blocks.SapphireOre;
import com.bebrikmods.nazarweaponary.entities.items.AmethystItem;
import com.bebrikmods.nazarweaponary.entities.items.RubyItem;
import com.bebrikmods.nazarweaponary.entities.items.SapphireItem;
import com.bebrikmods.nazarweaponary.entities.items.SwordHandlerItem;
import com.bebrikmods.nazarweaponary.entities.status_effects.ExpStatusEffect;
import com.bebrikmods.nazarweaponary.entities.tools.armor_materials.ModArmorMaterial;
import com.bebrikmods.nazarweaponary.entities.tools.tool_items.AmethystSword;
import com.bebrikmods.nazarweaponary.entities.tools.tool_items.FragileGlassSword;
import com.bebrikmods.nazarweaponary.entities.tools.tool_items.RubySword;
import com.bebrikmods.nazarweaponary.entities.tools.tool_items.SapphireSword;
import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.FragileGlassToolMaterial;
import com.bebrikmods.nazarweaponary.init.generators.OreGenerator;
import com.bebrikmods.nazarweaponary.init.registrators.ArmorRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.BlockRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.StatusEffectRegistrator;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Rarity;

public class Initializer implements ModInitializer{

    /*
    TO CREATE NEW ITEM/BLOCK:
        1)CREATE CLASS
        2)ADD TEXTURE TO assets..textures.item OR assets..textures.block
        3 OPT.) ADD RECIPES TO data..recipes
        4 OPT.)ADD block_name.json TO data..loot_tables - CREATES LOOT DROP TABLES (from mining block)
     */


    //DO NOT CHANGE THIS
    public static final String MOD_ID = "nazarweaponary";

    // ======================  BLOCKS ======================
    public static final Block RUBY_ORE = new RubyOre("ruby_ore");
    public static final Block SAPPHIRE_ORE = new SapphireOre("sapphire_ore");

    // ====================== ITEMS ======================
    public static final Item RUBY = new RubyItem("ruby");
    public static final Item SAPPHIRE = new SapphireItem("sapphire");
    public static final Item AMETHYST = new AmethystItem("amethyst");
    public static final Item SWORD_HANDLER = new SwordHandlerItem("sword_handler");
    private static final FabricItemSettings armorSettings = new FabricItemSettings().fireproof().maxCount(1).rarity(Rarity.RARE).group(ItemGroup.COMBAT);


    public static final Item RUBY_HELMET = ArmorRegistrator.registerArmor("ruby_helmet", new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.HEAD, armorSettings));
    public static final Item RUBY_CHESTPLATE = ArmorRegistrator.registerArmor("ruby_chestplate", new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.CHEST, armorSettings));
    public static final Item RUBY_LEGGINGS = ArmorRegistrator.registerArmor("ruby_leggings", new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.LEGS, armorSettings));
    public static final Item RUBY_BOOTS = ArmorRegistrator.registerArmor("ruby_boots", new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.FEET, armorSettings));

    // ====================== STATUS EFFECTS ======================

    public static final StatusEffect EXP = new ExpStatusEffect("exp");

    // TOOLS
    public static final ToolItem RUBY_SWORD = new RubySword("ruby_sword", StatusEffects.REGENERATION, StatusEffects.STRENGTH);
    public static final ToolItem SAPPHIRE_SWORD = new SapphireSword("sapphire_sword", StatusEffects.SPEED);
    private static final ToolItem AMETHYST_SWORD = new AmethystSword("amethyst_sword", EXP);
    private static final ToolItem FRAGILE_GLASS_SWORD = new FragileGlassSword("fragile_glass_sword");


    public  void onInitialize() {
        new OreGenerator("ruby", RUBY_ORE, 5, 5, 65);
        new OreGenerator("sapphire", SAPPHIRE_ORE, 5, 5, 65);

        StatusEffectRegistrator.registerAllEffects();
        ItemRegistrator.registerAllItems();
        BlockRegistrator.registerAllBlocks();

    }

}
