package enums.differentElementsNames;

import java.util.LinkedList;
import java.util.List;

public enum  DropdownEntries {

    RED("RED"), GREEN("Green"), BLUE("Blue"), YELLOW("Yellow");

    private String displayName;

    DropdownEntries(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }

    public static List<String> getDisplayNames() {
        List<String> names = new LinkedList<>();
        for (DropdownEntries option: DropdownEntries.values()) {
            names.add(option.toString());
        }
        return names;
    }

    public static int getCount() {
        return DropdownEntries.values().length;
    }


}
