package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.CreacionExpedientesUI;
import com.nttdata.ct.web.ui.IndividualSiniestroNewUI;
import com.nttdata.ct.web.ui.SiniestrosCristalesUI;
import com.nttdata.ct.web.ui.SiniestrosRoboUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class SiniestrosRoboTask {
    @Autowired
    private DriverManager manager;

    @Autowired
    private SiniestrosRoboUI siniestrosRoboUI;

    @Autowired
    private CreacionExpedientesUI creacionExpedientesUI;

    @Autowired
    private SiniestrosCristalesUI siniestrosCristalesUI;

    @Autowired
    private IndividualSiniestroNewUI individualSiniestroUI;

    @ShotAfter(evidenceName = "Colocamos motivo de siniestro de autos individual")
    public void motivoSiniestronew(String codigoMotivoSiniestro, String codTipoAsegurado, String consecuencia, String consecuencia2,String consecuencia3) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        //Util.explicitWait(2);
        //Util.scrollToElement(manager.getDriver(), "//*[text()='Información Siniestro']");

        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::input[@name='lssRsnVal'][2]");
        Util.explicitWait(1);
        this.individualSiniestroUI.inputMotivoSiniestro.sendKeys(codigoMotivoSiniestro);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        this.individualSiniestroUI.inputTipoRelacion.sendKeys(codTipoAsegurado);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.btnSiguienteGlobal.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(),"//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        WebElement motivoSiniestro1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + consecuencia + "')]/preceding::*[@type=\"checkbox\"][1]")));
        motivoSiniestro1.click();
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        WebElement selectConsecuencia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + consecuencia2 + "')]/preceding::*[@type=\"checkbox\"][1]")));
        selectConsecuencia.click();
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        WebElement selectConsecuencia3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + consecuencia3 + "')]/preceding::*[@type=\"checkbox\"][1]")));
        selectConsecuencia3.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@class='btn btnprimary glyphicon glyphicon-arrow-down red']");
        Util.explicitWait(2);
        this.individualSiniestroUI.btnBajar.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(), '" + consecuencia + "')]/preceding::*[@type='checkbox'][1]");
        WebElement motivoSiniestro2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + consecuencia + "')]/preceding::*[@type='checkbox'][1]")));
        motivoSiniestro2.click();
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        WebElement selectConsecuencia2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + consecuencia2 + "')]/preceding::*[@type='checkbox'][1]")));
        selectConsecuencia2.click();
        WebElement selectCheckConsecuencia3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + consecuencia3 + "')]/preceding::*[@type='checkbox'][1]")));
        selectCheckConsecuencia3.click();
    }

    public void motivoSiniestro2new() {
        this.individualSiniestroUI.btnSiguienteGlobal.click();
        Util.explicitWait(4);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }

    @ShotAfter(evidenceName = "No. póliza para siniestro de autos")
    public void polizaSiniestroRobo() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        //Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/descendant::label[1]")));
        this.individualSiniestroUI.labelNoEmision.isEnabled();
        String noPoliza = this.individualSiniestroUI.labelNoEmision.getText();
        String noPoliza1 = noPoliza.replace("EL SINIESTRO ", "");
        String noPoliza2 = noPoliza1.replace("SE HA CREADO CORRECTAMENTE.", "");
        ExcelData.writeJsonSiniestro("polizaSiniestroRobo", noPoliza2);
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Apertura de expediente robo total")
    public void irAperturaExpedientesRoboTotal() {
        String numSimiestro = ExcelData.readJsonSiniestro("polizaSiniestroRobo");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(5);
        this.siniestrosCristalesUI.menSimiestro.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.siniestrosCristalesUI.btnAperturaExpedient.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.creacionExpedientesUI.inputNumSimiestro.sendKeys(numSimiestro);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.creacionExpedientesUI.btnSiguienteApertura.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.siniestrosRoboUI.btnRoboTotal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.btnSiguient.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        //this.creacionExpedientesUI.btnExpediente1.click();
        //Util.explicitWait(2);
        //Util.pageStatus(manager.getDriver());

        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]");
        this.creacionExpedientesUI.btnAcept.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

        Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Daños cristales")
    public void irLlenadoDatos1() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div[2]/div/div[2]/div[3]/div[2]/div/div/div/div/div[1]");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.inputNombreCompleto.sendKeys("OSCAR HERRERA ESPINOSA");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputRelacionContratante.sendKeys("CONTRATANTE");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputContacto.sendKeys("1");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputTelefono.sendKeys("558050752");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.inputTipoAtencion.sendKeys("1");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.inputActividadAtencion.sendKeys("17");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.getInputTipoCdr.sendKeys("1");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.inputCodTercero.sendKeys("10025");
        Util.scrollToEnd(manager.getDriver());
        this.creacionExpedientesUI.btnVerificar.click();
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.getBtnAceptarExpediente.click();

        Util.explicitWait(5);
    }

}
