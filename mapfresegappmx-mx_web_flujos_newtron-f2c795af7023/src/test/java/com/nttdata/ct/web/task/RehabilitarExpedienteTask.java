package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.RehabilitarExpedienteUI;
import com.nttdata.ct.web.ui.TerminacionExpedientesUi;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

@Task
public class RehabilitarExpedienteTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    public TerminacionExpedientesUi terminacionExpedientesUi;

    @Autowired
    public RehabilitarExpedienteUI rehabilitarExpedienteUI;

    @ShotAfter(evidenceName = "Ir a rehabilitacion expediente")
    public void habilitarExpediente() {
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.terminacionExpedientesUi.menuSimiestros.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.rehabilitarExpedienteUI.btnRehabilitarExpediente.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

    }

    @ShotAfter(evidenceName = "Rehabilitacion expediente")
    public void consultaExpediente() {
        String numSimiestro = ExcelData.readJsonSiniestro("polizaSiniestroColision");
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.rehabilitarExpedienteUI.inputNumSimiestro.sendKeys(numSimiestro);
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.rehabilitarExpedienteUI.inputExpediente.sendKeys("1");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.rehabilitarExpedienteUI.btonSig.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
    }
    @ShotAfter(evidenceName = "Causa rehabilitacion")
    public void consultaExpediente2() {
        this.rehabilitarExpedienteUI.botonSig.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.rehabilitarExpedienteUI.checkCancelacionLiq.click();
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div[1]/div[1]/div/div[5]");
        Util.explicitWait(5);
    }
    @ShotAfter(evidenceName = "Aceptar rehabilitacion")
    public void consultaExpediente3() {

        Util.pageStatus(manager.getDriver());
        //Algo Pasa en esta linea
        this.rehabilitarExpedienteUI.btnAceptarRehabi.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        //this.rehabilitarExpedienteUI.inputIndemnizacion.sendKeys("5");
        this.rehabilitarExpedienteUI.btnIndemnizacion.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.rehabilitarExpedienteUI.btnHonorarios.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.rehabilitarExpedienteUI.btnGastos.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.rehabilitarExpedienteUI.btnAcepCambios.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.rehabilitarExpedienteUI.btnAceptCamb.click();
        Util.explicitWait(5);
    }
    public void consultaExpediente4() {
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.rehabilitarExpedienteUI.btnAceptOpera.click();
        Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
    }
}
