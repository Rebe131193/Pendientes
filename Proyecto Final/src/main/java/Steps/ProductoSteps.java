package Steps;

import Pages.ProductoPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ProductoSteps extends BaseSteps {
    public ProductoSteps(WebDriver driver) {
        super(driver);
    }
    ProductoPage productoPage = PageFactory.initElements(webDriver,ProductoPage.class);

    public void ProductoCorrecto(){
        WebElement explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(
                        productoPage.getImgProduct()
                ));
        VerificarCondicion(ElementoMostrado(productoPage.getImgProduct()));
        VerificarCondicion(ElementoMostrado(productoPage.getH2ProductName()));
        VerificarCondicion(ElementoMostrado(productoPage.getH3ProductPrice()));
        VerificarCondicion(ElementoMostrado(productoPage.getDivProductDescription()));
        VerificarCondicion(ElementoMostrado(productoPage.getBtnAddToCart()));

    }

    public void imprimirDetallesProducto(){
        imprimir("------------");
        EsperarElementoMostrado(productoPage.getImgProduct());
        imprimir("Detalle del producto:");
        imprimir("Nombre: " + this.obtenerTextoElemento(productoPage.getH2ProductName()));
        imprimir("Precio: " + this.obtenerTextoElemento(productoPage.getH3ProductPrice()));
        imprimir("Descripción: " + this.obtenerTextoElemento(productoPage.getDivProductDescription()));
        imprimir("------------");
    }

    public void clickOnAddToCartBtn(){
        productoPage.getBtnAddToCart().click();
    }
    public void equivalencia(Alert alert, String txtAlert){
        try {
            Assert.assertEquals(txtAlert, "Product added");

        } catch(AssertionError e) {
            Assert.fail("Error: Elemento no encontrado.");
        }


        try{
            alert.accept();
        }catch(Exception e){
            try {
                throw new Exception(e.getMessage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public void agregarAlCarrito(){
        clickOnAddToCartBtn();
        imprimir("Agregando producto al carrito de compra...");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        String txtAlert = alert.getText();
        imprimir("Texto de alerta: " + txtAlert);
        equivalencia(alert, txtAlert);
    }
}
