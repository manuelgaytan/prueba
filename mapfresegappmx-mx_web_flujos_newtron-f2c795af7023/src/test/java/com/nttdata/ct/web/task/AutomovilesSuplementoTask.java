package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.evidence.aspect.method.ShotBefore;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.IndividualSuplementoUI;
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
public class AutomovilesSuplementoTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    private IndividualSuplementoUI individualSuplementoUI;

    @Autowired
    private LoginUI loginUI;
    @ShotAfter(evidenceName = "Apartado de suplemento individual")
    public void irSuplementoPoliza() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualSuplementoUI.selectEmision.click();
        Util.explicitWait(4);
        this.individualSuplementoUI.btnSuplementoPoliza.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "busqueda de suplemento póliza")
    public void busquedaSuplemento() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        String noPoliza = ExcelData.readJsonIndividual();
        this.individualSuplementoUI.inputSuplementoPoliza.sendKeys(noPoliza);
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
    @ShotAfter(evidenceName = "informacion Basica de autos individual")
    public void segundaPantallaSuplemento1() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollDown(manager.getDriver(), "200");
        this.individualSuplementoUI.btnAceptarIB.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement2(manager.getDriver(), individualSuplementoUI.btnSiguiente);
        this.individualSuplementoUI.btnSiguiente.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollTopPage(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id='operationsTreeDis']");
        this.individualSuplementoUI.selectPolizaModificar.click();
        Util.explicitWait(2);
        this.individualSuplementoUI.btnModificar.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollDown(manager.getDriver(), "900");
        this.individualSuplementoUI.btnSiguientEnable.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualSuplementoUI.btnSiguientEnable.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
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
        Util.scrollToElement(manager.getDriver(), "//body/descendant::*[@name='NUM_SERIE'][1]");
        this.individualSuplementoUI.inputNumSerie.clear();
        Util.explicitWait(2);
        this.individualSuplementoUI.inputNumSerie.sendKeys(vin);
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id='TRANSACTION_ID']/following::span[2]/..");
        this.individualSuplementoUI.btnAceptarAtributos.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id='btnNxt' and not(@disabled='disabled')]");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualSuplementoUI.btnSiguientEnable.click();
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Coberturas de auto individual")
    public void datosModificar() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@id='btnNxt' and not(@disabled='disabled')]");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualSuplementoUI.btnSiguientEnable.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        String franquicia = readExcel("modificar_autos_individual", 0, 1);
        if (!franquicia.equals("null-data")) {
            WebElement inputFranquicia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + franquicia + "')]/following::*[@name='cvrDctValueListInput' and not(@disabled='disabled')][1]")));
            String textFranquicia = readExcel("modificar_autos_individual", 1, 1);
            inputFranquicia.click();
            inputFranquicia.clear();
            Util.press(manager.getDriver(), inputFranquicia, textFranquicia);
        }
        String capital = readExcel("modificar_autos_individual", 0, 2);
        WebElement selectCapitalFirst = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + capital + "')]/preceding::span[1]")));
        selectCapitalFirst.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        WebElement cantidadCot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + capital + "')]/following::*[@id='formattedInput_anlAmnBrwInput_2_0' or @id='formattedInput_anlAmnBrwInput_3_0' or @id='formattedInput_anlAmnBrwInput_4_0'][2]")));
        String varCot1 = cantidadCot.getAttribute("value");
        ExcelData.writeJsonTemporal1(varCot1);
        WebElement selectCapitalFirst2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + capital + "')]/preceding::span[1]")));
        selectCapitalFirst2.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        if (!capital.equals("null-data")) {
            WebElement inputCapital = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + capital + "')]/following::*[@name='cvrLmtValueListInput' and not(@disabled='disabled')][1]")));
            String textCapital = readExcel("modificar_autos_individual", 1, 2);
            inputCapital.click();
            inputCapital.clear();
            Util.press(manager.getDriver(), inputCapital, textCapital);
            Util.explicitWait(2);
        }
        String checkCapital = readExcel("modificar_autos_individual", 0, 3);
        if (!checkCapital.equals("null-data")) {
            Util.pageStatus(manager.getDriver());
            WebElement checkCapital1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + checkCapital + "')]/following::*[@name='chkCvrSlc' and not(@disabled='disabled')][1]")));
            checkCapital1.click();
            Util.explicitWait(2);
        }
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(), 'Calcular')]");
        this.individualSuplementoUI.btnCalcular.isEnabled();
        this.individualSuplementoUI.btnCalcular.click();
        Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        WebElement selectCapital = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + capital + "')]/preceding::span[1]")));
        selectCapital.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        WebElement cantidadCot1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + capital + "')]/following::*[@id='formattedInput_anlAmnBrwInput_2_0' or @id='formattedInput_anlAmnBrwInput_3_0' or @id='formattedInput_anlAmnBrwInput_4_0'][2]")));
        String varCot = cantidadCot1.getAttribute("value");
        ExcelData.writeJsonTemporal2(varCot);
        WebElement selectCapital2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + capital + "')]/preceding::span[1]")));
        selectCapital2.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        String cotizacion = ExcelData.readJsonTemporal1();
        String recotizacion = ExcelData.readJsonTemporal2();
        Assert.assertNotEquals(cotizacion, recotizacion);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btnAcp']")));
        this.individualSuplementoUI.btnAceptar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        List<WebElement> modalErrorCot = manager.getDriver().findElements(By.xpath("//*[contains(text(),'Continuar Emisión')]"));
        int countError = modalErrorCot.size();
        if (countError > 0) {
            WebElement emisionError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Continuar Emisión')]")));
            emisionError.click();
        }
    }

    public void datosModificar2() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//body/descendant::*[@class='btn-navigation-label ng-binding'][last()]/ancestor::*[@accesskey='S']");

        // Neto
        Util.explicitWait(1);
        if(Util.webElementIsEnabled(10,manager.getDriver(),this.individualSuplementoUI.btnObservacionContinuarEmision)){
            Util.explicitWait(1);
            this.individualSuplementoUI.btnObservacionContinuarEmision.click();
            System.out.println("Se encontro la ventana emergente");
        }// Neto


        Util.explicitWait(2);
        this.individualSuplementoUI.btnSiguienteCotizacionFinal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "Suplemento individual")
    public void emisionIndividual() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.scrollToElement(manager.getDriver(), "//*[@id='pmsVal']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualSuplementoUI.textAreaObservaciones.sendKeys("PRUEBA MODIFICAR PÓLIZA");
        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(), "//textarea[@name='txtEnrRsnTxtVal']/following::*[contains(text(),'A')][1]");
        this.individualSuplementoUI.btnAceptarTextArea.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Motivo suplemento')]");
        this.individualSuplementoUI.selectMotivoSuplemento.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Motivo suplemento')]/following::*[@name=\"chkAcnTypVal\"][1]");
