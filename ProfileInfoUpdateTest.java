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

public class ProfileInfoUpdateTest {

    WebDriver driver;
    LoginPage loginPage;
    ProfilePage profilePage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    public void automatedProfileInformationUpdate() {
        driver.get("https://yourapp.com/login"); // Update URL

        loginPage.login("testuser", "password123");

        profilePage.goToProfileSettings();

        String bio = "Automation enthusiast";
        String location = "San Francisco";
        String interests = "Music, Travel";

        profilePage.updateProfile(bio, location, interests);

        Assert.assertEquals(profilePage.getBio(), bio);
        Assert.assertEquals(profilePage.getLocation(), location);
        Assert.assertEquals(profilePage.getInterests(), interests);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
