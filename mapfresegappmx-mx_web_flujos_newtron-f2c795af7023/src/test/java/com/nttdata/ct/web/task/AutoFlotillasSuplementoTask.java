package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;


import com.nttdata.ct.web.ui.FlotillasSuplementoUI;
import com.nttdata.ct.web.ui.IndividualSuplementoUI;
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

@Task
public class AutoFlotillasSuplementoTask {

    @Autowired
    public DriverManager manager;
    @Autowired
    public FlotillasSuplementoUI flotillasSuplementoUI;
    @Autowired
    public IndividualSuplementoUI individualSuplementoUI;

    public void ingresamosSuplementoPoliza(){
        this.flotillasSuplementoUI.selectEmision.click();
        Util.explicitWait(2);
        this.flotillasSuplementoUI.btnModPoliza.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    public void busquedaPolizaFlotillas() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        String poliza = ExcelData.readJsonTemporalPolizaFlotillas();
        this.flotillasSuplementoUI.inputNumPoliza.sendKeys(poliza);
        this.individualSuplementoUI.btnLupaPoliza.isEnabled();
        this.individualSuplementoUI.btnLupaPoliza.click();
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualSuplementoUI.btnBuscarCodigoSup.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualSuplementoUI.selectCantidad.click();
        Util.explicitWait(2);
        this.individualSuplementoUI.optionCantidad.click();
        Util.explicitWait(2);
        this.individualSuplementoUI.seleccionarEndoso.click();
        Util.pageStatus(manager.getDriver());
        this.individualSuplementoUI.btnAceptarEndosoGeneral.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualSuplementoUI.btnAceptarGlobal.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        List<WebElement> modalErrorCot3 = manager.getDriver().findElements(By.xpath("//*[@class='modal-body']/following::*[@class='modal-footer']/descendant::span[contains(text(),'Aceptar')][1]"));
        int countError = modalErrorCot3.size();
        if (countError > 0) {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='modal-body']/following::*[@class='modal-footer']/descendant::span[contains(text(),'Aceptar')][1]")));
            error.click();
        }
    }

    public void aceptarInformacionBasica(){
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollDown(manager.getDriver(), "200");
        this.flotillasSuplementoUI.btnAcceptUIB.click();
        Util.explicitWait(10);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.scrollToElement2(manager.getDriver(), flotillasSuplementoUI.btnNextU);
        this.flotillasSuplementoUI.btnNextU.click();
        Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
    }

    public void seleccionamosLaPolizaFlotillas(){

        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(2);
        Util.scrollTopPage(manager.getDriver());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"1\"]/td[1]")));
        this.flotillasSuplementoUI.selectPolizaU.click();
        Util.explicitWait(10);
        Util.pageStatus(manager.getDriver());

        this.flotillasSuplementoUI.btnAddCrear.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollDown(manager.getDriver(), "1600");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"btnNxt\" and not(@disabled='disabled')]")));
        this.flotillasSuplementoUI.btnSiguienteGlobal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

    public void seleccionamosConductoresFlotillas(){

        Util.scrollToElement(manager.getDriver(),"//body/descendant::button[@id='add' and contains(text(),'Añadir fila')][1]");
        this.flotillasSuplementoUI.btnAddFila.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasSuplementoUI.selectTipoBen.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasSuplementoUI.optionTpoBen.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasSuplementoUI.btnGuardarInterviniente.isEnabled();
        Util.scrollToElement(manager.getDriver(), "//*[@id='saveBtn']/..");
        Util.clicActions(manager.getDriver(), "//*[@id='saveBtn']");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id='btnNxt']");
        this.flotillasSuplementoUI.btnSiguienteGlobal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

    public void capturaosAuto2Flotillas(String codAmbCirculacion, String codTipoVehi, String tipoIndemnizacion, String codMarca, String codModelo, String codSubModelo, String anioSubModelo, String codUsoVehiculo, String codModalidad){

        this.flotillasSuplementoUI.inputAmbCirculacion.sendKeys(codAmbCirculacion);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        // Los caracteres de interés en un array de char.
        char[] chars = "0123456789".toCharArray();
        char[] charsCar = "WERTYUPASDFGHJKLZXCVBNM".toCharArray();
        int charsLength = chars.length;
        int charsLengthCar = charsCar.length;
        // Instanciamos la clase Random
        Random random = new Random();
        // Un StringBuffer para componer la cadena aleatoria de forma eficiente
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        StringBuffer buffer3 = new StringBuffer();
        StringBuffer buffer4 = new StringBuffer();
        StringBuffer buffer5 = new StringBuffer();
        // Bucle para elegir una cadena de 10 caracteres al azar
        for (int i = 0; i < 1; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer.append(chars[random.nextInt(charsLength)]);
        }
        for (int i = 0; i < 4; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer2.append(charsCar[random.nextInt(charsLengthCar)]);
        }
        for (int i = 0; i < 3; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer3.append(chars[random.nextInt(charsLength)]);
        }
        for (int i = 0; i < 3; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer4.append(charsCar[random.nextInt(charsLengthCar)]);
        }
        for (int i = 0; i < 6; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer5.append(chars[random.nextInt(charsLength)]);
        }
        // Y solo nos queda hacer algo con la cadena
        String numero = buffer.toString();
        String numero2 = buffer2.toString();
        String numero3 = buffer3.toString();
        String numero4 = buffer4.toString();
        String numero5 = buffer5.toString();
        String vin = numero + numero2 + numero3 + numero4 + numero5;
        this.flotillasSuplementoUI.inputNumSerie.sendKeys(vin);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        this.flotillasSuplementoUI.inputCodTipVehi.clear();
        Util.explicitWait(2);
        this.flotillasSuplementoUI.inputCodTipVehi.sendKeys(codTipoVehi);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasSuplementoUI.inputTipoIndemnizacion.sendKeys(tipoIndemnizacion);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasSuplementoUI.inputCodMarca.sendKeys(codMarca);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasSuplementoUI.inputCodModelo.sendKeys(codModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasSuplementoUI.inputCodSubModelo.sendKeys(codSubModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasSuplementoUI.inputAnioSubModelo.sendKeys(anioSubModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasSuplementoUI.inputCodUsoVehi.sendKeys(codUsoVehiculo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasSuplementoUI.inputCodModalidad.sendKeys(codModalidad);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement2(manager.getDriver(), flotillasSuplementoUI.btnAceptarAtributos);
        this.flotillasSuplementoUI.btnAceptarAtributos.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.enter(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

    }

    @ShotAfter(evidenceName = "Emisión de autos flotillas")
    public void cotizacion2AutoFlotillasSuplemento(){

        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.flotillasSuplementoUI.btnSiguienteGlobal.isEnabled();
        this.flotillasSuplementoUI.btnSiguienteGlobal.click();
        Util.explicitWait(6);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
//
//        String franquicia = readExcel("data_autos", 0, 1);
//        if (!franquicia.equals("null-data")) {
//            WebElement inputFranquicia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + franquicia + "')]/following::*[@name='cvrDctValueListInput' and not(@disabled='disabled')][1]")));
//            String textFranquicia = readExcel("data_autos", 1, 1);
//            inputFranquicia.click();
//            inputFranquicia.clear();
//            Util.press(manager.getDriver(), inputFranquicia, textFranquicia);
//
//        }
        String capital = readExcel("modificar_autos_flotillas", 0, 2);
        if (!capital.equals("null-data")) {
            WebElement inputCapital = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + capital + "')]/following::*[@name='cvrLmtValueListInput' and not(@disabled='disabled')][1]")));
            String textCapital = readExcel("modificar_autos_flotillas", 1, 2);
            inputCapital.click();
            inputCapital.clear();
            System.out.println("este es el dato de excel:"+textCapital);
            Util.press(manager.getDriver(), inputCapital, textCapital);
        }
        String checkCapital = readExcel("modificar_autos_flotillas", 0, 3);
        if (!checkCapital.equals("null-data")) {
            WebElement checkCapital1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + checkCapital + "')]/following::*[@name='chkCvrSlc' and not(@disabled='disabled')][1]")));
            checkCapital1.click();
        }
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(), 'Calcular')]");
        this.flotillasSuplementoUI.btnCalcular.isEnabled();
        this.flotillasSuplementoUI.btnCalcular.click();
        Util.explicitWait(10);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        this.flotillasSuplementoUI.selectRcTerceros.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        String varCot = this.flotillasSuplementoUI.cantidadCot.getAttribute("value");
        this.flotillasSuplementoUI.selectRcTerceros.click();
        ExcelData.writeJsonTemporalFlotillas1(varCot);
        WebElement inputCapital = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'RC Terceros')]/following::*[@name='cvrLmtValueListInput' and not(@disabled='disabled')][1]")));
        inputCapital.click();
        inputCapital.clear();
        Util.press(manager.getDriver(), inputCapital, "2500000 MXN");
        Util.explicitWait(5);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(), 'Calcular')]");
        this.flotillasSuplementoUI.btnCalcular.click();
        Util.explicitWait(10);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.flotillasSuplementoUI.selectRcTerceros.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        String varCot2 = this.flotillasSuplementoUI.cantidadCot.getAttribute("value");
        ExcelData.writeJsonTemporalFlotillas2(varCot2);
        String cotizacion = ExcelData.readJsonTemporal1Flotillas();
        String recotizacion = ExcelData.readJsonTemporal2Flotillas();
        Assert.assertNotEquals(cotizacion, recotizacion);
    }

    @ShotAfter(evidenceName = "Termino de emisión de autos flotillas")
    public void finModificacionDatosSuplemento() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@id='btnAcp']");
        this.flotillasSuplementoUI.btnAceptar.click();
        Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
        List<WebElement> modalErrorCot = manager.getDriver().findElements(By.xpath("//*[contains(text(),'Continuar Emisión')]"));
        int countError = modalErrorCot.size();
        if (countError > 0) {
            WebElement emisionError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Continuar Emisión')]")));
            emisionError.click();
        }
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::*[@class='btn-navigation-label ng-binding'][last()]/ancestor::*[@accesskey='S']");

        // Neto
        Util.explicitWait(1);
        if(Util.webElementIsEnabled(10,manager.getDriver(),this.flotillasSuplementoUI.btnObservacionContinuarEmision)){
            Util.explicitWait(1);
            this.flotillasSuplementoUI.btnObservacionContinuarEmision.click();
            System.out.println("Se encontro la ventana emergente");
        }// Neto

        this.flotillasSuplementoUI.btnSiguienteCotizacionFinal.click();
        Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
    }

    @ShotAfter(evidenceName = "Emisión flotillas")
    public void capturarObservacionesSuplemento(){
        /**String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
         int segundEsp = Integer.parseInt(segundosEspera);
         WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
         Util.scrollToElement(manager.getDriver(), "//*[@id='pmsVal']");
         this.loginUI.inputPlanPago.clear();
         this.loginUI.inputPlanPago.sendKeys("1");
         Util.tab(manager.getDriver());
         Util.explicitWait(2);
         Util.pageStatus(manager.getDriver());
         Util.explicitWait(2);
         this.loginUI.btnAceptarEmision.click();
         Util.explicitWait(2);
         Util.pageStatus(manager.getDriver());
         Util.explicitWait(2);**/
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.flotillasSuplementoUI.textAreaObservaciones.sendKeys("PRUEBA DE ENDOSO DE ADICION DE AUTO");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/fieldset/div/div/div/div/div[2]/div[2]/div/div[2]/fieldset/div/div[2]/div/div/div/div/ul/li[4]/a");
        this.flotillasSuplementoUI.btnFinalizarEmision2.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

        this.flotillasSuplementoUI.selectMotiSuplemento.click();
        Util.explicitWait(2);

        Util.scrollToElement(manager.getDriver(),"//div[@ui-view='plyIurCrtWrkRunSetV_view']//u[contains(text(),'A')]");

        this.flotillasSuplementoUI.checkSelectSuplemento.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

        this.flotillasSuplementoUI.btnAcceptSuplemento.click();
        Util.explicitWait(4);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        Util.scrollToElement(manager.getDriver(), "//*[@class='ng-binding']/u[contains(text(),'F')]");
        this.flotillasSuplementoUI.btnFinalizarEmision.click();
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        List<WebElement> errorEmision = manager.getDriver().findElements(By.xpath("//*[contains(text(),'Continuar Emisión')]"));
        int countError1 = errorEmision.size();
        if (countError1 > 0) {
            WebElement emisionError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Continuar Emisión')]")));
            emisionError.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/descendant::label[1]")));
        this.flotillasSuplementoUI.labelNoEmision.isEnabled();
        String noPoliza = this.flotillasSuplementoUI.labelNoEmision.getText();
        String noPoliza1 = noPoliza.replace("PROCESO DE GRABACIÓN TERMINADO CON ÉXITO[1-", "");
        String noPoliza2 = noPoliza1.replace("-1-0-0]","");
        ExcelData.writeJson("PolizaSuplementoFlotillas", noPoliza2);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Salir Modificacion de polizas")
    public void finModificacionAutoFlotillas() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.flotillasSuplementoUI.btnAceptarModal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'alir')]");
        this.flotillasSuplementoUI.btnSalir.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }
}
