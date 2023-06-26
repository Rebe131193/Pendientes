import Steps.DemoQASteps;
import Steps.GoogleSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class  DemoQATest extends BaseTest{
    private WebDriver webDriver = getWebDriver();
    private DemoQASteps demoQASteps = new DemoQASteps(webDriver);

    @Test
    public void practica4(){
        demoQASteps.abrirPaginaDemoQA();
        demoQASteps.navegarSelectMenu();
        demoQASteps.imprimir("Colores disponibles:");
        demoQASteps.imprimirColoresDisponibles();
        demoQASteps.imprimir("Atributo Valor:");
        demoQASteps.imprimirColoresOpciones();
        demoQASteps.selecccionarColorTexto("Blue");
        demoQASteps.imprimir(demoQASteps.getColorSeleccionado());
        demoQASteps.seleccionarColorValue("3");
        demoQASteps.imprimir(demoQASteps.getColorSeleccionado());
        demoQASteps.seleccionarColorIndex(2);
        demoQASteps.imprimir(demoQASteps.getColorSeleccionado());
        demoQASteps.finalizarWebDriver();
    }

    @Test
    public void practica4_2() throws InterruptedException {
        demoQASteps.abrirPaginaDemoQA();
        demoQASteps.navegarSelectMenu();
        Thread.sleep(2000);
        demoQASteps.maximizarVentana();
        Thread.sleep(2000);
        demoQASteps.scrollHaciaCarros();
        demoQASteps.imprimirOpcionesCarrosDisponibles();
        demoQASteps.finalizarWebDriver();
    }

}
