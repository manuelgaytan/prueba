package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.evidence.aspect.method.ShotBefore;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.IndividualPresupuestoUI;
import com.nttdata.ct.web.ui.LoginUI;
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
public class AutomovilesPresupuestoTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    private IndividualPresupuestoUI individualPresupuestoUI;

    @Autowired
    private LoginUI loginUI;

    @ShotAfter(evidenceName = "informacion Basica de autos individual")
    public void primerPantalla() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualPresupuestoUI.selectEmision.click();
        Util.explicitWait(4);
        this.individualPresupuestoUI.btnEmiPres.click();
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.btnAutoIndi.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        Util.tab(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//span[text()='Información Básica']/following::u[contains(text(),'A')][1]");
//        this.individualPresupuestoUI.btnAcceptIB.click();
        Util.clicJavascript(manager.getDriver(), "//*[@name='gppVal']");
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.clicActions(manager.getDriver(), "//span[text()='Información Básica']/following::u[contains(text(),'A')][1]");
//        Util.tripleClic(manager.getDriver(), "//span[text()='Información Básica']/following::u[contains(text(),'A')][1]");
//        this.individualPresupuestoUI.btnAceptarLupa.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
    }
    @ShotAfter(evidenceName = "informacion General de autos individual")
    public void primerPantalla2() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.lupa1.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.optionMoneda.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.btnAceptarLupa.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
//        Util.scrollToElement(manager.getDriver(), "//*[@nwt-unique-id='00J']");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@nwt-unique-id='00J']")));
//        Util.tab(manager.getDriver());
//        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//span[@class=\"ng-scope ng-binding\" and text()='Información General']/following::u[contains(text(),'A')][1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"ng-scope ng-binding\" and text()='Información General']/following::u[contains(text(),'A')][1]")));
        this.individualPresupuestoUI.btnAcceptIG.isEnabled();
        this.individualPresupuestoUI.btnAcceptIG.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "informacion Coaseguro de autos individual")
    public void primerPantalla3() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@class='ng-scope ng-binding' and contains(text(),'Coaseguro')]");
        this.individualPresupuestoUI.selectCoaseguro.isEnabled();
        this.individualPresupuestoUI.selectCoaseguro.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(), 'Tomador')]");
        this.individualPresupuestoUI.selectTomador.click();
        Util.explicitWait(4);
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "informacion tomador individual")
    public void primerPantalla4(String tipoDocumento, String rfcUsuario) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//body/descendant::*[@id=\"thpDcmTypVal\"][1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/descendant::*[@id=\"thpDcmTypVal\"][1]")));
        Util.tab(manager.getDriver());
        this.individualPresupuestoUI.inputTipDocRFC.sendKeys(tipoDocumento);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.individualPresupuestoUI.inputDocRFCUser.sendKeys(rfcUsuario);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.btnAcceptTom.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "informacion Basica de autos individual")
    public void primerPantalla5(String codigoTercero, String cuadCom, String codigoOficina, String codigoFuenteDist) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualPresupuestoUI.selectAgente.click();
        Util.explicitWait(2);
//        "//*[contains(text(),'Agente principal')]/following::*[@class=\"btn btn-default btn-icon-textless-search ng-isolate-scope\"][1]"
        this.individualPresupuestoUI.inputCodTer.sendKeys(codigoTercero);
       Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.inputCuadCom.sendKeys(cuadCom);
        Util.tab(manager.getDriver());  //Neto
        Util.scrollToElement(manager.getDriver(), "//span[contains(text(),'Agente')]");
        Util.explicitWait(2);
