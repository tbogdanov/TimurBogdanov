package enums;

public enum Strings {

    HOME_PAGE_TITLE("Home Page"),
    MAIN_HEADER_TITLE("EPAM FRAMEWORK WISHES\u2026"),
    MAIN_HEADER_TEXT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "+
                             "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. "+
                             "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS "+
                             "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT "+
                             "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    SUB_HEADER_TITLE("JDI GITHUB"),
    DIFFERENT_ELEMENTS_TITLE("Different Elements");

    private String elem;

    Strings(String elem) {
        this.elem = elem;
    }

    @Override
    public String toString() {
        return elem;
    }

}
