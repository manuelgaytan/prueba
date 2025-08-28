package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.LanzadorTareasUI;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.fail;

@Task
public class LanzadorTareasTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private LanzadorTareasUI lanzadorTareasUI;


    @ShotAfter(evidenceName = "Ir a Facturación")
    public void irFacturacion() {
        Util.pageStatus(manager.getDriver());
        this.lanzadorTareasUI.selectFacturacion.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.lanzadorTareasUI.optionEnvioArchivo.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Ir a Tareas")
    public void irTareas() {
        Util.pageStatus(manager.getDriver());
        this.lanzadorTareasUI.selectTareas.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.lanzadorTareasUI.optionLanzadorTareas.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Busqueda de tarea")
    public void busquedaTarea(String Tarea) {
        this.lanzadorTareasUI.inputTarea.sendKeys(Tarea);
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.lanzadorTareasUI.btnAceptar.click();
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Cargar archivo")
    public void validarArchivo(String archivo, String nombreTarea) {
        if (nombreTarea.equals("MMXGCL0002")) {
            LocalDate currentDate = LocalDate.now();
            LocalDate previousMonth = currentDate.minusMonths(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String monthCurrent = currentDate.format(formatter);
            String monthBefore = previousMonth.format(formatter);
            this.lanzadorTareasUI.fechaInicio.sendKeys(monthBefore);
            this.lanzadorTareasUI.FechaFin.sendKeys(monthCurrent);
            Util.explicitWait(1);
            this.lanzadorTareasUI.fechaInicio.click();
            Util.explicitWait(1);
            this.lanzadorTareasUI.tipoAnticipo.sendKeys("T");
            Util.explicitWait(1);
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
            Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
            this.lanzadorTareasUI.BtnAceptarAtributos.click();
            Util.explicitWait(1);
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
//            Util.scrollDown(manager.getDriver(), "1500");
        } else {
            this.lanzadorTareasUI.txtNombreArchivo.sendKeys(archivo);
            Util.explicitWait(1);
            this.lanzadorTareasUI.btnAcept.click();
            Util.explicitWait(1);
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
//            Util.scrollDown(manager.getDriver(), "1500");
        }
    }

    @ShotAfter(evidenceName = "Cargar archivo")
    public void cargarArchivo() {
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/resources/test.txt");
        String file1 = file.getAbsolutePath();
        this.lanzadorTareasUI.inputArchivo.sendKeys(file1);
        Util.explicitWait(1);
        this.lanzadorTareasUI.btnAceptarCarga.click();
        Util.waitAlert(manager.getDriver());
        Util.isVisibleAlertTemporal(manager.getDriver(), "Archivo cargado");
        this.lanzadorTareasUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }


    @ShotAfter(evidenceName = "Validar situación del archivo")
    public void validarSituacion() {

        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        //Util.waitSpinner(manager.getDriver(), 30);
        Util.waitWebElementIsEnabled(120, manager.getDriver(), this.lanzadorTareasUI.txtSituacion);
        Util.explicitWait(2);
        String EstatusActual = this.lanzadorTareasUI.txtSituacion.getText();
        assert EstatusActual.equals("TERMINACION NORMAL") : "No se cargo correctamente el archivo";
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }

    public void salirlanzadortarea() {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(7));

//        WebElement iframe = manager.getDriver().findElement(By.tagName("iframe"));
//        manager.getDriver().switchTo().frame(iframe);
//        WebElement salir = manager.getDriver().findElement(By.xpath("//button[@class='btn btn-navigation pull-left btn-icon-before-cancel ng-binding']"));
//        JavascriptExecutor executor = (JavascriptExecutor) manager.getDriver();
//        executor.executeScript("arguments[0].click();", salir);
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.lanzadorTareasUI.BtnSalir);
        this.lanzadorTareasUI.BtnSalir.click();
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.lanzadorTareasUI.btnmenu);
        Util.explicitWait(1);
        WebElement opcmenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/descendant::*[text()='Tareas'][1]")));
        opcmenu.click();
        Util.explicitWait(2);
        WebElement opcsubmenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-content-container\"]/div[1]/div[2]/div[1]/div/div[2]/div/div/div/a/span")));
        opcsubmenu.click();
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Descargar reporte")
    public void descargar() {
        this.lanzadorTareasUI.btnDescargar.click();
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        WebElement iframe = manager.getDriver().findElement(By.tagName("iframe"));
        manager.getDriver().switchTo().frame(iframe);
        WebElement selectEndodoso = manager.getDriver().findElement(By.xpath("//table[@id='cmnRerSetW']/descendant::tr[2]/td[2]"));
        JavascriptExecutor executor = (JavascriptExecutor) manager.getDriver();
        executor.executeScript("arguments[0].click();", selectEndodoso);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.lanzadorTareasUI.verTxt.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Descargar reporte")
    public void descargar2(String primaCobrada) {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");
        // Formatear la fecha actual
        String fechaFormateada = fechaActual.format(formato);
        this.lanzadorTareasUI.btnDescargar.click();
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        WebElement iframe = manager.getDriver().findElement(By.tagName("iframe"));
        manager.getDriver().switchTo().frame(iframe);
        WebElement selectEndodoso = manager.getDriver().findElement(By.xpath("//td[starts-with(text(), '" + primaCobrada + "')]"));
        JavascriptExecutor executor = (JavascriptExecutor) manager.getDriver();
        executor.executeScript("arguments[0].click();", selectEndodoso);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.lanzadorTareasUI.verTxt.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }


    @ShotAfter(evidenceName = "Completar formulario")
    public void completarFormulario(String bloquetesoreria) {
        this.lanzadorTareasUI.bloqueoTesoreria.sendKeys(bloquetesoreria);
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String str = ft.format(new Date());
        this.lanzadorTareasUI.fechaInicio.sendKeys(str);
        this.lanzadorTareasUI.FechaFin.sendKeys(str);
        Util.explicitWait(1);
        this.lanzadorTareasUI.BtnAceptarAtributos.click();
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Cargar archivo")
    public void buscarTarea(String archivo, String nombreTarea, String codArchivo) {
        LocalDate currentDate = LocalDate.now();
        LocalDate previousMonth = currentDate.minusMonths(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String monthCurrent = currentDate.format(formatter);
        String monthBefore = previousMonth.format(formatter);
        switch (nombreTarea) {
            case "MMXGCL0045":
                this.lanzadorTareasUI.fechaInicio.sendKeys(monthBefore);
                this.lanzadorTareasUI.FechaFin.sendKeys(monthCurrent);
                Util.explicitWait(2);
                Util.pageStatus(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                break;
            case "MMXGCL0047":
                LocalDate sumMes = currentDate.plusMonths(1);
                String sumMesFormat = sumMes.format(formatter);
                this.lanzadorTareasUI.FechaFin.sendKeys(sumMesFormat);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.inputTipoExpediente.sendKeys("R");
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                break;
            case "MMXGCL0051":
                this.lanzadorTareasUI.fechaInicio.sendKeys(monthCurrent);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.FechaFin.sendKeys(monthCurrent);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                break;
            case "MMXGCL0103":
                this.lanzadorTareasUI.fechaInicio.sendKeys(monthCurrent);
                this.lanzadorTareasUI.FechaFin.sendKeys(monthCurrent);
                Util.explicitWait(1);
                this.lanzadorTareasUI.inputTipoGestor.sendKeys("IM");
                Util.explicitWait(1);
                this.lanzadorTareasUI.inputCodEntidad.sendKeys("0001");
                Util.explicitWait(1);
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.btnAcept.click();
                Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
//            Util.scrollDown(manager.getDriver(), "1500");
                break;
            case "MMXGCL0113":
                Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
                this.lanzadorTareasUI.FechaProceIni.sendKeys(monthCurrent);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.FechaProceFin.sendKeys(monthCurrent);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                this.lanzadorTareasUI.inputDetalle.sendKeys("D");
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.inputCodAgente.sendKeys("59510");
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.inputAfiliacion.sendKeys("0");
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
                Util.explicitWait(3);
                break;
            case "MMXGCL0118":
                LocalDate fechaModificada = currentDate.minusMonths(2);
                String fechaFormateada2 = fechaModificada.format(formatter);
                this.lanzadorTareasUI.fechaInicio.sendKeys(fechaFormateada2);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.FechaFin.sendKeys(monthCurrent);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
                Util.explicitWait(3);
                break;
            case "MMXCOL0154":
                this.lanzadorTareasUI.fechaInicio.sendKeys(monthCurrent);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.FechaFin.sendKeys(monthCurrent);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.codSector.sendKeys("4");
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.codMoneda.sendKeys("1");
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
                Util.explicitWait(3);
                break;
            case "MMXGCL0127":
                this.lanzadorTareasUI.fechaInicio.sendKeys(monthCurrent);
                this.lanzadorTareasUI.FechaFin.sendKeys(monthCurrent);
                Util.explicitWait(1);
                this.lanzadorTareasUI.inputTipoReporte.sendKeys("1");
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(1);
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.btnAcept.click();
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                break;
            case "MMXGC00308":

                this.lanzadorTareasUI.inputFileName.sendKeys(codArchivo);
                Util.explicitWait(1);
                this.lanzadorTareasUI.inputFileName.clear();
                Util.explicitWait(1);
                this.lanzadorTareasUI.inputFileName.sendKeys(codArchivo);
                Util.tab(manager.getDriver());
                Util.explicitWait(1);
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.btnAcept.click();
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                break;
            case "MMXGC00172":
                //Insumo
                Util.explicitWait(5);
                Util.pageStatus(manager.getDriver());
                this.lanzadorTareasUI.inputCodArchivo.sendKeys(codArchivo);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.btnAcept.click();
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                break;
            case "MMXGCL0136":
                this.lanzadorTareasUI.inputcodCompania.sendKeys("1");
                Util.explicitWait(1);
                this.lanzadorTareasUI.inputFechaProceso.sendKeys(monthCurrent);
                Util.explicitWait(1);
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.btnAcept.click();
                Util.tab(manager.getDriver());
                Util.explicitWait(12);
                Util.pageStatus(manager.getDriver());
                Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
                break;
            case "MMXGC00304":
                // Insumos
                Util.explicitWait(1);
                this.lanzadorTareasUI.txtNombreArchivo.sendKeys(archivo);
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.btnAcept.click();
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                break;
            case "TRNGC00179":
                // Insumos
                this.lanzadorTareasUI.inputFechaProceso.sendKeys(monthCurrent);
                Util.explicitWait(1);
                this.lanzadorTareasUI.inputNumOrden.sendKeys("1");
                Util.explicitWait(1);
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.btnAcept.click();
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                break;
            case "MMXGC00131":
                // Insumos
                this.lanzadorTareasUI.txtNombreArchivo.sendKeys(archivo);
                Util.explicitWait(1);
                this.lanzadorTareasUI.inputNumAviso.sendKeys("1");
                Util.explicitWait(1);
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.btnAcept.click();
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                break;
            case "MMXGC00305":
                this.lanzadorTareasUI.inputFechaProceso.sendKeys(monthCurrent);
                Util.explicitWait(1);
                this.lanzadorTareasUI.txtNombreArchivo.sendKeys(archivo);
                Util.explicitWait(1);
                this.lanzadorTareasUI.inputOrdenProcMasivo.sendKeys("1");
                Util.explicitWait(1);
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                Util.explicitWait(1);
                this.lanzadorTareasUI.btnAcept.click();
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                break;
            case "MMXTSL0005":
                // Insumos
                Util.explicitWait(1);
                this.lanzadorTareasUI.inputCodGestor.sendKeys("4");
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                this.lanzadorTareasUI.inputMinMax.sendKeys("5000");
                Util.explicitWait(1);
                this.lanzadorTareasUI.inputNatExp.sendKeys("GE");
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                this.lanzadorTareasUI.txtNombreDeArchivo.sendKeys(codArchivo);
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.btnAcept.click();
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
//            Util.scrollDown(manager.getDriver(), "1500");
                break;
            case "MMXTSL0011":
                // Insumos
                this.lanzadorTareasUI.inputCodArchivo.sendKeys(codArchivo);
                Util.tab(manager.getDriver());
                Util.explicitWait(5);
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.btnAcept.click();
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
//            Util.scrollDown(manager.getDriver(), "1500");
                break;
            default:
                System.out.println("Código not available.");
                break;
        }
    }

    @ShotAfter(evidenceName = "Completar Formulario Atributos del primero al fin de mes")
    public void completarformularioatributosprimeroafindemes() {
        // Obtiene la fecha actual
        LocalDate currentDate = LocalDate.now();

        // Obtiene el primer día del mes actual
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String diaunomesactual = firstDayOfMonth.format(formatter);

        // Obtiene el último día del mes actual
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        String ultimodiamesactual = lastDayOfMonth.format(formatter);

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.fechaInicio);
        this.lanzadorTareasUI.fechaInicio.sendKeys(diaunomesactual);
        this.lanzadorTareasUI.FechaFin.sendKeys(ultimodiamesactual);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.lanzadorTareasUI.BtnAceptar.click();
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
    }

    @ShotAfter(evidenceName = "Completar Formulario Atributos Reportes")
    public void completarformularioatributosreportes() {
        // Obtiene la fecha actual
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Obtiene el último día del mes actual
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        String ultimodiamesactual = lastDayOfMonth.format(formatter);

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.FechaFin);
        this.lanzadorTareasUI.FechaFin.sendKeys(ultimodiamesactual);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.lanzadorTareasUI.BtnAceptar.click();
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
    }

    @ShotAfter(evidenceName = "Validar Reporte")
    public void validarreporte(String reporte) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(15));
        Util.waitSpinner(manager.getDriver(), 30);
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.btnSpollInformes);
        Util.explicitWait(3);
        this.lanzadorTareasUI.btnSpollInformes.click();
        Util.pageStatus(manager.getDriver());
        manager.getDriver().switchTo().frame(manager.getDriver().findElement(By.xpath("//iframe[@frameborder=\"0\"]")));

        WebElement reporteext = null;
        try {
            reporteext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//td[starts-with(text(), '"+reporte+"')]")));
        } catch (Throwable ignored) {
        }
