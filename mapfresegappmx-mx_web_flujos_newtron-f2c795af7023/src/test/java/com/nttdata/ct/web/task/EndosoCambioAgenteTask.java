package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.AnulacionSuplementoUI;
import com.nttdata.ct.web.ui.EndosoCambioAgenteUI;
import com.nttdata.ct.web.ui.EndosoCambioPlanPagoUI;
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
public class EndosoCambioAgenteTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private IndividualEndosoDisminucionUI individualEndosoDisminucionUI;
    @Autowired
    private EndosoCambioAgenteUI endosoCambioAgenteUI;
    @Autowired
    private EndosoCambioPlanPagoUI endosoCambioPlanPagoUI;
    @Autowired
    private AnulacionSuplementoUI anulacionSuplementoUI;

    @ShotAfter(evidenceName = "informacion poliza")
    public void primerPantalla( String codSuplemento, String suplemento){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        //String codPoliza = ExcelData.readJsonGlobal("polizaValidacion18Individual");
        String codPoliza = ExcelData.readJsonIndividual();  //Mantenimiento Ernesto
        this.individualEndosoDisminucionUI.selectEmision.click();
        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.btnModPoliza.click();
        Util.explicitWait(2);
        this.individualEndosoDisminucionUI.imputNumPoliza.sendKeys(codPoliza);
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.imputCodSuplemento.sendKeys(codSuplemento);
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.imputSuplemento.sendKeys(suplemento);
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
        this.endosoCambioAgenteUI.btnAceptar.click();
        Util.explicitWait(4);
    }

    @ShotAfter(evidenceName = "Agente Actual")
    public void cambioAgente() {
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"app-content-container\"]/div/div/div[2]/div[2]/div[1]/div/div/div/div[7]/div[1]");
        this.endosoCambioAgenteUI.btnAgente.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"nwtPlyInaOthPssPrcFrmW\"]/div/div");
        Util.explicitWait(3);
    }
    @ShotAfter(evidenceName = "Nuevo Agente")
    public void cambioAgente2(String codTercero, String cuadComision, String codOficina, String canalDsitrib) {
        Util.pageStatus(manager.getDriver());
        this.endosoCambioAgenteUI.inputCodigoTercero.clear();
        this.endosoCambioAgenteUI.inputCodigoTercero.sendKeys(codTercero);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.endosoCambioAgenteUI.inputCuadroComision.clear();
        this.endosoCambioAgenteUI.inputCuadroComision.sendKeys(cuadComision);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.endosoCambioAgenteUI.inputCodigoOficina.clear();
        this.endosoCambioAgenteUI.inputCodigoOficina.sendKeys(codOficina);
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.endosoCambioAgenteUI.inputFuenteDsitribucion.clear();
        this.endosoCambioAgenteUI.inputFuenteDsitribucion.sendKeys(canalDsitrib);
        Util.explicitWait(3);
        Util.scrollDown(manager.getDriver(),"100");
        Util.tab(manager.getDriver());

        Util.pageStatus(manager.getDriver());
        this.endosoCambioAgenteUI.cambioAgenteAcept.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
    }

    @ShotAfter(evidenceName = "Agente cambiado")
    public void cambioAgente3(String codTercero) {
        WebDriverWait wait = Util.wait(manager.getDriver());
        this.endosoCambioAgenteUI.btnSiguiente.click();
        Util.explicitWait(3);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.endosoCambioAgenteUI.btnModificar.click();
        Util.explicitWait(3);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.endosoCambioAgenteUI.btnSiguienteInter.click();
        Util.explicitWait(3);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.endosoCambioAgenteUI.btnSiguienteInter.click();
        Util.explicitWait(4);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id='btnNxt']");
        this.endosoCambioAgenteUI.btnSiguienteInter.click();
        Util.explicitWait(4);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/div[1]/div/div[2]/div/fieldset/div/div/div");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(6);
        this.endosoCambioAgenteUI.btnSiguienteInter.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        this.endosoCambioAgenteUI.btnSiguienteInter.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/div[1]/div/div[2]/div/fieldset/div/div/div");
        Util.explicitWait(3);
        this.endosoCambioAgenteUI.btnCalcular.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        this.endosoCambioAgenteUI.btnAceptarInter.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(3);
        Util.pageStatus(manager.getDriver());
        this.endosoCambioAgenteUI.btnSiguiente2.click();
        Util.explicitWait(4);

        this.endosoCambioAgenteUI.inputAgente.clear();
        this.endosoCambioAgenteUI.inputAgente.sendKeys(codTercero);
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        this.endosoCambioAgenteUI.btnAceptarAgen.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(3);
        Util.pageStatus(manager.getDriver());
        this.endosoCambioAgenteUI.inputObservacion.sendKeys("Prueba cambio de agente");
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/fieldset/div/div/div/div/div[2]/div[2]/div/div[2]/fieldset/div/div[2]/div/div/div/div");
        this.endosoCambioAgenteUI.btnAceptarObserv.click();
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/fieldset/div/div/div/div/div[3]/div[1]/h4");
        this.endosoCambioAgenteUI.btnSuplemento.click();
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/fieldset/div/div/div/div/div[3]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div");
        this.endosoCambioAgenteUI.checkRenovacion.click();
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.endosoCambioAgenteUI.btnAceptarRenovacion.click();
        Util.explicitWait(3);
        this.endosoCambioAgenteUI.btnFinalizar.click();
        Util.explicitWait(3);


        List<WebElement> modalObservecion = manager.getDriver().findElements(By.xpath("/html/body/div[3]/div/div"));
        int aceptModal12 = modalObservecion.size();
        if (aceptModal12 > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div")));
            this.individualEndosoDisminucionUI.btnContinuarEmision.click();
            Util.explicitWait(4);
        }

    }
    @ShotAfter(evidenceName = "Endoso Modificado")
    public void GeneraEndosoAceptar(){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.endosoCambioAgenteUI.btnAceptarGrabacion.click();
        Util.explicitWait(3);
        String disminuPrima = this.endosoCambioAgenteUI.labelRenovacion.getAttribute("title");
        Assert.assertEquals(disminuPrima,"RENOVACION");
        Util.explicitWait(3);
        List<WebElement> procesoGrabacionModal = manager.getDriver().findElements(By.xpath("/html/body/div[2]/div"));
        int aceptModal12 = procesoGrabacionModal.size();
        if (aceptModal12 > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div")));
            this.individualEndosoDisminucionUI.btnAcepProcesGraba.click();
            Util.explicitWait(4);

        }
    }
    public void finalizar() {
        this.anulacionSuplementoUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
    }


    public void salirGrabacion() {
        this.individualEndosoDisminucionUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

    }
}