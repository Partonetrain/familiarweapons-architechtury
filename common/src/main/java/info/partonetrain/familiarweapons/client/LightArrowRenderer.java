package info.partonetrain.familiarweapons.client;

import info.partonetrain.familiarweapons.entity.LightArrowEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class LightArrowRenderer extends ArrowRenderer<LightArrowEntity> {

    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation("familiarweapons", "textures/entity/light_arrow.png");

    public LightArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(LightArrowEntity entity) {
        return TEXTURE_LOCATION;
    }

}
