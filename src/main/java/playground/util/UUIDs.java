package playground.util;

import java.util.Locale;
import java.util.UUID;

public class UUIDs {

    private UUIDs() {
        super();
    }

    /* -------------------------------------------------------- */

    public static String random() {
        return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase(Locale.ENGLISH);
    }

}
