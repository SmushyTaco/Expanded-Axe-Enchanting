package com.smushytaco.expanded_axe_enchanting
import io.wispforest.owo.config.annotation.Config
import io.wispforest.owo.config.annotation.Modmenu
@Modmenu(modId = ExpandedAxeEnchanting.MOD_ID)
@Config(name = ExpandedAxeEnchanting.MOD_ID, wrapperName = "ModConfig")
@Suppress("UNUSED")
class ModConfiguration {
    @JvmField
    var canUseFireAspectOnAxe = true
    @JvmField
    var canUseKnockbackOnAxe = true
    @JvmField
    var canUseLootingOnAxe = true
    @JvmField
    var canUseImpalingOnAxe = true
    @JvmField
    var canUseDensityOnAxe = true
    @JvmField
    var canUseBreachOnAxe = true
    @JvmField
    var canUseWindBurstOnAxe = true
}