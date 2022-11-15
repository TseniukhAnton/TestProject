package org.selenium.practice.pages.navigationpan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.practice.pages.base.BasePage;
import org.selenium.practice.pages.checkboxes.CheckBoxesPage;
import org.selenium.practice.pages.home.HomePage;
import org.selenium.practice.pages.inputfields.InputFields;

public class NavigationPanel extends BasePage {

    public NavigationPanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//span[contains(text(),'Input fields')]")
    private WebElement inputFields;

    @FindBy(xpath = "//span[contains(text(),'Check-boxes')]")
    private WebElement checkBoxes;

    @FindBy(xpath = "//span[contains(text(),'Drop-downs')]")
    private WebElement dropDowns;

    @FindBy(xpath = "//span[contains(text(),'Radio-buttons')]")
    private WebElement radioButtons;

    @FindBy(xpath = "//span[contains(text(),'Table')]")
    private WebElement table;

    @FindBy(xpath = "//span[contains(text(),'Toggles')]")
    private WebElement toggles;

    @FindBy(xpath = "//span[contains(text(),'Date pickers')]")
    private WebElement datePickers;

    public HomePage openHomePage() {
        home.click();
        return new HomePage(driver);
    }

    public InputFields openInputFields() {
        inputFields.click();
        return new InputFields(driver);
    }

    public CheckBoxesPage openCheckBoxes() {
        checkBoxes.click();
        return new CheckBoxesPage(driver);
    }




}
