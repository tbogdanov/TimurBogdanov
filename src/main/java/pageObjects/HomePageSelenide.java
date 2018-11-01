package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Benefits;
import enums.ServiceOptions;
import enums.Users;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Strings.MAIN_HEADER_TEXT;
import static enums.Strings.SUB_HEADER_TITLE;

public class HomePageSelenide {

    private final String pageUrl = "https://epam.github.io/JDI/index.html";

    @FindBy(css = "title")
    private SelenideElement title;

    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement userName;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8>li")
    private ElementsCollection headerMenuItems;

    @FindBy(css = ".icons-benefit")
    private ElementsCollection benefitIcons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection benefitTexts;

    @FindBy(css = ".main-title.text-center")
    private SelenideElement mainHeaderTitle;

    @FindBy(css = ".main-txt.text-center")
    private SelenideElement mainHeaderText;

    @FindBy(css = ".main-content a")
    private SelenideElement subHeader;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement sidebarMenu;

    @FindBy(css = ".footer-content.overflow")
    private SelenideElement footer;

    @FindBy(css = ".nav .dropdown-toggle")
    private SelenideElement headerServiceDropdown;

    @FindBy(css = ".nav .dropdown-menu > li > a")
    private ElementsCollection headerServiceMenu;

    @FindBy(css = ".fa-caret-down")
    private SelenideElement leftServiceDropdown;

    @FindBy(css = "li.menu-title:nth-child(3) > ul:nth-child(2) > li > a")
    private ElementsCollection leftServiceMenu;

    @FindBy(css = ".nav a[href = 'different-elements.html']")
    private SelenideElement difElements;

    @FindBy(css = ".nav a[href = 'dates.html']")
    private SelenideElement dates;

    public void openPage() {
        open(pageUrl);
    }

    public void login(Users user) {
        userIcon.click();
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void checkUserName(Users user) {
        userName.shouldBe(visible);
        userName.shouldHave(text(user.getName()));
    }

    public void checkTitle() {
        Assert.assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkBenefitElements() {

        benefitIcons.shouldHaveSize(Benefits.getCount());
        for (SelenideElement icon : benefitIcons) {
            icon.shouldBe(visible);
        }

        benefitTexts.shouldHaveSize(Benefits.getCount());
        for (SelenideElement text : benefitTexts) {
            text.shouldBe(visible);
        }
        benefitTexts.shouldHave(texts(Benefits.getTexts()));
    }

    public void checkHeaderTexts() {
        mainHeaderText.shouldBe(visible);
        mainHeaderText.shouldHave(text(MAIN_HEADER_TEXT.toString()));

        subHeader.shouldBe(visible);
        subHeader.shouldHave(text(SUB_HEADER_TITLE.toString()));
    }

    public void checkLeftServiceMenu() {
        leftServiceDropdown.click();

        leftServiceMenu.shouldHave(texts(ServiceOptions.getDisplayNames()));

        for (SelenideElement element : leftServiceMenu) {
            element.shouldBe(visible);
        }
    }

    public void checkHeaderServiceMenu() {
        headerServiceDropdown.click();

        headerServiceMenu.shouldHave(texts(ServiceOptions.getDisplayNames()
                .stream().map(name -> name.toUpperCase()).collect(Collectors.toList())));
        for (SelenideElement element : headerServiceMenu) {
            element.shouldBe(visible);
        }
    }

    public void openDifferentElementsPage() {
        headerServiceDropdown.click();
        difElements.click();
    }

    public void openDatesPage() {
        headerServiceDropdown.click();
        dates.click();
    }

    public void checkLeftSection() {
        Assert.assertTrue(sidebarMenu.isDisplayed());
    }

}

