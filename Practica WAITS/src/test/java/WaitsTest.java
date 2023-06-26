import Pages.WaitsPage;
import Steps.WaitsSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WaitsTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();

    WaitsSteps waitsSteps = new WaitsSteps(webDriver);

    @Test(description = "Prueba de Fluent Wait en Calendario para la fecha de hoy Mayo 22")
    public void WaitTest(){
        waitsSteps.abrirPaginaCalendario();
        waitsSteps.clickMay22();
        waitsSteps.waitFechaSeleccionada();
        waitsSteps.finalizarWebDriver();
    }

    @Test(description = "Prueba de Explicit Wait en Calendario para la fecha de hoy Mayo 22")
    public void ExplicitWaitTest(){
        waitsSteps.abrirPaginaCalendario();
        waitsSteps.clickMay22();
        waitsSteps.waitFechaSeleccionadaExplicit();
        waitsSteps.finalizarWebDriver();
    }

}
