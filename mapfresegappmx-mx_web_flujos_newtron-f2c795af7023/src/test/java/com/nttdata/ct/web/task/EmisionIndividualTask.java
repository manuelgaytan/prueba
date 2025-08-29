package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.evidence.aspect.method.ShotBefore;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.IndividualCambioPlacasUI;
import com.nttdata.ct.web.ui.IndividualUI;
import com.nttdata.ct.web.ui.LoginUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static com.nttdata.ct.web.task.ExcelData.readExcel;
import static com.nttdata.ct.web.task.ExcelData.readExcelRec;

@Task
public class EmisionIndividualTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    private IndividualUI individualUI;

    @Autowired
    private LoginUI loginUI;
    @Autowired
    private IndividualCambioPlacasUI individualCambioPlacasUI;

    @ShotAfter(evidenceName = "informacion Basica de autos individual")
    public void primerPantalla() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualUI.selectEmision.click();
        Util.explicitWait(4);
        this.individualUI.btnEmiPoli.click();
        Util.pageStatus(manager.getDriver());
        this.individualUI.btnAutoIndi.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        this.individualUI.btnAcceptIB.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
    }
    @ShotAfter(evidenceName = "informacion General de autos individual")
    public void primerPantalla2() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"plyGniW_crnVal\"]")));
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"plyGniW\"]/div[2]/div/ul/li[2]/a/label/span/..");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"plyGniW\"]/div[2]/div/ul/li[2]/a")));
        Util.waitDataIsNotVisibleInput(manager.getDriver(), "//*[@id=\"plyGniW\"]/div[2]/div/ul/li[2]/a[@class=\"btn btn-infoVal\" and @disabled=\"disabled\"]");
        this.individualUI.btnAcceptIG.isEnabled();
        this.individualUI.btnAcceptIG.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "informacion Coaseguro de autos individual")
    public void primerPantalla3() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Coaseguro')]");
        this.individualUI.selectCoaseguro.isEnabled();
        this.individualUI.selectCoaseguro.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(), 'Tomador')]");
        this.individualUI.selectTomador.click();
        Util.explicitWait(4);
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "informacion Basica de autos individual")
    public void primerPantalla4(String tipoDocumento, String rfcUsuario) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"plyInePlhW_thpDcmTypVal\"]")));
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"plyInePlhW_thpDcmTypVal\"]");
        Util.tab(manager.getDriver());
        this.individualUI.inputTipDocRFC.sendKeys(tipoDocumento);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.individualUI.inputDocRFCUser.sendKeys(rfcUsuario);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualUI.btnAcceptTom.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "informacion Basica de autos individual")
    public void primerPantalla5(String codigoTercero, String cuadCom, String codigoOficina) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualUI.selectAgente.click();
        Util.explicitWait(2);
        this.individualUI.inputCodTer.sendKeys(codigoTercero);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.individualUI.inputCuadCom.sendKeys(cuadCom);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id='plyInaSetW_thrLvlVal']");
        this.individualUI.inputCodOfic.sendKeys(codigoOficina);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id='plyInaSetW_thrLvlVal']");
    }
    @ShotAfter(evidenceName = "informacion Intervinientes de autos individual")
    public void primerPantalla6() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualUI.btnAcceptAgent.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id='app-content-container']/div/div/div[3]/div/div/div[1]/div/div/div[6]/div[1]/h4/a");
        this.individualUI.selectIntervinentes.click();
        Util.explicitWait(4);
        Util.tab(manager.getDriver());
    }

    @ShotAfter(evidenceName = "informacion Atributos Poli de autos individual")
    public void primerPantalla7() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@id='app-content-container']/descendant::*[contains(text(),'Atributos póliza')]");
        this.individualUI.selectAtributPoli.click();
        Util.explicitWait(4);
        Util.tab(manager.getDriver());
        this.individualUI.inputCodProduct.sendKeys("2");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id='plyAtrSetW']/descendant::span[last()]/..");
        Util.pageStatus(manager.getDriver());
        this.individualUI.btnAcceptAPoli.click();
        Util.waitWebElementIsEnabled(30, manager.getDriver(), this.individualUI.btnSiguiente); // Mantenimiento Ernesto
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualUI.btnSiguiente.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Cotización de autos individual")
    public void segundaPantalla(String codAmbCirculacion, String codTipoVehi, String tipoIndemnizacion, String codMarca, String codModelo, String codSubModelo, String anioSubModelo, String codUsoVehiculo, String codModalidad) {
        this.individualUI.btnSiguienteGlobal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.btnAddFila.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.selectTipoBen.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.optionTpoBen.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.btnGuardarInterviniente.isEnabled();
        Util.scrollToElement(manager.getDriver(), "//*[@id='saveBtn']/..");
        Util.clicActions(manager.getDriver(), "//*[@id='saveBtn']");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id='btnNxt']");
        this.individualUI.btnSiguienteGlobal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.inputAmbCirculacion.sendKeys(codAmbCirculacion);
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
        this.individualUI.inputNumSerie.sendKeys(vin);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        this.individualUI.inputCodTipVehi.sendKeys(codTipoVehi);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.inputTipoIndemnizacion.sendKeys(tipoIndemnizacion);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.inputCodMarca.sendKeys(codMarca);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.inputCodModelo.sendKeys(codModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.inputCodSubModelo.sendKeys(codSubModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.inputAnioSubModelo.sendKeys(anioSubModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.inputCodUsoVehi.sendKeys(codUsoVehiculo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        String numPlaca = numero2 + numero3;
        this.individualCambioPlacasUI.inputCambioPlca.sendKeys(numPlaca);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.individualUI.inputCodModalidad.sendKeys(codModalidad);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualUI.btnAceptarAtributos.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.enter(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Emisión de autos individual")
    public void datosModificar() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualUI.btnSiguienteGlobal.isEnabled();
        this.individualUI.btnSiguienteGlobal.click();
        Util.explicitWait(6);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
//        String franquicia = readExcel("data_autos", 0, 1);
//        if (!franquicia.equals("null-data")) {
//            WebElement inputFranquicia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + franquicia + "')]/following::*[@name='cvrDctValueListInput' and not(@disabled='disabled')][1]")));
//            String textFranquicia = readExcel("data_autos", 1, 1);
//            inputFranquicia.click();
//            inputFranquicia.clear();
//            Util.press(manager.getDriver(), inputFranquicia, textFranquicia);
////            inputFranquicia.sendKeys(textFranquicia);
//        }
        String capital = readExcel("data_autos", 0, 2);
        if (!capital.equals("null-data")) {
            WebElement inputCapital = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + capital + "')]/following::*[@name='cvrLmtValueListInput' and not(@disabled='disabled')][1]")));
            String textCapital = readExcel("data_autos", 1, 2);
            inputCapital.click();
            inputCapital.clear();
            System.out.println("este es el dato de excel:"+textCapital);
            Util.press(manager.getDriver(), inputCapital, textCapital);
        }
        String checkCapital = readExcel("data_autos", 0, 3);
        if (!checkCapital.equals("null-data")) {
            WebElement checkCapital1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + checkCapital + "')]/following::*[@name='chkCvrSlc' and not(@disabled='disabled')][1]")));
            checkCapital1.click();
        }
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(), 'Calcular')]");
        this.individualUI.btnCalcular.isEnabled();
        this.individualUI.btnCalcular.click();
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement2(manager.getDriver(),individualUI.selectRcTerceros);
        this.individualUI.selectRcTerceros.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        String varCot = this.individualUI.cantidadCot.getAttribute("value");
        this.individualUI.selectRcTerceros.click();
        ExcelData.writeJsonTemporal1(varCot);
        WebElement inputCapital = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'RC Terceros')]/following::*[@name='cvrLmtValueListInput' and not(@disabled='disabled')][1]")));
        inputCapital.click();
        inputCapital.clear();
        Util.press(manager.getDriver(), inputCapital, "2000000 MXN");
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(), 'Calcular')]");
        this.individualUI.btnCalcular.click();
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualUI.selectRcTerceros.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        String varCot2 = this.individualUI.cantidadCot.getAttribute("value");
        ExcelData.writeJsonTemporal2(varCot2);
        String cotizacion = ExcelData.readJsonTemporal1();
        String recotizacion = ExcelData.readJsonTemporal2();
        Assert.assertNotEquals(cotizacion, recotizacion);
    }
    @ShotAfter(evidenceName = "Termino de emisión de autos individual")
    public void datosModificar2() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@id='btnAcp']");
        this.individualUI.btnAceptar.click();
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        List<WebElement> modalErrorCot = manager.getDriver().findElements(By.xpath("//*[contains(text(),'Continuar Emisión')]"));
        int countError = modalErrorCot.size();
        if (countError > 0) {
            WebElement emisionError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Continuar Emisión')]")));
            emisionError.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/descendant::*[@class='btn-navigation-label ng-binding'][last()]/ancestor::*[@accesskey='S']")));
        Util.scrollToElement(manager.getDriver(), "//body/descendant::*[@class='btn-navigation-label ng-binding'][last()]/ancestor::*[@accesskey='S']");
        this.individualUI.btnSiguienteCotizacionFinal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotBefore(evidenceName = "Ingresamos Credenciales UAT")
    @ShotAfter(evidenceName = "Inicio de sesión UAT hecho correctamente")
    public void ingresoCredencialesCotEmi() {
        ArrayList<WebElement> elementos = (ArrayList<WebElement>) manager.getDriver().findElements(By.xpath("//input"));
        System.out.println("Número de elementos: " + elementos.size());
        Util.pageStatus(manager.getDriver());
        String user = readExcel("dataWebAutomoviles", 2, 0);
        this.loginUI.inputUser.clear();
        Util.explicitWait(1);
        this.loginUI.inputUser.sendKeys(user);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.loginUI.buttonLogin.click();
        String pass = readExcel("dataWebAutomoviles", 3, 0);
        //this.loginUI.inputPassword.clear();
        Util.explicitWait(2);
        this.loginUI.inputPassword.sendKeys("Mapfre_345_poi");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.loginUI.buttonLogin.click();
        Util.explicitWait(4);
        try{
            WebDriverWait wai = new WebDriverWait(manager.getDriver(),Duration.ofSeconds(5));
            wai.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Quiere mantener la ses') or contains(text(),'Stay signed in')]")));
            this.loginUI.buttonLogin.click();
        }catch (Exception ex){
            System.out.println("No aparece mensaje Mantener Sesión Abierta");
        }

        Util.pageStatus(manager.getDriver());

    }

    @ShotBefore(evidenceName = "Ingresamos Credenciales REC")
    @ShotAfter(evidenceName = "Inicio de sesión REC hecho correctamente")
    public void ingresoCredencialesCotEmiREC() {
        Util.pageStatus(manager.getDriver());
        String user = readExcel("dataWebREC", 2, 0);
        this.loginUI.inputUser.sendKeys(user);
        String pass = readExcel("dataWebREC", 3, 0);
        this.loginUI.inputPassword.sendKeys(pass);

        Util.explicitWait(2);
        //String user = readExcelRec("dataWebAutomovilesRec", 2, 0);
        this.loginUI.inputUser.sendKeys("ORHERRER@mapfre.net");
        this.loginUI.buttonLogin.click();
        Util.explicitWait(4);
        //String pass = readExcelRec("dataWebAutomovilesRec", 3, 0);
        this.loginUI.inputPassword.sendKeys(pass);
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.loginUI.buttonLogin.click();
        Util.explicitWait(3);
        Util.pageStatus(manager.getDriver());
        this.loginUI.buttonLogin.click();
        Util.explicitWait(6);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
    }



    @ShotAfter(evidenceName = "Emisión individual")
    public void emisionIndividual() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        Util.scrollToElement(manager.getDriver(), "//*[@id='pmsVal']");
        this.individualUI.inputPlanPago.clear();
        this.individualUI.inputPlanPago.sendKeys("1");
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualUI.btnAceptarEmision.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualUI.textAreaObservaciones.sendKeys("MENSAJE DE PRUEBA");
        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::label[@class='textSm'][last()]/span");
        this.individualUI.btnAceptarEmisionFinal.click();
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        Util.scrollToElement(manager.getDriver(), "//*[@class='ng-binding']/u[contains(text(),'F')]");
        this.individualUI.btnFinalizarEmision.click();
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        List<WebElement> modalErrorCot = manager.getDriver().findElements(By.xpath("//*[contains(text(),'Continuar Emisión')]"));
        int countError = modalErrorCot.size();
        if (countError > 0) {
            WebElement emisionError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Continuar Emisión')]")));
            emisionError.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/descendant::label[1]")));
        this.individualUI.labelNoEmision.isEnabled();
        String noPoliza = this.individualUI.labelNoEmision.getText();
        String noPolizaUno = noPoliza.replace("PROCESO DE GRABACIÓN TERMINADO CON ÉXITO[1-", "");
        String noPoliza1 = noPolizaUno.replace("-0-0-0]","");
        String noPoliza2 = noPoliza1.replace("PÓLIZA RETENIDA[1-","");
        ExcelData.writeJsonIndividual(noPoliza2);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "Emisión individual 2")
    public void emisionIndividual2() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualUI.btnAceptarModal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'alir')]");
        this.individualUI.btnSalir.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

    @ShotBefore(evidenceName = "Ingresamos Credenciales en Recepción")
    @ShotAfter(evidenceName = "Inicio de sesión hecho correctamente en recepción")
    public void ingresoCredencialesCotEmiRec() {
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        String user = readExcelRec("dataWebAutomovilesRec", 2, 0);
        this.loginUI.inputUser.clear();
        Util.pageStatus(manager.getDriver());
        this.loginUI.inputUser.sendKeys("ORHERRER@mapfre.net");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.loginUI.buttonLogin.click();
        String pass = readExcel("dataWebAutomoviles", 3, 0);
        this.loginUI.inputPassword.clear();
        Util.explicitWait(1);
        this.loginUI.inputPassword.sendKeys("Mapfre_345_ser");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.loginUI.buttonLogin.click();
        Util.explicitWait(4);
        try{
            WebDriverWait wai = new WebDriverWait(manager.getDriver(),Duration.ofSeconds(5));
            wai.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Quiere mantener la ses') or contains(text(),'Stay signed in')]")));
            this.loginUI.buttonLogin.click();
        }catch (Exception ex){
            System.out.println("No aparece mensaje Mantener Sesión Abierta");
        }

        Util.pageStatus(manager.getDriver());
    }

}
