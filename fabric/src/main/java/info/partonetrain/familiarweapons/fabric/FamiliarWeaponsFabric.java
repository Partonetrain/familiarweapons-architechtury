package info.partonetrain.familiarweapons.fabric;

import info.partonetrain.familiarweapons.FamiliarWeapons;
import info.partonetrain.familiarweapons.registry.FWDispenserBehavior;
import net.fabricmc.api.ModInitializer;

public class FamiliarWeaponsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FamiliarWeapons.init();
        FWDispenserBehavior.init();
    }
}
