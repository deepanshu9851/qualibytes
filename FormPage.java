package org.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    WebDriver driver;

    @FindBy(id = "name")    private WebElement nameInput;

    @FindBy(id = "email")    private WebElement emailInput;

    @FindBy(id = "submitBtn")    private WebElement submitBtn;

    @FindBy(id = "nameError")    private WebElement nameError;

    @FindBy(id = "emailError")    private WebElement emailError;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void submitEmptyForm() {
        // Clear inputs in case something is pre-filled
        nameInput.clear();
        emailInput.clear();
        submitBtn.click();
    }

    public boolean isNameErrorShown() {
        return nameError.isDisplayed();
    }

    public boolean isEmailErrorShown() {
        return emailError.isDisplayed();
    }
}
