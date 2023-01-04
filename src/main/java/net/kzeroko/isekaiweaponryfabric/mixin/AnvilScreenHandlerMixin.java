package net.kzeroko.isekaiweaponryfabric.mixin;

import net.kzeroko.isekaiweaponryfabric.item.RangeWeapon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;

@Mixin(value = AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ForgingScreenHandler {

    public AnvilScreenHandlerMixin(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
    }

    @Inject(method = "updateResult", at = @At(value = "RETURN"))
    private void updateAnvilResult(CallbackInfo ci) {
        ItemStack leftStack = this.input.getStack(0).copy();
        ItemStack rightStack = this.input.getStack(1).copy();
        if ((leftStack.getItem() instanceof RangeWeapon)
                && (rightStack.getItem() instanceof RangeWeapon
                || rightStack.getItem().toString().contains("enchant")
                || rightStack.getItem().toString().contains("book")
        )) {
            ItemStack repaired = ItemStack.EMPTY;
            this.output.setStack(0, repaired);
            this.sendContentUpdates();
        }
    }
}
