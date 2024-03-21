package info.partonetrain.familiarweapons.entity;

import info.partonetrain.familiarweapons.item.LightArrowItem;
import info.partonetrain.familiarweapons.registry.FWEntityTypes;
import info.partonetrain.familiarweapons.registry.FWItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class LightArrowEntity extends AbstractArrow {
    public static final int EFFECT_DURATION = 400;
    public static final double BASE_DAMAGE = 4.0D;

    public LightArrowEntity(EntityType<? extends LightArrowEntity> entityType, Level level) {
        super(entityType, level);
    }

    public LightArrowEntity(Level level, LivingEntity shooter) {
        super(FWEntityTypes.LIGHT_ARROW.get(), shooter, level);
    }

    public LightArrowEntity(Level level, double x, double y, double z) {
        super(FWEntityTypes.LIGHT_ARROW.get(), x, y, z, level);
    }

    @Override
    public void tick() {
        Vec3 thisPos = this.position();
        Vec3 futurePos = thisPos.add(this.getDeltaMovement());
        Vec3 pastPos = thisPos.subtract(this.getDeltaMovement());

        if (this.level().isClientSide) {
            this.level().addParticle(ParticleTypes.INSTANT_EFFECT, pastPos.x, pastPos.y, pastPos.z, 1, 1, 1);
            this.level().addParticle(ParticleTypes.INSTANT_EFFECT, thisPos.x(), thisPos.y(), thisPos.z(), 1, 1, 1);
            this.level().addParticle(ParticleTypes.INSTANT_EFFECT, futurePos.x, futurePos.y, futurePos.z, 1, 1, 1);
        }
        super.tick();
    }

    @Override
    protected void doPostHurtEffects(LivingEntity target) {
        super.doPostHurtEffects(target);
        MobEffectInstance mobEffectInstance = new MobEffectInstance(MobEffects.GLOWING, EFFECT_DURATION, 0);
        target.addEffect(mobEffectInstance, this.getEffectSource());
    }

    @Override
    public double getBaseDamage() {
        return BASE_DAMAGE;
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (!this.level().isClientSide()) {
            BlockPos relativePos = result.getBlockPos().relative(result.getDirection().getOpposite());
            BlockState nextBlock = this.level().getBlockState(relativePos);
            if (nextBlock.canBeReplaced() && this.getPierceLevel() > 0) {
                this.setPos(result.getBlockPos().getCenter());
                this.setDeltaMovement(this.getDeltaMovement());
                this.setPierceLevel((byte) (this.getPierceLevel() - 1));
                System.out.println(this.getPierceLevel());
            } else {
                super.onHitBlock(result);
            }
        }
    }

    @Override
    protected void tickDespawn() {
        super.tickDespawn();
    }

    @Override
    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        if(this.getPierceLevel() < (byte) 4){
            this.setPierceLevel((byte) 4);
        }

        super.shoot(x, y, z, velocity, inaccuracy);
    }

    @Override
    public @NotNull ItemStack getPickupItem() {
        return new ItemStack(FWItems.LIGHT_ARROW.get());
    }


}
