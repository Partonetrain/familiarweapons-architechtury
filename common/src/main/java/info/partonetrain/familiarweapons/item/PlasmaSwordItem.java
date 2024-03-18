package info.partonetrain.familiarweapons.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class PlasmaSwordItem extends SwordItem {
    public PlasmaSwordItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    public static boolean hurtEnemyIgnoreArmor(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!target.level().isClientSide()){
            target.hurt(target.level().damageSources().generic(), (float) attacker.getAttributeValue(Attributes.ATTACK_DAMAGE));
            //generic should be in #bypasses_armor
            //no knockback is intentional, but it would be done here.
        }
        stack.hurtAndBreak(1, attacker, (livingEntity) -> {
            livingEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });

        return true;
    }
}
