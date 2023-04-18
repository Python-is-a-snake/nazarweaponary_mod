package com.bebrikmods.nazarweaponary.MYTRIES.init;

import com.bebrikmods.nazarweaponary.MYTRIES.entries.items.SapphireItem;
import com.bebrikmods.nazarweaponary.MYTRIES.init.registrators.MyBlockRegistrator;
import com.bebrikmods.nazarweaponary.MYTRIES.init.registrators.MyItemRegistrator;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;

public class Initializer implements ModInitializer{
    public static final String MOD_ID = "nazarweaponary";
    private static final Item SAPPHIRE = new SapphireItem("sapphire");


    public  void onInitialize() {

        MyItemRegistrator.registerAllItems();
        MyBlockRegistrator.registerAllBlocks();
    }





}
