package winlyps.noChickensFromEggs

import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.plugin.java.JavaPlugin

class NoChickensFromEggs : JavaPlugin(), Listener {

    override fun onEnable() {
        // Register the event listener
        server.pluginManager.registerEvents(this, this)
        logger.info("NoChickensFromEggs plugin has been enabled!")
    }

    override fun onDisable() {
        logger.info("NoChickensFromEggs plugin has been disabled!")
    }

    @EventHandler
    fun onCreatureSpawn(event: CreatureSpawnEvent) {
        // Check if the spawning entity is a chicken and the spawn reason is EGG
        if (event.entityType == EntityType.CHICKEN && event.spawnReason == CreatureSpawnEvent.SpawnReason.EGG) {
            // Cancel the spawn event to prevent chicken from spawning
            event.isCancelled = true
        }
    }
}