package com.bebrikmods.nazarweaponary.entities.tools.tool_items;

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

public abstract class ModSword extends SwordItem {

    private ArrayList<StatusEffect> effects;
    private static final Settings settings = new Settings().fireproof().rarity(Rarity.EPIC).group(ItemGroup.COMBAT);

    protected ModSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, StatusEffect... statusEffects) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.effects = new ArrayList<>(Arrays.asList(statusEffects));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        for(StatusEffect statusEffect : effects){
            if(user.hasStatusEffect(statusEffect)){
                user.removeStatusEffect(statusEffect);
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        //remove !player.getMainHandStack().isEmpty() && player.getMainHandStack().getItem() == this
        if (entity instanceof PlayerEntity player && selected && !player.getMainHandStack().isEmpty() && player.getMainHandStack().getItem() == this) {
            for (StatusEffect effect : effects) {
                StatusEffectInstance effectInstance = player.getStatusEffect(effect);
                if (effectInstance == null || effectInstance.getDuration() < 2) {
                    player.addStatusEffect(new StatusEffectInstance(effect, 200, 1, false, false, true));
                }
            }
        }else{
            onStoppedUsing(stack, world, (LivingEntity) entity, 0);
        }
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


