package info.partonetrain.familiarweapons.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import info.partonetrain.familiarweapons.client.LightArrowRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class FWEntityRendererRegistry {

    public static void init(){
        EntityRendererRegistry.register(FWEntityTypes.LIGHT_ARROW, LightArrowRenderer::new);
    }

    @ExpectPlatform
    public static void setupPlatform()
    {
        throw new AssertionError();
    }
}
