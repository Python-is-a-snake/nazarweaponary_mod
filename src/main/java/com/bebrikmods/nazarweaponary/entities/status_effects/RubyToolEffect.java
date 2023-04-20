package com.bebrikmods.nazarweaponary.entities.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class RubyToolEffect extends StatusEffect {
  public RubyToolEffect() {
    super(
            StatusEffectCategory.BENEFICIAL, // Тип ефекту, корисний
            0xff0000 // Колір ефекту (червоний)
    );
  }
  @Override
  public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    // Тут ви можете визначити, що буде відбуватись кожен тік (20 разів на секунду)
    // У цьому випадку ми додаємо ефект швидкості
    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, amplifier));
  }
}