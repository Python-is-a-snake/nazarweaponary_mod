package com.bebrikmods.nazarweaponary.entitys.blocks;

import com.bebrikmods.nazarweaponary.init.registrators.MyBlockRegistrator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class RubyBlock extends Block {
    private String path;

    public RubyBlock(String path) {
        super(FabricBlockSettings.of(Material.METAL).strength(3.0f));
        this.path = path;
        MyBlockRegistrator.addBlock(path, this);
    }
}
