package org.Tests;


import org.Pages.LoginPage;
import org.Pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProfilePictureUploadTest {

    WebDriver driver;
    LoginPage loginPage;
    ProfilePage profilePage;

    @BeforeClass
    public void setup()
    {
    	
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    public void automatedProfilePictureUpload() {
        driver.get("https://Neosofttech.com/login"); 

        loginPage.login("testuser", "password123");

        profilePage.goToProfileSettings();

        profilePage.uploadProfilePicture("src/test/resources/profile_pic.jpg");

        Assert.assertTrue(profilePage.isProfilePictureDisplayed(), "Profile picture is not displayed.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
