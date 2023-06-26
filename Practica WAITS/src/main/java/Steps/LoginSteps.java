package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSteps extends BaseSteps {
    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    public void abrirURLLogin() {
        webDriver.get("https://practicetestautomation.com/practice-test-login/");
    }

    public void ingresarUsuario(String usuario) {
        WebElement campoUsuario = webDriver.findElement(By.id("username"));
        campoUsuario.sendKeys(usuario);
    }
    public void ingresarPassword(String contrasena) {
        WebElement campoContrasena = webDriver.findElement(By.id("password"));
        campoContrasena.sendKeys(contrasena);
    }
    public void enviarForm() {
        WebElement botonIngresa = webDriver.findElement(By.id("submit"));
        botonIngresa.click();
    }
    public String obtenerTextoMensaje() {

        //WebElement contenidoTexto = webDriver.findElement(By.cssSelector("p.has-text-align-center"));//. por clase
        WebElement contenidoTexto = webDriver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/p[1]/strong"));
        return contenidoTexto.getText();
    }
    public boolean botonLogOutVisible() {
        WebElement elementoVista = webDriver.findElement(By.cssSelector("div.wp-block-group > div > div > a"));//Selector por hijos (children or child)
        return elementoVista.isDisplayed();
    }
}
