package org.example.test;

import org.example.pom.FormPom;
import org.example.utilities.Driver;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormTest {

    public WebDriver driver;
    public static String Url="https://demoqa.com/automation-practice-form";
    public static String FIRST_NAME="Andrei";
    public static String LAST_NAME="Popov";
    public static String EMAIL="popovandrei444@gmail.com";
    public static String GENDER="Male";
    public static String DATE="13 Dec 2006";
    public static String NUMBER="062146229";
    @BeforeClass
    public void beforeTest(){
        driver= Driver.getAutoLocalDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void formTest() throws InterruptedException {
        driver.get(Url);
        FormPom form=new FormPom(driver);
        form.setFirstName(FIRST_NAME);
        form.setLastName(LAST_NAME);
        form.setEmail(EMAIL);
        form.setGender(GENDER);
        form.setUserNumber(NUMBER);
        form.setBirthDate(DATE);
        form.closeAdvert();
        Thread.sleep(3000);

        System.out.println();


    }
    @AfterClass
    public void afterTest(){
        driver.quit();
    }

}