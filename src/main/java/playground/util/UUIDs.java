package playground.util;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public interface UUIDs {

    public static Supplier<String> DEFAULT_UUID_SUPPLIER = () -> UUID.randomUUID().toString().replaceAll("-", "");

    public static String create(final Supplier<String> supplier) {
        Objects.requireNonNull(supplier);
        return supplier.get();
    }

    public static String random() {
        return create(DEFAULT_UUID_SUPPLIER);
    }

}
