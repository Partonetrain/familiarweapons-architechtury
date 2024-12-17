package info.partonetrain.familiarweapons.fabric;

import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import info.partonetrain.familiarweapons.FamiliarWeapons;
import info.partonetrain.familiarweapons.client.AnkhShieldPredicate;
import info.partonetrain.familiarweapons.registry.FWDispenserBehavior;
import info.partonetrain.familiarweapons.registry.FWEntityRendererRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class FamiliarWeaponsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FamiliarWeapons.BetterCombatInstalled = FabricLoader.getInstance().isModLoaded("bettercombat");
        FamiliarWeapons.init();
        FWDispenserBehavior.init();

        if(Platform.getEnvironment() == Env.CLIENT){
            FWEntityRendererRegistry.init();
            AnkhShieldPredicate.init();
        }
    }
}
