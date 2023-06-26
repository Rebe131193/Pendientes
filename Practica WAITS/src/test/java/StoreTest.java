import Steps.StoreSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreTest extends BaseTest{
    private WebDriver webDriver = getWebDriver();
    private StoreSteps StoreSteps = new StoreSteps(webDriver);

    @Test
    public void Store() throws InterruptedException {
        StoreSteps.abrirURLStore();
        Assert.assertTrue(StoreSteps.verificarCelularesCategoria());
        Assert.assertTrue(StoreSteps.verificarLaptopsCategoria());
        Assert.assertTrue(StoreSteps.verificarMonitoresCategoria());
        StoreSteps.finalizarWebDriver();
    }
}
