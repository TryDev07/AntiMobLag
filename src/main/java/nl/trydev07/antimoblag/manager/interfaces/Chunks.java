package nl.trydev07.antimoblag.manager.interfaces;


/* TryDev07 created on 21-12-2020
 * Project: AntiMobLag
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public interface Chunks {

    /**
     * Initialize all necessary data into the ChunkData class.
     */
    void init();

    /**
     * Check if there are more entities then allowed in the chunks.
     * if there are more then allowed they will automatically be removed from the chunk.
     * @param maxAllowed Give the maximum mobs allowed in the chunks.
     */
    void removeToManyEntities(int maxAllowed);

    /**
     * Activates the check that will happen at a each period of the given time.
     * You can change the given time using the config file.
     * @param maxAllowedByConfig Define the max allowed mobs.
     */
    void loadChecks(int maxAllowedByConfig);
}
