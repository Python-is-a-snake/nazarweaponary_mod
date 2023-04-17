package com.bebrikmods.nazarweaponary;

import com.bebrikmods.nazarweaponary.registry.ModBlocks;
import com.bebrikmods.nazarweaponary.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class TutorialMod implements ModInitializer {

    public static final String MOD_ID = "nazarweaponary";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}