//        this.individualPresupuestoUI.lupa2.click();
//        Util.pageStatus(manager.getDriver());
//        Util.explicitWait(2);
//        this.individualPresupuestoUI.optionCuadCom.click();
//        Util.pageStatus(manager.getDriver());
//        Util.explicitWait(2);
//        this.individualPresupuestoUI.btnAceptarLupa.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//span[contains(text(),'Agente')]");
        this.individualPresupuestoUI.inputCodOfic.sendKeys(codigoOficina);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.lupa3.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.optionCodOficina.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.btnAceptarLupa.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//span[contains(text(),'Agente')]");
        this.individualPresupuestoUI.inputFuenteDist.sendKeys(codigoFuenteDist);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.lupa4.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.optionFuenteDist.click();
        Util.explicitWait(2);
        this.individualPresupuestoUI.btnAceptarLupa.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "informacion Intervinientes de autos individual")
    public void primerPantalla6() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualPresupuestoUI.btnAcceptAgent.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//span[contains(text(),'Intervinientes')]");
        this.individualPresupuestoUI.selectIntervinentes.click();
        Util.explicitWait(4);
        Util.tab(manager.getDriver());
    }

    @ShotAfter(evidenceName = "informacion Atributos Poliza de autos individual")
    public void primerPantalla7() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@id='app-content-container']/descendant::*[contains(text(),'Atributos póliza')]");
        this.individualPresupuestoUI.selectAtributPoli.click();
        Util.explicitWait(4);
        Util.tab(manager.getDriver());
        this.individualPresupuestoUI.inputCodProduct.sendKeys("2");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id='app-content-container']/descendant::*[contains(text(),'Atributos póliza')]/following::u[contains(text(),'A')][1]");
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.btnAcceptAPoli.click();
        Util.waitWebElementIsEnabled(30, manager.getDriver(), this.individualPresupuestoUI.btnSiguiente); //Neto
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.btnSiguiente.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Cotización de autos individual")
    public void segundaPantalla(String codAmbCirculacion, String codTipoVehi, String tipoIndemnizacion, String codMarca, String codModelo, String codSubModelo, String anioSubModelo, String codUsoVehiculo, String codModalidad) {
        this.individualPresupuestoUI.btnSiguienteGlobal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.btnAddFila.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.selectTipoBen.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.optionTpoBen.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.btnGuardarInterviniente.isEnabled();
        Util.scrollToElement(manager.getDriver(), "//*[@id='saveBtn']/..");
        Util.clicActions(manager.getDriver(), "//*[@id='saveBtn']");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id='btnNxt']");
        this.individualPresupuestoUI.btnSiguienteGlobal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.inputAmbCirculacion.sendKeys(codAmbCirculacion);
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
        this.individualPresupuestoUI.inputNumSerie.sendKeys(vin);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        this.individualPresupuestoUI.inputCodTipVehi.sendKeys(codTipoVehi);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.inputTipoIndemnizacion.sendKeys(tipoIndemnizacion);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.inputCodMarca.sendKeys(codMarca);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.inputCodModelo.sendKeys(codModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.inputCodSubModelo.sendKeys(codSubModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.inputAnioSubModelo.sendKeys(anioSubModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.inputCodUsoVehi.sendKeys(codUsoVehiculo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.inputCodModalidad.sendKeys(codModalidad);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"TRANSACTION_ID\"]/following::span[2]/..");  //Neto
        this.individualPresupuestoUI.btnAceptarAtributos.click();
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
        this.individualPresupuestoUI.btnSiguienteGlobal.isEnabled();
        this.individualPresupuestoUI.btnSiguienteGlobal.click();
        Util.explicitWait(6);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
//        manager.getDriver().switchTo().frame("frmPrincipal");
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
        this.individualPresupuestoUI.btnCalcular.isEnabled();
        this.individualPresupuestoUI.btnCalcular.click();
        Util.explicitWait(10);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.selectRcTerceros.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        String varCot = this.individualPresupuestoUI.cantidadCot.getAttribute("value");

        this.individualPresupuestoUI.selectRcTerceros.click();
        ExcelData.writeJsonTemporal1(varCot);
        WebElement inputCapital = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'RC Terceros')]/following::*[@name='cvrLmtValueListInput' and not(@disabled='disabled')][1]")));
        inputCapital.click();
        inputCapital.clear();
        Util.press(manager.getDriver(), inputCapital, "2000000 MXN");
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(), 'Calcular')]");
        this.individualPresupuestoUI.btnCalcular.click();
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.selectRcTerceros.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        String varCot2 = this.individualPresupuestoUI.cantidadCot.getAttribute("value");
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
        this.individualPresupuestoUI.btnAceptar.click();
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::*[@class='btn-navigation-label ng-binding'][last()]/ancestor::*[@accesskey='S']");
        this.individualPresupuestoUI.btnSiguienteCotizacionFinal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotBefore(evidenceName = "Ingresamos Credenciales")
    @ShotAfter(evidenceName = "Inicio de sesión hecho correctamente")
    public void ingresoCredencialesCotEmi() {
        Util.pageStatus(manager.getDriver());
        String user = readExcel("dataWebAutomoviles", 2, 0);
        this.loginUI.inputUser.sendKeys(user);
        String pass = readExcel("dataWebAutomoviles", 3, 0);
        this.loginUI.inputPassword.sendKeys(pass);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.loginUI.buttonLogin.click();
        Util.explicitWait(4);
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Emisión individual")
    public void emisionIndividual() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@id='pmsVal']");
