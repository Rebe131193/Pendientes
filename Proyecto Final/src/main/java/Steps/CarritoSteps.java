package Steps;

import Pages.CarritoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class CarritoSteps extends BaseSteps{
    public CarritoSteps(WebDriver driver) {
        super(driver);
    }
    CarritoPage carritoPage = PageFactory.initElements(webDriver,CarritoPage.class);
    TiendaSteps tiendaSteps = new TiendaSteps(webDriver);
    ProductoSteps productoSteps = new ProductoSteps(webDriver);

    public void borrarProducto(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(
                        carritoPage.getElementoCarrito()
                ));
        List<WebElement> btnDeleteList =  carritoPage.getTdProductBtnDelete();
        for(WebElement item:btnDeleteList){
            item.click();
            EsperarElementoMostrado(carritoPage.getLiMenuCartFromCart());
        }
    }
    public void agregarVariosProductos(int numProducts){
        for(int x=0; x<numProducts; x++){
            tiendaSteps.cargarProducto(x);
            productoSteps.ProductoCorrecto();
            productoSteps.agregarAlCarrito();
            tiendaSteps.irAlInicio();
        }
        tiendaSteps.carrito();
    }
    public void verificarProductosCarrito(){
        List<WebElement> productList =  carritoPage.getTrProductAdded();
        List<WebElement> imgList =  carritoPage.getTdProductImage();
        List<WebElement> titleList =  carritoPage.getTdProductTitle();
        List<WebElement> priceList =  carritoPage.getTdProductPrice();
        List<WebElement> btnDeleteList =  carritoPage.getTdProductBtnDelete();

        imprimir(" ");
        imprimir(" ");
        imprimir(" ");
        imprimir(" ");
        imprimir(" ");
        imprimir("Productos agregados: " + productList.size());
        imprimir("Detalle: ");
        int x=0;
        for(WebElement item:productList){
            VerificarCondicion(ElementoMostrado(imgList.get(x)));
            VerificarCondicion(ElementoMostrado(titleList.get(x)));
            VerificarCondicion(ElementoMostrado(priceList.get(x)));
            VerificarCondicion(ElementoMostrado(btnDeleteList.get(x)));

            imprimir("Imagen: " + obtenerAtributoElemento(imgList.get(x),"src"));
            imprimir("Titulo: " + obtenerTextoElemento(titleList.get(x)));
            imprimir("Precio: " + obtenerTextoElemento(priceList.get(x)));
            imprimir("Link: " + obtenerTextoElemento(btnDeleteList.get(x)));
            x++;
            imprimir(" ");
            imprimir(" ");
        }

        VerificarCondicion(ElementoMostrado(carritoPage.getH3TotalCart()));
        VerificarCondicion(ElementoMostrado(carritoPage.getBtnPlaceOrder()));
        imprimir("Total: " + obtenerTextoElemento(carritoPage.getH3TotalCart()));
        imprimir("Activación de botón 'place order': " + ComprobarExiste(carritoPage.getBtnPlaceOrder()));
    }

}