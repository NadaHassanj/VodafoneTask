// BingSearchTest.java
package tests;

import framework.ExcelReader;
import framework.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BingHomePage;
import pages.SearchResultPage;

import java.io.IOException;

public class BingSearchTest extends TestBase {
    @DataProvider(name = "searchData")
    public Object[][] getSearchData() throws IOException {
        // Example of using a relative path
        String testDataFilePath ="src//java/file/testdata.xlsx";

        try {
            return ExcelReader.readTestData(testDataFilePath, "searchTestData");
        } catch (IOException e) {
            // Handle IOException appropriately (e.g., log the error, throw custom exception)
            e.printStackTrace();
            throw e;
        }
    }
    @Test(dataProvider = "searchData")
    public void testBingSearch(String browser, String url, String query) {
        BingHomePage homePage = new BingHomePage(driver);
        homePage.open(url);
        homePage.search(query);

        SearchResultPage resultPage = new SearchResultPage(driver);
        int firstPageResultCount = resultPage.countSearchResults();

        // Scroll down and go to the next page
        resultPage.scrollDown();
        resultPage.goToNextPage();

        // Count the number of search results on the second page
        int secondPageResultCount = resultPage.countSearchResults();

        // Validate if the number of results on page 1 is not equal to page 2
        Assert.assertNotEquals(firstPageResultCount, secondPageResultCount,
                "Number of results on page 1 is equal to page 2");


        // Close the browser window (handled by TestBase @AfterMethod)
    }}