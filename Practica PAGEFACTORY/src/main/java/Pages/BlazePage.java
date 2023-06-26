package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class BlazePage extends BasePage {

    public BlazePage(WebDriver webDriver) {
        super(webDriver);
    }

    private List<WebElement>setCategories() {
        return webDriver.findElements(By.xpath("//a[@id='itemc']"));

    }



    public List<WebElement> getCategories(){
        return setCategories();
    }
}
