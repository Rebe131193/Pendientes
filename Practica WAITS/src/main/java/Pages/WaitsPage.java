package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WaitsPage{

    @FindBy(xpath = "//td[@title='Monday, June 19, 2023']")
    private WebElement tdMay22;

    @FindBy(xpath = "//span[text()='Monday, June 19, 2023']")
    private WebElement spanMay22;

    public WebElement getTdMay22(){
        return tdMay22;
    }

    public WebElement getSpanMay22(){
        return spanMay22;
    }

}
