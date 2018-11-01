package enums.differentElementsNames;

import java.util.LinkedList;
import java.util.List;

public enum Statuses {
    TRUE("true"),
    FALSE("false");

    private String displayName;

    Statuses(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }

    public static List<String> getDisplayNames() {
        List<String> names = new LinkedList<>();
        for (Statuses option: Statuses.values()) {
            names.add(option.toString());
        }
        return names;
    }

    public static int getCount() {
        return Statuses.values().length;
    }


}
