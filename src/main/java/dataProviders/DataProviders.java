package dataProviders;

import org.testng.annotations.DataProvider;

/**
 * Created by Timur Bogdanov on 15.10.18.
 */
public class DataProviders {

    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][] {
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }

}
