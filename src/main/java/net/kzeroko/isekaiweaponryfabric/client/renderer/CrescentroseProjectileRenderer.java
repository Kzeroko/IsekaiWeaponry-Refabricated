package net.kzeroko.isekaiweaponryfabric.client.renderer;

import net.kzeroko.isekaiweaponryfabric.client.model.CrescentroseProjectileModel;
import net.kzeroko.isekaiweaponryfabric.entity.CrescentroseProjectile;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class CrescentroseProjectileRenderer extends GeoProjectilesRenderer<CrescentroseProjectile> {

    public CrescentroseProjectileRenderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new CrescentroseProjectileModel());
    }

    protected int getBlockLight(CrescentroseProjectile entityIn, BlockPos partialTicks) {
        return 10;
    }

    @Override
    public RenderLayer getRenderType(CrescentroseProjectile animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureResource(animatable));
    }
}
