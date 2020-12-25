package nl.trydev07.antimoblag.util;

import nl.trydev07.antimoblag.AntiMobLag;

/* TryDev07 created on 22-12-2020
 * Project: AntiMobLag
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class ConfigData {

    public static final boolean enable_auto_checks = Boolean.parseBoolean(AntiMobLag.getFileManager().getConfig("config.yml").get("EnableAutoChecks").toString());
    public static final int time_between_checks = defineTime(AntiMobLag.getFileManager().getConfig("config.yml").get("AutoCheckTimeDelay").toString());
    public static final int entities_allowed = Integer.parseInt(AntiMobLag.getFileManager().getConfig("config.yml").get("MaxEntitiesAllowedPerChunk").toString());

    public static int defineTime(String str) {
        int i = 0;
        if(str.contains("")){

        }

        /*if (str.contains("h")) {
            String strNew = str.replace("h", "");
            int time = Integer.parseInt(strNew);
            i = i + (time * 72000);
        }
        if (str.contains("m")) {
            String strNew = str.replace("m", "");
            int time = Integer.parseInt(strNew);
            i = i + (time * 1200);
        }
        if (str.contains("s")) {
            String strNew = str.replace("s", "");
            int time = Integer.parseInt(strNew);
            i = i + (time * 20);
        }*/
        return i;
    }

}
