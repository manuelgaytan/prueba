package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.EmisionConsultaPolizaUI;
import com.nttdata.ct.web.ui.EmisionGestionControlTecnicoUI;
import com.nttdata.ct.web.ui.IndividualCambioPlacasUI;
import com.nttdata.ct.web.ui.LoginUI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class EmisionConsultaPolizaTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    private EmisionGestionControlTecnicoUI emisionGestionControlTecnicoUI;
    @Autowired
    private EmisionConsultaPolizaUI emisionConsultaPolizaUI;

    @Autowired
    private LoginUI loginUI;
    @Autowired
    private IndividualCambioPlacasUI individualCambioPlacasUI;

    @ShotAfter(evidenceName = "ingresar a Consulta Poliza Emisión")
    public void ingresarAConsultaPolizaEmision() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.emisionConsultaPolizaUI.btnConsultarPolizaEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }
    @ShotAfter(evidenceName = "Buscar Poliza")
    public void buscarPoliza(String numeroPoliza) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.emisionConsultaPolizaUI.txtNumeroPolizaEmision.sendKeys(numeroPoliza);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        this.emisionConsultaPolizaUI.btnBuscarPolizaEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

    }

    @ShotAfter(evidenceName = "Ingresar a Numero de  Poliza")
    public void ingresarANumeroPoliza(String numeroPoliza) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.emisionConsultaPolizaUI.btnNumeroPolizaEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

    }

    @ShotAfter(evidenceName = "Ingresar a recibos de poliza")
    public void ingresoReciboDePoliza() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[contains(text(),'Estamos cargando la página')]")));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.emisionConsultaPolizaUI.btnResibosEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

    }

}
