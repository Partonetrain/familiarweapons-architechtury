package info.partonetrain.familiarweapons.client;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.registries.RegistrySupplier;
import info.partonetrain.familiarweapons.registry.FWItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.item.Item;

@Environment(EnvType.CLIENT)
public class FWRender {

    public void init(){

    }

    @ExpectPlatform
    public static void setupPlatform()
    {
        throw new AssertionError();
    }
}
