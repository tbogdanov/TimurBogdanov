package pageObjects;

import enums.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

public class HomePage {

    private final String pageUrl = "https://epam.github.io/JDI/index.html";

    @FindBy(css = ".profile-photo")
    private WebElement userIcon;

    @FindBy(css = "#Name")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo span")
    private WebElement userName;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8>li")
    private List<WebElement> headerMenuItems;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> benefitIcons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitTexts;

    @FindBy(css = ".main-title.text-center")
    private WebElement mainHeaderTitle;

    @FindBy(css = ".main-txt.text-center")
    private WebElement mainHeaderText;

    @FindBy(css = ".main-content a")
    private WebElement subHeader;

    @FindBy(css = ".sidebar-menu")
    private WebElement sidebarMenu;

    @FindBy(css = ".footer-content.overflow")
    private WebElement footer;

    @FindBy(css = "#iframe")
    private WebElement iframe;

    @FindBy(css = ".epam-logo")
    private WebElement logo;

    public void openPage(WebDriver driver) {
        driver.navigate().to(Links.HOME_PAGE.toString());
    }

    public void login(Users user) {
        userIcon.click();
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void checkTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkUserName(Users user) {
        Assert.assertEquals(userName.getText(), user.getName());
        Assert.assertTrue(userName.isDisplayed());
    }

    public void checkHeaderMenuItems() {
        List<String> headerItemStrings = new LinkedList<>();

        for (WebElement item : headerMenuItems) {
            Assert.assertTrue(item.isDisplayed());
            headerItemStrings.add(item.getText());
        }

        Assert.assertEquals(headerItemStrings.size(), HeaderOptions.getCount());
        Assert.assertEquals(headerItemStrings, HeaderOptions.getDisplayNames());
    }

    public void checkBenefitIcons() {
        for (WebElement item : benefitIcons) {
            Assert.assertTrue(item.isDisplayed());
        }
    }

    public void checkBenefitTexts() {
        List<String> benefitTextStrings = new LinkedList<>();

        for (WebElement item : benefitTexts) {
            Assert.assertTrue(item.isDisplayed());
            benefitTextStrings.add(item.getText());
        }

        Assert.assertEquals(benefitTexts.size(), Benefits.getCount());
        Assert.assertEquals(benefitTextStrings, Benefits.getTexts());
    }

    public void checkMainHeaderTitle() {
        Assert.assertTrue(mainHeaderTitle.isDisplayed());
        Assert.assertEquals(mainHeaderTitle.getText(), Strings.MAIN_HEADER_TITLE.toString());
    }

    public void checkMainHeaderText() {
        Assert.assertTrue(mainHeaderText.isDisplayed());
        Assert.assertEquals(mainHeaderText.getText(), Strings.MAIN_HEADER_TEXT.toString());
    }

    public void checkSubHeader() {
        Assert.assertTrue(subHeader.isDisplayed());
        Assert.assertEquals(subHeader.getText(), Strings.SUB_HEADER_TITLE.toString());
    }

    public void checkSubHeaderLink() {
        Assert.assertEquals(subHeader.getAttribute("href"), Links.JDI_PAGE.toString());
    }

    public void checkLeftSection() {
        Assert.assertTrue(sidebarMenu.isDisplayed());
    }

    public void checkFooter() {
        Assert.assertTrue(footer.isDisplayed());
    }

    public void checkIframeExists() {
        Assert.assertTrue(iframe.isDisplayed());
    }

    public void checkIframeHasLogo(WebDriver driver) {
        driver.switchTo().frame(iframe);
        Assert.assertTrue(logo.isDisplayed());
    }

    public void leaveIframe(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

}

