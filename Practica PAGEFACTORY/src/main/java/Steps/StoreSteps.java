package Steps;

import Pages.StorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StoreSteps extends BaseSteps{
    public StoreSteps (WebDriver driver){
        super(driver);
    }

    StorePage storePage = PageFactory.initElements(webDriver, StorePage.class);

    public void abrirURLStore() {
        webDriver.get("https://www.demoblaze.com/");
    }

    public boolean verificarCelularesCategoria(){
        WebElement celulares = storePage.getCelularesCategorias();
        imprimir("Categoría mostrada: " + celulares.isDisplayed());
        return visible(celulares);
    }
    public boolean verificarLaptopsCategoria(){
        WebElement laptops = storePage.getLaptopsCategorias();
        imprimir("Categoría mostrada: " + laptops.isDisplayed());
        return visible(laptops);
    }
    public boolean verificarMonitoresCategoria(){
        WebElement monitores = storePage.getMonitoresCategorias();
        imprimir("Categoría mostrada: " + monitores.isDisplayed());
        return visible(monitores);
    }
    public boolean visible(WebElement element){
        if(element.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
}
