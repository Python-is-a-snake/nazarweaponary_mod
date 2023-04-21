package com.bebrikmods.nazarweaponary.entities.status_effects;

import com.bebrikmods.nazarweaponary.init.registrators.StatusEffectRegistrator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class ExpStatusEffect extends StatusEffect {
  private int ticks = 0;

  public ExpStatusEffect(String path) {
    super(StatusEffectCategory.BENEFICIAL, 0xFFFFFF);
    StatusEffectRegistrator.addEffect(path, this);
  }

  @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    if(ticks == 20){
      ticks = 0;
      return true;
    }
    ticks++;
    return false;
  }

  @Override
  public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    if (entity instanceof PlayerEntity player) {
      player.addExperience(1);
    }
  }
}