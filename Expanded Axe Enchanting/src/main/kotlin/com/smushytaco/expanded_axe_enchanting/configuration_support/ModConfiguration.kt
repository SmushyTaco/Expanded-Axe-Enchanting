package com.smushytaco.expanded_axe_enchanting.configuration_support
import com.smushytaco.expanded_axe_enchanting.ExpandedAxeEnchanting
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
@Config(name = ExpandedAxeEnchanting.MOD_ID)
class ModConfiguration: ConfigData {
    val canUseFireAspectOnAxe = true
    val canUseKnockbackOnAxe = true
    val canUseLootingOnAxe = true
    val canUseDensityOnAxe = true
    val canUseBreachOnAxe = true
    val canUseWindBurstOnAxe = true
}