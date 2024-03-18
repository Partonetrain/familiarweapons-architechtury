package info.partonetrain.familiarweapons.mixin;

import info.partonetrain.familiarweapons.item.ElegantReaperScytheItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {

    @Inject(method = "getAvailableEnchantmentResults", at = @At("RETURN"), cancellable = true)
    private static void FamiliarWeapons$getAvailableEnchantmentResults(int level, ItemStack stack, boolean allowTreasure, CallbackInfoReturnable<List<EnchantmentInstance>> cir) {
        if(stack.getItem() instanceof ElegantReaperScytheItem){
            cir.setReturnValue(EnchantmentHelper.getAvailableEnchantmentResults(level, Items.NETHERITE_SWORD.getDefaultInstance(), allowTreasure));
        }
    }
}

