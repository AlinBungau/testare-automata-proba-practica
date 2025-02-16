package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;

import java.util.List;

public class CreateAccountPage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By MY_ACCOUNT_BUTTON = By.xpath("//li[@class='ml-[15px]']//a[contains(text(),'My Account')]");
    private final static By CREATE_ACCOUNT_BUTTON = By.xpath("//span[normalize-space()='Create an Account']");
    private final static By CUSTOMER_NEW_CUSTOMER_ACCOUNT_TEXT = By.xpath("//span[@class='base']");
    private final static By PERSONAL_INFORMATION_TEXT = By.xpath("//span[normalize-space()='Personal Information']");
    private final static By FIRST_NAME_TEXT = By.xpath("//span[normalize-space()='First Name']");
    private final static By LAST_NAME_TEXT = By.xpath("//span[normalize-space()='Last Name']");
    private final static By SING_UP_FOR_NEWSLETTER_TEXT = By.xpath("//span[normalize-space()='Sign Up for Newsletter']");
    private final static By VAT_TEXT = By.xpath("//span[normalize-space()='Tax/VAT Number']");
    private final static By ALLOW_TEXT = By.xpath("//span[normalize-space()='Allow remote shopping assistance']");
    private final static By SIGN_IN_INFORMATION_TEXT = By.xpath("//span[normalize-space()='Sign-in Information']");
    private final static By EMAIL_TEXT = By.xpath("//span[normalize-space()='Email']");
    private final static By PASSWORD_TEXT = By.xpath("//span[normalize-space()='Password']");
    private final static By PASSWORD_STRENGTH_TEXT = By.xpath("//div[@id='password-strength-meter']");
    private final static By CONFIRM_PASSWORD_TEXT = By.xpath("//span[normalize-space()='Confirm Password']");

    public void clickMyAccountButton() {
        log.info("Click my account button");
        actions.clickElement(MY_ACCOUNT_BUTTON);
    }

    public void clickCreateAccountButton() {
        log.info("Click create account button");
        actions.clickElement(CREATE_ACCOUNT_BUTTON);
    }

    public List<String> getAccountLabels() {
        log.info("Get account labels");
        String customerText = actions.getElementText(CUSTOMER_NEW_CUSTOMER_ACCOUNT_TEXT);
        String personalText = actions.getElementText(PERSONAL_INFORMATION_TEXT);
        String firstNameText = actions.getElementText(FIRST_NAME_TEXT);
        String lastNameText = actions.getElementText(LAST_NAME_TEXT);
        String signUPText = actions.getElementText(SING_UP_FOR_NEWSLETTER_TEXT);
        String vatText = actions.getElementText(VAT_TEXT);
        String allowText = actions.getElementText(ALLOW_TEXT);
        String signInText = actions.getElementText(SIGN_IN_INFORMATION_TEXT);
        String emailText = actions.getElementText(EMAIL_TEXT);
        String passwordText = actions.getElementText(PASSWORD_TEXT);
        String passwordStrengthText = actions.getElementText(PASSWORD_STRENGTH_TEXT);
        String confirmPasswordText = actions.getElementText(CONFIRM_PASSWORD_TEXT);

        return List.of(customerText, personalText, firstNameText, signUPText, vatText, allowText, lastNameText, passwordText, signInText, emailText, passwordStrengthText, confirmPasswordText);
    }
}
