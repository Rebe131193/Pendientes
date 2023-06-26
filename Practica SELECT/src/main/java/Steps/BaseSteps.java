package Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BaseSteps {
    public WebDriver webDriver;
    public BaseSteps(WebDriver driver) {
        this.webDriver = driver;
    }

    public String getURLActual() {
        return webDriver.getCurrentUrl();
    }

    public String getTituloActual() {
        return webDriver.getTitle();
    }

    public void cerrarVentana() {
        webDriver.close();
    }

    public String getCodigoFuente() {
        return webDriver.getPageSource();
    }

    public String getTituloPagina(){ return webDriver.getTitle();}
    public void scrollToElementJS(WebElement element){
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void maximizarVentana(){ webDriver.manage().window().maximize();}

    public void imprimir(String cadena){ System.out.println(cadena);}
    public void finalizarWebDriver(){ webDriver.quit();}

    public void scrollToElement(WebElement element){
        new Actions(webDriver)
                .scrollToElement(element)
                .perform();
    }

}
