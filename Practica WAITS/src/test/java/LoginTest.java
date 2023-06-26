import Steps.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private WebDriver webDriver = getWebDriver();
    private LoginSteps loginSteps = new LoginSteps(webDriver);

    @Test
    public void loginTest() throws InterruptedException {
        loginSteps.abrirURLLogin();
        loginSteps.ingresarUsuario("student");
        loginSteps.ingresarPassword("Password123");
        loginSteps.enviarForm();
        Thread.sleep(1000);
        String correctaURL = "https://practicetestautomation.com/logged-in-successfully/";
        String urlActual = loginSteps.getURLActual();
        loginSteps.imprimir(urlActual);
        Assert.assertEquals(urlActual, correctaURL);
        Thread.sleep(1000);
        String correctoText = "Congratulations student. You successfully logged in!";
        String textActual = loginSteps.obtenerTextoMensaje();
        loginSteps.imprimir(textActual);
        Assert.assertEquals(textActual, correctoText);
        boolean botonVisible = loginSteps.botonLogOutVisible();
        Assert.assertTrue(botonVisible);
        loginSteps.finalizarWebDriver();
    }
}

