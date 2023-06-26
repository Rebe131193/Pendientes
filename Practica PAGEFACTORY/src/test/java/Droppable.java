import Steps.DemoQASteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Droppable extends BaseTest{
    private WebDriver webDriver = getWebDriver();
    private DemoQASteps demoQASteps = new DemoQASteps(webDriver);

    @Test
    public void Practica6() {
        demoQASteps.abrirPaginaDemoQA();
        demoQASteps.abrirDroppablePage();
        demoQASteps.dragAndDrop();
        String textoActual =  demoQASteps.obtenerTexto();
        Assert.assertEquals(textoActual, "Dropped!");
        demoQASteps.finalizarWebDriver();
    }

}