//        assert reporteext != null;
//        if(!reporteext.isDisplayed()){
//            Util.scrollDown(manager.getDriver(),"100");
//        }

        Util.scrollDown(manager.getDriver(),"100");
        if(!Util.webElementIsEnabled(10,manager.getDriver(),reporteext)) {
            fail("\n\n********************************************\n" +
                    "********************************************\n"+
                    "********************************************\n"+
                    "********* NO SE MUESTRA EL REPORTE ********* \n" +
                    "********************************************\n"+
                    "********************************************\n"+
                    "********************************************\n\n");
        }else {
            if(!reporteext.isEnabled()){
                Util.scrollToElement(manager.getDriver(), "//td[starts-with(text(), '"+reporte+"')]");
                //Util.scrollDown(manager.getDriver(),"100");
            }
            reporteext.click();
        }

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.btnVerReporte);
        this.lanzadorTareasUI.btnVerReporte.click();

    }

    public void validarreporteconterminacion(String reporte, String termina) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(15));

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.btnSpollInformes);
        Util.explicitWait(3);
        this.lanzadorTareasUI.btnSpollInformes.click();
        Util.pageStatus(manager.getDriver());
        manager.getDriver().switchTo().frame(manager.getDriver().findElement(By.xpath("//iframe[@frameborder=\"0\"]")));

        WebElement reporteext = null;
        try {
            reporteext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                            "//*[contains(text(), '"+reporte+"') and contains(text(), '"+termina+"')]")));
        } catch (Throwable ignored) {
        }

        if(!Util.webElementIsEnabled(10,manager.getDriver(),reporteext)) {
            fail("\n\n********************************************\n" +
                    "********************************************\n"+
                    "********************************************\n"+
                    "********* NO SE MUESTRA EL REPORTE ********* \n" +
                    "********************************************\n"+
                    "********************************************\n"+
                    "********************************************\n\n");
        }else {
            Util.scrollToElement(manager.getDriver(), "//*[contains(text(), '"+reporte+"') and contains(text(), '"+termina+"')]");
            Util.explicitWait(1);
            Util.scrollDown(manager.getDriver(),"-150");
            Util.explicitWait(1);
            reporteext.click();
        }

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.btnVerReporte);
        this.lanzadorTareasUI.btnVerReporte.click();
    }

    public void salirreporte() {
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.BtnSalir);
        this.lanzadorTareasUI.BtnSalir.click();
    }



    public void completarformularioatributosprimeroafindemescodigosector() {
        // Obtiene la fecha actual
        LocalDate currentDate = LocalDate.now();

        // Obtiene el primer día del mes actual
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String diaunomesactual = firstDayOfMonth.format(formatter);

        // Obtiene el último día del mes actual
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        String ultimodiamesactual = lastDayOfMonth.format(formatter);

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.fechaInicio);
        this.lanzadorTareasUI.fechaInicio.sendKeys(diaunomesactual);
        this.lanzadorTareasUI.FechaFin.sendKeys(ultimodiamesactual);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.lanzadorTareasUI.txtCodigoSector.sendKeys("4");
        Util.explicitWait(1);
        this.lanzadorTareasUI.BtnAceptar.click();
    }

    @ShotAfter(evidenceName = "Completar Formulario Atributos Validador de Siniestros")
    public void completarformularioatributosvalidadorasientos(String codigoejercicio, String codigoasiento, String numeroasiento, String listarerrores, String borraasiento, String listadocampos, String nombrearchivo) {

        // Obtiene la fecha actual
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Obtiene el último día del mes actual
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        String ultimodiamesactual = lastDayOfMonth.format(formatter);

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.txtCodigoEjercicio);

        this.lanzadorTareasUI.txtCodigoEjercicio.sendKeys(codigoejercicio);
        this.lanzadorTareasUI.FechaFinAsiento.sendKeys(ultimodiamesactual);
        Util.tab(manager.getDriver());
        this.lanzadorTareasUI.txtCodigoClaseAsiento.sendKeys(codigoasiento);
        this.lanzadorTareasUI.txtNumeroAsiento.sendKeys(numeroasiento);
        this.lanzadorTareasUI.txtListaError.sendKeys(listarerrores);
        this.lanzadorTareasUI.txtBorrarAsiento.sendKeys(borraasiento);
        this.lanzadorTareasUI.txtListadoCampos.sendKeys(listadocampos);
        this.lanzadorTareasUI.txtNombreDeArchivo.sendKeys(nombrearchivo);



        Util.pageStatus(manager.getDriver());
        this.lanzadorTareasUI.BtnAceptar.click();
    }

    @ShotAfter(evidenceName = "Atualizar Formulario Validador Asientos")
    public void actualizarformularioatributosvalidadorasientos(String codigoasiento, String nombrearchivo) {

        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.txtCodigoClaseAsiento);
        this.lanzadorTareasUI.txtCodigoClaseAsiento.clear();
        this.lanzadorTareasUI.txtCodigoClaseAsiento.sendKeys(codigoasiento);

        this.lanzadorTareasUI.txtNombreDeArchivo.clear();
        this.lanzadorTareasUI.txtNombreDeArchivo.sendKeys(nombrearchivo);



        Util.pageStatus(manager.getDriver());
        this.lanzadorTareasUI.BtnAceptar.click();
    }

    public void completarformulariointerfacecontable(String codigoejercicio, String codigoasiento, String moneda, String resumido, String reprocesar) {
        // Obtiene la fecha actual
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Obtiene el último día del mes actual
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        String ultimodiamesactual = lastDayOfMonth.format(formatter);

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.txtCodigoEjercicio);

        this.lanzadorTareasUI.txtCodigoEjercicio.sendKeys(codigoejercicio);
        this.lanzadorTareasUI.txtCodigoClaseAsiento.sendKeys(codigoasiento);
        this.lanzadorTareasUI.txtMoneda.sendKeys(moneda);
        this.lanzadorTareasUI.FechaFinAsiento.sendKeys(ultimodiamesactual);
        Util.tab(manager.getDriver());
        this.lanzadorTareasUI.txtResumido.sendKeys(resumido);
        this.lanzadorTareasUI.txtReprocesar.sendKeys(reprocesar);

        Util.pageStatus(manager.getDriver());
        this.lanzadorTareasUI.BtnAceptar.click();

        Util.explicitWait(1);
        if (Util.webElementIsEnabled(3, manager.getDriver(), this.lanzadorTareasUI.ventanaError)) {
            // Obtener los textos de los elementos de error
            String ventanaErrorTexto = this.lanzadorTareasUI.ventanaError.getText();
            String detalleErrorTexto = this.lanzadorTareasUI.detalleError.getText();

            // Crear el mensaje de error
            String mensajeError = String.format(
                    "Se muestra una ventana de Error:\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                    "***************************************************************************",
                    "***************************************************************************",
                    "***************************************************************************",
                    ventanaErrorTexto,
                    detalleErrorTexto,
                    "***************************************************************************",
                    "***************************************************************************",
                    "***************************************************************************"
            );

            // Lanzar el fallo con el mensaje de error
            fail(mensajeError);
        }
    }

    public void lanzadorTareasTaskactualizarformulariointerfacecontable(String codigoasiento, String moneda) {
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.lanzadorTareasUI.txtCodigoClaseAsiento);
        this.lanzadorTareasUI.txtCodigoClaseAsiento.clear();
        this.lanzadorTareasUI.txtCodigoClaseAsiento.sendKeys(codigoasiento);

        this.lanzadorTareasUI.txtMoneda.clear();
        this.lanzadorTareasUI.txtMoneda.sendKeys(moneda);



        Util.pageStatus(manager.getDriver());
        this.lanzadorTareasUI.BtnAceptar.click();
    }

    @ShotAfter(evidenceName = "Cargar Archivo")
    public void complearatributos(String archivo, String campoId, String valor) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(15));

        this.lanzadorTareasUI.btnLupa.click();
        Util.explicitWait(1);
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/resources/" + archivo);
        String file1 = file.getAbsolutePath();
        System.out.println("El archivo es:" + file1);

        WebElement iframe = manager.getDriver().findElement(By.tagName("iframe"));
        manager.getDriver().switchTo().frame(iframe);
       //WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(10));
       //wait.until(ExpectedConditions.elementToBeClickable(this.lanzadorTareasUI.imputArchivo));
        String pagina = manager.getDriver().getPageSource();
        System.out.println(pagina);

