package info.partonetrain.familiarweapons.item;

import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ElegantReaperScytheItem extends HoeItem {
    //Accepts all enchantments that NETHERITE_SWORD and NETHERITE_HOE accepts - see EnchantmentHelperMixin
    private static final int COOLDOWN = 60;
    public static final int RIGHTCLICK_DURABILITY_DAMAGE = 3;

    public ElegantReaperScytheItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);

    }

    @Override
    @NotNull
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand){
        ItemStack itemstack = player.getItemInHand(usedHand);
        if (!player.getCooldowns().isOnCooldown(this) && !level.isClientSide()) {
            Vec3 look = player.getLookAngle();
            WitherSkull projectile = new WitherSkull(level, player, look.x(), look.y(), look.z());
            projectile.setOwner(player);
            projectile.setPos(projectile.getX(), projectile.getY() + 1, projectile.getZ());
            level.addFreshEntity(projectile);
            player.getCooldowns().addCooldown(this, COOLDOWN);
            player.swing(usedHand,true);
            itemstack.hurtAndBreak(RIGHTCLICK_DURABILITY_DAMAGE, player, entity -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
            return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide());

        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }

}