//        this.individualSuplementoUI.selectPolizaModificar.click();
        Util.clicJavascript(manager.getDriver(), "//*[@title='1']");
        Util.explicitWait(2);
        Util.clicActions(manager.getDriver(), "//*[contains(text(),'Motivo suplemento')]/following::*[@name=\"chkAcnTypVal\"][1]");
//        Util.clicElementwithScroll(manager.getDriver(), "//*[contains(text(),'Motivo suplemento')]/following::*[@name=\"chkAcnTypVal\"][1]");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::label[@class='textSm'][last()]/span");
        this.individualSuplementoUI.btnAceptarEmisionFinal.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@class='ng-binding']/u[contains(text(),'F')]");
        this.individualSuplementoUI.btnFinalizarEmision.click();
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        Util.pageStatus(manager.getDriver());
        List<WebElement> modalObservecion = manager.getDriver().findElements(By.xpath("/html/body/div[3]/div/div"));
        int aceptModal12 = modalObservecion.size();
        if (aceptModal12 > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div")));
            this.individualSuplementoUI.btnContinuarEmision.click();
            Util.explicitWait(4);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/descendant::label[1]")));
        this.individualSuplementoUI.labelNoEmision.isEnabled();
        String noPoliza = this.individualSuplementoUI.labelNoEmision.getText();
        String noPoliza1 = noPoliza.replace("PROCESO DE GRABACIÓN TERMINADO CON ÉXITO[1-", "");
        String noPoliza2 = noPoliza1.replace("-1-0-0]","");
        ExcelData.writeJsonSuplemento(noPoliza2);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    public void emisionIndividual2() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.individualSuplementoUI.btnAceptarModal.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'alir')]");
        this.individualSuplementoUI.btnSalir.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

}