//        JavascriptExecutor jse = (JavascriptExecutor)manager.getDriver();
//        jse.executeScript("document.querySelector(\"input[name='file']\").value='"+file+"';",2000);
//        jse.executeScript("document.querySelector(\"input[name='file']\").dispatchEvent(new Event('input'))",2000);

        //this.lanzadorTareasUI.imputArchivo.sendKeys(file1);
        Util.explicitWait(2);


        WebElement elemento = manager.getDriver().findElement(By.xpath("//input[@name=\"file\"]"));
        try {
            elemento.click();
        } catch (Exception e) {
            ((JavascriptExecutor) manager.getDriver()).executeScript("arguments[0].click();", elemento);
        }
        Util.explicitWait(2);
        WebElement input = manager.getDriver().findElement(By.xpath("//input[@name=\"file\"]"));
        input.clear();
        input.sendKeys(valor);

        //this.lanzadorTareasUI.imputArchivo.sendKeys(file1);
        Util.explicitWait(2);
    }


    @ShotAfter(evidenceName = "Finalizar Cargar de Archivo")
    public void complearatributosfinalizar() {
        this.lanzadorTareasUI.btnFinalizar.click();
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Aceptar Atributos")
    public void aceptaratributosAceptar() {
        this.lanzadorTareasUI.btnAceptarAtributos.click();

    }

}

