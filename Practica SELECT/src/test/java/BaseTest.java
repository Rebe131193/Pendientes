import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;

public class BaseTest {
    private WebDriver webDriver;
    private SafariDriver driver;
    private ChromeDriver driverChrome;
    private SafariOptions opciones;
    public SafariDriver getWebDriver(){
        System.setProperty("webdriver.safari.driver",  "/usr/bin/safaridriver");
        SafariOptions opciones = new SafariOptions();
        //opciones.setAutomaticInspection(true);
        opciones.setUseTechnologyPreview(true);
        driver = new SafariDriver(opciones);
        return driver;
    }
}
