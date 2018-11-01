package hw3;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import static enums.Users.PITER_CHAILOVSKII;

public class BasicElementsTest extends TestBase {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void siteHasBasicElementsTest() {

        // S1: Open test site by URL
        homePage.openPage(driver);

        // S2: Assert Browser title
        homePage.checkTitle(driver);

        // S3: Perform login
        homePage.login(PITER_CHAILOVSKII);

        // S4: Assert User name in the left-top side of screen that user is logged in
        homePage.checkUserName(PITER_CHAILOVSKII);

        // S5: Assert Browser title
        homePage.checkTitle(driver);

        // S6: Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkHeaderMenuItems();

        // S7: Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkBenefitIcons();

        // S8: Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkBenefitTexts();

        // S9: Assert a text of the main header
        homePage.checkMainHeaderTitle();
        homePage.checkMainHeaderText();

        // S10: Assert a text of the sub header
        homePage.checkSubHeader();

        // S11: Assert it has a proper URL
        homePage.checkSubHeaderLink();

        // S12: Assert that there is an Iframe in the center of the page
        homePage.checkIframeExists();

        // S13: Switch to the Iframe and check if there is an EPAM logo
        homePage.checkIframeHasLogo(driver);

        // S14: Switch back to the page
        homePage.leaveIframe(driver);

        // S15: Assert that there is Left Section
        homePage.checkLeftSection();

        // S16: Assert that there is Footer
        homePage.checkFooter();
    }

}
