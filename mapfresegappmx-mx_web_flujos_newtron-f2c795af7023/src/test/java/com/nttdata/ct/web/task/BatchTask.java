package com.nttdata.ct.web.task;
import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.FlotillasEmisionUI;
import com.nttdata.ct.web.ui.BatchUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@Task
public class BatchTask {

    @Autowired
    public DriverManager manager;
    @Autowired
    public BatchUI batchUI;

    @ShotAfter(evidenceName = "Apartado de administración de tareas")
    public void irConsultarPoliza() {
        Util.pageStatus(manager.getDriver());
        this.batchUI.mantenimiento.click();
        Util.explicitWait(4);
        this.batchUI.envioServidor.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/resources/GENERAL_PRE_GRL_SVCAMACH_4.TXT");
        String file1 = file.getAbsolutePath();
        this.batchUI.inputUpload.sendKeys(file1);
        Util.explicitWait(2);
        this.batchUI.btnAceptar.click();
        Util.waitAlert(manager.getDriver());
        Util.isVisibleAlertTemporal(manager.getDriver(), "Archivo cargado");
        File file2 = new File(pathFirst + "/src/test/resources/GENERAL_PRE_INT_SVCAMACH_4.TXT");
        String fileTwo = file2.getAbsolutePath();
        this.batchUI.inputUpload.sendKeys(fileTwo);
        Util.explicitWait(2);
        this.batchUI.btnAceptar.click();
        Util.pageStatus(manager.getDriver());
        Util.waitAlert(manager.getDriver());
        Util.isVisibleAlertTemporal(manager.getDriver(), "Archivo cargado");
        File file3 = new File(pathFirst + "/src/test/resources/GENERAL_PRE_RYC_SVCAMACH_4.TXT");
        String fileTree = file3.getAbsolutePath();
        this.batchUI.inputUpload.sendKeys(fileTree);
        Util.explicitWait(2);
        this.batchUI.btnAceptar.click();
        Util.waitAlert(manager.getDriver());
        Util.isVisibleAlertTemporal(manager.getDriver(), "Archivo cargado");
        this.batchUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "Apartado de lanzador de tareas e ingresar los datos de archivos txt")
    public void irLanzadorTareas(String tarea, String codEstructura) {
        this.batchUI.tareas.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.batchUI.lanzadorTareas.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.batchUI.inputTarea.sendKeys(tarea);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.batchUI.btnAceptarTarea.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.batchUI.inputGRL.sendKeys("GENERAL_PRE_GRL_SVCAMACH_4.TXT");
        Util.explicitWait(1);
        this.batchUI.inputINT.sendKeys("GENERAL_PRE_INT_SVCAMACH_4.TXT");
        Util.explicitWait(1);
        this.batchUI.inputRYC.sendKeys("GENERAL_PRE_RYC_SVCAMACH_4.TXT");
        Util.explicitWait(1);
        this.batchUI.inputCodEstructura.sendKeys(codEstructura);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Validamos nuestras tareas")
    public void clicAceptarTareas() {
        Util.explicitWait(2);
        this.batchUI.btnAceptarCot.click();
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.scrollDown(manager.getDriver(),"1500");
    }

    @ShotAfter(evidenceName = "Validamos que no se habilite el botón de error")
    public void validarTareas() {
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//*[@class='spinner-label ng-binding']");
        Util.explicitWait(20);
        this.batchUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollTopPage(manager.getDriver());
        this.batchUI.selectEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.batchUI.consultarProcesoMasivo.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.batchUI.inputTipoMovBatch.sendKeys("8");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        Date current = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateToday = formatter.format(current);
        this.batchUI.inputFechaProcesoBatch.sendKeys(dateToday);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        this.batchUI.btnBuscarProceso.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.doubleClic(manager.getDriver(), batchUI.selectProceso);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.scrollDown(manager.getDriver(),"1500");
        Util.scrollDown(manager.getDriver(),"1500");
        List<WebElement> modalError = manager.getDriver().findElements(By.xpath("//body/descendant::button[text()='Consultar Errores' and not(@disabled='disabled')][1]"));
        int countEnv = modalError.size();
        System.out.println(countEnv);
        if (countEnv > 0) {
            throw new IllegalArgumentException("Se habilito el botón de error");
        }
    }
}

