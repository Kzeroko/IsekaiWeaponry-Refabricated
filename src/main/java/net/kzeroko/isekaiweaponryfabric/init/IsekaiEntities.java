package net.kzeroko.isekaiweaponryfabric.init;

import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.entity.CrescentroseProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;

public class IsekaiEntities {

    public static EntityType<CrescentroseProjectile> CRESCENTROSE_PROJECTILE = buildEntity(CrescentroseProjectile::new, CrescentroseProjectile.class, 0.5F,
            0.5F, SpawnGroup.MISC);

    public static <T extends Entity> EntityType<T> buildEntity(EntityType.EntityFactory<T> entity, Class<T> entityClass, float width, float height, SpawnGroup group) {
        String name = entityClass.getSimpleName().toLowerCase();
        return IsekaiEntityBuilder.<T>createBuilder(new Identifier(IsekaiweaponryFabric.MOD_ID, name)).entity(entity)
                .category(group).dimensions(EntityDimensions.changing(width, height)).build();
    }
}
