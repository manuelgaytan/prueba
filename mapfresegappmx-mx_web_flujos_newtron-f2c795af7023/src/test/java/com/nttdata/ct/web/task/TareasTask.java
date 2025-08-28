package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class TareasTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    private EmisionGestionControlTecnicoUI emisionGestionControlTecnicoUI;
    @Autowired
    private TareasUI tareasUI;

    @Autowired
    private LoginUI loginUI;
    @Autowired
    private IndividualCambioPlacasUI individualCambioPlacasUI;

    @ShotAfter(evidenceName = "ingresar a Envío de Archivos al Servidor")
    public void ingresarAEnvioDeArchivosAlServidor() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.tareasUI.selectFacturacion.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        this.tareasUI.btnEnvioDeArchivosAlServidor.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
    }

    @ShotAfter(evidenceName = "Cargar Archivo")
    public void cargarArchivo() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/resources/COBROSELE.txt");
        String file1 = file.getAbsolutePath();
        this.tareasUI.inputUpload.sendKeys(file1);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

        Util.explicitWait(4);
        this.tareasUI.btnAceptarCargaArchivo.click();
        Util.explicitWait(2);
        Util.waitAlert(manager.getDriver());
       Util.isVisibleAlertTemporal(manager.getDriver(), "Archivo cargado");

    }

    @ShotAfter(evidenceName = "Validar Carga Archivo")
    public void validarCargaArchivo() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.tareasUI.btnSalirCargarArchivo.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

    }

    @ShotAfter(evidenceName = "ingresar a Tarea")
    public void ingresarALanzadorDeTareas() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.tareasUI.selectTareas.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        this.tareasUI.btnLanzadorDeTareas.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }


    @ShotAfter(evidenceName = "CP002_Ejecución de tarea MMXGC00171")
    public void ejecucionDeTareasMMXGC00171(String tarea, String codigoDeCampania, String tipoProceso, String orden, String tipoDeGestor, String codigoDeGestor, String tipoDeNegocio, String descuentoComision, String formaDeCompensacion, String repocesaPolConError, String nombreArchivo) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.tareasUI.textoTareas.sendKeys(tarea);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.tareasUI.btnAceptarTareas.click();
        Util.pageStatus(manager.getDriver());
        //Util.explicitWait(2);

        Util.waitWebElementIsEnabled(10,manager.getDriver(),this.tareasUI.textoCodigoDeCompania);

        this.tareasUI.textoCodigoDeCompania.clear();
        this.tareasUI.textoCodigoDeCompania.sendKeys(codigoDeCampania);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.tareasUI.textoTipoDeProceso.sendKeys(tipoProceso);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.ingresarFechaActual(manager.getDriver(),"//input[@name='JBFEC_PROCESO']","dd-MM-yyyy");

        this.tareasUI.textoOrden.clear();
        this.tareasUI.textoOrden.sendKeys(orden);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.tareasUI.textoTipoDeGestor.sendKeys(tipoDeGestor);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.tareasUI.textoCodigoDeGestor.sendKeys(codigoDeGestor);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.tareasUI.textoTipoDeNegocio.sendKeys(tipoDeNegocio);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.ingresarFechaActual(manager.getDriver(),"//input[@name='JBFEC_COBRO']","dd-MM-yyyy");

        this.tareasUI.textoDescuentoComision.sendKeys(descuentoComision);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        this.tareasUI.textoFormatoDeCompensacion.clear();
        this.tareasUI.textoFormatoDeCompensacion.sendKeys(formaDeCompensacion);
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        this.tareasUI.textoReprocesaPolConErro.clear();
        Util.explicitWait(2);
        this.tareasUI.textoReprocesaPolConErro.sendKeys(repocesaPolConError);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

        Util.scrollDown(manager.getDriver(), "100");

        this.tareasUI.textoNombreArchivo.sendKeys(nombreArchivo);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);

        this.tareasUI.btnAceptarAtributo.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        // empieza segundo click Boton Aceptar

        this.tareasUI.textoCodigoDeCompania.clear();
        this.tareasUI.textoCodigoDeCompania.sendKeys(codigoDeCampania);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());

        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());

        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());

        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        this.tareasUI.textoReprocesaPolConErro.clear();
        Util.explicitWait(2);
        this.tareasUI.textoReprocesaPolConErro.sendKeys(repocesaPolConError);
        Util.explicitWait(2);
        this.tareasUI.textoNombreArchivo.sendKeys(nombreArchivo);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

        Util.scrollDown(manager.getDriver(), "400");

        this.tareasUI.btnAceptarAtributo.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(15);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

        //termina el segundo boton aceptar

