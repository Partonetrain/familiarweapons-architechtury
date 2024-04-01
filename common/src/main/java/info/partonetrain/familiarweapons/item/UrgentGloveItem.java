package info.partonetrain.familiarweapons.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class UrgentGloveItem extends SwordItem {
    public UrgentGloveItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        Multimap<Attribute, AttributeModifier> ret = HashMultimap.create(super.getDefaultAttributeModifiers(slot)); //make mutable
        if (slot == EquipmentSlot.MAINHAND) {
            ret.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(UUID.fromString("3a2e99b9-286a-4688-a20e-20a66dea1596"),"Urgent main hand modifier", 0.15, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        if (slot == EquipmentSlot.OFFHAND) {
            ret.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(UUID.fromString("f6551c7b-0c8a-4e8e-a9fb-0a1f3457fe98"),"Urgent offhand modifier", 0.15, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        return ret;
    }
}
