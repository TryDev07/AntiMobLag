package nl.trydev07.antimoblag.util;

import nl.trydev07.antimoblag.AntiMobLag;

import java.util.regex.Pattern;

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
        if (containsRegex(str, Pattern.compile("(?=.*h)(?=.*m)(?=.*s)"))) {
            String[] string = str.split("h|m|s");
            i = (Integer.parseInt(string[0]) * 72000) + (Integer.parseInt(string[1]) * 1200) + (Integer.parseInt(string[2]) * 20);
        } else if (containsRegex(str, Pattern.compile("(?=.*h)(?=.*m)"))) {
            String[] string = str.split("h|m");
            i = (Integer.parseInt(string[0]) * 72000) + (Integer.parseInt(string[1]) * 1200);
        } else if (containsRegex(str, Pattern.compile("(?=.*m)(?=.*s)"))) {
            String[] string = str.split("m|s");
            i = (Integer.parseInt(string[0]) * 1200) + (Integer.parseInt(string[1]) * 20);
        } else if (containsRegex(str, Pattern.compile("(?=.*h)(?=.*s)"))) {
            String[] string = str.split("h|s");
            i = (Integer.parseInt(string[0]) * 72000) + (Integer.parseInt(string[1]) * 20);
        } else {
            if (str.contains("h")) {
                String strNew = str.replace("h", "");
                int time = Integer.parseInt(strNew);
                i = i + (time * 72000);
            } else if (str.contains("m")) {
                String strNew = str.replace("m", "");
                int time = Integer.parseInt(strNew);
                i = i + (time * 1200);
            } else if (str.contains("s")) {
                String strNew = str.replace("s", "");
                int time = Integer.parseInt(strNew);
                i = i + (time * 20);
            }
        }

        AntiMobLag.system_out_println("Time=" + i);
        return i;
    }

    public static boolean containsRegex(String input, Pattern regex) {
        if (regex.matcher(input).find()) {
            return true;
        }
        return false;
    }

}
