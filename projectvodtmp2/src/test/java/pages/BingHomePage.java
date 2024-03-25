// BingHomePage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BingHomePage {
    private final WebDriver driver;
    private final By searchBox = By.name("q");
    private final By searchButton = By.name("go");

    public BingHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void search(String query) {
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchButton).click();
    }
}
