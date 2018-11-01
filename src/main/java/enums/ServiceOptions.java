package enums;

import java.util.LinkedList;
import java.util.List;

public enum ServiceOptions {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLES_PAGES("Tables With Pages"),
    DIFFERENT_ELEMENTS("Different Elements");

    private String displayName;

    ServiceOptions(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }

    public static List<String> getDisplayNames() {
        List<String> names = new LinkedList<>();
        for (ServiceOptions option: ServiceOptions.values()) {
            names.add(option.toString());
        }
        return names;
    }

    public static int getCount() {
        return ServiceOptions.values().length;
    }

}
