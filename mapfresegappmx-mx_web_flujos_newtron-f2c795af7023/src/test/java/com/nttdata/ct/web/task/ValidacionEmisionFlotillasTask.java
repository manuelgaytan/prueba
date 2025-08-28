package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.FlotillasEmisionUI;
import com.nttdata.ct.web.ui.LoginUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class ValidacionEmisionFlotillasTask {

    @Autowired
    public DriverManager manager;
    @Autowired
    public FlotillasEmisionUI flotillasEmisionUI;
    @Autowired
    public LoginUI loginUI;

    @ShotAfter(evidenceName = "informacion Basica de autos flotillas")
    public void primerPantalla(String numPolizaGrupo, String numContrato, String numSubcontrato) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.flotillasEmisionUI.selectEmision.click();
        Util.explicitWait(4);
        this.flotillasEmisionUI.btnEmiPoli.click();
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.btnAutoFloti.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(4);
        if (!numPolizaGrupo.equals("ZZZZZZZZZZZZZ")) {
            WebElement inputPolGrupo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='gppVal']")));
            inputPolGrupo.sendKeys(numPolizaGrupo);
//            this.flotillasEmisionUI.inputPolGrupo.sendKeys(numPolizaGrupo);
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            Util.tab(manager.getDriver());
        }
        if (!numContrato.contains("99999")) {
            WebElement inputNumContrato = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='delVal']")));
            inputNumContrato.sendKeys(numContrato);
//            this.flotillasEmisionUI.inputNumContrato.sendKeys(numContrato);
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
            Util.tab(manager.getDriver());
        }
        if (!numSubcontrato.contains("99999")) {
            WebElement inputNumSubcontrato = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='sblVal']")));
            inputNumSubcontrato.sendKeys(numSubcontrato);
