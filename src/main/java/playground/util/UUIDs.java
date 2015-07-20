package playground.util;

import java.util.UUID;
import java.util.function.Supplier;

public interface UUIDs {

    public static Supplier<String> UUID_SUPPLIER = () -> UUID.randomUUID().toString().replaceAll("-", "");

    public static String create(final Supplier<String> supplier) {
        return supplier.get();
    }

    public static String random() {
        return create(UUID_SUPPLIER);
    }

}
