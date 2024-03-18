package info.partonetrain.familiarweapons.mixin;

import info.partonetrain.familiarweapons.item.ElegantReaperScytheItem;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {
    @Shadow @Final public EnchantmentCategory category;

    @Inject(method = "canEnchant", at = @At("RETURN"), cancellable = true)
    private void FamiliarWeapons$canEnchant(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        boolean canEnchant = false;
        if(stack.getItem() instanceof ElegantReaperScytheItem){
                canEnchant = this.category == EnchantmentCategory.WEAPON;
            }
            cir.setReturnValue(canEnchant);
    }
}

