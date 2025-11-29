package com.smushytaco.expanded_axe_enchanting
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.minecraft.core.RegistryAccess
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.enchantment.Enchantment
import kotlin.jvm.optionals.getOrNull
object ExpandedAxeEnchanting : ModInitializer {
    const val MOD_ID = "expanded_axe_enchanting"
    val config = ModConfig.createAndLoad()
    private var dynamicRegistryManager: RegistryAccess? = null
    override fun onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register { server -> dynamicRegistryManager = server.registryAccess() }
    }
    fun isSameEnchantment(enchantment: Enchantment, enchantmentRegistryKey: ResourceKey<Enchantment>) = dynamicRegistryManager?.lookup(Registries.ENCHANTMENT)?.getOrNull()?.wrapAsHolder(enchantment)?.`is`(enchantmentRegistryKey) ?: false
}