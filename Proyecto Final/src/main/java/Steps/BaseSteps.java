package Steps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;

public class BaseSteps {
    public WebDriver webDriver;
    public BaseSteps(WebDriver driver) {
        this.webDriver = driver;
    }

    public void openURL(String url){
        webDriver.get(url);
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

    public void imprimir(String cadena){
        Reporter.log(cadena);
        System.out.println(cadena);}
    public void finalizarWebDriver(){ webDriver.quit();}

    public void scrollToElement(WebElement element){
        new Actions(webDriver)
                .scrollToElement(element)
                .perform();
    }


    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void VerificarCondicion(boolean condicion){
        if(condicion != true){
            Assert.fail("Error: Elemento no mostrado o no existe.");
        }
    }

    public String obtenerAtributoElemento(WebElement elemento, String atributo){
        return elemento.getAttribute(atributo);
    }

    public String obtenerTextoElemento(WebElement elemento){
        return elemento.getText();
    }

    public boolean ComprobarExiste(WebElement elemento) {
        try {
            Assert.assertTrue(this.ElementoExiste(elemento));
            Assert.assertTrue(this.ElementoMostrado(elemento));
            return true;
        }catch(AssertionError e) {
            Assert.fail("Error: Elemento no encontrado.");
            return false;
        }
    }

    public void EsperarElementoMostrado(WebElement ele){
        Wait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(webDriver1 -> {
            return ele.isDisplayed();
        });
    }

    public boolean ElementoExiste(WebElement elemento){
        if(elemento.isEnabled()){
            return true;
        } else {
            return false;
        }
    }

    public boolean ElementoMostrado(WebElement elemento){
        if(elemento.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }

}
