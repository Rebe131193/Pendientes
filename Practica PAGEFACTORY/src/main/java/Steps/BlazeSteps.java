package Steps;

import Pages.BlazePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BlazeSteps extends BaseSteps{
    public BlazeSteps(WebDriver driver) {
        super(driver);
    }

    BlazePage BlazePage = new BlazePage(webDriver);

    public void abrirPaginaBlaze(){
        webDriver.get("https://www.demoblaze.com/");
    }

    private List<WebElement> getMenuElementsList(){
        return BlazePage.getCategories();
    }
    public int  contarCategorias(){
        return getMenuElementsList().size();
    }
    public List<WebElement> imprimirCategorias(){
        List<WebElement> listMenu =  getMenuElementsList();
        for(WebElement menuOption:listMenu){
            imprimir(menuOption.getText());
        }
        return null;
    }
}
