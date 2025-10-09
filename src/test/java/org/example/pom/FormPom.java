package org.example.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPom {

    public WebDriver driver;
    public JavascriptExecutor js;

    @FindBy(xpath="//*[@id='firstName']")
    WebElement firstName;
    @FindBy(xpath="//*[@id='lastName']")
    WebElement lastName;
    @FindBy(xpath="//*[@id='userEmail']")
    WebElement userEmail;
    @FindBy(xpath="//*[@id='userNumber']")
    WebElement userNumber;
    @FindBy(xpath="//*[@id='dateOfBirthInput']")
    WebElement dateOfBirthInput;

    public FormPom(WebDriver driver){
        this.driver=driver;
        js=(JavascriptExecutor) driver;
        PageFactory.initElements(driver,this);
    }
    public void setFirstName(String firstNameParam){
        firstName.clear();
        firstName.sendKeys(firstNameParam);

    }
    public void setLastName(String lastNameParam){
        lastName.clear();
        lastName.sendKeys(lastNameParam);

    }
    public void setEmail(String userEmailParam){
        userEmail.clear();
        userEmail.sendKeys(userEmailParam);

    }
    public void setGender(String genderParam)
    {WebElement gender= driver.findElement(By.xpath("//*[@id='genterWrapper']//label[text()='"+genderParam+"']"));
        gender.click();

    }
    public void setBirthDate(String birthDateParam){
        dateOfBirthInput.sendKeys(Keys.CONTROL,"a");
        dateOfBirthInput.sendKeys(birthDateParam);
        dateOfBirthInput.sendKeys(Keys.ENTER);
    }



    public void setUserNumber(String userNumberParam){
        userNumber.clear();
        userNumber.sendKeys(userNumberParam);

    }

    public void closeAdvert() {
        try {
            js.executeScript("var elem = document.evaluate(\"//*[@id='adplus-anchor']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {}
        try {
            js.executeScript("var elem = document.evaluate(\"//footer\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {}
    }
}