package enums.differentElementsNames;

import java.util.LinkedList;
import java.util.List;

public enum Checkboxes {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String displayName;

    Checkboxes(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }

    public static List<String> getDisplayNames() {
        List<String> names = new LinkedList<>();
        for (Checkboxes option: Checkboxes.values()) {
            names.add(option.toString());
        }
        return names;
    }

    public static int getCount() {
        return Checkboxes.values().length;
    }

}
