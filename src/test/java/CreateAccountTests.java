import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.CreateAccountPage;
import org.automation.pageobjects.HomePage;
import org.junit.jupiter.api.*;

import java.util.List;

public class CreateAccountTests {

    HomePage homePage = new HomePage();
    CreateAccountPage createAccountPage = new CreateAccountPage();

    @BeforeEach
    public void setUp() {
        homePage.openHomePage();
    }

    @Severity(SeverityLevel.MINOR)
    @Test
    @DisplayName("Validate create account fields test")
    public void validateCreateAccountFields() {
        createAccountPage.clickMyAccountButton();
        createAccountPage.clickCreateAccountButton();
        List<String> labelsText = createAccountPage.getAccountLabels();
    }





    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
