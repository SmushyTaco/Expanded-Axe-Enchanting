package com.smushytaco.expanded_axe_enchanting.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_axe_enchanting.ExpandedAxeEnchanting;
import net.minecraft.enchantment.*;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(Enchantment.class)
public abstract class AxeModification {
    @ModifyReturnValue(method = "isAcceptableItem", at = @At("RETURN"))
    public boolean isAcceptableItem(boolean original, ItemStack stack) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (ExpandedAxeEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.FIRE_ASPECT)) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseFireAspectOnAxe() || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        } else if (ExpandedAxeEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.KNOCKBACK)) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseKnockbackOnAxe() || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        } else if (ExpandedAxeEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.LOOTING)) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseLootingOnAxe() || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        } else if (ExpandedAxeEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.DENSITY)) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseDensityOnAxe() || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        } else if (ExpandedAxeEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.BREACH)) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseBreachOnAxe() || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        } else if (ExpandedAxeEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.WIND_BURST)) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseWindBurstOnAxe() || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        }
        return original;
    }
}