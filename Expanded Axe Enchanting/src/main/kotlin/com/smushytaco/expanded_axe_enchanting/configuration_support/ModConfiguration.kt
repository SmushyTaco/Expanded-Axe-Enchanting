package com.smushytaco.expanded_axe_enchanting.configuration_support
import com.smushytaco.expanded_axe_enchanting.ExpandedAxeEnchanting
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment
@Config(name = ExpandedAxeEnchanting.MOD_ID)
class ModConfiguration: ConfigData {
    @Comment("Default value is yes. If set to yes you'll be able to use Fire Aspect on an axe. If set to no you won't be able to.")
    val canUseFireAspectOnAxe = true
    @Comment("Default value is yes. If set to yes you'll be able to use Knockback on an axe. If set to no you won't be able to.")
    val canUseKnockbackOnAxe = true
    @Comment("Default value is yes. If set to yes you'll be able to use Looting on an axe. If set to no you won't be able to.")
    val canUseLootingOnAxe = true
}