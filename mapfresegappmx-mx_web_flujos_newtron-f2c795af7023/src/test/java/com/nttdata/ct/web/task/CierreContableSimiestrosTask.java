package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.CierreContableSimiestrosUI;
import com.nttdata.ct.web.ui.LanzadorTareasUI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Task
public class CierreContableSimiestrosTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    private LanzadorTareasUI lanzadorTareasUI;

    @Autowired
    private CierreContableSimiestrosUI cierreContableSimiestrosUI;

    @ShotAfter(evidenceName = "Ingresar datos")
    public void datosTareas(String numTarea) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(180));
        LocalDate currentDate = LocalDate.now();
        LocalDate sumMonth = currentDate.plusMonths(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String monthCurrent = currentDate.format(formatter);
        String monthBefore = sumMonth.format(formatter);
        switch (numTarea) {
            case "TRNTS20001":

                this.cierreContableSimiestrosUI.inputFechaHasta.sendKeys(monthCurrent);
                Util.explicitWait(2);
                Util.pageStatus(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));
                Util.scrollTopPage(manager.getDriver());
                this.cierreContableSimiestrosUI.btnCancelar.click();
                Util.explicitWait(4);
                break;

            case "TRNTS20002":
                this.cierreContableSimiestrosUI.inputFechaHasta.clear();
                this.cierreContableSimiestrosUI.inputFechaHasta.sendKeys(monthCurrent);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));
                Util.scrollTopPage(manager.getDriver());
                Util.explicitWait(2);
                this.cierreContableSimiestrosUI.btnCancelar.click();
                Util.explicitWait(4);
                break;
            case "TRNGCA0007":
                LocalDate sumMonth2 = currentDate.minusMonths(1);
                String monthBefore2 = sumMonth2.format(formatter);
                this.lanzadorTareasUI.fechaInicio.clear();
                this.lanzadorTareasUI.fechaInicio.sendKeys(monthBefore2);
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.FechaFin.sendKeys(monthCurrent);
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));
                Util.explicitWait(4);
                break;

            case "MMXGCL0210":
                this.lanzadorTareasUI.txtCodigoEjercicio.sendKeys("2024");
                Util.tab(manager.getDriver());
                this.lanzadorTareasUI.FechaFinAsiento.sendKeys(monthCurrent);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));
                break;

            case "MMXCOL0006":
                //this.cierreContableSimiestrosUI.codCompania.sendKeys("1");
                //Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.codSector.sendKeys("4");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.codRamo.sendKeys("999");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.timeProceso.sendKeys("202401");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReporte.sendKeys("G");
                Util.tab(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));
                break;
            case "MMXCOL0003":
                this.cierreContableSimiestrosUI.codSector.sendKeys("4");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.codRamo.sendKeys("999");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.timeProceso.sendKeys("202401");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoExpedienteRecobro.sendKeys("S");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReporte.sendKeys("R");
                Util.tab(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));

                break;

            case "MMXCOL0004":
                this.cierreContableSimiestrosUI.codSector.sendKeys("4");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.codRamo.sendKeys("999");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.timeProceso.sendKeys("202401");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoExpedienteRecobro.sendKeys("D");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReporte.sendKeys("R");
                Util.tab(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));
                break;
            case "MMXCOL0005":
                this.cierreContableSimiestrosUI.codSector.sendKeys("4");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.codRamo.sendKeys("999");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.timeProceso.sendKeys("202401");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoExpedienteRecobro.sendKeys("R");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReporte.sendKeys("R");
                Util.tab(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));

                break;

            case "MMXCOL0100":
                this.cierreContableSimiestrosUI.codSector.sendKeys("4");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.codRamo.sendKeys("450");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.timeProceso.sendKeys("202401");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReporte.sendKeys("G");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.informeDetallado.sendKeys("S");
                Util.tab(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));
                break;

            case "2MMXCOL0100":
                this.cierreContableSimiestrosUI.codSector.sendKeys("4");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.codRamo.sendKeys("450");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.timeProceso.sendKeys("202401");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReporte.sendKeys("R");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.informeDetallado.sendKeys("S");
                Util.tab(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));
                break;
            case "MMXCOL3062":
                this.cierreContableSimiestrosUI.codSector.sendKeys("4");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.codRamo.sendKeys("999");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.timeProceso.sendKeys("202401");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReserva.clear();
                this.cierreContableSimiestrosUI.tipoReserva.sendKeys("1");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReporte.sendKeys("G");
                Util.tab(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));
                break;
            case "2MMXCOL3062":
                this.cierreContableSimiestrosUI.codSector.sendKeys("4");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.codRamo.sendKeys("999");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.timeProceso.sendKeys("202401");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReserva.clear();
                this.cierreContableSimiestrosUI.tipoReserva.sendKeys("2");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReporte.sendKeys("G");
                Util.tab(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));
                break;
            case "3MMXCOL3062":
                this.cierreContableSimiestrosUI.codSector.sendKeys("4");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.codRamo.sendKeys("999");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.timeProceso.sendKeys("202401");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReserva.clear();
                this.cierreContableSimiestrosUI.tipoReserva.sendKeys("3");
                Util.tab(manager.getDriver());
                this.cierreContableSimiestrosUI.tipoReporte.sendKeys("G");
                Util.tab(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//button[@id='btnAcp']");
                this.lanzadorTareasUI.BtnAceptarAtributos.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-container ng-isolate-scope darkness']")));
                break;
            default:
                System.out.println("Código not available.");
                break;
        }
    }
}
