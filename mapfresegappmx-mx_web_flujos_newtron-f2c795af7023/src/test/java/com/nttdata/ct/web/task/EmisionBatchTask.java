package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.EmisionBatchUI;
import com.nttdata.ct.web.ui.IndividualConsultaUI;
import com.nttdata.ct.web.ui.TareasUI;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.nttdata.ct.web.task.ExcelData.readExcel;


@Task
public class EmisionBatchTask {

    @Autowired
    public DriverManager manager;
    @Autowired
    private EmisionBatchUI emisionBatchUI;
    @Autowired
    private TareasUI tareasUI;
    @Autowired
    private IndividualConsultaUI individualConsultaUI;


    @ShotAfter(evidenceName = "ingresar a Envío de Archivos al Servidor")
    public void ingresarEnvioArchivosServidor() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.tareasUI.selectFacturacion.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        this.emisionBatchUI.optEnvioArchivoServ.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }

    @ShotAfter(evidenceName = "Atributos Fichero")
    public void AtributosFichero(String nombreFichero, String codigoEstructura, String proceso){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.inputNombreFichero.sendKeys(nombreFichero);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

        this.emisionBatchUI.inputCodigoEstructura.sendKeys(codigoEstructura);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

        this.emisionBatchUI.btnAceptar.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollDown(manager.getDriver(),"200");

        wait.until(ExpectedConditions.visibilityOf(this.emisionBatchUI.txtResultado));
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

        //String resultado = this.emisionBatchUI.txtResultado.getText();
        String resultado = this.emisionBatchUI.txtResultado.getAttribute("value");
        if(proceso.equals("Emision NE")) {
            ExcelData.writeJsonGlobal("EmisionOrden", resultado.substring(42));
        } else if (proceso.equals("Cancelar")){
            ExcelData.writeJsonGlobal("CancelarOrden",resultado.substring(42));
        }
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

        this.emisionBatchUI.btnSalir.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }


    @ShotAfter(evidenceName = "Atributos Fichero")
    public void AtributosBatch(String proceso){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        formattedDate = formattedDate.replace("-","");

        String numOrden="";
        if(proceso.equals("Emision NE")){
            this.emisionBatchUI.inputProcesoBatch.sendKeys("3");
            Util.explicitWait(2);
            this.emisionBatchUI.inputFechaProceso.click();
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            this.emisionBatchUI.inputFechaProceso.clear();
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            this.emisionBatchUI.inputFechaProceso.sendKeys(formattedDate);
            Util.explicitWait(2);
            numOrden = ExcelData.readJsonGlobal("EmisionOrden");
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
            this.emisionBatchUI.inputOrden.click();
            Util.explicitWait(1);
            this.emisionBatchUI.inputOrden.clear();
            Util.explicitWait(1);
            this.emisionBatchUI.inputOrden.sendKeys(numOrden);

        }else if(proceso.equals("Cancelar")){
            this.emisionBatchUI.inputProcesoBatch.sendKeys("4");
            Util.explicitWait(2);
            this.emisionBatchUI.inputFechaProceso.click();
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            this.emisionBatchUI.inputFechaProceso.clear();
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            this.emisionBatchUI.inputFechaProceso.sendKeys(formattedDate);
            Util.explicitWait(2);
            numOrden = ExcelData.readJsonGlobal("CancelarOrden");
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
            this.emisionBatchUI.inputOrden.click();
            Util.explicitWait(1);
            this.emisionBatchUI.inputOrden.clear();
            Util.explicitWait(1);
            this.emisionBatchUI.inputOrden.sendKeys(numOrden);
            Util.explicitWait(2);
            this.emisionBatchUI.inputSuplemento.sendKeys("490");
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
            this.emisionBatchUI.inputSubCodSuple.sendKeys("6");
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(2);
        }

        this.emisionBatchUI.inputReproceso.sendKeys("N");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.inputAbortar.sendKeys("N");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.btnAceptar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.scrollDown(manager.getDriver(),"100");
        Util.explicitWait(1);

        wait.until(ExpectedConditions.visibilityOf(this.emisionBatchUI.tipoSituacion));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.btnSalir.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Validar emisión de Ordenes")
    public void ingresarDatosOrden(String proceso){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        String noOrden="";
        String xpath="";
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        formattedDate = formattedDate.replace("-","");
        switch (proceso) {
            case("NE"):
                noOrden = ExcelData.readJsonGlobal("EmisionOrden");
                xpath = "//td[contains(text(),'confirmacion_emi_NRFM_" + formattedDate + "')]";
                break;
            case("Cancelar"):
                noOrden = ExcelData.readJsonGlobal("CancelarOrden");
                xpath = "//td[contains(text(),'confirmacion_can_general_" + formattedDate + "')]";
                break;
            case( "Emision General"):
                noOrden = ExcelData.readJsonGlobal("batchGralOrden");
                xpath = "//td[contains(text(),'confirmacion_emi_general_" + formattedDate + "')]";
                break;
            default:
                System.out.println("No existe la opción");
                break;
        }
        System.out.println("Xpath: "+xpath);
        this.emisionBatchUI.inputOrden.sendKeys(noOrden);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.btnAceptar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.scrollDown(manager.getDriver(),"200");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);

        wait.until(ExpectedConditions.visibilityOf(this.emisionBatchUI.tipoSituacion));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.btnSpool.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.activarIframe(manager.getDriver(),"//iframe");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.waitElementVisible(manager.getDriver(),manager.getDriver().findElement(By.xpath(xpath)));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(),xpath);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollDown(manager.getDriver(),"-100");

        WebElement confirmacionEmision = manager.getDriver().findElement(By.xpath(xpath));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        if(proceso.equals("EmisionGeneral")){
            ExcelData.writeJsonGlobal("archivoGralBatch", confirmacionEmision.getText());
        }else {
            ExcelData.writeJsonGlobal("ArchivoEmision", confirmacionEmision.getText());
        }

        confirmacionEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.btnVerTxt.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        wait.until(ExpectedConditions.elementToBeClickable(this.emisionBatchUI.btnSalirSpool));
        this.emisionBatchUI.btnSalirSpool.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Vigencia Poliza")
    public void validarInfoPoliza (){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        String archivo = ExcelData.readJsonGlobal("ArchivoEmision");
        String noPoliza= ExcelData.readtxt(archivo);
        Util.explicitWait(2);
        this.individualConsultaUI.selectEmision.click();
        Util.explicitWait(4);
        this.individualConsultaUI.btnConsultarPoliza.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualConsultaUI.inputConsultarPoliza.sendKeys(noPoliza);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.individualConsultaUI.btnBuscarPoliza.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        ExcelData.writeJsonGlobal("PolizaEmision",noPoliza);
        //Util.waitElementVisible(manager.getDriver(),this.emisionBatchUI.lblVigencia);
        String polizaVig = this.emisionBatchUI.lblVigencia.getText().replace("/","");
        String anioVig = polizaVig.substring(4);
        String mesVig = polizaVig.substring(2,4);//
        String diaVig = polizaVig.substring(0,2);//
        String vigencia = anioVig+mesVig+diaVig;
        System.out.println("FECHA VIGENCIA "+vigencia);
        ExcelData.writeJsonGlobal("vigenciaPoliza",vigencia);
        createAndWriteToFile(noPoliza,vigencia);
    }

    public void createAndWriteToFile(String poliza,String vigencia) {
        FileWriter fileWriter = null;
        try {
            String pathFirst = System.getProperty("user.home");
            File file = new File(pathFirst + "/Downloads/CANCELPOLIZABATCH.TXT");
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getAbsolutePath());
                } else {
                    System.out.println("File already exists: " + file.getAbsolutePath());
                }
            }

            // Step 4: Write data to the file using FileWriter
            fileWriter = new FileWriter(file);
            fileWriter.write(poliza+vigencia+"25");
            System.out.println("Data has been written to the file: " + file.getAbsolutePath());
        } catch (IOException e) {
            // Step 5: Handle exceptions
            System.err.println("An error occurred while handling the file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Step 6: Close FileWriter to avoid memory leaks
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.err.println("An error occurred while closing FileWriter: " + e.getMessage());
                }
            }
        }
    }

    public void cargarArchivosBatch(String archivo) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        String pathFirst = System.getProperty("user.dir");
        //File file = new File(pathFirst + "/src/test/resources/CANCELPOLIZABATCH.TXT");
        File file = new File(archivo);
        System.out.println("Existe:"+file.exists());
        String file1 = file.getAbsolutePath();
        this.emisionBatchUI.inputArchivo.sendKeys(file1);
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.emisionBatchUI.btnAceptarCarga.click();
        Util.waitAlert(manager.getDriver());
        Util.explicitWait(2);
        Util.isVisibleAlertTemporal(manager.getDriver(), "Archivo cargado");
        Util.explicitWait(2);
    }

    public void regresarCargaArchivo() {
        this.emisionBatchUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Atributos Ficheros")
    public void atributosFicheros(String general, String interveniente, String riesgoCobertura){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.emisionBatchUI.inputFicheroGeneral.clear();
        Util.explicitWait(1);
        this.emisionBatchUI.inputFicheroGeneral.sendKeys(general);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.inputFicheroInterveniente.clear();
        Util.explicitWait(1);
        this.emisionBatchUI.inputFicheroInterveniente.sendKeys(interveniente);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.inputRiesgoCobertura.clear();
        Util.explicitWait(1);
        this.emisionBatchUI.inputRiesgoCobertura.sendKeys(riesgoCobertura);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.inputCodigoEstructura.clear();
        Util.explicitWait(1);
        this.emisionBatchUI.inputCodigoEstructura.sendKeys("MMXEATEMGR");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.btnAceptar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.scrollDown(manager.getDriver(),"100");
        Util.explicitWait(1);

        /*wait.until(ExpectedConditions.visibilityOf(this.emisionBatchUI.tipoSituacion));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);*/

        this.emisionBatchUI.btnSalir.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

    }

    @ShotAfter (evidenceName = "Menu Consulta proceso masivo")
    public void menuConsultaProcesoMasivo(){
        this.emisionBatchUI.lblEmision.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.emisionBatchUI.lblConsultarProcesoMasivo.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Atributos proceso masivo")
    public void atributosProcesoMasivo(){
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.inputMovimientoBatch.clear();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.emisionBatchUI.inputMovimientoBatch.sendKeys("3");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        formattedDate = formattedDate.replace("-","");
        this.emisionBatchUI.inputDateProcesamiento.clear();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.emisionBatchUI.inputDateProcesamiento.sendKeys(formattedDate);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.btnBuscar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.lblRegistroMasivo.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Actions act = new Actions(manager.getDriver());
        act.doubleClick(emisionBatchUI.lblRegistroMasivo).perform();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter
    public void obtenerNumOrdenGeneral(){
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.activarIframe(manager.getDriver(),"//iframe");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        wait.until(ExpectedConditions.visibilityOf(this.emisionBatchUI.lblOrdenCarga));
        String batchGralOrden = this.emisionBatchUI.lblOrdenCarga.getAttribute("value");
        ExcelData.writeJsonGlobal("batchGralOrden",batchGralOrden);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.desactivarIframe(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.emisionBatchUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);


    }


    @ShotAfter(evidenceName = "ingresar a Tarea")
    public void LanzadorDeTareas() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.emisionBatchUI.selectTareas.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        Util.scrollDown(manager.getDriver(),"-150");
        this.emisionBatchUI.btnLanzadorDeTareas.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }
}
