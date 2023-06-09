package com.bebrikmods.nazarweaponary.entities.blocks;

import com.bebrikmods.nazarweaponary.init.registrators.BlockRegistrator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class SapphireOre extends Block {

    public SapphireOre(String path) {
        super(FabricBlockSettings.of(Material.METAL).strength(3.0f).requiresTool());
        BlockRegistrator.addBlock(path, this);
    }
}
