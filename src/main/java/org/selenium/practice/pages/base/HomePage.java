package org.selenium.practice.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By logo = By.xpath("//span[contains(text(),'QA Automation Web')]");
    private final By admin = By.xpath("//mat-label[contains(text(),'admin')]");
    private final By home = By.xpath("//span[contains(text(), 'Home')]");

    public HomePage checkHomePageView(){
        driver.findElement(logo).isDisplayed();
        driver.findElement(admin).isDisplayed();
        driver.findElement(home).isDisplayed();

        return this;
    }
}
