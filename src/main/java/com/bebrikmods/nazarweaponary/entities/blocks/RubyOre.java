package com.bebrikmods.nazarweaponary.entities.blocks;

import com.bebrikmods.nazarweaponary.init.registrators.BlockRegistrator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class RubyOre extends Block {

    public RubyOre(String path) {
        super(FabricBlockSettings.of(Material.METAL).strength(3.0f).requiresTool());
        BlockRegistrator.addBlock(path, this);
    }


}
