package info.partonetrain.familiarweapons;

import dev.architectury.platform.Platform;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.architectury.utils.Env;
import info.partonetrain.familiarweapons.client.AnkhShieldPredicate;
import info.partonetrain.familiarweapons.registry.FWEntityRendererRegistry;
import info.partonetrain.familiarweapons.events.XplatEvents;
import info.partonetrain.familiarweapons.registry.FWEntityTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import info.partonetrain.familiarweapons.registry.FWItems;

public class FamiliarWeapons {
    public static final String MOD_ID = "familiarweapons";
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> MAIN_TAB = TABS.register("tab", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup." + MOD_ID + ".tab"),
                    () -> new ItemStack(FWItems.PLASMA_SWORD.get())));

    public static boolean BetterCombatInstalled;

    public static void init() {
        TABS.register();
        FWItems.ITEMS.register();
        FWEntityTypes.ENTITY_TYPES.register();
        XplatEvents.init();

        if(Platform.getEnvironment() == Env.CLIENT){
            FWEntityRendererRegistry.init();
            AnkhShieldPredicate.init();
        }
    }
}
