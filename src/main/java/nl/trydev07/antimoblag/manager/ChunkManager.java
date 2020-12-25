package nl.trydev07.antimoblag.manager;

import nl.trydev07.antimoblag.AntiMobLag;
import nl.trydev07.antimoblag.manager.interfaces.Chunks;
import nl.trydev07.antimoblag.manager.oop.ChunkData;
import nl.trydev07.antimoblag.util.ConfigData;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

/* TryDev07 created on 10-12-2020
 * Project: AntiMobLag
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class ChunkManager extends ChunkData implements Chunks {

    static ChunkManager chunkManager;

    public static ChunkManager getChunkManager() {
        return chunkManager;
    }

    int entityLength;

    public ChunkManager() {

    }

    public ChunkManager(World w) {
        setWorld(w);
        init();
        chunkManager = this;
    }

    @Override
    public void init() {
        if (!(getChunks().isEmpty())) return;
        getChunks().clear();
        for (Chunk chunk : getWorld().getLoadedChunks()) {
            getChunks().add(chunk);
        }
    }

    @Override
    public void removeToManyEntities(int maxAllowed) {
        for (Chunk chunk : getChunks()) {
            entityLength = chunk.getEntities().length;
            if (entityLength != 0) {
                for (Entity chunkEntity : chunk.getEntities()) {
                    if (maxAllowed <= entityLength) {
                        if (chunkEntity.getType() != EntityType.PLAYER) {
                            chunkEntity.remove();
                            entityLength--;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void loadChecks(final int maxAllowedByConfig) {
        AntiMobLag.system_out_println(ConfigData.time_between_checks + "");
        new BukkitRunnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                AntiMobLag.system_out_println("1 minute later");
                for (World w : Bukkit.getWorlds()) {
                    new ChunkManager(w).removeToManyEntities(maxAllowedByConfig);
                }

                long endTime = System.currentTimeMillis();
                AntiMobLag.system_out_println("it took: " + (endTime - startTime) + "ms");
            }
        }.runTaskTimerAsynchronously(AntiMobLag.getAntiMobLag(), 0, ConfigData.time_between_checks);
    }

    public boolean checkIfEntityMore(Chunk chunk) {
        if (chunk.getEntities().length >= ConfigData.entities_allowed) {
            return true;
        }
        return false;
    }
}