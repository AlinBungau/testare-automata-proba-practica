package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public class HomePage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);


    private final static By SEARCH_FIELD = By.xpath("(//input[@id='search'])[2]");
    private final static By HOME_PAGE_PRODUCTS = By.xpath("//div[@class='relative products products-grid mode-grid products-grid']//div[@class='product-item lg:px-[10px] lg:pt-[15px] pb-[10px] min-h-[175px]']");
    private final static By ELEMENTS_FROM_SEARCH = By.xpath("(//span[@class='text-sm'])[1]");
    private final static By SEARCH_RESULTS = By.xpath("//div[@class='relative products products-grid mode-grid products-grid']//div[@class='product-item lg:px-[10px] lg:pt-[15px] pb-[10px] min-h-[175px]']");

    public void openHomePage() {
        log.info("Open home page");
        manager.openBrowser();
        manager.getDriver().get("https://www.classicfootballshirts.co.uk/");
        manager.getDriver().manage().window().maximize();
    }

    public List<WebElement> productsDisplayed() {
        log.info("Check if products are displayed");
        return actions.getElements(HOME_PAGE_PRODUCTS);
    }


    public void searchElementFromDropdown(String searchElement) {
        log.info("Search for element: {}", searchElement);
        actions.clickElement(SEARCH_FIELD);
        actions.sendKeys(SEARCH_FIELD, searchElement);
        actions.waitElementToBeClickable(By.xpath("(//span[@class='text-sm'])[1]"), 10);
        List<WebElement> searchSuggestions = actions.getElements(ELEMENTS_FROM_SEARCH);
        for (var item : searchSuggestions) {
            if (item.getText().toLowerCase(Locale.ROOT).equals(searchElement.toLowerCase(Locale.ROOT))) {
                item.click();
                break;
            }
        }
    }

    public List<WebElement> getSearchResults() {
        return actions.getElements(SEARCH_RESULTS);
    }
}
