package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.evidence.aspect.method.ShotBefore;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.EmisionGestionControlTecnicoUI;
import com.nttdata.ct.web.ui.IndividualCambioPlacasUI;
import com.nttdata.ct.web.ui.IndividualUI;
import com.nttdata.ct.web.ui.LoginUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class EmisionGestionControlTecnicoTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    private EmisionGestionControlTecnicoUI emisionGestionControlTecnicoUI;

    @Autowired
    private LoginUI loginUI;
    @Autowired
    private IndividualCambioPlacasUI individualCambioPlacasUI;

    @ShotAfter(evidenceName = "ingresar a Emisión")
    public void ingresarAEmison() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.emisionGestionControlTecnicoUI.selectEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }

    @ShotAfter(evidenceName = "ingresar a Gestión Control Técnico Emisión")
    public void ingresarAGestionControlTecnicoEmision() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.emisionGestionControlTecnicoUI.btnGestionControlTecnicoEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }
    @ShotAfter(evidenceName = "Buscar Poliza")
    public void buscarPoliza() {

        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
//        this.emisionGestionControlTecnicoUI.inputPoliza.sendKeys(numeroPoliza);
        this.emisionGestionControlTecnicoUI.btnBuscarPolizaEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.explicitWait(1);
        String polizaCaptura = this.emisionGestionControlTecnicoUI.capturarPoliza.getText();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        ExcelData.writeJsonGlobal("PolizaControlTecnico", polizaCaptura);
        String numeroPoliza = ExcelData.readJsonGlobal("PolizaControlTecnico");

        this.emisionGestionControlTecnicoUI.txtNumeroPolizaEmision.sendKeys(numeroPoliza);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        this.emisionGestionControlTecnicoUI.btnBuscarPolizaEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }

    @ShotAfter(evidenceName = "Seleccionar Poliza")
    public void seleccionarPoliza() {
        String numeroPoliza = ExcelData.readJsonGlobal("PolizaControlTecnico");
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.emisionGestionControlTecnicoUI.seleccionPoliza.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        this.emisionGestionControlTecnicoUI.btnSiguienteEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }

    @ShotAfter(evidenceName = "Seleccionar Poliza para Autorizar")
    public void seleccionarPolizaParaAutorizar(String observaciones) {
        String numeroPoliza = ExcelData.readJsonIndividual();
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.emisionGestionControlTecnicoUI.seleccionPoliza.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        this.emisionGestionControlTecnicoUI.textareaObservacionesEmision.sendKeys(numeroPoliza);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

    }

    @ShotAfter(evidenceName = "Autorizar Poliza")
    public void autorizarPiloza() {
        String numeroPoliza = ExcelData.readJsonGlobal("PolizaControlTecnico");
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.emisionGestionControlTecnicoUI.btnAutorizarPolizaEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'LA PÓLIZA YA ESTÁ AUTORIZADA. (" + numeroPoliza + ")')]")));

    }

    @ShotAfter(evidenceName = "Rechazar Poliza")
    public void rechazarPiloza() {
        String numeroPoliza = ExcelData.readJsonGlobal("PolizaControlTecnico");
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.emisionGestionControlTecnicoUI.btnRechazoPolizaEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'ERROR DE CONTROL TÉCNICO RECHAZADO')]")));

    }
}
