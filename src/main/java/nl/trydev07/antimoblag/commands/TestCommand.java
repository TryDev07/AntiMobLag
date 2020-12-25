package nl.trydev07.antimoblag.commands;

import nl.trydev07.antimoblag.manager.ChunkManager;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* TryDev07 created on 21-12-2020
 * Project: AntiMobLag
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            if (command.getName().equalsIgnoreCase("CheckEntityCount")) {
                Player player = (Player) commandSender;
                Chunk c = player.getLocation().getChunk();

               new ChunkManager(player.getWorld());
               ChunkManager.getChunkManager().removeToManyEntities(10);

            }
        }
        return false;
    }
}
