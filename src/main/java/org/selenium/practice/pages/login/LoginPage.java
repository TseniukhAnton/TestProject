package org.selenium.practice.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.practice.pages.base.BasePage;
import org.selenium.practice.pages.home.HomePage;

import static org.selenium.practice.constants.Constant.Login.LOGIN;
import static org.selenium.practice.constants.Constant.Login.PASSWORD;

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

    public HomePage login() {
        waitElementIsVisible(login);
        login.sendKeys(LOGIN);
        password.sendKeys(PASSWORD);
        loginBtn.click();
        return new HomePage(driver);
    }
}
