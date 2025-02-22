import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    LoginPage login = new LoginPage();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        login.openLoginPage();
    }

    @Test
       public void login() {
        login.loginPage();
        String actualUrl = "https://www.classicfootballshirts.co.uk/customer/account/index/";
        String expectedUrl = BrowserManager.getDriver().getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }


    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }

}
