package nl.trydev07.antimoblag.listeners;

import nl.trydev07.antimoblag.AntiMobLag;
import nl.trydev07.antimoblag.manager.ChunkManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import static nl.trydev07.antimoblag.util.ConfigData.To_Many_Entities_Message;

/* TryDev07 created on 23-12-2020
 * Project: AntiMobLag
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class AntiMobLagListener implements Listener {

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {

        if (event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.BREEDING)) {
            if (new ChunkManager().checkIfEntityMore(event.getLocation().getChunk())) {
                for(Entity entities : event.getLocation().getChunk().getEntities()){
                    if(entities instanceof Player){
                        Player player = (Player) entities;
                        player.sendMessage(To_Many_Entities_Message);
                    }
                }
                event.setCancelled(true);
            }
        }
    }
}
