package net.kzeroko.isekaiweaponryfabric.client.renderer;

import net.kzeroko.isekaiweaponryfabric.client.model.CrescentroseProjectileModel;
import net.kzeroko.isekaiweaponryfabric.client.model.DonnerandschlagProjectileModel;
import net.kzeroko.isekaiweaponryfabric.entity.CrescentroseProjectile;
import net.kzeroko.isekaiweaponryfabric.entity.DonnerandschlagProjectile;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class DonnerandschlagProjectileRenderer extends GeoProjectilesRenderer<DonnerandschlagProjectile> {

    public DonnerandschlagProjectileRenderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new DonnerandschlagProjectileModel());
    }

    protected int getBlockLight(DonnerandschlagProjectile entityIn, BlockPos partialTicks) {
        return 15;
    }

    @Override
    public RenderLayer getRenderType(DonnerandschlagProjectile animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureResource(animatable));
    }
}
