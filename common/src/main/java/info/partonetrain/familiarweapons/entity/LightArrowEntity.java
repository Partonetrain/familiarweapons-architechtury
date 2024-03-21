package info.partonetrain.familiarweapons.entity;

import info.partonetrain.familiarweapons.item.LightArrowItem;
import info.partonetrain.familiarweapons.registry.FWEntityTypes;
import info.partonetrain.familiarweapons.registry.FWItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class LightArrowEntity extends SpectralArrow {
    public static final int EFFECT_DURATION = 400;
    public static final int MAX_LIFESPAN = 900;
    public int lifespan;
    public LightArrowEntity(EntityType<? extends LightArrowEntity> entityType, Level level) {
        super(entityType, level);
    }

//    tried to make it extend AbstractArrow

//    public LightArrowEntity(Level level, double x, double y, double z) {
//        super(FWEntityTypes.LIGHT_ARROW.get(), x, y, z, level);
//    }
//
//    public LightArrowEntity(Level level, LivingEntity shooter) {
//        super(FWEntityTypes.LIGHT_ARROW.get(), shooter, level);
//    }

    @Override
    protected void doPostHurtEffects(LivingEntity target) {
        super.doPostHurtEffects(target);
        MobEffectInstance mobEffectInstance = new MobEffectInstance(MobEffects.GLOWING, EFFECT_DURATION, 1); //not like the amplifier matters
        target.addEffect(mobEffectInstance, this.getEffectSource());
    }

//    @Override
//    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
//        this.setNoGravity(true);
//        this.setNoPhysics(true);
//        super.shoot(x, y, z, velocity, inaccuracy);
//    }

    @Override
    public @NotNull ItemStack getPickupItem() {
        return new ItemStack(FWItems.LIGHT_ARROW.get());
    }

    @Override
    public void tickDespawn() {
        lifespan++;
        if (lifespan >= MAX_LIFESPAN) {
            this.discard();
        }
    }
}
