package net.kzeroko.isekaiweaponryfabric.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.EntityFactory;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IsekaiEntityBuilder<E extends Entity> {
    private static Identifier name;
    private EntityFactory<E> entityFactory;
    private SpawnGroup category;
    private EntityDimensions dimensions;

    public IsekaiEntityBuilder() {
    }

    public static <E extends Entity> IsekaiEntityBuilder<E> createBuilder(Identifier nameIn) {
        name = nameIn;
        return new IsekaiEntityBuilder<>();
    }

    public IsekaiEntityBuilder<E> entity(EntityFactory<E> entityFactory) {
        this.entityFactory = entityFactory;
        return this;
    }

    public IsekaiEntityBuilder<E> category(SpawnGroup category) {
        this.category = category;
        return this;
    }

    public IsekaiEntityBuilder<E> dimensions(EntityDimensions size) {
        this.dimensions = size;
        return this;
    }

    public EntityType<E> build() {
        EntityType.Builder<E> entityBuilder = EntityType.Builder.create(this.entityFactory, this.category)
                .setDimensions(this.dimensions.width, this.dimensions.height);

        EntityType<E> entityType = Registry.register(Registry.ENTITY_TYPE, name, entityBuilder.build(name.getPath()));

        return entityType;
    }
}