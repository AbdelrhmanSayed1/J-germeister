package Pages;

import com.shaft.driver.SHAFT;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.lowagie.text.Annotation.URL;


public class AgeFormPage{

    private SHAFT.GUI.WebDriver driver;

    public AgeFormPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
        driver.browser().navigateToURL(URL);

    }


    By day = By.id("DD");

    By month = By.id("MM");

    By year = By.id("YYYY");


    public By menuBar =By.xpath("//*[@id=\"app\"]/div/div/div/nav/div/div[1]");
    public By FailureForLoginMessage =By.className("verificationError_headline__h-42s-");

    public By XIconInvalidMessage =By.className("input_errorIcon__24vck-");
    public void addAge(int Day, int Month, int Year){
        driver.element().type(day, String.valueOf(Day))
                .type(month, String.valueOf(Month))
                .type(year, String.valueOf(Year));
    }

    public void scrollingInFields(int Day, int Month, int Year){
        driver.element().type(day, String.valueOf(Day))
                .keyPress(day, Keys.ARROW_DOWN)
                .type(month, String.valueOf(Month))
                .keyPress(month, Keys.ARROW_DOWN)
                .type(year, String.valueOf(Year));

    }
    public void invalidNumbers(int Day, int Month, int Year){
        driver.element().type(day, String.valueOf(Day).concat("-1"))
                .type(month, String.valueOf(Month).concat(".1"))
                .type(year, String.valueOf(Year));
    }


}
