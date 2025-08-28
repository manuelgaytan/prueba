package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.ProcesoPagoComisionUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

@Task
public class ProcesoPagoComisionTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private ProcesoPagoComisionUI procesoPagoComisionUI;

    @ShotAfter(evidenceName = "Completar formulario de Atributos")
    public void completarFormulario(String fechaproinicial,String fechaprofinal,String detalleresumido,String codagente) {
        Util.pageStatus(manager.getDriver());
        Date current = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        String message = formatter.format(current);
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatterYearBefore = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate yearPlus = currentDate.plusYears(1);
        String yearPlus1 = yearPlus.format(formatterYearBefore);
        Util.explicitWait(manager.getDriver(),this.procesoPagoComisionUI.dateFechaIni);
        this.procesoPagoComisionUI.dateFechaIni.sendKeys(message);
        Util.explicitWait(1);
        this.procesoPagoComisionUI.dateFechaFin.sendKeys(yearPlus1);
        Util.explicitWait(1);
        this.procesoPagoComisionUI.txtDetalleResumido.sendKeys(detalleresumido);
        Util.explicitWait(1);
        this.procesoPagoComisionUI.txtCodAgente.sendKeys(codagente);
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Aceptar formulario de Atributos")
    public void aceptarFormuraio() {
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
        this.procesoPagoComisionUI.btnAceptarFormulario.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

        Util.scrollToEnd(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Descargar Archivo de Salida")
    public void descargarArchivoDeSalida(String comienzacon) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(10));
        Util.pageStatus(manager.getDriver());

        this.procesoPagoComisionUI.btnSpollInformes.click();
        Util.explicitWait(3);
        //manager.getDriver().switchTo().frame(manager.getDriver().findElement(By.xpath("//iframe[@frameborder=\"0\"]")));
        WebElement iframe = manager.getDriver().findElement(By.tagName("iframe"));
        manager.getDriver().switchTo().frame(iframe);
        boolean isVisible=false;
        try {
            // XPath del elemento a verificar
            String xpath1 = "(//td[starts-with(text(), '"+comienzacon+"')])[1]";
            String xpath2 = "(//td[starts-with(text(), '"+comienzacon+"')])[2]";

            // Esperar a que el elemento sea visible
            WebElement archivoAdescargar1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));
            WebElement archivoAdescargar2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath2)));

            // Verificar si el elemento está visible usando JavaScript (en caso de que haya problemas con la visibilidad en capas superpuestas)
            JavascriptExecutor js = (JavascriptExecutor) manager.getDriver();
            isVisible = (Boolean) js.executeScript(
                    "return (arguments[0].offsetWidth > 0 && arguments[0].offsetHeight > 0) && arguments[0].getClientRects().length > 0;",
                    archivoAdescargar1
            );
            System.out.println(isVisible);
            if (isVisible) {
                System.out.println("Se los archivos a descargar");
               // archivoAdescargar1.click();
                JavascriptExecutor executor = (JavascriptExecutor) manager.getDriver();
                executor.executeScript("arguments[0].click();", archivoAdescargar1);
                Util.explicitWait(1);
                this.procesoPagoComisionUI.btnDescargarInforme.click();
               // archivoAdescargar2.click();
                executor.executeScript("arguments[0].click();", archivoAdescargar2);
                Util.explicitWait(1);
                this.procesoPagoComisionUI.btnDescargarInforme.click();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertNotEquals("\n\n" +
                "*********************************************" + "\n" +
                "*** No se encontro el archivo a descargar ***" + "\n" +
                "*********************************************", false, isVisible);
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Validar que se muestre el archivo no LOG")
    public void validarQueSeMuestreArchivoNoLog(String comienzacon,String nocontenga) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(10));
        Util.pageStatus(manager.getDriver());

        boolean isVisible=false;
        try {
            // XPath del elemento a verificar
            String xpath = "(//td[starts-with(text(), '"+comienzacon+"')and not(contains(text(), '"+nocontenga+"'))])[1]";

            // Esperar a que el elemento sea visible
            WebElement archivoAdescargar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            // Verificar si el elemento está visible usando JavaScript (en caso de que haya problemas con la visibilidad en capas superpuestas)
            JavascriptExecutor js = (JavascriptExecutor) manager.getDriver();
            isVisible = (Boolean) js.executeScript(
                    "return (arguments[0].offsetWidth > 0 && arguments[0].offsetHeight > 0) && arguments[0].getClientRects().length > 0;",
                    archivoAdescargar
            );

            if (isVisible) {
                System.out.println("Se a encontrado el archivo a descargar");
                archivoAdescargar.click();
                Util.explicitWait(1);
                this.procesoPagoComisionUI.btnDescargarInforme.click();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        assertNotEquals("\n\n" +
                "*********************************************" + "\n" +
                "*** No se encontro el archivo a descargar ***" + "\n" +
                "*********************************************", false, isVisible);

        Util.explicitWait(3);

    }





}
