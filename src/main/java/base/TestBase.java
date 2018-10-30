package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

/**
 * Created by Timur Bogdanov on 15.10.18.
 */
public class TestBase {

    private long time;

    @BeforeSuite
    public void beforeSuite() {
        //setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        time = currentTimeMillis();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Test framework worked for: " + (currentTimeMillis() - time));
    }

}