//        this.individualPresupuestoUI.inputPlanPago.clear();
//        this.individualPresupuestoUI.inputPlanPago.sendKeys("1");
//        Util.tab(manager.getDriver());
        Util.scrollTopPage(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//body/descendant::*[@class=\"btn btn-default btn-icon-textless-search ng-isolate-scope\"][1]");
        Util.explicitWait(2);
        Util.scrollTopPage(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.lupaPlanPago.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.optionPago.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.aceptarPago.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualPresupuestoUI.btnAceptarEmision.click();
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        List<WebElement> modalErrorCot = manager.getDriver().findElements(By.xpath("//*[contains(text(),'Continuar Emisión')]"));
        int countError = modalErrorCot.size();
        if (countError > 0) {
            WebElement emisionError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Continuar Emisión')]")));
            emisionError.click();
        }
        Util.explicitWait(2);
//        List<WebElement> elementVisible = driver.findElements(By.xpath(element));
//        int elementVisible1 = elementVisible.size();
//        if(elementVisible1 < 1) {
//
//        }
        this.individualPresupuestoUI.textAreaObservaciones.sendKeys("MENSAJE DE PRUEBA");
        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::label[@class='textSm'][last()]/span");
        this.individualPresupuestoUI.btnAceptarEmisionFinal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@class='ng-binding']/u[contains(text(),'F')]");
        this.individualPresupuestoUI.btnFinalizarEmision.click();
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
        this.individualPresupuestoUI.labelNoEmision.isEnabled();
        String noPoliza = this.individualPresupuestoUI.labelNoEmision.getText();
        String noPolizaUno = noPoliza.replace("PROCESO DE GRABACIÓN TERMINADO CON ÉXITO[1-", "");
        String noPoliza1 = noPolizaUno.replace("-0-0-0]","");
        String noPoliza2 = noPoliza1.replace("PÓLIZA RETENIDA[1-","");
        ExcelData.writeJsonPresupuesto(noPoliza2);
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Emisión individual 2")
    public void emisionIndividual2() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualPresupuestoUI.btnAceptarModal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'alir')]");
        this.individualPresupuestoUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Emisión presupuesto validada correctamente")
    public void consultaPresupuesto() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//body/descendant::*[text()='Emisión'][1]");
        Util.scrollTopPage(manager.getDriver());
        this.individualPresupuestoUI.selectEmision.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.selectGestionPropuestas.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        String polizaPresupuesto = ExcelData.readJsonPresupuesto();
        this.individualPresupuestoUI.inputGestionPresupuesto.sendKeys(polizaPresupuesto);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualPresupuestoUI.btnBuscarGestionPresupuesto.click();
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(20);
//        Util.waitSpinner(manager.getDriver(), 15);
        Util.explicitWait(1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Iniciar']")));
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'"+polizaPresupuesto+"')]");
    }

}
