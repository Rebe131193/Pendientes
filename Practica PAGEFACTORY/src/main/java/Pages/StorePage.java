package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePage extends BasePage{

    public StorePage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement setcelularesCategorias(){
        return webDriver.findElement(By.xpath("//div[@class='list-group']/child::a[2]"));
    }
    private WebElement setlaptopsCategorias(){
        return webDriver.findElement(By.xpath("//div[@class='list-group']/child::a[3]"));
    }
    private WebElement setmonitoresCategorias() {
        return webDriver.findElement(By.xpath("//div[@class='list-group']/child::a[4]"));
    }


    public WebElement getCelularesCategorias(){
        return setcelularesCategorias();
    }
    public WebElement getLaptopsCategorias(){
        return setlaptopsCategorias();
    }
    public WebElement getMonitoresCategorias() {
        return setmonitoresCategorias();
    }


}
