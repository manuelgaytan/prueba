package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.evidence.aspect.method.ShotBefore;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.task.ExcelData;
import com.nttdata.ct.web.ui.FlotillasConsultaUI;
import com.nttdata.ct.web.ui.LoginUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.Random;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class AutoFlotillasConsultaTask {

    @Autowired
    public DriverManager manager;
    @Autowired
    private FlotillasConsultaUI flotillasConsultaUI;


    @ShotAfter(evidenceName = "Apartado consultar póliza")
    public void irConsultarPoliza() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasConsultaUI.selectEmision.click();
        Util.explicitWait(4);
        this.flotillasConsultaUI.btnConsultarPoliza.click();
        Util.pageStatus(manager.getDriver());
        String noPoliza = ExcelData.readJsonTemporalPolizaFlotillas();
        this.flotillasConsultaUI.inputConsultarPoliza.sendKeys(noPoliza);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasConsultaUI.btnBuscarPoliza.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
    }

    public void informacionConsulta() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        String noPoliza = ExcelData.readJsonTemporalPolizaFlotillas();
        WebElement btnPoliza = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/descendant::*[text()='" + noPoliza + "'][1]")));
        btnPoliza.click();
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Validamos la consulta individual")
    public void validacionConsulta() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
//        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Coaseguro')]");
        Util.pageStatus(manager.getDriver());
        this.flotillasConsultaUI.validateRamo.isEnabled();
        Util.scrollToElement(manager.getDriver(), "//body/descendant::*[contains(text(),'AUTOS FLOTILLAS')][1]");
    }

    public void validacionConsulta2() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/descendant::*[@class=\"icons gniImg\"][1]")));
        this.flotillasConsultaUI.btnInfGeneral.click();
        Util.pageStatus(manager.getDriver());
        Util.scrollDown(manager.getDriver(), "200");
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "informacion general de autos individual")
    public void validacionConsulta3() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/descendant::*[contains(text(),'Atributos póliza')][1]")));
//        Util.scrollDown(manager.getDriver(), "-400");
//        this.flotillasConsultaUI.btnAtributosPoliza.click();
        Util.pageStatus(manager.getDriver());
        Util.scrollDown(manager.getDriver(), "200");
        Util.explicitWait(2);
    }
}
