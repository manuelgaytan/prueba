package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.EndosoCambioAgenteUI;
import com.nttdata.ct.web.ui.IndividualCambioPlacasUI;
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
import static org.junit.Assert.fail;

@Task
public class IndividualCambioPlacasTask {

    @Autowired
    public DriverManager manager;

    @Autowired
    private IndividualEndosoDisminucionUI individualEndosoDisminucionUI;
    @Autowired
    private IndividualCambioPlacasUI individualCambioPlacasUI;
    @Autowired
    private EndosoCambioAgenteUI endosoCambioAgenteUI;

    @ShotAfter(evidenceName = "informacion poliza")
    public void primerPantalla(String codSuplemento, String suplemento){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
//        String codPoliza = ExcelData.readJsonPoliza("polizaValidacion17Individual");
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

        Util.explicitWait(1);
        if(Util.webElementIsEnabled(3,manager.getDriver(),this.individualEndosoDisminucionUI.ventanaError)) {
            fail("Se muestra una ventana de Error:\n\"********************************************************************\"" +
                    "\n********************************************************************\"" +
                    "\n********************************************************************\"" +
                    "\n"+this.individualEndosoDisminucionUI.ventanaError.getText()+" \n"+this.individualEndosoDisminucionUI.detalleError.getText()+
                    "\n********************************************************************\"" +
                    "\n********************************************************************\"" +
                    "\n********************************************************************\"" +
                    "\n********************************************************************\"\n\n\n\n");
        }

        //Util.explicitWait(3);
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
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

        this.endosoCambioAgenteUI.btnSiguienteModificarPoliza.click();  //Mantenimiento Ernesto
        Util.waitWebElementIsEnabled(20, manager.getDriver(), this.individualEndosoDisminucionUI.btnModificar); //Mantenimiento Ernesto
        Util.explicitWait(1); //Mantenimiento Ernesto
    }

    @ShotAfter(evidenceName = "Placa valor original")
    public void modificarPoliza(){
//        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
//        Util.explicitWait(3);
//        this.individualEndosoDisminucionUI.btnSiguiente.click();
//        Util.scrollToElement(manager.getDriver(),"//button[@id='btnNxt']");
//        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.btnModificar.click();
        Util.explicitWait(3);
        Util.scrollToElement(manager.getDriver(),"//button[@id='btnNxt']");
        this.individualEndosoDisminucionUI.btnSiguienteInter.click();
        Util.explicitWait(3);

        Util.scrollToElement(manager.getDriver(),"//button[@id='btnNxt']");
        this.individualEndosoDisminucionUI.btnSiguienteInter.click();
        Util.explicitWait(3);
//        this.individualEndosoDisminucionUI.btnSiguienteInter.click();
  //      Util.explicitWait(3);
    }

    @ShotAfter(evidenceName = "Modificar numero de placas")
    public void modificarNumeroPlacas(){


        this.individualCambioPlacasUI.inputCambioPlca.clear();
        this.individualCambioPlacasUI.inputCambioPlca.sendKeys("VHF968");
        Util.explicitWait(4);

    }
    @ShotAfter(evidenceName = "Numero de placas modificado")
    public void ModificarnumeroPlacas2(){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        Util.scrollToElement(manager.getDriver(),"//*[@id=\"btnNxt\"]");
        this.individualCambioPlacasUI.btnNumPlaca.click();
        Util.explicitWait(4);
        this.individualEndosoDisminucionUI.btnSiguienteInter.click();
        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.btnSiguienteInter.click();
        Util.explicitWait(3);
        /* this.individualEndosoDisminucionUI.btnCalcular.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());*/

        Util.scrollToElement(manager.getDriver(),"//button[@id='btnAcp' and @ng-click='objBtn.btnAcp.onClick()']");
        this.individualEndosoDisminucionUI.btnAceptarEndoso.click();

        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());

        List<WebElement> modalErrorCot = manager.getDriver().findElements(By.xpath("//*[contains(text(),'Continuar Emisión')]"));
        int countError = modalErrorCot.size();
        if (countError > 0) {
            WebElement emisionError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Continuar Emisión')]")));
            emisionError.click();
        }


        this.individualEndosoDisminucionUI.btnSiguiente2.click();
        Util.explicitWait(4);
        Util.scrollToElement(manager.getDriver(),"//a[@class='accordion-toggle' and @ng-click='toggleOpen()']/span[text()='Motivo suplemento']");
        this.individualEndosoDisminucionUI.inputTxtObservaciones.sendKeys("Endoso cambio de placas");
        Util.explicitWait(4);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.individualEndosoDisminucionUI.btnAceptarObservacion.toString())));

        this.individualEndosoDisminucionUI.btnAceptarObservacion.click();
        Util.explicitWait(3);

        this.individualEndosoDisminucionUI.btnMotivoSuplemento.click();
        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.checkSelecMotivoSuple.click();
        Util.explicitWait(3);
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"gridIur_pager_center\"]/table/tbody/tr/td[4]");
        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.btnAceptarMotivoSuple.click();
        String disminuPrima = this.individualCambioPlacasUI.labelDismiPrim.getAttribute("title");
        Assert.assertEquals(disminuPrima,"SIN MOVIMIENTO");

        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.btnFinalizar.click();
        Util.explicitWait(3);

    }
    @ShotAfter(evidenceName = "Endoso Modificado")
    public void GeneraEndosoAceptar(){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        List<WebElement> procesoGrabacionModal = manager.getDriver().findElements(By.xpath("/html/body/div[2]/div"));
        int aceptModal12 = procesoGrabacionModal.size();
        if (aceptModal12 > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div")));
            this.individualEndosoDisminucionUI.btnAcepProcesGraba.click();
            Util.explicitWait(2);
        }
    }
}
