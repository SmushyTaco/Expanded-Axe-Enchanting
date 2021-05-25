package com.smushytaco.expanded_axe_enchanting.mixins;
import com.smushytaco.expanded_axe_enchanting.ExpandedAxeEnchanting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.KnockbackEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
@Mixin(KnockbackEnchantment.class)
public abstract class AxesCanHaveKnockback extends Enchantment {
    protected AxesCanHaveKnockback(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }
    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseKnockbackOnAxe()) return super.isAcceptableItem(stack);
        return stack.getItem() instanceof AxeItem || super.isAcceptableItem(stack);
    }
}