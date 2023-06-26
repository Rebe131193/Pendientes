package Steps;

import Pages.WaitsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitsSteps extends BaseSteps{
    public WaitsSteps(WebDriver webDriver){
        super(webDriver);
    }

    WaitsPage waitsPage = PageFactory.initElements(webDriver, WaitsPage.class);

    public void abrirPaginaCalendario(){
        webDriver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
    }

    public void clickMay22(){
        waitsPage.getTdMay22().click();
    }

    public void waitFechaSeleccionada(){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))//Va a checar 15 veces, en 30 segundos va a checar cada 2 segundos, 30/2=15
                .ignoring(NoSuchElementException.class);

        fluentWait.until(webDriver -> {
            return waitsPage.getSpanMay22().isDisplayed();
        });
    }

    public void waitFechaSeleccionadaExplicit(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(
                        waitsPage.getSpanMay22()
                ));
    }
}
