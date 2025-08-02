package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTests extends BaseTest {

	
	

    //  Expected: Login button should be disabled when fields are empty
    // Actual: Login button was enabled even without entering credentials
    @Test
    public void testLoginButtonDisabledWhenFieldAreEmpty() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.login-button")));
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button should be disabled when fields are empty");
       }

    @Test
    public void testPasswordMaskedbutton() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked initially");

        loginPage.togglePasswordVisibility();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> !driver.findElement(By.id("formPassword")).getAttribute("type").equals("password"));

        Assert.assertFalse(loginPage.isPasswordMasked(), "Password should be visible after toggle");
       
    }

    @Test
    public void testInvalidLoginShowErrorMsg() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUserId("invalid@example.com");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.invalid-credential-div p")));


        String error = loginPage.getErrorMessage();
        System.out.println("Error Message: " + error);
        Assert.assertTrue(error.contains("Invalid Credentials"), "Error message should mention 'Invalid'");
        
    }
   @Test
   public void validateLoginPageElements() {
	   LoginPage loginPage = new LoginPage(driver);
	   
	   Assert.assertTrue(loginPage.isUserIdDisplayed(), "Username field is not displayed");
	   Assert.assertTrue(loginPage.isPasswordDisplayed(),"Password field is not displayed");
	   Assert.assertTrue(loginPage.isEyeIconDisplayed(),"Eye icon is not displayed");
	   Assert.assertTrue(loginPage.isLoginButtonDisplayed(),"Login Button is not displayed");
	   
   }
     
}
