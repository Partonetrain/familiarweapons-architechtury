package info.partonetrain.familiarweapons;

import com.google.common.base.Suppliers;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import info.partonetrain.familiarweapons.registry.FWItems;

import java.util.function.Supplier;

public class FamiliarWeapons {
    public static final String MOD_ID = "familiarweapons";
    // We can use this if we don't want to use DeferredRegister
    public static final Supplier<RegistrarManager> REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    // Registering a new creative tab
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> MAIN_TAB = TABS.register("tab", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup." + MOD_ID + ".tab"),
                    () -> new ItemStack(FWItems.ANKH_SHIELD.get())));
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);
    //ITEMS.reg

    
    public static void init() {
        TABS.register();
        ITEMS.register();
        
        //System.out.println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
