package info.partonetrain.familiarweapons.fabric;

import info.partonetrain.familiarweapons.FamiliarWeapons;
import net.fabricmc.api.ModInitializer;

public class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FamiliarWeapons.init();
    }
}
