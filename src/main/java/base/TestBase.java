package base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

/**
 * Created by Timur Bogdanov on 15.10.18.
 */
public class TestBase {

    private long time;
    protected ChromeOptions options;
    private HashMap<String, Object> chromePrefs;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        time = currentTimeMillis();

        // Preparing chromePrefs for a driver
        chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", "target");

        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        // For Selenide
        Configuration.browser = "chrome";
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 200;
        Configuration.startMaximized = true;
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("Test framework worked for: " + (currentTimeMillis() - time));
    }

}
