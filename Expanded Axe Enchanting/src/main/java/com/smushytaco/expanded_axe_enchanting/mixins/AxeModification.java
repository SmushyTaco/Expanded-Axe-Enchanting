package com.smushytaco.expanded_axe_enchanting.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_axe_enchanting.ExpandedAxeEnchanting;
import net.minecraft.enchantment.*;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(Enchantment.class)
public abstract class AxeModification {
    @Shadow
    @Final
    public EnchantmentTarget target;
    @ModifyReturnValue(method = "isAcceptableItem", at = @At("RETURN"))
    public boolean isAcceptableItem(boolean original, ItemStack stack) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment instanceof FireAspectEnchantment) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseFireAspectOnAxe() || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        } else if (enchantment instanceof KnockbackEnchantment) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseKnockbackOnAxe() || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        }  else if (enchantment instanceof LuckEnchantment) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseLootingOnAxe() || target != EnchantmentTarget.WEAPON || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        }
        return original;
    }
}