package enums.differentElementsNames;

import java.util.LinkedList;
import java.util.List;

public enum  RadioButtons {
    GOLD("Gold"), SILVER("Silver"), BRONZE("Bronze"), SELEN("Selen");

    private String displayName;

    RadioButtons(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }

    public static List<String> getDisplayNames() {
        List<String> names = new LinkedList<>();
        for (RadioButtons option: RadioButtons.values()) {
            names.add(option.toString());
        }
        return names;
    }

    public static int getCount() {
        return RadioButtons.values().length;
    }

}
