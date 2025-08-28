package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.LanzadorTareasUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.time.Duration;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class DatosBancariosPolizaTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private LanzadorTareasUI lanzadorTareasUI;
    @ShotAfter(evidenceName = "Cargar archivo")
    public void cargarArchivo(String polizaArchivo) {

        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/resources/"+polizaArchivo);
        String file1 = file.getAbsolutePath();
        this.lanzadorTareasUI.inputArchivo.sendKeys(file1);
        Util.explicitWait(1);
        this.lanzadorTareasUI.btnAceptarCarga.click();
        Util.waitAlert(manager.getDriver());
        Util.isVisibleAlertTemporal(manager.getDriver(), "Archivo cargado");
        this.lanzadorTareasUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
    }
    @ShotAfter(evidenceName = "Nombre archivo")
    public void ingresarNombreArchivo(String nombreArchivo) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        WebElement selectCapitalFirst = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("JBNOMBRE_ARCHIVO")));
        selectCapitalFirst.sendKeys(nombreArchivo);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.lanzadorTareasUI.BtnAceptarAtributos.click();

    }


}
