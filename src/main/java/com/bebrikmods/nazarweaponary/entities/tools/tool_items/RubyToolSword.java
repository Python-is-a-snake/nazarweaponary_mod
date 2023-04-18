package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.RubyToolMaterial;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;

public class RubyToolSword extends SwordItem {
    private String path;

    public RubyToolSword(String path) {
        super(new RubyToolMaterial(), 5, -1.0F, new Item.Settings().fireproof().rarity(Rarity.EPIC).group(ItemGroup.COMBAT));
        ItemRegistrator.addItem(path, this);
    }
}
