package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;

import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.ConsultaFacturasUI;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

@Task
public class ConsultaFacturaTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    public ConsultaFacturasUI consultaFacturasUI;


    @ShotAfter(evidenceName = "Facturacion")
    public void irConsultaFactura() {
        String codPoliza = ExcelData.readJsonIndividual();
        this.consultaFacturasUI.btnFacturacion.click();
        Util.explicitWait(3);
        Util.scrollDown(manager.getDriver(),"-150");
        this.consultaFacturasUI.btnConsultaFactura.click();
        Util.explicitWait(3);
        this.consultaFacturasUI.btnPolizaRec.click();
        Util.explicitWait(3);
        this.consultaFacturasUI.inputNumPoliza.sendKeys(codPoliza);
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.clicJavascript(manager.getDriver(), "//button[@id='btnSrch']");
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Decargar archivo zip")
    public void generarArchivoZip(){
        String codPoliza = ExcelData.readJsonIndividual();
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"acgEliGtiCtnMmxW\"]/div/div/div/div[5]");
        Util.explicitWait(3);
        this.consultaFacturasUI.checkFactura.click();
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        String numPoliza = this.consultaFacturasUI.labelNumPoliza.getAttribute("title");
        Assert.assertEquals(numPoliza, codPoliza);
        this.consultaFacturasUI.btnExportar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        //Util.scrollToElement(manager.getDriver(), "//*[@id=\"acgEliGtiTblMmxW\"]/div[7]");
        this.consultaFacturasUI.btnAmbos.click();
        Util.explicitWait(3);
        Util.isVisibleAlertRFCCreate(manager.getDriver());
        Util.explicitWait(7);
    }

}