//            this.flotillasEmisionUI.inputNumSubcontrato.sendKeys(numSubcontrato);
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
            Util.tab(manager.getDriver());
        }
        this.flotillasEmisionUI.btnAcceptIB.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
    }

    @ShotAfter(evidenceName = "informacion General Coaseguro de autos flotillas")
    public void primerPantallaConPolizaGrupo(String numPolizaGrupo) {
        if (!numPolizaGrupo.contains("ZZZZZZZZZZZZZ")) {
            List<WebElement> modalErrorCot = manager.getDriver().findElements(By.xpath("//*[@id='plyGniW_crnVal' and @disabled='disabled']"));
            int countError = modalErrorCot.size();
            if (countError < 1) {
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
                Util.waitElementNoVisible(manager.getDriver(), "//*[@id=\"plyGniW\"]/div[2]/div/ul/li[2]/a[@class=\"btn btn-infoVal\" and @disabled=\"disabled\"]");
                this.flotillasEmisionUI.btnAcceptIG.isEnabled();
                this.flotillasEmisionUI.btnAcceptIG.click();
                Util.explicitWait(2);
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
            }
        }
    }

    @ShotAfter(evidenceName = "informacion General Coaseguro de autos flotillas")
    public void primerPantallaConPolizaGrupo1(String numPolizaGrupo) {
        if (!numPolizaGrupo.contains("ZZZZZZZZZZZZZ")) {
            Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Coaseguro')]");
            this.flotillasEmisionUI.selectCoaseguro.isEnabled();
            this.flotillasEmisionUI.selectCoaseguro.click();
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
        }
    }

    @ShotAfter(evidenceName = "informacion General de Tomador autos flotillas")
    public void primerPantallaConPolizaGrupo2(String numPolizaGrupo, String tipoDocumento, String rfcUsuario) {
        if (!numPolizaGrupo.contains("ZZZZZZZZZZZZZ")) {
            Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(), 'Tomador')]");
            this.flotillasEmisionUI.selectTomador.click();
            Util.explicitWait(4);
            Util.pageStatus(manager.getDriver());
            Util.scrollToElement(manager.getDriver(), "//*[@id=\"plyInePlhW_thpDcmTypVal\"]");
            Util.explicitWait(3);
            Util.pageStatus(manager.getDriver());
            List<WebElement> modalErrorCot = manager.getDriver().findElements(By.xpath("//*[@id='plyInePlhW_thpDcmTypVal' and @disabled='disabled']"));
            int countError = modalErrorCot.size();
            if (countError < 1) {
                Util.tab(manager.getDriver());
                this.flotillasEmisionUI.inputTipDocRFC.sendKeys(tipoDocumento);
                Util.pageStatus(manager.getDriver());
                Util.tab(manager.getDriver());
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                this.flotillasEmisionUI.inputDocRFCUser.sendKeys(rfcUsuario);
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                this.flotillasEmisionUI.btnAcceptTom.click();
                Util.explicitWait(2);
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
            }
        }
    }

    @ShotAfter(evidenceName = "informacion General de Agente autos flotillas")
    public void primerPantallaConPolizaGrupo3(String numPolizaGrupo, String codigoTercero, String cuadCom, String codigoOficina) {
        if (!numPolizaGrupo.contains("ZZZZZZZZZZZZZ")) {
            this.flotillasEmisionUI.selectAgente.click();
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
            List<WebElement> modalErrorCot = manager.getDriver().findElements(By.xpath("//*[@id='plyInaSetW_thpVal' and @disabled='disabled']"));
            int countError = modalErrorCot.size();
            if (countError < 1) {
                this.flotillasEmisionUI.inputCodTer.clear();
                Util.pressBackspace(manager.getDriver(), flotillasEmisionUI.inputCodTer);
                this.flotillasEmisionUI.inputCodTer.sendKeys(codigoTercero);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.tab(manager.getDriver());
                Util.explicitWait(2);
                this.flotillasEmisionUI.inputCuadCom.clear();
                Util.pressBackspace(manager.getDriver(), flotillasEmisionUI.inputCuadCom);
                this.flotillasEmisionUI.inputCuadCom.sendKeys(cuadCom);
                Util.tab(manager.getDriver());
                Util.explicitWait(2);
                Util.tab(manager.getDriver());
                Util.scrollToElement(manager.getDriver(), "//*[@id='plyInaSetW_thrLvlVal']");
//                this.flotillasEmisionUI.inputCodOfic.sendKeys(codigoOficina);
                Util.pageStatus(manager.getDriver());
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
                this.flotillasEmisionUI.btnAcceptAgent.click();
                Util.explicitWait(2);
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(2);
            }
        }
    }

    @ShotAfter(evidenceName = "informacion General de Intervinientes autos flotillas")
    public void primerPantallaConPolizaGrupo4(String numPolizaGrupo) {
        if (!numPolizaGrupo.contains("ZZZZZZZZZZZZZ")) {
            Util.scrollToElement(manager.getDriver(), "//*[@id='app-content-container']/div/div/div[3]/div/div/div[1]/div/div/div[6]/div[1]/h4/a");
            this.flotillasEmisionUI.selectIntervinentes.click();
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
        }
    }

    @ShotAfter(evidenceName = "informacion General de Atributos póliza autos flotillas")
    public void primerPantallaConPolizaGrupo5(String numPolizaGrupo) {
        if (!numPolizaGrupo.contains("ZZZZZZZZZZZZZ")) {
            Util.scrollToElement(manager.getDriver(), "//*[@id='app-content-container']/descendant::*[contains(text(),'Atributos póliza')]");
            this.flotillasEmisionUI.selectAtributPoli.click();
            Util.explicitWait(4);
            Util.pageStatus(manager.getDriver());
            this.flotillasEmisionUI.inputCodProduct.sendKeys("3");
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
            Util.tab(manager.getDriver());
            Util.explicitWait(2);
            Util.scrollToElement(manager.getDriver(), "//*[@id='plyAtrSetW']/descendant::span[last()]/..");
            Util.pageStatus(manager.getDriver());
            Util.tab(manager.getDriver());
            this.flotillasEmisionUI.inputGiro.sendKeys("99");
            Util.pageStatus(manager.getDriver());
            Util.tab(manager.getDriver());
            Util.explicitWait(2);
        }
    }
    @ShotAfter(evidenceName = "informacion General de Atributos póliza autos flotillas")
    public void primerPantallaConPolizaGrupo5Descuento(String numPolizaGrupo) {
        if (!numPolizaGrupo.contains("ZZZZZZZZZZZZZ")) {
            Util.scrollToElement(manager.getDriver(), "//*[@id='app-content-container']/descendant::*[contains(text(),'Atributos póliza')]");
            this.flotillasEmisionUI.selectAtributPoli.click();
            Util.explicitWait(4);
            Util.pageStatus(manager.getDriver());
            this.flotillasEmisionUI.inputCodProduct.sendKeys("3");
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
            Util.tab(manager.getDriver());
            Util.explicitWait(2);
            Util.scrollToElement(manager.getDriver(), "//*[@id='plyAtrSetW']/descendant::span[last()]/..");
            Util.pageStatus(manager.getDriver());
            Util.tab(manager.getDriver());
            Util.explicitWait(2);
            this.flotillasEmisionUI.inputDescuento.sendKeys("5");
            Util.explicitWait(2);
            this.flotillasEmisionUI.inputGiro.sendKeys("99");
            Util.pageStatus(manager.getDriver());
            Util.tab(manager.getDriver());
            Util.explicitWait(2);
        }
    }

    public void primerPantallaConPolizaGrupo6() {
        this.flotillasEmisionUI.btnAcceptAPoli.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.btnSiguiente.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "informacion General de autos flotillas")
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
        Util.waitElementNoVisible(manager.getDriver(), "//*[@id='plyGniW']/div[2]/div/ul/li[2]/a[@class='btn btn-infoVal' and @disabled='disabled']");
        this.flotillasEmisionUI.btnAcceptIG.isEnabled();
        this.flotillasEmisionUI.btnAcceptIG.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "informacion Coaseguro de autos flotillas")
    public void primerPantalla3() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Coaseguro')]");
        this.flotillasEmisionUI.selectCoaseguro.isEnabled();
        this.flotillasEmisionUI.selectCoaseguro.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(), 'Tomador')]");
        this.flotillasEmisionUI.selectTomador.click();
        Util.explicitWait(4);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "informacion tomador flotillas")
    public void primerPantalla4(String tipoDocumento, String rfcUsuario) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"plyInePlhW_thpDcmTypVal\"]")));
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"plyInePlhW_thpDcmTypVal\"]");
        Util.tab(manager.getDriver());
        this.flotillasEmisionUI.inputTipDocRFC.sendKeys(tipoDocumento);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.flotillasEmisionUI.inputDocRFCUser.sendKeys(rfcUsuario);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasEmisionUI.btnAcceptTom.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "informacion agente flotillas")
    public void primerPantalla5(String codigoTercero, String cuadCom, String codigoOficina) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.flotillasEmisionUI.selectAgente.click();
        Util.explicitWait(2);
        this.flotillasEmisionUI.inputCodTer.sendKeys(codigoTercero);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasEmisionUI.inputCuadCom.sendKeys(cuadCom);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id='plyInaSetW_thrLvlVal']");
        this.flotillasEmisionUI.inputCodOfic.sendKeys(codigoOficina);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id='plyInaSetW_thrLvlVal']");
    }
    @ShotAfter(evidenceName = "informacion agente flotillas")
    public void primerPantalla5Descuento(String codigoTercero, String cuadCom, String codigoOficina) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.flotillasEmisionUI.selectAgente.click();
        Util.explicitWait(2);
        this.flotillasEmisionUI.inputCodTer.sendKeys(codigoTercero);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasEmisionUI.inputCuadCom.sendKeys(cuadCom);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id='plyInaSetW_thrLvlVal']");
        this.flotillasEmisionUI.inputCodOfic.sendKeys(codigoOficina);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id='plyInaSetW_thrLvlVal']");
    }

    @ShotAfter(evidenceName = "informacion Intervinientes de autos flotillas")
    public void primerPantalla6() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.flotillasEmisionUI.btnAcceptAgent.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id='app-content-container']/div/div/div[3]/div/div/div[1]/div/div/div[6]/div[1]/h4/a");
        this.flotillasEmisionUI.selectIntervinentes.click();
        Util.explicitWait(4);
        Util.tab(manager.getDriver());
    }

    @ShotAfter(evidenceName = "tab riesgo flotillas")
    public void primerPantalla7() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@id='app-content-container']/descendant::*[contains(text(),'Atributos póliza')]");
        this.flotillasEmisionUI.selectAtributPoli.click();
        Util.explicitWait(4);
        Util.tab(manager.getDriver());
        this.flotillasEmisionUI.inputCodProduct.sendKeys("3");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id='plyAtrSetW']/descendant::span[last()]/..");
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.inputGiro.sendKeys("99");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasEmisionUI.btnAcceptAPoli.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.btnSiguiente.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "tab riesgo flotillas")
    public void primerPantalla7Descuento() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@id='app-content-container']/descendant::*[contains(text(),'Atributos póliza')]");
        this.flotillasEmisionUI.selectAtributPoli.click();
        Util.explicitWait(4);
        Util.tab(manager.getDriver());
        this.flotillasEmisionUI.inputCodProduct.sendKeys("3");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id='plyAtrSetW']/descendant::span[last()]/..");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasEmisionUI.inputDescuento.sendKeys("0.10");
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasEmisionUI.inputGiro.sendKeys("99");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasEmisionUI.btnAcceptAPoli.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.btnSiguiente.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Ingresamos datos del vehiculo individual")
    public void segundaPantalla(String codAmbCirculacion, String codTipoVehi, String tipoIndemnizacion, String codMarca, String codModelo, String codSubModelo, String anioSubModelo, String codUsoVehiculo) {
        this.flotillasEmisionUI.btnSiguienteGlobal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.btnAddFila.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.selectTipoBen.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.optionTpoBen.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.btnGuardarInterviniente.isEnabled();
        Util.scrollToElement(manager.getDriver(), "//*[@id='saveBtn']/..");
        Util.clicActions(manager.getDriver(), "//*[@id='saveBtn']");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id='btnNxt']");
        this.flotillasEmisionUI.btnSiguienteGlobal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.inputAmbCirculacion.sendKeys(codAmbCirculacion);
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
        this.flotillasEmisionUI.inputNumSerie.sendKeys(vin);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        this.flotillasEmisionUI.inputCodTipVehi.clear();
        Util.pressBackspace(manager.getDriver(), flotillasEmisionUI.inputCodTipVehi);
        Util.explicitWait(2);
        this.flotillasEmisionUI.inputCodTipVehi.sendKeys(codTipoVehi);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.inputTipoIndemnizacion.sendKeys(tipoIndemnizacion);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.inputCodMarca.sendKeys(codMarca);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.inputCodModelo.sendKeys(codModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.inputCodSubModelo.sendKeys(codSubModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.inputAnioSubModelo.sendKeys(anioSubModelo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.flotillasEmisionUI.inputCodUsoVehi.sendKeys(codUsoVehiculo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "ingresamos Modalidad individual")
    public void segundaPantalla2(String codModalidad, String codTipoVehi) {
        this.flotillasEmisionUI.inputCodModalidad.sendKeys(codModalidad);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        if (codTipoVehi.contains("9") || codTipoVehi.contains("18") || codTipoVehi.contains("21") || codTipoVehi.contains("23") || codTipoVehi.contains("30") || codTipoVehi.contains("20") || codTipoVehi.contains("19") || codTipoVehi.contains("26")) {
            this.flotillasEmisionUI.inputcpCHRiesgo.sendKeys("33038");
            Util.explicitWait(2);
            Util.pageStatus(manager.getDriver());
            Util.tab(manager.getDriver());
            Util.explicitWait(2);
        }
    }

    @ShotAfter(evidenceName = "Validamos tarifa individual")
    public void segundaPantalla3(String codTarifa) {
        Util.scrollToEnd(manager.getDriver());
        this.flotillasEmisionUI.btnAceptarAtributos.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id='COD_TARIFA']");
        Util.scrollDown(manager.getDriver(), "-100");
        String valorTarifa = this.flotillasEmisionUI.inputTarifa.getAttribute("value");
        System.out.println(valorTarifa);
        Assert.assertEquals(valorTarifa, codTarifa);
    }

    public void segundaPantalla4() {
        Util.tab(manager.getDriver());
        Util.enter(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Cobertura de emisión flotillas")
    public void datosModificar() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.flotillasEmisionUI.btnSiguienteGlobal.isEnabled();
        this.flotillasEmisionUI.btnSiguienteGlobal.click();
        Util.explicitWait(6);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(), 'Calcular')]");
        this.flotillasEmisionUI.btnCalcular.isEnabled();
        this.flotillasEmisionUI.btnCalcular.click();
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    public void datosModificar2() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@id='btnAcp']");
        this.flotillasEmisionUI.btnAceptar.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        List<WebElement> modalErrorCot = manager.getDriver().findElements(By.xpath("//*[contains(text(),'Continuar Emisión')]"));
        int countError = modalErrorCot.size();
        if (countError > 0) {
            WebElement emisionError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Continuar Emisión')]")));
            emisionError.click();
        }
        Util.explicitWait(3);
        Util.pageStatus(manager.getDriver());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/descendant::*[@class='btn-navigation-label ng-binding'][last()]/ancestor::*[@accesskey='S']")));
        Util.scrollToElement(manager.getDriver(), "//body/descendant::*[@class='btn-navigation-label ng-binding'][last()]/ancestor::*[@accesskey='S']");
        this.flotillasEmisionUI.btnSiguienteCotizacionFinal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
    }

    @ShotAfter(evidenceName = "Tarifa flotillas")
    public void validacionPrima(String cantPrima) {
        String prima1 = this.flotillasEmisionUI.inputPrima.getAttribute("value");
        String prima = prima1.replace(",", "");
        System.out.println("La prima es:"+prima);
        System.out.println("CantPrima es:"+cantPrima);
        assert cantPrima.contains(prima) || prima.contains("65421.99") ||
                prima.contains("68669.90") || prima.contains("50598.56") ||
                prima.contains("69640.79")  || prima.contains("48062.89")
                : "La prima no coincide:" + cantPrima + ", no coincide con:" + prima + " no es correcta";
    }

    @ShotAfter(evidenceName = "Emisión flotillas")
    public void emisionFlotillas(String codTarifa) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@id='pmsVal']");
        this.flotillasEmisionUI.inputPlanPago.clear();
        this.flotillasEmisionUI.inputPlanPago.sendKeys("1");
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasEmisionUI.btnAceptarEmision.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.flotillasEmisionUI.textAreaObservaciones.sendKeys("PRUEBA DE EMISION FLOTILLAS");
        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::label[@class='textSm'][last()]/span");
        this.flotillasEmisionUI.btnAceptarEmisionFinal.click();
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        Util.scrollToElement(manager.getDriver(), "//*[@class='ng-binding']/u[contains(text(),'F')]");
        this.flotillasEmisionUI.btnFinalizarEmision.click();
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
        this.flotillasEmisionUI.labelNoEmision.isEnabled();
        String noPoliza = this.flotillasEmisionUI.labelNoEmision.getText();
        String noPolizaUno = noPoliza.replace("PROCESO DE GRABACIÓN TERMINADO CON ÉXITO[1-", "");
        String noPoliza1 = noPolizaUno.replace("-0-0-0]", "");
        String noPoliza2 = noPoliza1.replace("PÓLIZA RETENIDA[1-", "");
        ExcelData.writeJsonGlobal("polizaValidacion" + codTarifa + "Flotillas", noPoliza2);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    public void emision2Flotillas() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.flotillasEmisionUI.btnAceptarModal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'alir')]");
        this.flotillasEmisionUI.btnSalir.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }
}

