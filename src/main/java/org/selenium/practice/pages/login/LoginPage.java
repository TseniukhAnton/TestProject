package org.selenium.practice.pages.login;

import com.google.common.base.Verify;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.practice.pages.base.BasePage;
import org.selenium.practice.pages.home.HomePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.selenium.practice.constants.Constant.Login.*;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    private WebElement login;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='loginBtn']")
    private WebElement loginBtn;

    public LoginPage wrongLogin() {
        waitElementIsVisible(login);
        wait.until(ExpectedConditions.visibilityOf(login));
        waitImplicitly();
        login.sendKeys(WRONG_LOGIN);
        password.sendKeys(WRONG_PASSWORD);
        loginBtn.click();
        alertCheck();
        return this;
    }

    public void alertCheck(){
        Alert alert = wait.until(alertIsPresent());
        String alertText = alert.getText();
        System.out.println(alertText);
        Verify.verify(alertText.equals("Invalid credentials"));
        alert.accept();
    }

    public HomePage login() {
        waitElementIsVisible(login);
        wait.until(ExpectedConditions.visibilityOf(login));
        waitImplicitly();
        login.sendKeys(LOGIN);
        password.sendKeys(PASSWORD);
        loginBtn.click();
        return new HomePage(driver);
    }
}
