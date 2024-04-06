package info.partonetrain.familiarweapons.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

public class PlasmaSwordItem extends SwordItem {
    public PlasmaSwordItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    public static void pierceArmor(@NotNull LivingEntity attacker, ItemStack stack, InteractionHand hand, Entity target) {
        if(!attacker.level().isClientSide()){
            target.hurt(attacker.level().damageSources().generic(), (float) attacker.getAttributeValue(Attributes.ATTACK_DAMAGE));
            //generic should be in #bypasses_armor
            //no knockback is intentional, but it would be done here.
        }
        if(hand == InteractionHand.MAIN_HAND){
            stack.hurtAndBreak(1, attacker, (livingEntity) -> {
                livingEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }
        else if(hand == InteractionHand.OFF_HAND){ //bettercombat only
            stack.hurtAndBreak(1, attacker, (livingEntity) -> {
                livingEntity.broadcastBreakEvent(EquipmentSlot.OFFHAND);
            });
        }
    }
}
