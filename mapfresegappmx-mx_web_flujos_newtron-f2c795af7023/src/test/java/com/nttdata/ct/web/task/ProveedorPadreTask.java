package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.BatchUI;
import com.nttdata.ct.web.ui.ProveedorUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

@Task
public class ProveedorPadreTask {

    @Autowired
    public DriverManager manager;

    @Autowired
    public ProveedorUI proveedorUI;

    @ShotAfter(evidenceName = "Apartado de administración de tareas")
    public void irConsultarPoliza() {
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.terceros.click();
        Util.explicitWait(4);
        this.proveedorUI.proveedor.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Buscamos proveedor existente")
    public void llenamosDatosProvP() {
        this.proveedorUI.inputTipoDoc.sendKeys("RFC");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.inputDocumento.sendKeys("AAC821026GC2");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.inputActividadTer.sendKeys("17");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.btnBuscar.click();
        Util.explicitWait(3);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.btnCrear.click();
        Util.explicitWait(3);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Ingresamos el rfc del proveedor padre que se va a crear")
    public void llenamosDatosProvP2() {
        WebElement iframe = manager.getDriver().findElement(By.xpath("//body/descendant::iframe[1]"));
        //Switch to the frame
        manager.getDriver().switchTo().frame(iframe);
        this.proveedorUI.inputDocumentoCrear.click();
        this.proveedorUI.inputDocumentoCrear.click();
        this.proveedorUI.inputDocumentoCrear.clear();
        this.proveedorUI.inputDocumentoCrear.clear();
        Util.explicitWait(3);
        Util.runRfcAleatorio("rfcProveedorPadre");
        String rfc = ExcelData.readJsonGlobal("rfcProveedorPadre");
        this.proveedorUI.inputDocumentoCrear.sendKeys(rfc);
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Clic en aceptar")
    public void llenamosDatosProvP3() {
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.btnAceptarProv.click();
        Util.explicitWait(3);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Ingresamos datos del proveedor padre1")
    public void creacionProvPadre() {
        Util.explicitWait(2);
        this.proveedorUI.inputTipologia.sendKeys("AGT");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.inputCatProveedor.sendKeys("TMM");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Ingresamos datos del proveedor padre2")
    public void creacionProvPadre2() {
        this.proveedorUI.btnAceptarTipologia.click();
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.inputNombre.sendKeys("MANUEL");
        Util.explicitWait(2);
        this.proveedorUI.inputApellido1.sendKeys("CRUZ");
        this.proveedorUI.inputApellido2.sendKeys("CRUZ");
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "Ingresamos datos del proveedor padre3")
    public void creacionProvPadre3() {
        this.proveedorUI.inputTipoProveedor.sendKeys("AC");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Ingresamos datos del proveedor padre4")
    public void creacionProvPadre4() {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String str = ft.format(new Date());
        this.proveedorUI.inputFechaInicioContr.sendKeys(str);
        this.proveedorUI.inputFechaFinContr.sendKeys(str);
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Añadimos datos de sucursal")
    public void creacionProvPadre5() {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String str = ft.format(new Date());
        this.proveedorUI.btnAceptarDG.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Documentos Alternativos')]/following::*[contains(text(),'Añadir')][1]/..");
        Util.explicitWait(1);
        Util.clicJavascript(manager.getDriver(), "//*[contains(text(),'Documentos Alternativos')]/following::*[contains(text(),'Añadir')][1]/../*[1]");
//        this.proveedorUI.btnAnadirDA.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        char[] chars = "0123456789".toCharArray();
        int charsLength = chars.length;
        // Instanciamos la clase Random
        Random random = new Random();
        // Un StringBuffer para componer la cadena aleatoria de forma eficiente
        StringBuffer buffer = new StringBuffer();
        // Bucle para elegir una cadena de 10 caracteres al azar
        for (int i = 0; i < 9; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer.append(chars[random.nextInt(charsLength)]);
        }
        String ine = buffer.toString();
        this.proveedorUI.inputTipoDocAlternativo.sendKeys("INE");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.inputDocAlternativo.sendKeys(ine);
        this.proveedorUI.inputFechaEmiAlternativo.sendKeys(str);
        Util.explicitWait(1);
        this.proveedorUI.inputFechaCadAlternativo.sendKeys(str);
        this.proveedorUI.inputPaisEmisorAlt.sendKeys("MEX");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.checkDocComp.click();
        this.proveedorUI.inputObservacionesAlt.sendKeys("NINGUNA");
        Util.explicitWait(1);
        this.proveedorUI.inputFechaComprobacion.sendKeys(str);
        Util.explicitWait(1);
        this.proveedorUI.inputFechaVal.sendKeys(str);
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
    }
    @ShotAfter(evidenceName = "Creamos el proveedor padre y su sucursal con documentos alternativos")
    public void creacionProvPadre6() {
        Util.clicJavascript(manager.getDriver(), "//*[contains(text(),'Documentos Alternativos')]/following::*[contains(text(),'Confirmar') and @class='textSm ng-binding'][1]/../*[1]");
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.clicJavascript(manager.getDriver(), "//body/descendant::button[contains(text(),'Crear')][1]");
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Ingresamos proveedor hijo")
    public void llenamosDatosProvHijo() {
        this.proveedorUI.btnCrear.click();
        Util.explicitWait(3);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        WebElement iframe = manager.getDriver().findElement(By.xpath("//body/descendant::iframe[1]"));
        //Switch to the frame
        manager.getDriver().switchTo().frame(iframe);
        this.proveedorUI.inputDocumentoCrear.click();
        this.proveedorUI.inputDocumentoCrear.click();
        this.proveedorUI.inputDocumentoCrear.clear();
        this.proveedorUI.inputDocumentoCrear.clear();
        Util.explicitWait(3);
        // Los caracteres de interés en un array de char.
        char[] chars = "0123456789".toCharArray();
        char[] charsCar = "ERTYUPASDFGHJKLCVBNM".toCharArray();
        int charsLength = chars.length;
        int charsLengthCar = charsCar.length;
        // Instanciamos la clase Random
        Random random = new Random();
        // Un StringBuffer para componer la cadena aleatoria de forma eficiente
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        // Bucle para elegir una cadena de 10 caracteres al azar
        for (int i = 0; i < 4; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer.append(charsCar[random.nextInt(charsLengthCar)]);
        }
        for (int i = 0; i < 2; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer2.append(charsCar[random.nextInt(charsLengthCar)]);
        }
        // Y solo nos queda hacer algo con la cadena
        String letras4 = buffer.toString();
        String letras2 = buffer2.toString();
        int mes = ThreadLocalRandom.current().nextInt(10, 12 + 1);
        int dia = ThreadLocalRandom.current().nextInt(10, 30 + 1);
        int numero1 = ThreadLocalRandom.current().nextInt(1980, 2005 + 1);
        int numero2 = ThreadLocalRandom.current().nextInt(1, 9 + 1);
        String anio1 = String.valueOf(numero1);
        String anio2 = anio1.substring(2, 4);
        String mes1 = String.valueOf(mes);
        String dia1 = String.valueOf(dia);
        String lastNumber = String.valueOf(numero2);
        String rfcHijo = letras4 + anio2 + mes1 + dia1 + letras2 + lastNumber;
        ExcelData.writeJsonGlobal("rfcProveedorHijo", rfcHijo);
        String rfcPadre = ExcelData.readJsonGlobal("rfcProveedorPadre");
        this.proveedorUI.inputDocumentoCrear.sendKeys(rfcHijo);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.inputTipoDocumentoPadre.sendKeys("RFC");
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.inputDocumentoPadre.clear();
        Util.explicitWait(2);
        this.proveedorUI.inputDocumentoPadre.sendKeys(rfcPadre);
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "Clic en aceptar")
    public void llenamosDatosProvHijo2() {
        this.proveedorUI.btnAceptarProv.click();
        Util.explicitWait(3);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Creación de proveedor hijo")
    public void creacionProvHijo() {
        Util.explicitWait(2);
        this.proveedorUI.inputTipologia.sendKeys("AGT");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.inputCatProveedor.sendKeys("TMM");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Ingresamos datos de proveedor hijo")
    public void creacionProvHijo2() {
        this.proveedorUI.btnAceptarTipologia.click();
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.inputNombre.sendKeys("MANUEL");
        Util.explicitWait(2);
        this.proveedorUI.inputApellido1.sendKeys("CRUZ");
        this.proveedorUI.inputApellido2.sendKeys("PAZ");
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "Ingresamos datos de proveedor hijo 2")
    public void creacionProvHijo3() {
        this.proveedorUI.inputTipoProveedor.sendKeys("AC");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String str = ft.format(new Date());
        this.proveedorUI.inputFechaInicioContr.sendKeys(str);
        this.proveedorUI.inputFechaFinContr.sendKeys(str);
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Ingresamos datos de proveedor hijo 3")
    public void creacionProvHijo4() {
        this.proveedorUI.btnAceptarDG.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.clicJavascript(manager.getDriver(), "//body/descendant::button[contains(text(),'Crear')][1]");
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Validación de proveedor hijo y padre")
    public void validacionProveedoresCreados() {
        String rfcHijo = ExcelData.readJsonGlobal("rfcProveedorHijo");
        Util.explicitWait(2);
        this.proveedorUI.inputDocumento.click();
        this.proveedorUI.inputDocumento.clear();
        this.proveedorUI.inputDocumento.sendKeys(rfcHijo);
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.proveedorUI.btnBuscar.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        String rfcPadre = ExcelData.readJsonGlobal("rfcProveedorPadre");
        Util.clicJavascript(manager.getDriver(), "//td[contains(text(),'"+rfcHijo+"')][1]");
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.proveedorUI.btnConsultar.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
    }
}

