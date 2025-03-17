import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.CreateAccountPage;
import org.automation.pageobjects.HomePage;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        List<String> expectedLabels = List.of("Personal Information", "First Name", "Sign Up for Newsletter", "Tax/VAT Number", "Last Name", "Email", "Password", "Allow remote shopping assistance", "Confirm Password","Password Strength: No Password", "Sign-in Information");
        expectedLabels.forEach(label -> assertTrue(labelsText.contains(label), "Label '" + label + "' should be present"));
    }





    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
