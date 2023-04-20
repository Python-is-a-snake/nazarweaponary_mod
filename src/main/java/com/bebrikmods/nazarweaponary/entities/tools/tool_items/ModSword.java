package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class ModSword extends SwordItem {
    private ArrayList<StatusEffect> effects;
    private static final Settings settings = new Settings().fireproof().rarity(Rarity.EPIC).group(ItemGroup.COMBAT);

    protected ModSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, StatusEffect... statusEffects) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.effects = new ArrayList<>(Arrays.asList(statusEffects));

    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient && user instanceof ServerPlayerEntity serverPlayerEntity) {
            serverPlayerEntity.clearStatusEffects();
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected && entity instanceof PlayerEntity serverPlayerEntity) {
            for(StatusEffect statusEffect : effects){
                serverPlayerEntity.addStatusEffect(new StatusEffectInstance(statusEffect, 20));
            }
        }
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isClient) {
            for(StatusEffect statusEffect : effects){
                player.addStatusEffect(new StatusEffectInstance(statusEffect, 20));
            }
        }
    }

}

