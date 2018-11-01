package enums;

import java.util.LinkedList;
import java.util.List;

public enum HeaderOptions {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    private String displayName;

    HeaderOptions(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }

    public static List<String> getDisplayNames() {
        List<String> names = new LinkedList<>();
        for (HeaderOptions option: HeaderOptions.values()) {
            names.add(option.toString());
        }
        return names;
    }

    public static int getCount() {
        return HeaderOptions.values().length;
    }

}
