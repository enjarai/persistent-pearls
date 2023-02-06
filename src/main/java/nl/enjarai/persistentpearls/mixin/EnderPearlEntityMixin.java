package nl.enjarai.persistentpearls.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static nl.enjarai.persistentpearls.PersistentPearls.PEARLS_PERSISTENT_GAMERULE;

@Mixin(EnderPearlEntity.class)
public abstract class EnderPearlEntityMixin extends ThrownItemEntity {
    public EnderPearlEntityMixin(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(
            method = "Lnet/minecraft/entity/projectile/thrown/EnderPearlEntity;tick()V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void persistentPearls$disablePearlDespawn(CallbackInfo ci) {
        if (world.getGameRules().getBoolean(PEARLS_PERSISTENT_GAMERULE)) {
            super.tick();
            ci.cancel();
        }
    }
}
