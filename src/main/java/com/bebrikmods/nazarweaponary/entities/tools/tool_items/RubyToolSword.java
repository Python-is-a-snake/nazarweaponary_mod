package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import com.bebrikmods.nazarweaponary.entities.tools.tool_materials.RubyToolMaterial;
import com.bebrikmods.nazarweaponary.init.registrators.ItemRegistrator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

public class RubyToolSword extends SwordItem{
    private String path;
    private StatusEffect effect;

    public RubyToolSword(String path) {
        super(new RubyToolMaterial(), 5, -1.0F, new Item.Settings().fireproof().rarity(Rarity.EPIC).group(ItemGroup.COMBAT));
        ItemRegistrator.addItem(path, this);
        this.effect = StatusEffects.STRENGTH;
    }



    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient && user instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity) user).clearStatusEffects();
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected && entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(effect, 20));
        }
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isClient) {
            player.addStatusEffect(new StatusEffectInstance(effect, 20));
        }
    }


}
