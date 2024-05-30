package com.smushytaco.expanded_axe_enchanting.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_axe_enchanting.ExpandedAxeEnchanting;
import net.minecraft.enchantment.*;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(Enchantment.class)
public abstract class AxeModification {
    @Shadow
    @Final
    private Enchantment.Properties properties;
    @ModifyReturnValue(method = "isAcceptableItem", at = @At("RETURN"))
    public boolean isAcceptableItem(boolean original, ItemStack stack) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment == Enchantments.FIRE_ASPECT) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseFireAspectOnAxe() || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        } else if (enchantment == Enchantments.KNOCKBACK) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseKnockbackOnAxe() || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        }  else if (enchantment instanceof LuckEnchantment) {
            if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseLootingOnAxe() || properties.supportedItems() != ItemTags.SWORD_ENCHANTABLE || !(stack.getItem() instanceof AxeItem)) return original;
            return true;
        }
        return original;
    }
}