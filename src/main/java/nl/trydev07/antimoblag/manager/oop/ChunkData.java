package nl.trydev07.antimoblag.manager.oop;

import org.bukkit.Chunk;
import org.bukkit.World;

import java.util.HashSet;
import java.util.Set;

/* TryDev07 created on 10-12-2020
 * Project: AntiMobLag
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class ChunkData {

    Set<Chunk> chunks = new HashSet<Chunk>();
    Integer maxAllowed;
    World world;

    public Integer getMaxAllowed() {
        return maxAllowed;
    }

    public void setMaxAllowed(Integer maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Set<Chunk> getChunks() {
        return chunks;
    }

    public void setChunks(Set<Chunk> chunks) {
        this.chunks = chunks;
    }
}
