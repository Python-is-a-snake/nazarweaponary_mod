package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ModSword extends SwordItem {

    private final List<StatusEffect> effects;

    protected ModSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, StatusEffect... statusEffects) {
        super(toolMaterial, attackDamage, attackSpeed,
                //SWORD SETTINGS
                new FabricItemSettings()
                        .maxDamage(toolMaterial.getDurability())
                        .group(ItemGroup.COMBAT)
                        .fireproof()
                        .rarity(Rarity.EPIC));

        this.effects = new ArrayList<>(Arrays.asList(statusEffects));
    }

    public void applyEffectsOnPlayer(PlayerEntity player){
        for (StatusEffect effect : effects) {
            StatusEffectInstance effectInstance = player.getStatusEffect(effect);
            if (effectInstance == null || effectInstance.getDuration() < 2) {
                player.addStatusEffect(new StatusEffectInstance(effect, 200, 1, false, false, true));
            }
        }
    }

    public void removeEffectsOnPlayer(PlayerEntity player) {
        for (StatusEffect effect : effects) {
            if (player.hasStatusEffect(effect)) {
                player.removeStatusEffect(effect);
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        /*
        Параметри методу:

            stack - предмет, який знаходиться в інвентарі.
            world - світ, в якому знаходиться гравець.
            entity - екземпляр гравця.
            slot - номер слоту в інвентарі, в якому знаходиться предмет.
            selected - прапорець, який показує, чи є цей предмет вибраним у гравця.

         */
        if (entity instanceof PlayerEntity player && !player.getInventory().getStack(slot).isEmpty()) {
            if (player.getMainHandStack().getItem().equals(this) && selected) {
                applyEffectsOnPlayer(player);
            } else {
                removeEffectsOnPlayer(player);
            }
        }
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        removeEffectsOnPlayer((PlayerEntity) user);
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isClient) {
            for (StatusEffect effect : effects){
                player.addStatusEffect(new StatusEffectInstance(effect, 5));
            }
        }
    }

}


