package nl.trydev07.antimoblag;

import nl.trydev07.antimoblag.commands.TestCommand;
import nl.trydev07.antimoblag.listeners.AntiMobLagListener;
import nl.trydev07.antimoblag.manager.ChunkManager;
import nl.trydev07.antimoblag.util.ConfigData;
import nl.trydev07.antimoblag.util.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/* TryDev07 created on 10-12-2020
 * Project: AntiMobLag
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class AntiMobLag extends JavaPlugin {

    static JavaPlugin AntiMobLag;
    static FileManager FileManager;

    public static JavaPlugin getAntiMobLag() {
        return AntiMobLag;
    }

    public static FileManager getFileManager() {
        return FileManager;
    }

    public static void system_out_println(String msg) {
        if (msg == null) return;
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&eAntiMobLag&8] &7- &c" + msg));
    }

    @Override
    public void onEnable() {
        AntiMobLag = this;
        this.getCommand("CheckEntityCount").setExecutor(new TestCommand());
        FileManager = new FileManager(this);
        FileManager.getConfig("config.yml").copyDefaults(true).save();


        if (ConfigData.enable_auto_checks) {
            new ChunkManager().loadChecks(ConfigData.entities_allowed);
        }

        getServer().getPluginManager().registerEvents(new AntiMobLagListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
