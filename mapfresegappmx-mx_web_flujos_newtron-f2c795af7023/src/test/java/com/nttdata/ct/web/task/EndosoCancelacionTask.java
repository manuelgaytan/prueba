package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.EndosoCambioAgenteUI;
import com.nttdata.ct.web.ui.EndosoCancelacionUI;
import com.nttdata.ct.web.ui.IndividualEndosoDisminucionUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class EndosoCancelacionTask {

    @Autowired
    public DriverManager manager;
    @Autowired
    private IndividualEndosoDisminucionUI individualEndosoDisminucionUI;
    @Autowired
    private EndosoCancelacionUI endosoCancelacionUI;


    @ShotAfter(evidenceName = "informacion poliza")
    public void primerPantalla(){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        //String codPoliza = ExcelData.readJsonGlobal("polizaValidacion16Flotillas");
        //String codPoliza = ExcelData.readJsonGlobal("polizaValidacion17Flotillas");
        String noPoliza = ExcelData.readJsonSuplemento();//Mantenimiento Ernesto
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
        this.individualEndosoDisminucionUI.imputSuplemento.sendKeys("6");
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

        Util.explicitWait(3);
    }

    @ShotAfter(evidenceName = "Aceptar grabación")
    public void comentarioCancelacion() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        this.endosoCancelacionUI.btnSiguiente.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        this.endosoCancelacionUI.inputObservacion.sendKeys("Cancelacion poliza");
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        this.endosoCancelacionUI.btnAcepObservacion.click();
        Util.explicitWait(3);
        Util.pageStatus(manager.getDriver());
        this.endosoCancelacionUI.btnMotivoSuple.click();
        Util.explicitWait(3);
        this.endosoCancelacionUI.checkFaltaPago.click();
        Util.explicitWait(3);
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"app-content-container\"]/div/div/div[1]/div/div/fieldset/div/div/div/div/div[3]/div[2]/div/div[2]/fieldset/div/div/div[2]/div");
        this.endosoCancelacionUI.btnAceptarSuplemento.click();
        Util.explicitWait(3);
        Util.pageStatus(manager.getDriver());
        this.endosoCancelacionUI.btnFinalizar.click();

        List<WebElement> modalObservecion = manager.getDriver().findElements(By.xpath("/html/body/div[3]/div/div"));
        int aceptModal12 = modalObservecion.size();
        if (aceptModal12 > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div")));
            this.individualEndosoDisminucionUI.btnContinuarEmision.click();
            Util.explicitWait(4);
        }
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(5);
       }
    @ShotAfter(evidenceName = "Poliza cancelada")
    public void GeneraEndosoAceptar(){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.endosoCancelacionUI.btnAceptarGrabacion.click();
        Util.explicitWait(5);
        String disminuPrima = this.endosoCancelacionUI.labelFaltaPago.getAttribute("title");
        Assert.assertEquals(disminuPrima,"FALTA DE PAGO");
        Util.explicitWait(3);
        List<WebElement> procesoGrabacionModal = manager.getDriver().findElements(By.xpath("/html/body/div[2]/div"));
        int aceptModal12 = procesoGrabacionModal.size();
        if (aceptModal12 > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div")));
            this.individualEndosoDisminucionUI.btnAcepProcesGraba.click();
            Util.explicitWait(2);
        }
    }
}
