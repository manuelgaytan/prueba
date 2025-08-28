package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;

import com.nttdata.ct.web.evidence.aspect.method.ShotBefore;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.IndividualEndosoDisminucionUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.nttdata.ct.web.task.ExcelData.readExcel;
import static com.nttdata.ct.web.task.ExcelData.readJsonIndividual;


@Task
public class IndividualEndosoDisminucionTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    private IndividualEndosoDisminucionUI individualEndosoDisminucionUI;

    @ShotAfter(evidenceName = "informacion poliza")
    public void primerPantallaDisminucionPrimas( String codSuplemento, String suplemento){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        String codPoliza = ExcelData.readJsonIndividual();
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
        List<WebElement> aceptModal = manager.getDriver().findElements(By.xpath("/html/body/div[2]/div"));
        int aceptModal1 = aceptModal.size();
        if (aceptModal1 > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div")));
            this.individualEndosoDisminucionUI.btnModalPolizaRetenida.click();
            Util.explicitWait(2);
        }

        Util.explicitWait(4);
        this.individualEndosoDisminucionUI.btnInfoAceptar.click();
        Util.explicitWait(4);
        this.individualEndosoDisminucionUI.btnSiguiente.click();

    }
    @ShotAfter(evidenceName = "Prima original RC")
    public void modificarPoliza(){
        this.individualEndosoDisminucionUI.btnModificar.click();
        Util.explicitWait(3);
        Util.scrollToElement(manager.getDriver(),"//button[@id='btnNxt']");
        this.individualEndosoDisminucionUI.btnSiguienteInter.click();
        Util.scrollToElement(manager.getDriver(),"//button[@id='btnNxt']");
        Util.explicitWait(3);

        this.individualEndosoDisminucionUI.btnSiguienteInter.click();
        Util.explicitWait(3);
        Util.scrollToElement(manager.getDriver(),"//button[@id='btnNxt']");
        this.individualEndosoDisminucionUI.btnSiguienteInter.click();
        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.btnSiguienteInter.click();
        Util.explicitWait(3);
    }

    @ShotAfter(evidenceName = "Modificar valor RC Terceros")
    public void ModificarValorRcTerceros(){
        String rcTerceros = this.individualEndosoDisminucionUI.inputRcTerceros.getAttribute("value");
        System.out.println("rcTerceros "+ rcTerceros);
        String rcTerceros1 = rcTerceros.replace(" MXN","");
        int rcTerceros2 = Integer.parseInt(rcTerceros1);
        int rcTerceros3 = rcTerceros2-500000;
        String rcTerceros4 = Integer.toString(rcTerceros3);
        this.individualEndosoDisminucionUI.inputRcTerceros.clear();
        this.individualEndosoDisminucionUI.inputRcTerceros.sendKeys(rcTerceros4+" MXN");

    }
    @ShotAfter(evidenceName = "Modificar valor RC Terceros")
    public void ModificarValorRcTerceros3(){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualEndosoDisminucionUI.btnCalcular.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());

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
        this.individualEndosoDisminucionUI.inputTxtObservaciones.sendKeys("Endoso disminucion de primas test");
        Util.explicitWait(4);

        this.individualEndosoDisminucionUI.btnAceptarObservacion.click();
        Util.explicitWait(3);


        this.individualEndosoDisminucionUI.btnMotivoSuplemento.click();
        Util.explicitWait(3);

        this.individualEndosoDisminucionUI.checkSelecMotivoSuple.click();
        Util.explicitWait(3);
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"gridIur_pager_center\"]/table/tbody/tr/td[4]");
        this.individualEndosoDisminucionUI.btnAceptarMotivoSuple.click();
        Util.explicitWait(1);
        String disminuPrima = this.individualEndosoDisminucionUI.labelDismiPrim.getAttribute("title");
        Assert.assertEquals(disminuPrima,"DISMINUCION DE PRIMA");

        Util.explicitWait(3);
        this.individualEndosoDisminucionUI.btnFinalizar.click();
        Util.explicitWait(3);

    }
    @ShotBefore(evidenceName = "Endoso Modificado")
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