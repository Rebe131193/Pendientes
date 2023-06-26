package Steps;

import Pages.TiendaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class TiendaSteps extends BaseSteps{
    public TiendaSteps(WebDriver driver){
        super(driver);
    }

    TiendaPage tiendaPage = PageFactory.initElements(webDriver,TiendaPage.class);
    public void openProductStoreUrl(){
        openURL("https://www.demoblaze.com/index.html");
    }

    public void validateHomePageIsLoaded(){
        EsperarElementoMostrado(tiendaPage.getDivCarouselProducts());
        VerificarCondicion(ElementoMostrado(tiendaPage.getDivCarouselProducts()));
        imprimir("Cargando la web" + " ------>");
        scrollToElement(tiendaPage.getACategoryListTitle());
        VerificarCondicion(ElementoMostrado(tiendaPage.getACategoryListTitle()));
        imprimir("Todo cargado.");
    }

    public void imprimirProductos(){
        List<WebElement> productsListTitle =  tiendaPage.getH4ProductTitle();
        imprimir("Productos: ");

        for(WebElement productTitle:productsListTitle){
            imprimir(productTitle.getText());
        }

        imprimir("Número de productos: " + productsListTitle.size());
    }

    public void cargarProducto(int prodIndex){
        List<WebElement> productsListTitles =  tiendaPage.getH4ProductTitle();
        List<WebElement> productsListCards =  tiendaPage.getDivProducCard();

        WebElement productTitle = productsListTitles.get(prodIndex);
        WebElement productCard = productsListCards.get(prodIndex);
        imprimir("Detalle del producto: " + this.obtenerTextoElemento(productTitle));
        productCard.click();
        String productDetailsUrl = this.getCurrentUrl();
        imprimir("-----");
        imprimir(productDetailsUrl);
        imprimir("------");
        boolean correctUrl = productDetailsUrl.contains("prod.html?idp_=") ? true : false;
        VerificarCondicion(correctUrl);
    }

    public void irAlInicio(){
        tiendaPage.getLiMenuHome().click();
        imprimir("Regresando a la página de inicio");
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(
                        tiendaPage.getDivCarouselProducts()
                ));
    }

    public void carrito(){
        tiendaPage.getLiMenuCart().click();
        imprimir("Abriendo detalle del carrrito");
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(
                        tiendaPage.getLiMenuHome()
                ));
    }
}
