package com.bebrikmods.nazarweaponary.init.registrators;

import com.bebrikmods.nazarweaponary.init.Initializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class BlockRegistrator {

    private static Map<String, Block> MOD_BLOCKS = new HashMap<>();

    public static void addBlock(String path, Block block){
        //create item that represent block and add it to BUILDING_BLOCKS group
        BlockItem blockItem = new BlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));

        ItemRegistrator.addItem(path, blockItem);
        MOD_BLOCKS.put(path, block);
    }

    public static void registerAllBlocks(){
        for(String path : MOD_BLOCKS.keySet()){
            Registry.register(Registry.BLOCK, new Identifier(Initializer.MOD_ID, path), MOD_BLOCKS.get(path));
        }
    }

}
