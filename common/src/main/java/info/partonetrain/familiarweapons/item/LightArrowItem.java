package info.partonetrain.familiarweapons.item;

import info.partonetrain.familiarweapons.entity.LightArrowEntity;
import info.partonetrain.familiarweapons.registry.FWEntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpectralArrowItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class LightArrowItem extends SpectralArrowItem {
    public LightArrowItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter) {
        return new LightArrowEntity(FWEntityTypes.LIGHT_ARROW.get(), level);
    }

}
