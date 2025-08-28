package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.CambioGestionIndividualUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

@Task
public class CambioGestionIndividualTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    public CambioGestionIndividualUI cambioGestionIndividualUI;

    @ShotAfter(evidenceName = "Atributos de poliza")
    public void atributosPioliza() {

        String numPoliza = ExcelData.readJsonIndividual();
        Util.explicitWait(3);
        Util.pageStatus(manager.getDriver());
        this.cambioGestionIndividualUI.inputNumeroPoliza.sendKeys(numPoliza);
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.cambioGestionIndividualUI.inputTipoGestor.sendKeys("AG");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.cambioGestionIndividualUI.inputCodGestor.sendKeys("99999");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.cambioGestionIndividualUI.btnAceptar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
    }

    @ShotAfter(evidenceName = "Historial de ejecucion")
    public void historialEjecucion() {
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"gview_gridActions\"]/div[3]");
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Consultar cambios")
    public void consultarCambiosPoliza() {
        String numPoliza = ExcelData.readJsonIndividual();
//        this.cambioGestionIndividualUI.btnSalir.click();
//        Util.explicitWait(2);
//        Util.pageStatus(manager.getDriver());
//        Util.scrollDown(manager.getDriver(),"-200");
//        Util.waitWebElementIsEnabled(10,manager.getDriver(),this.cambioGestionIndividualUI.menuEmision);
//        this.cambioGestionIndividualUI.menuEmision.click();
//        Util.explicitWait(2);
//        Util.pageStatus(manager.getDriver());
//        this.cambioGestionIndividualUI.btnConsultaPoliza.click();
//        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.cambioGestionIndividualUI.inputPoliza.sendKeys(numPoliza);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.cambioGestionIndividualUI.btnBuscar.click();
        Util.explicitWait(5);
    }
    @ShotAfter(evidenceName = "Consultar recibo")
    public void consultarCambiosPoliza2() {
        String numPoliza = ExcelData.readJsonIndividual();
        WebElement linkElement = manager.getDriver().findElement(By.xpath("//a[text()='"+ numPoliza+"']"));
        linkElement.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.cambioGestionIndividualUI.btnRecibos.click();
        String numAgente = this.cambioGestionIndividualUI.textAgente.getText();
        Assert.assertEquals("99999", numAgente);
        Util.explicitWait(5);
    }

}