//        Util.scrollDown(manager.getDriver(), "500");
        Util.explicitWait(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@role='row'])[2]")));



    }


    @ShotAfter(evidenceName = "CP003_Descargar archivo de salida")
    public void descargarArchivoDeSalida() {
       // String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
       // int segundEsp = Integer.parseInt(segundosEspera);
       // WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        this.tareasUI.btnSalirAtributo.click();
        Util.pageStatus(manager.getDriver());
        //Util.explicitWait(2);
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.tareasUI.btnSpollInformes);
        this.tareasUI.btnSpollInformes.click();
        Util.pageStatus(manager.getDriver());
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        manager.getDriver().switchTo().frame(manager.getDriver().findElement(By.xpath("//iframe[@frameborder=\"0\"]")));
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.tareasUI.identificadorInforme);
        Util.explicitWait(1);
        this.tareasUI.identificadorInforme.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.tareasUI.btnDescargarInforme);
        this.tareasUI.btnDescargarInforme.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        String nombreExcel = this.tareasUI.identificadorInforme.getAttribute("title");
        ExcelData.writeJsonTask(nombreExcel);
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.tareasUI.btnSalirDescargas);
        Util.explicitWait(1);

        //Util.explicitWait(4);
//        String numero = readExcel("dataWebAutomoviles", 4, 0);
//        int segundEsp = Integer.parseInt(segundosEspera);
//        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

    }
    public static String readCsv(String buzonCobro) {
        String pathUser = System.getProperty("user.home");
        String[] parts = pathUser.toString().split("\\\\"); // Step 3: Split the string by backslash
        String userName = parts[parts.length - 1]; // Step 4: Access the desired part
        //Usar en el local "\\\\SMX000CTX000V1\\Ctx_Data$\\"+userName
        //String uat = pathUser

        // Se usan para producción //
//        String csvFile = pathUser+"\\Downloads\\"+buzonCobro; // Cambia esto a la ruta de tu archivo CSV
//        System.out.println("Csv:++++++:"+ csvFile);

        // Se usan para local //
        String csvFile = "\\\\SMX000CTX000V1\\Ctx_Data$\\"+userName+"\\Downloads\\"+buzonCobro; // Cambia esto a la ruta de tu archivo CSV
        System.out.println("Csv:++++++:"+ "\\\\SMX000CTX000V1\\Ctx_Data$\\"+userName);


        int targetRow = 4;
        int targetColumn = 0;
        String line;
        String splitBy = ",";
        int currentRow = 0;
        String cellValue;
        String nombreEnvio="";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(splitBy);
                    if (targetColumn < values.length) {
                        cellValue = values[targetColumn];
                        String[] valores = cellValue.split(";");
                        nombreEnvio = valores[6];
                        System.out.println(nombreEnvio);
                    } else {
                        System.out.println("La columna especificada no existe en esta fila.");
                    }
                    break; // Salimos una vez que encontramos la fila deseada
                }
                currentRow++;
            }
        } catch (IOException e) {
          return  null;
        }
        return nombreEnvio;
    }

    @ShotAfter(evidenceName = "Consulta aplicación de cobros")
    public void consultaAplicacionDeCobro() {
//        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
//        int segundEsp = Integer.parseInt(segundosEspera);
//        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.tareasUI.btnSalirDescargas.click();
        Util.pageStatus(manager.getDriver());

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.tareasUI.btnTesoreria);
        Util.explicitWait(1);
        this.tareasUI.btnTesoreria.click();

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.tareasUI.btnAplicacionDeCobros);
        Util.explicitWait(1);
        this.tareasUI.btnAplicacionDeCobros.click();

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.tareasUI.btnTipoDeProceso);
        Util.explicitWait(1 / 2);
        this.tareasUI.btnTipoDeProceso.sendKeys("20");
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(2);

        Util.ingresarFechaActual(manager.getDriver(), "//input[@name=\"lodDat\"]", "dd-MM-yyyy");
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        //Util.explicitWait(2);


        String nombreExcel = ExcelData.readJsonTask();
        String numeroAviso = readCsv(nombreExcel);
        System.out.println("Dato:" + numeroAviso);
        this.tareasUI.textoNumeroAviso.sendKeys(numeroAviso);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.tareasUI.btnAplicarCobros);
        Util.explicitWait(1);

    }

        @ShotAfter(evidenceName = "Consulta aplicación de cobros - Aplicar Cobro")
        public void consultaAplicacionDeCobroAceptar() {


        this.tareasUI.btnAplicarCobros.click();
        Util.pageStatus(manager.getDriver());
            Util.waitWebElementIsEnabled(15, manager.getDriver(), this.tareasUI.aceptarAplicarCobros);
            Util.explicitWait(1);
            this.tareasUI.aceptarAplicarCobros.click();
            Util.pageStatus(manager.getDriver());
            Util.waitWebElementIsEnabled(15, manager.getDriver(), this.tareasUI.btnAplicarCobrosMasivos);
            Util.explicitWait(1);

    }


    @ShotAfter(evidenceName = "Consulta aplicación de cobros - Aceptar Aplicar Cobro")
    public void consultaAplicacionDeCobroAceptarAplicacionCobro() {

        this.tareasUI.btnAplicarCobrosMasivos.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.tareasUI.btnAceptarAplicacion);
        Util.explicitWait(1);

    }

        @ShotAfter(evidenceName = "Consulta aplicación de cobros - Aceptar Aplicación")
        public void consultaAplicacionDeCobroAceptarAplicacion() {
        this.tareasUI.btnAceptarAplicacion.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitWebElementIsEnabled(20,manager.getDriver(),this.tareasUI.btnSalirCobros);
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "CP005_aplicación de cobros")
    public void aplicacionDeCobro() {

        this.tareasUI.btnSalirCobros.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(1);
        this.tareasUI.btnSalirCobros.click();
        Util.pageStatus(manager.getDriver());

        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitWebElementIsEnabled(20,manager.getDriver(),this.tareasUI.btnTesoreria);
        Util.explicitWait(1);
        this.tareasUI.btnTesoreria.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

        Util.waitWebElementIsEnabled(20,manager.getDriver(),this.tareasUI.btnHistoricoCobros);
        Util.explicitWait(1);
        this.tareasUI.btnHistoricoCobros.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(1);


        Util.ingresarFechaActual(manager.getDriver(),"//input[@name=\"lodDat\"]","dd-MM-yyyy");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);

        this.tareasUI.btnTipoDeProceso.sendKeys("20");
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        String nombreExcel = ExcelData.readJsonTask();
        String numeroAviso = readCsv(nombreExcel);
        this.tareasUI.textoNumeroAviso.sendKeys(numeroAviso);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

        Util.waitWebElementIsEnabled(20,manager.getDriver(),this.tareasUI.btnBuscar);
        Util.explicitWait(1);
        this.tareasUI.btnBuscar.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

        Util.waitWebElementIsEnabled(20,manager.getDriver(),this.tareasUI.btnHistorico);
        Util.explicitWait(1);
        this.tareasUI.btnHistorico.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div/div/div[3]");

        Util.waitWebElementIsEnabled(20,manager.getDriver(),this.tareasUI.btnConsulta);
        Util.explicitWait(1);
        this.tareasUI.btnConsulta.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

        Util.waitWebElementIsEnabled(20,manager.getDriver(),this.tareasUI.validarConsultaHistorico);
        Util.explicitWait(1);
        String disminuPrima = this.tareasUI.validarConsultaHistorico.getText();
        Assert.assertEquals(disminuPrima,"1 PESOS");

    }


}
