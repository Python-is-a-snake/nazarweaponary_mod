package com.bebrikmods.nazarweaponary.init.registrators;

import com.bebrikmods.nazarweaponary.init.Initializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

import static com.bebrikmods.nazarweaponary.init.Initializer.MOD_ID;

public class StatusEffectRegistrator {
    public static Map<String, StatusEffect> MOD_EFFECTS = new HashMap<>();

    public static void addEffect(String path, StatusEffect effect){
        MOD_EFFECTS.put(path, effect);
    }

    public static void registerAllItems(){
        for(String path : MOD_EFFECTS.keySet()){
            Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, path), MOD_EFFECTS.get(path));
        }
    }
}
