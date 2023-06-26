import Steps.CarritoSteps;
import Steps.ProductoSteps;
import Steps.TiendaSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TiendaTest extends BaseTest{

    private WebDriver webDriver = getWebDriver();
    private TiendaSteps tiendaSteps = new TiendaSteps(webDriver);
    private ProductoSteps productoSteps = new ProductoSteps(webDriver);
    private CarritoSteps carritoSteps = new CarritoSteps(webDriver);

    @BeforeTest(description = "Configuracion para todos los test", alwaysRun = true)
    public void Configuraciones(){
        //Iniciamos la web
        tiendaSteps.openProductStoreUrl();
        //Maximizamos la ventana
        tiendaSteps.maximizarVentana();
        //Esperamos
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Validar que todo este cargado
        tiendaSteps.validateHomePageIsLoaded();
        //Imprimimos los productos mostrados
        tiendaSteps.imprimirProductos();
    }

    @Test(description = "PRUEBA_1: Entranos al detalle del producto de la pagina inicial",
            priority = 1)
    public void Prueba___1(){
        //Da click en un producto de la lista desplegada en el home
        tiendaSteps.cargarProducto(3);

        productoSteps.ProductoCorrecto();
        //Verifica que todos los elementos del producto esten visibles
        productoSteps.agregarAlCarrito();
        //Imprime a consola los detalles del producto seleccionado
        productoSteps.imprimirDetallesProducto();
        //Regresa al home del sitio
        tiendaSteps.irAlInicio();
    }

    @Test(description = "PRUEBA_2: Agregamos al carrito y verificamos que este cargado en el carrito",
            priority = 2)
    public void Prueba___2(){
        //Producto seleccionado
        tiendaSteps.cargarProducto(3);
        //Verifica que el producto este visible
        productoSteps.ProductoCorrecto();
        //Agrega el producto al carrito
        productoSteps.agregarAlCarrito();
        //Entramos a la seccion de carrrito
        tiendaSteps.carrito();
        //Elimina el producto que fue agregado previamente
        carritoSteps.borrarProducto();
        //Regresa al home del sitio
        tiendaSteps.irAlInicio();
    }

    @Test(description = "PRUEBA_3: Agregamos al carrito un numero X de productos", priority = 3)
    public void Prueba___3() {
        //Agregamos varios productos
        carritoSteps.agregarVariosProductos(2);
        //Verificamos los productos esten en el carrito
        carritoSteps.verificarProductosCarrito();
    }

    @AfterTest(description = "Terminamos la prueba cerrando el navegador", alwaysRun = true)
    public void afterScenario(){
        //Termina la prueba
        tiendaSteps.finalizarWebDriver();
    }
}
