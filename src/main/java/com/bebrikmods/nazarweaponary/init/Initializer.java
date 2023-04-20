package com.bebrikmods.nazarweaponary.init;

import com.bebrikmods.nazarweaponary.entities.blocks.RubyOre;
import com.bebrikmods.nazarweaponary.entities.blocks.SapphireOre;
import com.bebrikmods.nazarweaponary.entities.items.AmethystItem;
import com.bebrikmods.nazarweaponary.entities.items.RubyItem;
import com.bebrikmods.nazarweaponary.entities.items.SapphireItem;
import com.bebrikmods.nazarweaponary.entities.items.SwordHandlerItem;
import com.bebrikmods.nazarweaponary.entities.status_effects.ExpStatusEffect;
import com.bebrikmods.nazarweaponary.entities.tools.tool_items.RubySword;
import com.bebrikmods.nazarweaponary.entities.tools.tool_items.SapphireSword;
import com.bebrikmods.nazarweaponary.init.generators.OreGenerator;
import com.bebrikmods.nazarweaponary.init.registrators.BlockRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.StatusEffectRegistrator;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;

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


    public static final Item SAPPHIRE = new SapphireItem("sapphire");
    public static final Block SAPPHIRE_ORE = new SapphireOre("sapphire_ore");

    public static final Item RUBY = new RubyItem("ruby");
    public static final Block RUBY_ORE = new RubyOre("ruby_ore");
    public static final Item AMETHYST = new AmethystItem("amethyst");


    public static final StatusEffect EXP = new ExpStatusEffect();

    public static final Item RUBY_SWORD = new RubySword("ruby_sword");

    public static final Item SAPPHIRE_SWORD = new SapphireSword("sapphire_sword");

    public static final Item SWORD_HANDLER = new SwordHandlerItem("sword_handler");

    public  void onInitialize() {
        new OreGenerator("ruby", RUBY_ORE, 5, 5, 65);
        new OreGenerator("sapphire", SAPPHIRE_ORE, 5, 5, 65);

        ItemRegistrator.registerAllItems();
        BlockRegistrator.registerAllBlocks();
        StatusEffectRegistrator.registerAllItems();
    }

}
