package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.evidence.aspect.method.ShotBefore;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.IndividualConsultaUI;
import com.nttdata.ct.web.ui.IndividualUI;
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
public class AutomovilesConsultaTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private IndividualConsultaUI individualConsultaUI;
    @Autowired
    private IndividualUI individualUI;

    @Autowired
    private LoginUI loginUI;

    @ShotAfter(evidenceName = "Apartado consultar póliza")
    public void irConsultarPoliza() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualConsultaUI.selectEmision.click();
        Util.explicitWait(4);
        this.individualConsultaUI.btnConsultarPoliza.click();
        Util.pageStatus(manager.getDriver());
        String noPoliza = ExcelData.readJsonIndividual();
        this.individualConsultaUI.inputConsultarPoliza.sendKeys(noPoliza);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.individualConsultaUI.btnBuscarPoliza.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
    }

    public void informacionConsulta() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        String noPoliza = ExcelData.readJsonIndividual();
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
        this.individualConsultaUI.validateRamo.isEnabled();
        Util.scrollToElement(manager.getDriver(), "//body/descendant::*[contains(text(),'AUTOS INDIVIDUAL')][1]");
    }

    @ShotAfter(evidenceName = "informacion general de autos individual")
    public void validacionConsulta2() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/descendant::*[@class=\"icons gniImg\"][1]")));
        this.individualConsultaUI.btnInfGeneral.click();
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
//        this.individualConsultaUI.btnAtributosPoliza.click();
        Util.pageStatus(manager.getDriver());
        Util.scrollDown(manager.getDriver(), "200");
        Util.explicitWait(2);
    }

}