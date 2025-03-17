import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.constants.ProductClass;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.HomePage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SearchTests {
    HomePage homePage = new HomePage();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        homePage.openHomePage();
    }


    @Test
    @DisplayName("Validate number of products in list test")
    public void validateProducts() {
        log.info("Validate products");
        homePage.searchElementFromDropdown("Deportivo Cali");
        List<WebElement> listOfProducts = homePage.getSearchResults ();
        assertNotNull(listOfProducts, "List of products is null");
        assertEquals(5, listOfProducts.size(), "Number of products is: " + listOfProducts.size());
        assertTrue(listOfProducts.get(0).getText().contains("Cali"));
    }

    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Search dropdown menu test")
    @ParameterizedTest
    @ValueSource(strings = {"AC Milan", "Jacket", "Liverpool"})
    public void searchTest(String testData) {
        homePage.searchElementFromDropdown(testData);
        List<WebElement> results = homePage.getSearchResults();
        for (WebElement item : results) {
            assertTrue(item.getText().contains(testData), "I found item: " + item.getText());
        }
    }



    @DisplayName("Final cart price test with enum")
    @ParameterizedTest
    @EnumSource(value = ProductClass.class, names = {"FIRST_PRODUCT", "SECOND_PRODUCT","THIRD_PRODUCT","FOURTH_PRODUCT"})
    public void searchTestWithEnum(ProductClass product) {
        homePage.searchElementFromDropdown(product.getProduct());
        List<WebElement> results = homePage.getSearchResults();



    results.get(2).click();
    homePage.selectSize("M");
    String finalPriceAfterSelection = homePage.getFinalPrice();
    String cartPrice = homePage.getCart();
    assertEquals(finalPriceAfterSelection, cartPrice, "Final price is the same as cart price");


    }

    @AfterEach
    public void tearDown() {         BrowserManager.closeDriver();         }

        }
