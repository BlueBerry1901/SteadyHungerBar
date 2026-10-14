package com.stablehunger.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * Vanilla's Gui#renderFood shifts each hunger icon by a random -1/0/+1 pixel
 * offset whenever saturation is exactly 0, which is the hunger-bar "jitter".
 * This neutralizes the offset by forcing the RandomSource draw that produces
 * it to always yield a net-zero result, without skipping the draw itself -
 * so the shared RandomSource consumed later in the same frame by
 * renderHearts/renderAirBubbles advances identically to vanilla.
 */
@Mixin(Gui.class)
public abstract class GuiMixin {

    @ModifyExpressionValue(
            method = "renderFood",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/RandomSource;nextInt(I)I"
            )
    )
    private int stablehunger$neutralizeFoodIconJitter(int original) {
        return 1;
    }
}
