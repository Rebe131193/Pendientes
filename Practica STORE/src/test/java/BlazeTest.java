import Steps.BaseSteps;
import Steps.BlazeSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BlazeTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();

    private BlazeSteps BlazeSteps = new BlazeSteps(webDriver);

    @Test
    public void Practica5(){
        BlazeSteps.abrirPaginaBlaze();
        BlazeSteps.imprimirCategorias();
        Assert.assertEquals(BlazeSteps.contarCategorias(), 3);
        BlazeSteps.finalizarWebDriver();
    }
}