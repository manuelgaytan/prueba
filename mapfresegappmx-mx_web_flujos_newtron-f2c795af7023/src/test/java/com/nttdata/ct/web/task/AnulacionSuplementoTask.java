package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.AnulacionSuplementoUI;
import com.nttdata.ct.web.ui.EndosoCancelacionUI;
import com.nttdata.ct.web.ui.IndividualEndosoDisminucionUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class AnulacionSuplementoTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private IndividualEndosoDisminucionUI individualEndosoDisminucionUI;
    @Autowired
    private EndosoCancelacionUI endosoCancelacionUI;
    @Autowired
    private AnulacionSuplementoUI anulacionSuplementoUI;

    @ShotAfter(evidenceName = "informacion poliza")
    public void primerPantalla( ){
        System.out.println("Si llega-------");
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        //String codPoliza = ExcelData.readJsonGlobal("polizaValidacion17Flotillas");
        String noPoliza = ExcelData.readJsonSuplemento();//Mantenimiento Ernesto
        System.out.println("Si llega-------");
        this.individualEndosoDisminucionUI.selectEmision.click();
        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.btnModPoliza.click();
        Util.explicitWait(2);
        this.individualEndosoDisminucionUI.imputNumPoliza.sendKeys(noPoliza);
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.imputCodSuplemento.sendKeys("490");
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.imputSuplemento.sendKeys("1");
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.btnAceptar.click();
        Util.explicitWait(3);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        List<WebElement> aceptModal = manager.getDriver().findElements(By.xpath("/html/body/div[2]/div"));
        int aceptModal1 = aceptModal.size();
        if (aceptModal1 > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div")));
            this.individualEndosoDisminucionUI.btnModalPolizaRetenida.click();
            Util.explicitWait(2);
        }
        this.endosoCancelacionUI.btnAceptInfo.click();
        Util.explicitWait(4);
    }

    @ShotAfter(evidenceName = "Aceptar grabación")
    public void comentarioSuplemento() {
        this.endosoCancelacionUI.btnSiguiente.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        this.endosoCancelacionUI.inputObservacion.sendKeys("Anulacion de suplemento");
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        this.anulacionSuplementoUI.aceptObservacion.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        this.anulacionSuplementoUI.checkAnulacionSuplemento.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div/div[2]/div[2]/fieldset/div/div/div/div/div[2]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/ul/li[4]/a");
        Util.explicitWait(4);
        this.anulacionSuplementoUI.aceptuplemento.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        String disminuPrima = this.anulacionSuplementoUI.labelSuplemento.getAttribute("title");
        Assert.assertEquals(disminuPrima,"ANULACION DE SUPLEMENTOS");
        Util.explicitWait(3);
        this.anulacionSuplementoUI.btnFinalizar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
    }

    @ShotAfter(evidenceName = "Suplemento anulado")
    public void aceptarGrabacion() {
        this.anulacionSuplementoUI.btnAceptGrabacion.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }


    public void finalizar() {
        this.anulacionSuplementoUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }
}
