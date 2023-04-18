package com.bebrikmods.nazarweaponary.init.registrators;

import com.bebrikmods.nazarweaponary.init.Initializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class MyItemRegistrator {
    private static Map<String, Item> MOD_ITEM = new HashMap<>();

    public static void addItem(String path, Item item){
        MOD_ITEM.put(path, item);
    }

    public static void registerAllItems(){
        for(String path : MOD_ITEM.keySet()){
            Registry.register(Registry.ITEM, new Identifier(Initializer.MOD_ID, path), MOD_ITEM.get(path));
        }
    }
}
