package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.AplicacionMasivaDeBancosUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@Task
public class AplicacionMasivaDeBancosTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private AplicacionMasivaDeBancosUI aplicacionMasivaDeBancosUI;

    @ShotAfter(evidenceName = "Completar formulario de Atributos")
    public void completarFormulario(String codcompania, String tipoproceso, String tipogestor) {
//        String nombrearchivo = "cobrosselec.txt";
        Util.pageStatus(manager.getDriver());
        Date current = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        String message = formatter.format(current);

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.aplicacionMasivaDeBancosUI.txtCodigoCompania);
        this.aplicacionMasivaDeBancosUI.txtCodigoCompania.clear();
        Util.explicitWait(2);
        this.aplicacionMasivaDeBancosUI.txtCodigoCompania.sendKeys(codcompania);
        Util.explicitWait(1);
        this.aplicacionMasivaDeBancosUI.txtTipoProceso.sendKeys(tipoproceso);
        Util.explicitWait(1);
        this.aplicacionMasivaDeBancosUI.txtFechaProceso.sendKeys(message);
        Util.explicitWait(1);
        this.aplicacionMasivaDeBancosUI.txtFechaProceso.click();
        Util.explicitWait(1);
        this.aplicacionMasivaDeBancosUI.txtTipoGestor.sendKeys(tipogestor);
        Util.explicitWait(1);
        }

        @ShotAfter(evidenceName = "Completar formulario de Atributos 2")
        public void completarFormulario2 (String codgestor, String tiponegocio, String formacompensacion, String nombrearchivo){
            WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
            Date current = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
            String message = formatter.format(current);
            this.aplicacionMasivaDeBancosUI.txtCodGestor.sendKeys(codgestor);
            Util.explicitWait(1);
            this.aplicacionMasivaDeBancosUI.liTipoNegocio.click();
            Util.explicitWait(1);
            WebElement opcProvincia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='" + tiponegocio + "']")));
            opcProvincia.click();
            Util.explicitWait(1);
            this.aplicacionMasivaDeBancosUI.btnAceptarLista.click();
            Util.explicitWait(1);
            this.aplicacionMasivaDeBancosUI.txtFechaCobro.sendKeys(message);
            Util.explicitWait(1);
            this.aplicacionMasivaDeBancosUI.txtFormaCompensacion.clear();
            Util.explicitWait(1);
            this.aplicacionMasivaDeBancosUI.txtFormaCompensacion.sendKeys(formacompensacion);
            Util.explicitWait(1);
            this.aplicacionMasivaDeBancosUI.txtReprocesan.clear();
            Util.explicitWait(2);
            this.aplicacionMasivaDeBancosUI.txtReprocesan.sendKeys("N");
            Util.explicitWait(1);
            this.aplicacionMasivaDeBancosUI.txtxNombreArchivo.sendKeys(nombrearchivo);
            Util.explicitWait(1);
        }

    @ShotAfter(evidenceName = "Aceptar y validar si se muestre mensaje de ERROR")
        public void validarERROR () {
            Util.pageStatus(manager.getDriver());
            Util.scrollDown(manager.getDriver(), "400");

            this.aplicacionMasivaDeBancosUI.btnAceptar.click();
            Util.explicitWait(1);
        }

        @ShotAfter(evidenceName = "Aceptar formulario de Atributos")
        public void aceptarFormulario (String codcompania, String nombrearchivo){

            Util.pageStatus(manager.getDriver());

            boolean loop = false;
            do {
                List<WebElement> elementVisible = manager.getDriver().findElements(By.xpath("//a[contains(text(),'[REPROCESA POL.CON ERROR (S/N)]: MMX-20000: [GC_K_')]"));
                int elementVisible1 = elementVisible.size();
                if (elementVisible1 < 1) {
                    loop = true;
                    System.out.println("No se muestra el Error");
                } else {
                    System.out.println("Error Presente");
                    // empieza segundo click Boton Aceptar

                    this.aplicacionMasivaDeBancosUI.txtCodigoCompania.clear();
                    this.aplicacionMasivaDeBancosUI.txtCodigoCompania.sendKeys(codcompania);
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

                    this.aplicacionMasivaDeBancosUI.txtxNombreArchivo.sendKeys(nombrearchivo);
                    Util.explicitWait(1);

                    Util.scrollDown(manager.getDriver(), "400");
                    this.aplicacionMasivaDeBancosUI.btnAceptar.click();
                }
            } while (!loop);
            //Util.explicitWait(1);
        }

    @ShotAfter(evidenceName = "CP003_Descargar archivo de salida")
    public void descargarArchivoDeSalida() {
        this.aplicacionMasivaDeBancosUI.btnSalirAtributo.click();
        Util.pageStatus(manager.getDriver());
        //Util.explicitWait(2);
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.aplicacionMasivaDeBancosUI.btnSpollInformes);
        this.aplicacionMasivaDeBancosUI.btnSpollInformes.click();
        Util.pageStatus(manager.getDriver());
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        manager.getDriver().switchTo().frame(manager.getDriver().findElement(By.xpath("//iframe[@frameborder=\"0\"]")));
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.aplicacionMasivaDeBancosUI.identificadorInforme);
        Util.explicitWait(2);
        this.aplicacionMasivaDeBancosUI.identificadorInforme.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);


        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.aplicacionMasivaDeBancosUI.btnDescargarInforme);
        this.aplicacionMasivaDeBancosUI.btnDescargarInforme.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        String nombreExcel = this.aplicacionMasivaDeBancosUI.identificadorInforme.getAttribute("title");
        ExcelData.writeJsonTask(nombreExcel);
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.aplicacionMasivaDeBancosUI.btnSalirDescargas);
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Consulta aplicación de cobros")
    public void consultaAplicacionDeCobro() {

        this.aplicacionMasivaDeBancosUI.btnSalirDescargas.click();
        Util.pageStatus(manager.getDriver());

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.aplicacionMasivaDeBancosUI.btnTesoreria);
        Util.explicitWait(1);
        this.aplicacionMasivaDeBancosUI.btnTesoreria.click();

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.aplicacionMasivaDeBancosUI.btnAplicacionDeCobros);
        Util.explicitWait(1);
        this.aplicacionMasivaDeBancosUI.btnAplicacionDeCobros.click();

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.aplicacionMasivaDeBancosUI.btnTipoDeProceso);
        Util.explicitWait(1 / 2);
        this.aplicacionMasivaDeBancosUI.btnTipoDeProceso.sendKeys("20");
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(2);

        Util.ingresarFechaActual(manager.getDriver(), "//input[@name=\"lodDat\"]", "dd-MM-yyyy");
        Util.pageStatus(manager.getDriver());
        Util.tab(manager.getDriver());
        //Util.explicitWait(2);


        String nombreExcel = ExcelData.readJsonTask();
        String numeroAviso = readCsv(nombreExcel);
        System.out.println("Dato:" + numeroAviso);
        this.aplicacionMasivaDeBancosUI.textoNumeroAviso.sendKeys(numeroAviso);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.aplicacionMasivaDeBancosUI.btnAplicarCobros);
        Util.explicitWait(1);

    }

    @ShotAfter(evidenceName = "Consulta aplicación de cobros - Aplicar Cobro")
    public void consultaAplicacionDeCobroAceptar() {


        this.aplicacionMasivaDeBancosUI.btnAplicarCobros.click();
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.aplicacionMasivaDeBancosUI.aceptarAplicarCobros);
        Util.explicitWait(1);
        this.aplicacionMasivaDeBancosUI.aceptarAplicarCobros.click();
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.aplicacionMasivaDeBancosUI.btnAplicarCobrosMasivos);
        Util.explicitWait(1);

    }


    @ShotAfter(evidenceName = "Consulta aplicación de cobros - Aceptar Aplicar Cobro")
    public void consultaAplicacionDeCobroAceptarAplicacionCobro() {

        this.aplicacionMasivaDeBancosUI.btnAplicarCobrosMasivos.click();
        Util.pageStatus(manager.getDriver());
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.aplicacionMasivaDeBancosUI.btnAceptarAplicacion);
        Util.explicitWait(1);

    }

    @ShotAfter(evidenceName = "Consulta aplicación de cobros - Aceptar Aplicación")
    public void consultaAplicacionDeCobroAceptarAplicacion() {
        this.aplicacionMasivaDeBancosUI.btnAceptarAplicacion.click();
        Util.pageStatus(manager.getDriver());
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitWebElementIsEnabled(20,manager.getDriver(),this.aplicacionMasivaDeBancosUI.btnSalirCobros);
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Historico de Cobros")
    public void historicocobros() {

        Util.ingresarFechaActual(manager.getDriver(), "//input[@name=\"lodDat\"]", "dd-MM-yyyy");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);

        this.aplicacionMasivaDeBancosUI.btnTipoDeProceso.sendKeys("20");
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        String nombreExcel = ExcelData.readJsonTask();
        String numeroAviso = readCsv(nombreExcel);
        this.aplicacionMasivaDeBancosUI.textoNumeroAviso.sendKeys(numeroAviso);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

        Util.waitWebElementIsEnabled(20, manager.getDriver(), this.aplicacionMasivaDeBancosUI.btnBuscar);
        Util.explicitWait(1);
        this.aplicacionMasivaDeBancosUI.btnBuscar.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

        Util.waitWebElementIsEnabled(20, manager.getDriver(), this.aplicacionMasivaDeBancosUI.btnHistorico);
        Util.explicitWait(1);
        this.aplicacionMasivaDeBancosUI.btnHistorico.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[@id=\"app-content-container\"]/div/div/div/div[3]");
        Util.waitWebElementIsEnabled(20,manager.getDriver(),this.aplicacionMasivaDeBancosUI.btnConsulta);
        Util.explicitWait(1);
    }

        @ShotAfter(evidenceName = "Historico de Cobros - Consultar")
        public void historicocobrosconsultar() {

        this.aplicacionMasivaDeBancosUI.btnConsulta.click();
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

        Util.waitWebElementIsEnabled(20,manager.getDriver(),this.aplicacionMasivaDeBancosUI.validarConsultaHistorico);
        Util.explicitWait(1);
        String disminuPrima = this.aplicacionMasivaDeBancosUI.validarConsultaHistorico.getText();
        Assert.assertEquals(disminuPrima,"1 PESOS");

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



}
