package com.smushytaco.expanded_axe_enchanting.mixins;
import com.smushytaco.expanded_axe_enchanting.ExpandedAxeEnchanting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
@Mixin(FireAspectEnchantment.class)
public abstract class AxesCanHaveFireAspect extends Enchantment {
    protected AxesCanHaveFireAspect(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }
    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (!ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseFireAspectOnAxe()) return super.isAcceptableItem(stack);
        return stack.getItem() instanceof AxeItem || super.isAcceptableItem(stack);
    }
}