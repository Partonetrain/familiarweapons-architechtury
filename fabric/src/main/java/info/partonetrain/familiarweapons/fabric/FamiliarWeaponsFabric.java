package info.partonetrain.familiarweapons.fabric;

import info.partonetrain.familiarweapons.FamiliarWeapons;
import info.partonetrain.familiarweapons.registry.FWDispenserBehavior;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class FamiliarWeaponsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FamiliarWeapons.BetterCombatInstalled = FabricLoader.getInstance().isModLoaded("bettercombat");
        FamiliarWeapons.init();
        FWDispenserBehavior.init();
    }
}
