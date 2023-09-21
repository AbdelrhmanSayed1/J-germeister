package TestCasesPackage;

import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeSuite;

public class TCBase {


    public String URL = "https://www.jagermeister.com/en-GB/home";
    public static SHAFT.GUI.WebDriver driver;

    @BeforeSuite
    public void SetupDriver() throws InterruptedException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(URL);
    }
}
