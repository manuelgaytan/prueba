package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.evidence.aspect.method.ShotBefore;
import com.nttdata.ct.web.ui.AnulacionSuplementoUI;
import com.nttdata.ct.web.ui.EndosoCambioPlanPagoUI;
import com.nttdata.ct.web.ui.IndividualEndosoDisminucionUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import com.nttdata.ct.web.lib.DriverManager;

import java.time.Duration;
import java.util.List;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class EndosoCambioPlanPagoTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    private IndividualEndosoDisminucionUI individualEndosoDisminucionUI;
    @Autowired
    private EndosoCambioPlanPagoUI endosoCambioPlanPagoUI;
    @Autowired
    private AnulacionSuplementoUI anulacionSuplementoUI;

    @ShotAfter(evidenceName = "informacion poliza")
    public void primerPantallaPlanPago( String codSuplemento, String suplemento){
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
        this.individualEndosoDisminucionUI.imputCodSuplemento.sendKeys(codSuplemento);
        Util.tab(manager.getDriver());
        this.individualEndosoDisminucionUI.imputSuplemento.sendKeys(suplemento);
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        this.individualEndosoDisminucionUI.btnAceptar.click();
        ///html/body/div/div[1]/div/div/div/div/div
        //validar modal de error
        /*Util.explicitWait(2);
        List<WebElement> cerrarModal = manager.getDriver().findElements(By.xpath("/html/body/div/div[1]/div/div/div/div/div"));
        int aceptModal2 = cerrarModal.size();
        if (aceptModal2 > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div/div/div/div")));
            this.endosoCambioPlanPagoUI.btnCerrar.click();
            Util.explicitWait(2);
        }*/
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
        Util.explicitWait(4);
        //*[@id="app-content-container"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/div/ul
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/div/ul");
        this.endosoCambioPlanPagoUI.btnAceptar.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Opción Economica")
    public void modificarPlanPago() {
        this.endosoCambioPlanPagoUI.btnSiguiente.click();
        Util.explicitWait(4);

    }
    @ShotAfter(evidenceName = "Informacion poliza Recibos")
    public void modificarPlanPago2() {
        this.endosoCambioPlanPagoUI.inputPlanPago.clear();
        this.endosoCambioPlanPagoUI.inputPlanPago.sendKeys("4");
        Util.tab(manager.getDriver());
        Util.explicitWait(4);
        this.endosoCambioPlanPagoUI.btnAceptPlan.click();
        Util.explicitWait(4);

    }
    @ShotAfter(evidenceName = "Cambio de Plan de pago Terminado")
    public void modificarPlanPago3() {
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/fieldset/div/div/div/div/div[1]/div[2]/div/div[2]/fieldset/div/div/fieldset[2]/div/div/div[2]/div/div/div/div/ul/li[4]/a");
        Util.explicitWait(3);
        this.endosoCambioPlanPagoUI.btnAceptRecibo.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/fieldset/div/div/div/div/div[2]/div[2]/div/div[2]/fieldset/div/div[2]/div/div/div/div");

        this.endosoCambioPlanPagoUI.inputObservacion.sendKeys("Cambio de Plan de Pago");
        Util.explicitWait(3);
        this.endosoCambioPlanPagoUI.btnAceptarObservacion.click();

        //this.endosoCambioPlanPagoUI.motivoSuplemento.click();
        Util.explicitWait(3);
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/fieldset/div/div/div/div/div[3]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div");
        this.endosoCambioPlanPagoUI.checkPlanpAGO.click();
        Util.explicitWait(3);
        this.endosoCambioPlanPagoUI.btnAceptPlanPago.click();

        String disminuPrima = this.endosoCambioPlanPagoUI.labelDismiPrim.getAttribute("title");
        Assert.assertEquals(disminuPrima,"CAMBIO DE PLAN DE PAGO");
        this.endosoCambioPlanPagoUI.btnFinalizar.click();
        Util.explicitWait(5);
    }
    @ShotAfter(evidenceName = "Proceso de plan de pago terminado")
    public void generaEndosoAceptar() {
        this.endosoCambioPlanPagoUI.btnAceptarGrabacion.click();
        Util.explicitWait(4);
        Util.pageStatus(manager.getDriver());
        this.endosoCambioPlanPagoUI.btnSalir.click();
        Util.explicitWait(4);
    }

    public void salirGrabacion(){

        this.anulacionSuplementoUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }
}
