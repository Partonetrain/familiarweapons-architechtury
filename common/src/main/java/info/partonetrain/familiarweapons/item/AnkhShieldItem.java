package info.partonetrain.familiarweapons.item;

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
            }
        }
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
        return repairCandidate.is(Items.OBSIDIAN) || super.isValidRepairItem(stack, repairCandidate);
    }
}
