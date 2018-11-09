package base;

import org.openqa.selenium.WebDriver;

public class Utils {

    public static void leaveIframe(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

}
