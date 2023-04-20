package com.bebrikmods.nazarweaponary.init;

import com.bebrikmods.nazarweaponary.entities.blocks.RubyOre;
import com.bebrikmods.nazarweaponary.entities.blocks.SapphireOre;
import com.bebrikmods.nazarweaponary.entities.items.AmethystItem;
import com.bebrikmods.nazarweaponary.entities.items.RubyItem;
import com.bebrikmods.nazarweaponary.entities.items.SapphireItem;
import com.bebrikmods.nazarweaponary.entities.tools.tool_items.RubyToolSword;
import com.bebrikmods.nazarweaponary.init.registrators.BlockRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Initializer implements ModInitializer{

    /*
    TO CREATE NEW ITEM/BLOCK:
        1)CREATE CLASS
        2)ADD NAME TO assets..lang
        3)ADD ITEM_ID.json TO assets..models.item OR assets..models.block
        4)ADD TEXTURE TO assets..textures.items OR assets..textures.blocks
        5 OPT.) ADD RECIPES TO data..recipes
        6)ADD block_name.json TO data..loot_tables - CREATES LOOT DROP TABLES (from mining block)
     */
    public static final String MOD_ID = "nazarweaponary";

    public static final Item SAPPHIRE = new SapphireItem("sapphire");
    public static final Block SAPPHIRE_ORE = new SapphireOre("sapphire_ore");

    public static final Item RUBY = new RubyItem("ruby");
    public static final Block RUBY_ORE = new RubyOre("ruby_ore");
    public static final Item AMETHYST = new AmethystItem("amethyst");
    public static final Item RUBY_SWORD = new RubyToolSword("ruby_sword");


    public  void onInitialize() {
        new OreGenerator("ruby", RUBY_ORE, 5, 5, 65);
        new OreGenerator("sapphire", SAPPHIRE_ORE, 5, 5, 65);

        ItemRegistrator.registerAllItems();
        BlockRegistrator.registerAllBlocks();

    }

}
