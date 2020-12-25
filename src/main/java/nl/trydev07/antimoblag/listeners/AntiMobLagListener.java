package nl.trydev07.antimoblag.listeners;

import nl.trydev07.antimoblag.AntiMobLag;
import nl.trydev07.antimoblag.manager.ChunkManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

/* TryDev07 created on 23-12-2020
 * Project: AntiMobLag
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class AntiMobLagListener implements Listener {

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event){
        if(event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.BREEDING)){
            if(new ChunkManager().checkIfEntityMore(event.getLocation().getChunk())){
                AntiMobLag.system_out_println("There are to many entities in this chunk.");
                event.setCancelled(true);
            }
        }
    }
}
