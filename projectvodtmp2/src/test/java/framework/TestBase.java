// TestBase.java
package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestBase {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        driver = BrowserFactory.createDriver(browser);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
