package playground.util;

import java.util.Iterator;
import java.util.UUID;
import java.util.stream.Stream;

public final class UUIDs {

    private UUIDs() {
        super();
    }

    private static Iterator<String> UUID_ITERATOR = Stream.generate(() -> UUID.randomUUID().toString()).iterator();

    /* -------------------------------------------------------- */

    public static String random() {
        return UUID_ITERATOR.next().replaceAll("-", "").toLowerCase();
    }

}
