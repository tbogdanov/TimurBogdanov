package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.differentElementsNames.Checkboxes;
import enums.differentElementsNames.DropdownEntries;
import enums.differentElementsNames.RadioButtons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsPage {

    private final String pageUrl = "https://epam.github.io/JDI/different-elements.html";

    @FindBy(css = "title")
    private SelenideElement title;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = "select")
    private SelenideElement dropdown;

    @FindBy(css = "div.main-content .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = "div[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = "div[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = ".logs li")
    private ElementsCollection logEntries;

    @Step("Check if all checkboxes, radios, buttons and dropdowns are present")
    public void checkInternalElements() {
        checkboxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        dropdown.shouldBe(visible);
    }

    @Step("Check the visibility of the left section")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step("Check the visibility of the right section")
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @Step("Check log entries after checking Checkboxes")
    public void checkCheckboxLogEntries(boolean status, Checkboxes... selected) {
        /* We should check log entries in the reverse order.
           $$(...) was used instead of dedicated ElementsCollection because
           the latter one doesn't update itself and we get older lines.
           $$(...) always updates the requested node!
         */
        int logIndex = selected.length-1;
        for (Checkboxes cb : selected) {
            String expectedEntry = String.format("%s: condition changed to %s", cb.toString(), Boolean.toString(status));
            $$(".logs li").get(logIndex).shouldHave(text(expectedEntry));
            logIndex--;
        }
    }

    @Step("Check log entries after selecting Radio buttons")
    public void checkRadioLogEntry(RadioButtons value) {
        String expectedEntry = String.format("metal: value changed to %s", value.toString());
        $$(".logs li").get(0).shouldHave(text(expectedEntry));
    }

    @Step("Check log entries after selecting from Dropdown")
    public void checkDropdownLogEntry(DropdownEntries value) {
        String expectedEntry = String.format("Colors: value changed to %s", value.toString());
        $$(".logs li").get(0).shouldHave(text(expectedEntry));
    }

    @Step("Check a checkbox")
    public void toggleCheckboxes(Checkboxes... selected) {
        for (Checkboxes cb : selected) {
            checkboxes.findBy(text(cb.toString())).$("[type = checkbox]").click();
        }
    }

    @Step("Select a Radio button from the list")
    public void selectRadioButton(RadioButtons radioName) {
        radios.findBy(text(radioName.toString())).$("[type = radio]").click();
    }

    @Step("Select an entry from Dropdown")
    public void selectDropdownOption(DropdownEntries option) {
        dropdown.click();
        dropdown.selectOption(option.toString());
    }

}