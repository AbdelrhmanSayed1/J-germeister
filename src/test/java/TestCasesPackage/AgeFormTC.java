package TestCasesPackage;

import Pages.AgeFormPage;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class AgeFormTC extends TCBase{

    AgeFormPage ageFormObj;


    @BeforeTest
    public void beforeTest() throws InterruptedException {
        ageFormObj = new AgeFormPage(driver);

    }

    @Test(priority = 5)
    public void loginAdultAge(){
        ageFormObj.addAge(10,2,1990);
        driver.element().assertThat(ageFormObj.menuBar).exists().perform();

    }

    @Test(priority = 2)
    public void loginYoungAge() throws InterruptedException {
        ageFormObj.addAge(10,2,2023);
        driver.element().assertThat(ageFormObj.FailureForLoginMessage).text().contains("Computer says “nein”").perform();
    }

    @Test(priority = 1)
    public void enteringFutuerAge() throws InterruptedException {
        ageFormObj.addAge(1,1,2026);
        driver.element().assertThat(ageFormObj.FailureForLoginMessage).text().contains("Computer says “nein”").perform();
        driver.getDriver().findElement(By.className("verificationError_close__2oGVD-")).click();

    }
    @Test(priority = 3)
    public void negativeAge(){
        ageFormObj.scrollingInFields(0,2,0);
        driver.element().assertThat(ageFormObj.XIconInvalidMessage).exists().perform();
    }

    //A BUG IN THE AGE GATEWAY IT SHOULD DISPLAY INVALID DATE
    @Test(priority = 4)
    public void addingSpecialChars(){
        ageFormObj.invalidNumbers(0,2,0);
    }





}
