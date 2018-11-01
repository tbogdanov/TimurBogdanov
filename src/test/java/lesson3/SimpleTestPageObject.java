package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;

import java.util.concurrent.TimeUnit;

import static enums.Users.PITER_CHAILOVSKII;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

/**
 * Created by Timur Bogdanov on 11.10.18.
 */
public class SimpleTestPageObject {

    private WebDriver driver = new ChromeDriver();
    private HomePageSelenide homePage = PageFactory.initElements(driver, HomePageSelenide.class);

    @BeforeClass
    public void beforeClass() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //WebDriver driver = new ChromeDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {

        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void simpleTest() {

        // 2. Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        // 3. Assert Title
        assertEquals(driver.getTitle(), "Home Page");

        // 4. Login
        homePage.login(PITER_CHAILOVSKII);

        // 5. Assert the main title text
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        // Close the driver

    }

}
