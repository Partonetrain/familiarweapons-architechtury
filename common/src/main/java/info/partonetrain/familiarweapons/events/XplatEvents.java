package info.partonetrain.familiarweapons.events;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import info.partonetrain.familiarweapons.FamiliarWeapons;
import info.partonetrain.familiarweapons.item.AnkhShieldItem;
import info.partonetrain.familiarweapons.item.PlasmaSwordItem;
import info.partonetrain.familiarweapons.registry.FWItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class XplatEvents {

    public static void init(){
        EntityEvent.LIVING_HURT.register(XplatEvents::onLivingHurt);
    }

    public static EventResult onLivingHurt(LivingEntity victim, DamageSource source, float damage)
    {
        ItemStack victimStack = victim.getUseItem();
        if (victimStack.getItem() instanceof AnkhShieldItem ankh && victim.isBlocking())
        {
            ankh.damageOnBlock(victimStack, damage, victim, source);
        }

        if(source.getEntity() instanceof LivingEntity attacker){
            ItemStack attackerMainhand = attacker.getItemBySlot(EquipmentSlot.MAINHAND);
            ItemStack attackerOffhand = attacker.getItemBySlot(EquipmentSlot.OFFHAND);
            if(attackerMainhand.is(FWItems.PLASMA_SWORD.get())){
                PlasmaSwordItem.pierceArmor(attacker, attackerMainhand, InteractionHand.MAIN_HAND, victim);
            }
            if(attacker instanceof Player && FamiliarWeapons.BetterCombatInstalled && attackerOffhand.is(FWItems.PLASMA_SWORD.get())){
                //TODO make this only work if plasma sword is the attacking weapon
                PlasmaSwordItem.pierceArmor(attacker, attackerOffhand, InteractionHand.OFF_HAND, victim);
            }
        }

        return EventResult.pass();
    }
}
