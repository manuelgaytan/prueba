package com.nttdata.ct.web.task;
import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.GestorCobroUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.fail;

@Task
public class GestorCobroTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private GestorCobroUI gestorCobroUI;

    @ShotAfter(evidenceName = "Completar formulario de Atributos")
    public void completarFormulario(String npoliza,String secuenciamediopago,String codgerente,String fechaefecto,String diapago) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
        Util.pageStatus(manager.getDriver());

        this.gestorCobroUI.txtNumPoliza.sendKeys(npoliza);
        Util.explicitWait(1);
        this.gestorCobroUI.liSecuenciaMedio.click();
        this.gestorCobroUI.liSecuenciaMedio.click();
        Util.explicitWait(1);
        WebElement opcSecuenciaMedio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+secuenciamediopago+"']")));
        opcSecuenciaMedio.click();Util.explicitWait(1);
        this.gestorCobroUI.btnAceptarLista.click();
        this.gestorCobroUI.liTipoGestor.click();
        Util.explicitWait(1);
        WebElement opcTipoGestor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='TA']")));
        opcTipoGestor.click();Util.explicitWait(1);
        this.gestorCobroUI.btnAceptarLista.click();
        Util.explicitWait(1);
        this.gestorCobroUI.liCodGerente.click();
        Util.explicitWait(1);
        WebElement opcCodGerente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+codgerente+"']")));
        opcCodGerente.click();Util.explicitWait(1);
        this.gestorCobroUI.btnAceptarLista.click();
        Util.explicitWait(1);
        this.gestorCobroUI.txtFechaEfecto.sendKeys(fechaefecto);
        Util.explicitWait(1);
        this.gestorCobroUI.txtDiaPago.sendKeys(diapago);
        Util.explicitWait(1);
        Util.scrollToEnd(manager.getDriver());
        this.gestorCobroUI.btnAceptarFormulario.click();

        // Neto
        if(Util.webElementIsEnabled(10,manager.getDriver(),this.gestorCobroUI.ventanaError)) {
            // Obtener los textos de los elementos de error
            String ventanaErrorTexto = this.gestorCobroUI.ventanaError.getText();
            String detalleErrorTexto = this.gestorCobroUI.detalleError.getText();

            // Crear el mensaje de error
            String mensajeError = String.format(
                    "Se muestra una ventana de Error:\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                    "********************************************************************",
                    "********************************************************************",
                    "********************************************************************",
                    ventanaErrorTexto,
                    detalleErrorTexto,
                    "********************************************************************",
                    "********************************************************************",
                    "********************************************************************"
            );
            // Lanzar el fallo con el mensaje de error
            throw new AssertionError(mensajeError);
        }

//        Util.explicitWait(1);
//        if(Util.webElementIsEnabled(10,manager.getDriver(),this.gestorCobroUI.ventanaError)) {
//            fail("Se muestra una ventana de Error"+this.gestorCobroUI.ventanaError.getText()+" \n\n Favor de validar el mensaje de Error\n\n\n\n");
//        }
        // Neto

        Util.explicitWait(3);
    }

    public void salirFormuraio() {
        Util.pageStatus(manager.getDriver());
        this.gestorCobroUI.btnSalir.click();
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Consultar Póliza")
    public void consultarPoliza(String npoliza) {
        Util.pageStatus(manager.getDriver());
        this.gestorCobroUI.txtPoliza.sendKeys(npoliza);
        Util.explicitWait(1);
        this.gestorCobroUI.btnBuscar.click();
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Consultar Historico")
    public void consultarHistorico() {
        Util.pageStatus(manager.getDriver());
        this.gestorCobroUI.btnHistorico.click();
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Consultar Por Suplemento")
    public void consultarSuplemento() {
        WebElement iframe = manager.getDriver().findElement(By.tagName("iframe"));
        manager.getDriver().switchTo().frame(iframe);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(),"//div[@class='ng-binding'][normalize-space()='Suplemento']");

        this.gestorCobroUI.btnSuplemento.click();
        Util.explicitWait(2);
        manager.getDriver().switchTo().parentFrame();
        manager.getDriver().switchTo().frame(1);
        this.gestorCobroUI.btnInformacionGeneral.click();
        Util.explicitWait(1);
    }



}
