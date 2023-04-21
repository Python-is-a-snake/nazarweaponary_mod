package com.bebrikmods.nazarweaponary.entities.status_effects;

import com.bebrikmods.nazarweaponary.init.registrators.StatusEffectRegistrator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class ExpStatusEffect extends StatusEffect {
  private int timer = 0; // таймер для відліку 5 секунд

  public ExpStatusEffect(String path) {
    super(StatusEffectCategory.BENEFICIAL, 0xFFFFFF);
    StatusEffectRegistrator.addEffect(path, this);
  }

  @Override
  public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    if (entity instanceof PlayerEntity) {
      if (timer == 0) { // якщо таймер досягнув 0
        ((PlayerEntity) entity).addExperience(1); // додати 1 досвід гравцю
        timer = 100; // встановити таймер на 5 секунд (100 тіків = 5 секунд)
      } else {
        timer--; // зменшити таймер
      }
    }
  }

  @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    return true; // ефект може діяти протягом будь-якого часу
  }
}