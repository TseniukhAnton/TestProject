package org.selenium.practice.pages.checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.practice.pages.base.BasePage;
import org.selenium.practice.pages.home.HomePage;
import org.testng.asserts.SoftAssert;

public class CheckBoxesPage extends BasePage {
    public CheckBoxesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[@for='mat-checkbox-1-input']")
    private WebElement indeterminate;
    //private final By indeterminate = By.xpath("//label[@for='mat-checkbox-1-input']");
    private final By primary = By.xpath("//label[@for='mat-checkbox-2-input']");
    private final By accent = By.xpath("//label[@for='mat-checkbox-3-input']");
    private final By warn = By.xpath("//label[@for='mat-checkbox-4-input']");


    public void checkboxesSelectedCheck() {
        new HomePage(driver).openCheckBoxes();
        indeterminate.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(indeterminate.isSelected());
        softAssert.assertTrue(driver.findElement(primary).isSelected());
        softAssert.assertTrue(driver.findElement(accent).isSelected());
        softAssert.assertTrue(driver.findElement(warn).isSelected());

        driver.quit();
    }

}
