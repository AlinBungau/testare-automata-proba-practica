import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    @DisplayName("Search products with multiple results")
    public void searchProductsWithMultipleResults() {
        homePage.searchElementFromDropdown("AC Milan");
        List<WebElement> results = homePage.getSearchResults();
        for (WebElement item : results) {
            assertTrue(item.getText().contains("AC Milan"), "Items found" + item.getText());
        }
    }

    @AfterEach
    public void tearDown() {         BrowserManager.closeDriver();         }

        }
