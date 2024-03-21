package info.partonetrain.familiarweapons.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import info.partonetrain.familiarweapons.FamiliarWeapons;
import info.partonetrain.familiarweapons.entity.LightArrowEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class FWEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(FamiliarWeapons.MOD_ID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<LightArrowEntity>> LIGHT_ARROW = ENTITY_TYPES.register("light_arrow", () ->
            EntityType.Builder.<LightArrowEntity>of(LightArrowEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build(new ResourceLocation(FamiliarWeapons.MOD_ID, "light_arrow").toString()));
}
