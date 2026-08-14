package ru.spliterash.musicbox.minecraft.nms;

import org.bukkit.Bukkit;

public class NMSUtils {

    public static int parseMajorVersion(String raw) {
        int firstDotIndex = raw.indexOf(".");

        String first = raw.substring(0, firstDotIndex);

        // Legacy scheme: 1.19.2 -> major version is 19 (the second segment)
        // New scheme: 26.2 -> major version is 26 (the first segment)
        if (first.equals("1")) {
            raw = raw.substring(firstDotIndex + 1);

            int secondDotIndex = raw.indexOf(".");

            if (secondDotIndex != -1)
                raw = raw.substring(0, secondDotIndex);

            return Integer.parseInt(raw);
        }

        return Integer.parseInt(first);
    }

    public static String getRawVersion() {
        String strVersion = Bukkit.getVersion();

        int start = strVersion.indexOf("(MC: ") + 5;

        strVersion = strVersion.substring(start);

        int end = strVersion.indexOf(")");

        strVersion = strVersion.substring(0, end);

        return strVersion;
    }

    public static int getVersion() {
        return parseMajorVersion(getRawVersion());
    }
}
