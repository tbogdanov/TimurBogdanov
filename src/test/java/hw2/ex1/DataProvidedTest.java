package hw2.ex1;

import base.TestBase;
import enums.Links;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by Timur Bogdanov on 28.05.18.
 */
public class DataProvidedTest extends TestBase {


    @DataProvider
    public Object[][] benefitDataProvider() {
        return new Object[][] {
                {1, "To include good practices\nand ideas from successful\nEPAM project"},
                {2, "To be flexible and\ncustomizable"},
                {3, "To be multiplatform"},
                {4, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026"}
        };
    }

    @Test(dataProvider = "benefitDataProvider", threadPoolSize = 4)
    public void siteHasSpecificBenefitStringTest(int id, String expectedBenefit) {

        // Open test site by URL
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to(Links.HOME_PAGE.toString());

        // Assert that there is a specific benefit test under the specific icon
        WebElement benefitItem = driver.findElement(By.xpath("//div[@class='col-sm-3'][" + id + "]/div/span[@class='benefit-txt']"));

        Assert.assertTrue(benefitItem.isDisplayed());
        Assert.assertEquals(benefitItem.getText(), expectedBenefit);

        // Close the driver
        driver.close();
    }


}
