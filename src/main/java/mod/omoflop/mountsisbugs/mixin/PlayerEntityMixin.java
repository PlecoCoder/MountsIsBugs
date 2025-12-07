package mod.omoflop.mountsisbugs.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Redirect(method = "getBlockBreakingSpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isOnGround()Z"))
    boolean mountsIsBugs$getBlockBreakingSpeed(PlayerEntity instance) {
        if (instance.hasVehicle()) return false;
        return instance.isOnGround();
    }

}
