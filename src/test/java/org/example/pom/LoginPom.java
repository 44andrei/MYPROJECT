package org.example.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom extends BasicPom{ //meow
    @FindBy(xpath = "//*[@id='userName']") //ham
    WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id='login']")
    WebElement login;

    public LoginPom(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void setPassword(String passParam) {
        password.clear();
        password.sendKeys(passParam);
    }

    public void setUserName(String userNameParam) {
        userName.clear();
        userName.sendKeys(userNameParam);
    }
}