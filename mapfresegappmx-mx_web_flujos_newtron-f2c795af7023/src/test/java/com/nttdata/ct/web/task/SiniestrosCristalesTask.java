package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.CreacionExpedientesUI;
import com.nttdata.ct.web.ui.IndividualSiniestroNewUI;
import com.nttdata.ct.web.ui.SiniestrosCristalesUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class SiniestrosCristalesTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private CreacionExpedientesUI creacionExpedientesUI;

    @Autowired
    private SiniestrosCristalesUI siniestrosCristalesUI;

    @Autowired
    private IndividualSiniestroNewUI individualSiniestroUI;

    @ShotAfter(evidenceName = "Colocamos motivo de siniestro de autos individual")
    public void motivoSiniestronew(String codigoMotivoSiniestro, String codTipoAsegurado, String consecuencia, String consecuencia2) {
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
    }

    public void motivoSiniestro2new() {
        this.individualSiniestroUI.btnSiguienteGlobal.click();
        Util.explicitWait(4);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }

    @ShotAfter(evidenceName = "Apertura de expediente")
    public void irAperturaExpedientes() {
        String numSimiestro = ExcelData.readJsonSiniestro("polizaSiniestroCristales");
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
        this.siniestrosCristalesUI.btnDanosCristales.click();
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
//        this.creacionExpedientesUI.btnDanosParciales.click();
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
    @ShotAfter(evidenceName = "Daños cristales")
    public void valoracionInicialExpediente() {
        Util.explicitWait(2);
        this.creacionExpedientesUI.getBtnSiguient3.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.radioCalValAutoma.click();
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.btnAcptFuncion.click();
        //WebElement confirmarBton = manager.getDriver().findElement(By.xpath("//*[@id=\"1\"]/td[1]"));
        //String texto = this.creacionExpedientesUI.provedoresExpedientes.getText();
        //String texto = confirmarBton.getText();
        //Assert.assertEquals(texto,"PROVEEDORES DE EXPEDIENTES");
        Util.explicitWait(5);
    }
    @ShotAfter(evidenceName = "Daños cristales")
    public void irAperturaExpedientesLesionados() {
        String numSimiestro = ExcelData.readJsonSiniestro("polizaSiniestroCristales");
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
        this.siniestrosCristalesUI.btnLesionesOcupantes.click();
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


        Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Daños cristales")
    public void llenadoLesionadosCrist() {
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"plyAtrPssLssSetFrmW\"]/div/div/div[2]");
        this.siniestrosCristalesUI.inputNomCompl.sendKeys("OBEB CAMPOS");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.inputRelacionContratante.sendKeys("HERMANO");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.inputTel.sendKeys("5567891278");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.inputEmail.sendKeys("OBED@GMAIL.COM");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"plyAtrPssLssSetFrmW\"]/div/div/div[5]");
        this.siniestrosCristalesUI.inputNomOcupantes.sendKeys("2");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.inputLesionGravedad.sendKeys("1");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.inputAmbulancia.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.inputRelaContratante.sendKeys("HERMANO");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosCristalesUI.inputPosicionAuto.sendKeys("2");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

    }

    public void datosCompleLesionados() {
        Util.scrollToEnd(manager.getDriver());
        this.creacionExpedientesUI.btnVerificar.click();
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.getBtnAceptarExpediente.click();
        Util.explicitWait(2);
        this.siniestrosCristalesUI.btonSigui.click();
        Util.explicitWait(2);
        this.siniestrosCristalesUI.btnProveExp.click();
        Util.explicitWait(3);
    }

    @ShotAfter(evidenceName = "Daños cristales")
    public void finalizarLEO() {
        this.siniestrosCristalesUI.btnSguienFinal.click();
        Util.waitElementItsNotVisible(manager.getDriver(),"//div[@class='loading-container ng-isolate-scope darkness']");

    }


    public void finalizarLEO2() {
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.aceptarExped.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.btonFinalizar.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.btnAceptTerm.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.btnAceptOpera.click();
        Util.explicitWait(5);
    }
    @ShotAfter(evidenceName = "No. póliza para siniestro de autos")
    public void polizaSiniestroColisionnew() {
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
        ExcelData.writeJsonSiniestro("polizaSiniestroCristales", noPoliza2);
        Util.explicitWait(2);
    }
}
