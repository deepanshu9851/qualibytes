package org.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    WebDriver driver;

    @FindBy(id = "bio")  private WebElement bioInput;

    @FindBy(id = "location")   private WebElement locationInput;

    @FindBy(id = "interests") private WebElement interestsInput;

    @FindBy(id = "saveProfile")    private WebElement saveBtn;

    @FindBy(id = "bioText") private WebElement bioText;

    @FindBy(id = "locationText")   private WebElement locationText;

    @FindBy(id = "interestsText")   private WebElement interestsText;

    @FindBy(id = "uploadPicture")    private WebElement uploadInput;

    @FindBy(id = "profileImage")    private WebElement profileImage;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToProfileSettings() {
        driver.get("https://Neosofttech.com/profile/settings"); // 
    }

    public void updateProfile(String bio, String location, String interests) {
        bioInput.clear();
        bioInput.sendKeys(bio);

        locationInput.clear();
        locationInput.sendKeys(location);

        interestsInput.clear();
        interestsInput.sendKeys(interests);

        saveBtn.click();
    }

    public String getBio() {
        return bioText.getText();
    }

    public String getLocation() {
        return locationText.getText();
    }

    public String getInterests() {
        return interestsText.getText();
    }

    public void uploadProfilePicture(String filePath) {
        uploadInput.sendKeys(filePath);
    }

    public boolean isProfilePictureDisplayed() {
        return profileImage.isDisplayed();
    }
}
