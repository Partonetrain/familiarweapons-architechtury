package info.partonetrain.familiarweapons.forge;

import dev.architectury.platform.forge.EventBuses;
import info.partonetrain.familiarweapons.FamiliarWeapons;
import info.partonetrain.familiarweapons.registry.FWDispenserBehavior;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FamiliarWeapons.MOD_ID)
public class FamiliarWeaponsForge {
    public FamiliarWeaponsForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(FamiliarWeapons.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FamiliarWeapons.init();
    }

    public void commonSetup(FMLCommonSetupEvent event){
        FWDispenserBehavior.init();
    }
}
