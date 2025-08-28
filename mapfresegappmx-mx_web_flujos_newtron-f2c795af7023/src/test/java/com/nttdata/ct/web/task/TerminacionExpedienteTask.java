package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.TerminacionExpedientesUi;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

@Task
public class TerminacionExpedienteTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    public TerminacionExpedientesUi terminacionExpedientesUi;

    @ShotAfter(evidenceName = "terminacion expediente")
    public void terminacionExpediente() {
//        Util.explicitWait(2);
//        Util.pageStatus(manager.getDriver());
//        this.terminacionExpedientesUi.menuSimiestros.click();
//        Util.explicitWait(2);
//        Util.pageStatus(manager.getDriver());
//        this.terminacionExpedientesUi.btnTerminacionExpediente.click();
        //Mantenimiento Ernesto,comente lo anterior por que agregue ingresar al modulo desde un step


            String numSimiestro = ExcelData.readJsonSiniestro("polizaSiniestroColision");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.terminacionExpedientesUi.inputSimiestro.sendKeys(numSimiestro);
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.terminacionExpedientesUi.inputExpediente.sendKeys("1");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.terminacionExpedientesUi.btonSiguiente.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

    }
    @ShotAfter(evidenceName = "terminacion expediente")
    public void motivoTerminacion() {
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.terminacionExpedientesUi.btonFinalizar.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(2);
        this.terminacionExpedientesUi.checkTramitacionFinalizada.click();
       // Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        //WebElement confirmarBton = manager.getDriver().findElement(By.xpath("//*[@id=\"1\"]/td[3]"));
        //String texto = this.creacionExpedientesUI.provedoresExpedientes.getText();
        //String texto = confirmarBton.getText();
        //Assert.assertEquals(texto,"TRAMITACION FINALIZADA");
       // this.terminacionExpedientesUi.btonAceptar.click();
       // Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        //Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
    }
    public void aceptarOperacion() {
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div[1]/div[1]/div/div[5]");
        Util.explicitWait(2);
        this.terminacionExpedientesUi.aceptarSimiestro.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.terminacionExpedientesUi.btnAceptOper.click();
        Util.explicitWait(5);
    }
}
