package com.smushytaco.expanded_axe_enchanting.mixins;
import com.smushytaco.expanded_axe_enchanting.ExpandedAxeEnchanting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.LuckEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
@Mixin(LuckEnchantment.class)
public abstract class AxesCanHaveLooting extends Enchantment {
    protected AxesCanHaveLooting(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }
    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (type != EnchantmentTarget.WEAPON || !ExpandedAxeEnchanting.INSTANCE.getConfig().getCanUseLootingOnAxe()) return super.isAcceptableItem(stack);
        return stack.getItem() instanceof AxeItem || super.isAcceptableItem(stack);
    }
}