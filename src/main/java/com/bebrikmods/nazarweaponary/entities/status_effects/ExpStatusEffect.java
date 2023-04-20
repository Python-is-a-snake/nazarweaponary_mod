package com.bebrikmods.nazarweaponary.entities.status_effects;

import com.bebrikmods.nazarweaponary.init.registrators.StatusEffectRegistrator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class ExpStatusEffect extends StatusEffect {

  private static final int TICKS_PER_SECOND = 10;
  private int ticksElapsed;

  public ExpStatusEffect(String path) {
    super(StatusEffectCategory.BENEFICIAL, 0xFFFFFF);
    StatusEffectRegistrator.addEffect(path, this);
  }

  @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    return true;
  }

  @Override
  public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    if (entity instanceof PlayerEntity playerEntity) {
      if (ticksElapsed % TICKS_PER_SECOND == 0) {
        playerEntity.addExperience(1);
      }
      ticksElapsed++;
    }
  }
}