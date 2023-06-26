
package Steps;

import Pages.DemoQASelectMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DemoQASteps extends BaseSteps{

    public DemoQASteps(WebDriver driver) {
        super(driver);
    }

    DemoQASelectMenuPage demoQASelectMenuPage = new DemoQASelectMenuPage(webDriver);//added

    public void abrirPaginaDemoQA(){
        webDriver.get("https://demoqa.com/text-box/");

        imprimir("Navegando en DemoQA");
    }

    public void enviarFullName(String nombreCompleto){
        webDriver.findElement(By.id("userName")).sendKeys(nombreCompleto);
    }

    public void enviarEmail(String correoElectronico){
        webDriver.findElement(By.id("userEmail")).sendKeys(correoElectronico);
    }

    public void enviarCurrentAddress(String direccionActual){
        webDriver.findElement(By.id("currentAddress")).sendKeys(direccionActual);

    }

    public void enviarPermanentAddress(String direccionPermanente){
        webDriver.findElement(By.id("permanentAddress")).sendKeys(direccionPermanente);
    }

    public void clickSubmit(){
        WebElement botonSubmit = webDriver.findElement(By.id("submit"));
        botonSubmit.click();
    }

    public void navegarSelectMenu(){
        webDriver.navigate().to("https://demoqa.com/select-menu");
    }

    public void selecccionarColorTexto(String color){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        listaColores.selectByVisibleText(color);
    }

    public String getColorSeleccionado(){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        return listaColores.getFirstSelectedOption().getText();
    }

    public void seleccionarColorValue(String value){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        listaColores.selectByValue(value);
    }

    public void seleccionarColorIndex(int index){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        listaColores.selectByIndex(index);
    }

    public List<WebElement> getOpcionesColores(){
        Select listaColores = new Select(demoQASelectMenuPage.getListaColores());
        return listaColores.getOptions();
    }

    public void imprimirColoresDisponibles(){
        for (WebElement o: getOpcionesColores()){
            imprimir(o.getText());
        }
    }

    public void imprimirColoresOpciones(){
        for (WebElement o: getOpcionesColores()) {
            imprimir(o.getAttribute("value"));
        }
    }

    public void scrollHaciaCarros(){
        new Actions(webDriver)
                .scrollToElement(demoQASelectMenuPage.getListaCarros())
                .perform();

    }

    public List<WebElement> getOpcionesCarros(){
        Select listaCarros = new Select(demoQASelectMenuPage.getListaCarros());
        return listaCarros.getOptions();
    }

    public void imprimirOpcionesCarrosDisponibles(){
        for (WebElement o: getOpcionesCarros()){
            imprimir(o.getText());
        }
    }
    public void fillForm(){
        WebElement sendFullName = webDriver.findElement(By.id("userName"));
        sendFullName.sendKeys("Yuri Ordaz");
        WebElement email = webDriver.findElement(By.id("userEmail"));
        email.sendKeys("yuri@gmail.com");
        WebElement currentAddress = webDriver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Av.Saturno #555");
        WebElement permanentAddress = webDriver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Calle Marte #888");
    }

}

