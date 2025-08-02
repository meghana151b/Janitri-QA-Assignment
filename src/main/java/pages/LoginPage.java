package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "formEmail")
    WebElement userIdInput;

    @FindBy(id = "formPassword")
    WebElement passwordInput;

    @FindBy(css = "button.login-button")
    WebElement loginButton;

    @FindBy(css = "img.passowrd-visible")
    WebElement eyeIcon;
    

    @FindBy(css = "div.invalid-credential-div p")
    WebElement errorMessage;

    public void enterUserId(String userId) {
        userIdInput.clear();
        userIdInput.sendKeys(userId);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
   
    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public boolean isPasswordMasked() {
        return passwordInput.getAttribute("type").equals("password");
    }

    public void togglePasswordVisibility() {
        eyeIcon.click();
    }

    public String getErrorMessage() {
        try {
            return errorMessage.getText();
        } catch (Exception e) {
            return "No error message found";
        }
    }
    public boolean isUserIdDisplayed() {
    	return userIdInput.isDisplayed();
    }
    public boolean isPasswordDisplayed() {
    	return passwordInput.isDisplayed();
    }
    public boolean isLoginButtonDisplayed() {
    	return loginButton.isDisplayed();
    }
    public boolean isEyeIconDisplayed() {
    	return eyeIcon.isDisplayed();
    }
    
   

}