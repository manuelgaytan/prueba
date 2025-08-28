package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.IndividualSiniestroNewUI;
import com.nttdata.ct.web.ui.IndividualSiniestroUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class AutomovilesSiniestroNewTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    private IndividualSiniestroNewUI individualSiniestroUI;

    @ShotAfter(evidenceName = "Ingresamos datos generales del automóvil")
    public void ingresarDatosGeneralesnew(String poliza) {
        Date current = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaactual = formatter.format(current);

        LocalDate currentDate = LocalDate.now();
        // Step 3: Define a formatter for better readability of the output
        DateTimeFormatter formatterMontBefore = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        /*Se realiza la resta de un mes a la fecha
         * Si se quiere realizar con una poliza recien emitida comentar las siguientes lineas.*/
        LocalDate previousMonth = currentDate.minusMonths(1);
        String monthBefore = previousMonth.format(formatterMontBefore);

        this.individualSiniestroUI.inputOcurrenciaFecha.sendKeys(monthBefore);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.individualSiniestroUI.inputHrOcurrenciaFecha.sendKeys("08:00");
        Util.explicitWait(1);
        Util.up(manager.getDriver());
        Util.enter(manager.getDriver());
        Util.explicitWait(1);
        ExcelData.writeJsonSiniestro("polizaIndividual", poliza);
        Util.pageStatus(manager.getDriver());
        String numPoliza = ExcelData.readJsonSiniestro("polizaIndividual");
        this.individualSiniestroUI.inputPoliza.sendKeys(numPoliza);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.individualSiniestroUI.btnBuscarPoliza.click();
        //Util.explicitWait(2);
        Util.waitElementItsNotVisible(manager.getDriver(),"//div[@class='loading-container ng-isolate-scope darkness']");
    }

    @ShotAfter(evidenceName = "Aceptar Datos Generales")
    public void aceptarDatosGeneralesnew() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        //Util.waitElementItsNotVisible(manager.getDriver(),"//div[@class='loading-container ng-isolate-scope darkness']");
        Util.scrollToElement(manager.getDriver(), "//label[contains(text(),'Aceptar')]");
        //this.individualSiniestroUI.btnAceptarInfSiniestro.isEnabled();
        Util.waitWebElementIsEnabled(20, manager.getDriver(), this.individualSiniestroUI.btnAceptarInfSiniestro);
        this.individualSiniestroUI.btnAceptarInfSiniestro.click();
        //Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        List<WebElement> errorModal = manager.getDriver().findElements(By.xpath("//*[@ng-disabled='nextLoading']"));
        int countError = errorModal.size();
        if (countError > 0) {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-disabled='nextLoading']")));
            error.click();
        }
        Util.waitElementItsNotVisible(manager.getDriver(),"//div[@class='loading-container ng-isolate-scope darkness']");
    }






    @ShotAfter(evidenceName = "Colocamos motivo de siniestro de autos individual")
    public void motivoSiniestronew(String codigoMotivoSiniestro, String codTipoAsegurado, String consecuencia) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        //Util.explicitWait(2);
        //Util.scrollToElement(manager.getDriver(), "//*[text()='Información Siniestro']");

        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::input[@name='lssRsnVal'][2]");
        Util.explicitWait(1);
        this.individualSiniestroUI.inputMotivoSiniestro.sendKeys(codigoMotivoSiniestro);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        this.individualSiniestroUI.inputTipoRelacion.sendKeys(codTipoAsegurado);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.btnSiguienteGlobal.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(),"//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        WebElement motivoSiniestro1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + consecuencia + "')]/preceding::*[@type=\"checkbox\"][1]")));
        motivoSiniestro1.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@class='btn btnprimary glyphicon glyphicon-arrow-down red']");
        Util.explicitWait(2);
        this.individualSiniestroUI.btnBajar.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(), '" + consecuencia + "')]/preceding::*[@type='checkbox'][1]");
        WebElement motivoSiniestro2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + consecuencia + "')]/preceding::*[@type='checkbox'][1]")));
        motivoSiniestro2.click();
    }

    public void motivoSiniestro2new() {
        this.individualSiniestroUI.btnSiguienteGlobal.click();
        Util.explicitWait(1);
//        Util.pageStatus(manager.getDriver());
//        Util.explicitWait(4);
        Util.waitElementItsNotVisible(manager.getDriver(),"//*[contains(text(),'Estamos cargando la página')]");
    }

    public void datosComplementariosnew() {
        Util.scrollToElement(manager.getDriver(), "//textarea[@name='cisTxtVal']");
        this.individualSiniestroUI.textareaRelato.sendKeys("Prueba - Siniestro al auto");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//textarea[@name='dmgDspVal']");
        this.individualSiniestroUI.textareaDescripcion.sendKeys("Prueba - en calle testing");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//textarea[@name='cisObsVal']");
        this.individualSiniestroUI.textareaObsRelato.sendKeys("Prueba - Ninguna");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
    }

    public void datosComplementarios2new(String codPais, String codEstado, String codPoblacion, String codPostal, String calle, String colonia, String entreCalles) {
        this.individualSiniestroUI.btnAceptarGlobal.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.individualSiniestroUI.inputCodPais.sendKeys(codPais);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputCodEstado.sendKeys(codEstado);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputCodPoblacion.sendKeys(codPoblacion);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputCalle.sendKeys(calle);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputColonia.sendKeys(colonia);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputEntreCalles.sendKeys(entreCalles);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputReferencia.sendKeys("NINGUNA");
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputCodPostal.sendKeys(codPostal);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Llenamos datos de ubicación del siniestro")
    public void ubicacionSiniestronew(String latitud, String longitud, String ubiVia, String direccionA) {
        this.individualSiniestroUI.inputLatitud.sendKeys(latitud);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputLongitud.sendKeys(longitud);
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputUbiVia.sendKeys(ubiVia);
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputDirA.sendKeys(direccionA);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'DATOS DEL SINIESTRO')]");
    }

    @ShotAfter(evidenceName = "Llenamos datos de Lugar del robo")
    public void lugarDelRobo(String consecuencia, String mismoLugarRobo, String codPaisRT, String ubiVia, String codPoblacionRT, String calleyNoRT, String coloniaRT, String entreCallesRT, String referenciaRT, String cpRT) {
        if (consecuencia.equals("ROBO TOTAL") || consecuencia.equals("ROBO PARCIAL")) {
            this.individualSiniestroUI.inputMsmUbiSin.sendKeys(mismoLugarRobo);
            Util.explicitWait(2);
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
            if (mismoLugarRobo.equals("S")) {
                this.individualSiniestroUI.inputcodPaisRT.sendKeys(codPaisRT);
                Util.explicitWait(2);
                Util.pageStatus(manager.getDriver());
                this.individualSiniestroUI.inputEstadoRT.sendKeys(ubiVia);
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
                this.individualSiniestroUI.inputCodPoblacionRT.sendKeys(codPoblacionRT);
                Util.explicitWait(1);
                Util.pageStatus(manager.getDriver());
                this.individualSiniestroUI.inputCalleyNoRT.sendKeys(calleyNoRT);
                Util.explicitWait(1);
                Util.pageStatus(manager.getDriver());
                this.individualSiniestroUI.inputColoniaRT.sendKeys(coloniaRT);
                Util.explicitWait(1);
                Util.pageStatus(manager.getDriver());
                this.individualSiniestroUI.inputEntreCallesRT.sendKeys(entreCallesRT);
                Util.explicitWait(1);
                Util.pageStatus(manager.getDriver());
                this.individualSiniestroUI.inputReferenciaRT.sendKeys(referenciaRT);
                Util.explicitWait(1);
                Util.pageStatus(manager.getDriver());
                this.individualSiniestroUI.inputCPRT.sendKeys(cpRT);
                Util.explicitWait(1);
                Util.pageStatus(manager.getDriver());
            }
        }
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'DATOS DEL SINIESTRO')]");
    }

    @ShotAfter(evidenceName = "Llenamos datos de vehículo asegurado")
    public void vehiculoAseguradonew(String color) {
        // Los caracteres de interés en un array de char.
        char[] chars = "0123456789".toCharArray();
        char[] chars2 = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
        int charsLength = chars.length;
        int charsM = chars2.length;
        // Instanciamos la clase Random
        Random random = new Random();
        // Un StringBuffer para componer la cadena aleatoria de forma eficiente
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        // Bucle para elegir una cadena de 10 caracteres al azar
        for (int i = 0; i < 3; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer.append(chars[random.nextInt(charsLength)]);
        }
        // Bucle para elegir una cadena de 4 caracteres al azar
        for (int i = 0; i < 4; i++) {
            // Añadimos al buffer un caracter al azar del array
            buffer2.append(chars2[random.nextInt(charsM)]);
        }
        String numero = buffer.toString();
        String numero2 = buffer2.toString();
        this.individualSiniestroUI.inputNumPLaca.sendKeys(numero2 + numero);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputColorEstSiniestro.sendKeys(color);
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Llenamos datos del ajustador")
    public void ajustadornew(String consecuencia, String codAjustador) {
//        Util.explicitWait(800);
        if (!consecuencia.equals("ROBO TOTAL") || !consecuencia.equals("ROBO PARCIAL")) {
            if (!codAjustador.equals("null")) {
                this.individualSiniestroUI.inputAjustador.sendKeys(codAjustador);
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
            }
        }
        Util.scrollToElement(manager.getDriver(), "//*[@id='COD_AJUSTADOR']");
    }

    @ShotAfter(evidenceName = "Llenamos datos del abogado")
    public void abogadonew(String consecuencia, String codAbogado) {
        if (consecuencia.equals("ROBO TOTAL") || consecuencia.equals("ROBO PARCIAL")) {
            if (!codAbogado.equals("null")) {
                this.individualSiniestroUI.inputAbogado.sendKeys(codAbogado);
                Util.explicitWait(1);
                Util.tab(manager.getDriver());
                Util.pageStatus(manager.getDriver());
            }
        }
        Util.scrollToElement(manager.getDriver(), "//*[@id='COD_ABOGADO']");
    }

    @ShotAfter(evidenceName = "Llenamos datos del conductor")
    public void datosComplementarios3new(String nombre, String apellidoPat, String apellidoMat) {
        this.individualSiniestroUI.inputNombreConductor.sendKeys(nombre);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputApellidoConductor.sendKeys(apellidoPat);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputApellidoMaternoDC.sendKeys(apellidoMat);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.individualSiniestroUI.inputEdadConductor.sendKeys("27");
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Llenamos datos de la cita")
    public void datosComplementarios4new(String cita, String codEstado, String codPoblacionRT, String calleyNoRT, String coloniaRT, String entreCallesRT, String referenciaRT, String cpRT, String latitud, String longitud) {
        this.individualSiniestroUI.inputCita.sendKeys(cita);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        if (cita.equals("S")) {
            this.individualSiniestroUI.inputHrCita.sendKeys("16:00");
            Util.tab(manager.getDriver());
            Util.explicitWait(2);
            this.individualSiniestroUI.inputUbiCita.sendKeys("S");
            Util.tab(manager.getDriver());
            LocalDate currentDate = LocalDate.now();
            LocalDate previousMonth = currentDate.plusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String nextDay = previousMonth.format(formatter);
            this.individualSiniestroUI.inputFechaCita.sendKeys(nextDay);
            Util.tab(manager.getDriver());
            Util.explicitWait(2);
            this.individualSiniestroUI.inputEstadoCita.sendKeys(codEstado);
            Util.tab(manager.getDriver());
            Util.explicitWait(1);
            this.individualSiniestroUI.inputCodPoblacionCita.sendKeys(codPoblacionRT);
            Util.tab(manager.getDriver());
            Util.explicitWait(1);
            this.individualSiniestroUI.inputCalleyNo.sendKeys(calleyNoRT);
            Util.tab(manager.getDriver());
            Util.explicitWait(1);
            this.individualSiniestroUI.inputColoniaCita.sendKeys(coloniaRT);
            Util.tab(manager.getDriver());
            Util.explicitWait(1);
            this.individualSiniestroUI.inputEntreCallesCita.sendKeys(entreCallesRT);
            Util.tab(manager.getDriver());
            Util.explicitWait(1);
            this.individualSiniestroUI.inputReferenciaCita.sendKeys(referenciaRT);
            Util.tab(manager.getDriver());
            Util.explicitWait(1);
            this.individualSiniestroUI.inputCodPostalCita.sendKeys(cpRT);
            Util.tab(manager.getDriver());
            Util.explicitWait(1);
            this.individualSiniestroUI.inputLatitudCita.sendKeys(latitud);
            Util.tab(manager.getDriver());
            Util.explicitWait(1);
            this.individualSiniestroUI.inputLongitudCita.sendKeys(longitud);
            Util.tab(manager.getDriver());
            Util.explicitWait(1);
            this.individualSiniestroUI.inputEstatusCita.sendKeys("1");
            Util.tab(manager.getDriver());
            Util.explicitWait(2);
        }
    }

    @ShotAfter(evidenceName = "Tipo de ajuste")
    public void tipoAjustenew(String tipoAjuste) {
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[@id='TIP_ESTATUS_CITA']");
        this.individualSiniestroUI.inputTipoAjuste.sendKeys(tipoAjuste);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Datos complementarios5")
    public void datosComplementarios5new() {
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::u[contains(text(),'V')][1]");
        Util.clicJavascript(manager.getDriver(), "//body/descendant::u[contains(text(),'V')][1]");
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//body/descendant::u[contains(text(),'A')][1]");
        Util.clicJavascript(manager.getDriver(), "//body/descendant::u[contains(text(),'A')][1]");
        Util.explicitWait(2);
        this.individualSiniestroUI.btnVerificarDatosGlobal.click();

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.individualSiniestroUI.btnFinalizarGlobal);
        Util.explicitWait(2);
        this.individualSiniestroUI.btnFinalizarGlobal.click();
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(2);
    }


    @ShotAfter(evidenceName = "No. póliza para siniestro de autos")
    public void polizaSiniestroColisionnew () {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        //Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/descendant::label[1]")));
        this.individualSiniestroUI.labelNoEmision.isEnabled();
        String noPoliza = this.individualSiniestroUI.labelNoEmision.getText();
        String noPoliza1 = noPoliza.replace("EL SINIESTRO ", "");
        String noPoliza2 = noPoliza1.replace("SE HA CREADO CORRECTAMENTE.", "");
        ExcelData.writeJsonSiniestro("polizaSiniestroColision", noPoliza2);
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "No. póliza para siniestro de autos")
    public void polizaSiniestroRobonew () {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));

        //Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/descendant::label[1]")));
        this.individualSiniestroUI.labelNoEmision.isEnabled();
        String noPoliza = this.individualSiniestroUI.labelNoEmision.getText();
        String noPoliza1 = noPoliza.replace("EL SINIESTRO ", "");
        String noPoliza2 = noPoliza1.replace("SE HA CREADO CORRECTAMENTE.", "");
        ExcelData.writeJsonSiniestro("polizaSiniestroRobo", noPoliza2);
        Util.explicitWait(2);
    }


    }
