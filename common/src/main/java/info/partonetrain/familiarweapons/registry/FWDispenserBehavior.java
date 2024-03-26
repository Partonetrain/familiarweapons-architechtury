package info.partonetrain.familiarweapons.registry;

import info.partonetrain.familiarweapons.entity.LightArrowEntity;
import info.partonetrain.familiarweapons.item.ElegantReaperScytheItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.NotNull;

public class FWDispenserBehavior {

    public static void init(){
        DispenserBlock.registerBehavior(FWItems.ELEGANT_REAPER_SCYTHE.get(), new OptionalDispenseItemBehavior() {
            protected @NotNull ItemStack execute(BlockSource source, ItemStack stack) {
                this.setSuccess(false);
                Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
                BlockPos blockPos = source.getPos().relative(direction);
                ServerLevel level = source.getLevel();
                if(level.isEmptyBlock(blockPos)) {
                    Component name = Component.literal("Testament");
                    WitherBoss dummyWither = new WitherBoss(EntityType.WITHER, source.getLevel());
                    dummyWither.setCustomName(name);
                    if (stack.hurt(ElegantReaperScytheItem.RIGHTCLICK_DURABILITY_DAMAGE, source.getLevel().getRandom(), (ServerPlayer) null)) {
                        stack.setCount(0);
                    }

                    WitherSkull witherSkull = new WitherSkull(level, dummyWither, direction.getStepX(), direction.getStepY(), direction.getStepZ());
                    witherSkull.setPos(blockPos.getCenter().add(0, -0.25F, 0));
                    level.addFreshEntity(witherSkull);

                    this.setSuccess(true);
                }
                return stack;
            }
        });
        DispenserBlock.registerBehavior(FWItems.LIGHT_ARROW.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level level, Position position, ItemStack stack) {
                LightArrowEntity arrow = new LightArrowEntity(level, position.x(), position.y(), position.z());
                arrow.pickup = AbstractArrow.Pickup.ALLOWED;
                return arrow;
            }
        });
    }

}