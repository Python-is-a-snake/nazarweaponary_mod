package com.bebrikmods.nazarweaponary.init;

import com.bebrikmods.nazarweaponary.entitys.blocks.RubyBlock;
import com.bebrikmods.nazarweaponary.entitys.items.RubyItem;
import com.bebrikmods.nazarweaponary.entitys.items.SapphireItem;
import com.bebrikmods.nazarweaponary.init.registrators.MyBlockRegistrator;
import com.bebrikmods.nazarweaponary.init.registrators.MyItemRegistrator;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Initializer implements ModInitializer{
    public static final String MOD_ID = "nazarweaponary";
    private static final Item SAPPHIRE = new SapphireItem("sapphire");
    private static final Item RUBY = new RubyItem("ruby");
    private static final Block RUBY_BLOCK = new RubyBlock("ruby_block");


    public  void onInitialize() {
        MyItemRegistrator.registerAllItems();
        MyBlockRegistrator.registerAllBlocks();
    }





}
