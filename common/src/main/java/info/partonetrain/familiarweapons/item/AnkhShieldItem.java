package info.partonetrain.familiarweapons.item;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;

import java.util.Collection;

public class AnkhShieldItem extends ShieldItem {
    public AnkhShieldItem(Properties properties) {
        super(properties);
        ItemProperties.register(this, new ResourceLocation("blocking"), (itemStack, clientLevel, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
        });
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(!level.isClientSide && entity instanceof LivingEntity li){
            if(li.getItemBySlot(EquipmentSlot.MAINHAND).is(this) || li.getItemBySlot(EquipmentSlot.OFFHAND).is(this)) {
                Collection<MobEffectInstance> effects = li.getActiveEffects();
                for (MobEffectInstance effect : effects) {
                    if (!effect.getEffect().isBeneficial() && !effect.isInfiniteDuration()) {
                        li.removeEffect(effect.getEffect());
                    }
                }

                if(li.isOnFire()){
                    li.extinguishFire();
                }
            }
        }
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
        return repairCandidate.is(Items.OBSIDIAN);
    }

    public void damageOnBlock(ItemStack stack, float damage, LivingEntity victim, DamageSource source){
        if(source != null &&
                damage >= ShieldItem.MINIMUM_DURABILITY_DAMAGE && //3.0f
                victim.isDamageSourceBlocked(source))
        {
            stack.hurtAndBreak((int) damage, victim, entity -> entity.broadcastBreakEvent(EquipmentSlot.OFFHAND));
        }
    }
}
