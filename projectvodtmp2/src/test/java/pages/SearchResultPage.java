// SearchResultPage.java
package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {
    private WebDriver driver;

    // Locators
    @FindBy(xpath = "//body")
    private WebElement body;

    @FindBy(xpath = "//a[@title='Next']")
    private WebElement nextPageButton;

    @FindBy(xpath = "//div[@class='b_algo']")
    private List<WebElement> searchResults;

    // Constructor
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to scroll down
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // Method to navigate to the next page
    public void goToNextPage() {
        nextPageButton.click();
    }

    // Method to count search results
    public int countSearchResults() {
        return searchResults.size();
    }
}
