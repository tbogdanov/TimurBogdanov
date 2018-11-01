package hw4;


import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPage;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Users.PITER_CHAILOVSKII;
import static enums.differentElementsNames.Checkboxes.WATER;
import static enums.differentElementsNames.Checkboxes.WIND;
import static enums.differentElementsNames.DropdownEntries.YELLOW;
import static enums.differentElementsNames.RadioButtons.SELEN;
import static enums.differentElementsNames.Statuses.FALSE;
import static enums.differentElementsNames.Statuses.TRUE;

public class ServicePageTest extends TestBase {

    private HomePageSelenide homePage;
    private DifferentElementsPage differentElementsPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = page(HomePageSelenide.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        getWebDriver().close();
    }

    @Test
    public void checkHomeDifferentPagesFunctionalityTest() {

        //S1: Open test site by URL
        homePage.openPage();

        //S2: Assert browser title
        homePage.checkTitle();

        //S3: Perform login
        homePage.login(PITER_CHAILOVSKII);

        //S4: Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName(PITER_CHAILOVSKII);

        //S5: Check that dropdown "Service" in the header contains property options
        homePage.checkHeaderServiceMenu();

        //S6: Check that dropdown "Service" in the left section contains property options
        homePage.checkLeftServiceMenu();

        //S7: Open Different Elements page through Service in the header -> Different Element button
        homePage.openDifferentElementsPage();

        //S8: Check interface on Different Elements page
        differentElementsPage.checkInternalElements();

        //S9: Assert that there is Right Section
        differentElementsPage.checkRightSection();

        //S10: Assert that there is Left Section
        differentElementsPage.checkLeftSection();

        //S11: Select checkboxes
        differentElementsPage.toggleCheckboxes(WATER, WIND);

        //S12: Assert that for each checkbox there is an individual log row
        // and value corresponded to the checked status of checkbox
        differentElementsPage.checkCheckboxLogEntries(TRUE, WATER, WIND);

        //S13: Select radio button
        differentElementsPage.selectRadioButton(SELEN);

        //S14: Assert that there is a log row for that radio button
        differentElementsPage.checkRadioLogEntry(SELEN);

        //S15: Select in dropdown
        differentElementsPage.selectDropdownOption(YELLOW);

        //S16: Assert that for dropdown there is an individual log row
        // and value corresponded to the selected value
        differentElementsPage.checkDropdownLogEntry(YELLOW);

        //S17: Unselect and assert checkboxes
        differentElementsPage.toggleCheckboxes(WATER, WIND);

        //S18: Assert that for each checkbox there is an individual log row
        // and value corresponded to the unchecked status of checkbox
        differentElementsPage.checkCheckboxLogEntries(FALSE, WATER, WIND);
    }

}
