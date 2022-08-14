package com.smushytaco.expanded_axe_enchanting.mixins;
import com.smushytaco.expanded_axe_enchanting.ExpandedAxeEnchanting;
import net.minecraft.enchantment.*;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(Enchantment.class)
public abstract class AxeModification {
    @Shadow
    @Final
    public EnchantmentTarget type;
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment instanceof FireAspectEnchantment) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseFireAspectOnAxe() || !(stack.getItem() instanceof AxeItem)) return;
            cir.setReturnValue(true);
        } else if (enchantment instanceof KnockbackEnchantment) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseKnockbackOnAxe() || !(stack.getItem() instanceof AxeItem)) return;
            cir.setReturnValue(true);
        }  else if (enchantment instanceof LuckEnchantment) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseLootingOnAxe() || type != EnchantmentTarget.WEAPON || !(stack.getItem() instanceof AxeItem)) return;
            cir.setReturnValue(true);
        }
    }
}