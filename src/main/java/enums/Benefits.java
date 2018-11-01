package enums;

import java.util.LinkedList;
import java.util.List;

public enum Benefits {

    GOOD_PRACTICES("To include good practices\nand ideas from successful\nEPAM project"),
    FLEXIBLE("To be flexible and\ncustomizable"),
    MULTIPLATFORM("To be multiplatform"),
    GOOD_BASE("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026");

    private String benefitText;

    Benefits(String benefitText) {
        this.benefitText = benefitText;
    }

    @Override
    public String toString() {
        return this.benefitText;
    }

    public static List<String> getTexts() {
        List<String> texts = new LinkedList<>();
        for (Benefits option: Benefits.values()) {
            texts.add(option.toString());
        }
        return texts;
    }

    public static int getCount() {
        return Benefits.values().length;
    }



}
