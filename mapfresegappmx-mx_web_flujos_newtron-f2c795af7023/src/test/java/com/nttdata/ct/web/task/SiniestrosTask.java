package com.nttdata.ct.web.task;
import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.runner.Runner;
import com.nttdata.ct.web.ui.MetodosComunesUI;
import com.nttdata.ct.web.ui.SiniestrosUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.fail;

@Task
public class SiniestrosTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private SiniestrosUI siniestrosUI;
    Logger logger = Logger.getLogger(Runner.class.getName());


    /** Metodo Comun para cargar archivo 2-2 **/
    public void confirmarcargaarchivo() {
        Util.pageStatus(manager.getDriver());
        this.siniestrosUI.txtSiniestro.sendKeys();

    }

    @ShotAfter(evidenceName = "Ingresar los datos")
    public void intruducciondatos(String siniestro, String expediente) {
        Util.pageStatus(manager.getDriver());
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
        String jsonNumSimiestro = ExcelData.readJsonSiniestro("polizaSiniestroColision");

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.txtSiniestro);
        if (jsonNumSimiestro != null) {
            this.siniestrosUI.txtSiniestro.sendKeys(jsonNumSimiestro);
        } else {
            this.siniestrosUI.txtSiniestro.sendKeys(siniestro);
        }
        Util.explicitWait(1);
//        this.siniestrosUI.liExpediente.click();
//        Util.explicitWait(1);
//        WebElement opcProvincia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='" + expediente + "']")));
//        opcProvincia.click();

        this.siniestrosUI.liExpediente.sendKeys("1");
        Util.explicitWait(2);
//        Util.explicitWait(1);
//        this.siniestrosUI.btnAceptarLista.click();
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Seleccionar el motivo del siniestro")
    public void intruducciondatosseleccionarmotivo(){

        this.siniestrosUI.btnSiguiente.click();
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(25, manager.getDriver(), this.siniestrosUI.btnFinalizar);
        this.siniestrosUI.btnFinalizar.click();
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(25, manager.getDriver(), this.siniestrosUI.opcTramitacionFinalizada);
        this.siniestrosUI.opcTramitacionFinalizada.click();
        Util.explicitWait(1);
        //Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div[1]/div[1]/div/div[5]");
        Util.scrollToElement(manager.getDriver(),"//*[contains(text(),'Cancelar')]");
        Util.explicitWait(1);
        this.siniestrosUI.btnAceptar.click();
        Util.explicitWait(1);
    }


    public void intruducciondatosfinalizar(){

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnAceptarTerminar);
        this.siniestrosUI.btnAceptarTerminar.click();
        Util.explicitWait(2);
        this.siniestrosUI.btnSalir.click();
        Util.explicitWait(3);
    }

    @ShotAfter(evidenceName = "Seleccionar Número de Siniestro a rehabilitar")
    public void introduccionrehabilitarsiniestro(String siniestro, String expediente) {
        Util.pageStatus(manager.getDriver());
        String jsonNumSimiestro = ExcelData.readJsonSiniestro("polizaSiniestroColision");

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.txtSiniestro);

        if (jsonNumSimiestro != null){
            this.siniestrosUI.txtSiniestro.sendKeys(jsonNumSimiestro);
        } else {
            this.siniestrosUI.txtSiniestro.sendKeys(siniestro);
        }
        Util.explicitWait(1);
        this.siniestrosUI.btnSiguiente.click();
        Util.explicitWait(1);
    }


    @ShotAfter(evidenceName = "Seleccionar motivo de siniestro")
    public void seleccionarmotivosiniestro() {
        Util.pageStatus(manager.getDriver());

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.opcRiesgoNoVigente);
        this.siniestrosUI.opcRiesgoNoVigente.click();
        Util.explicitWait(1);
        this.siniestrosUI.btnAceptar.click();

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.txtExpediente);
        Util.explicitWait(1);
        //Dejar el escroll antes de dar clic en siguiente ya que si no se hace scroll la pantalla siguiente no carga correctamente
        this.siniestrosUI.btnSiguiente.click();
        Util.explicitWait(2);
    }


        public void motivosiniestroexpediente() {
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnAnterior);
            //Dejar el escroll antes de dar clic en siguiente ya que si no se hace scroll la pantalla siguiente no carga correctamente
            Util.explicitWait(1);
            this.siniestrosUI.btnAnterior.click();
            Util.explicitWait(1);
            Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnSiguiente);
            //Dejar el escroll antes de dar clic en siguiente ya que si no se hace scroll la pantalla siguiente no carga correctamente
            this.siniestrosUI.btnSiguiente.click();
            Util.explicitWait(2);
            Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnAnterior);
            //Dejar el escroll antes de dar clic en siguiente ya que si no se hace scroll la pantalla siguiente no carga correctamente
            Util.explicitWait(1);
            this.siniestrosUI.btnSiguiente.click();
            //Util.scrollToElement(manager.getDriver(), "//*[@id=\"app-content-container\"]/div/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div[6]/h4");
    }

    public void consecuanciasexpediente() {
//        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.txtNombreConsecuencia);
//        Util.explicitWait(1);
//        Util.scrollToElement(manager.getDriver(), "//*[@id=\"app-content-container\"]/div/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div[6]/h4");
//        this.siniestrosUI.btnSiguiente.click();
        //Util.scrollToElement(manager.getDriver(), "//*[@id="plyAtrPssNewCtnLssSetV"]/div/div[2]/div/div/div/div/button[3]/span");
    }

        @ShotAfter(evidenceName = "Aceptar datos complementarios")
        public void datoscomplementarios() {
            //Aceptar de relato del siniestro


            Util.waitWebElementIsEnabled(30, manager.getDriver(), this.siniestrosUI.txtRelato);
            Util.explicitWait(1);
            //Util.scrollToElement(manager.getDriver(), "//button[contains(text(),'Aceptar')]");
            Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Observaciones Relato:')]");

            Util.explicitWait(1);
            this.siniestrosUI.btnAceptarRelato.click();
            Util.explicitWait(2);


            // Dar scroll hasta verificar //button[@ng-if='objBtn.btnVrf']//span[@class='ng-binding']
            //Util.scrollToElement(manager.getDriver(), "//button[normalize-space()='Verificar']");
            Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Transversal')]");
            //button[@ng-if='objBtn.btnVrf']//span[@class='ng-binding']

            this.siniestrosUI.btnVerificar.click();
            Util.explicitWait(1);
            Util.waitWebElementIsEnabled(60, manager.getDriver(), this.siniestrosUI.btnAceptar2);
            this.siniestrosUI.btnAceptar2.click();

            Util.explicitWait(2);
            this.siniestrosUI.btnVerificar.click();
            Util.explicitWait(2);
            this.siniestrosUI.btnSiguiente.click();
        }

    @ShotAfter(evidenceName = "Seleccionar el expediente")
        public void seleccionartipoexpediente() {
        Util.pageStatus(manager.getDriver());

        WebElement iframe = manager.getDriver().findElement(By.tagName("iframe"));
        manager.getDriver().switchTo().frame(iframe);
        //manager.getDriver().switchTo().frame(manager.getDriver().findElement(By.xpath("//iframe[@frameborder=\"0\"]")));
            //Aceptar de relato del siniestro
            Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.opcDefensaJuridica);
            Util.explicitWait(1);
            this.siniestrosUI.opcDefensaJuridica.click();
            Util.explicitWait(1);
        }

    public void seleccionartipoexpediente2() {


        this.siniestrosUI.btnSiguiente.click();
        Util.explicitWait(5);

        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Cancelar')]");
        //Util.scrollToElement(manager.getDriver(), "//*[@id=\"app-content-container\"]/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div/div/div/div/ul/li[4]/a/label/span");
        Util.explicitWait(1);
        this.siniestrosUI.btnAceptarExpediente.click();
        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Abogado Código')]");
    }

    @ShotAfter(evidenceName = "Seleccionar abogado")
        public void seleccionarabogado() {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.liAbogado);
        this.siniestrosUI.liAbogado.click();

        Util.explicitWait(1);
        //WebElement opcliAbogado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'MONTERO LOPEZ, MARCELINO')]")));
        WebElement opcliAbogado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@role='row'][2]")));

        opcliAbogado.click();
        Util.explicitWait(1);
        this.siniestrosUI.btnAceptarlistado.click();
        Util.explicitWait(2);
//        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
//        String str = ft.format(new Date());

        Date current = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaactual = formatter.format(current);
        this.siniestrosUI.txtFechaAsignacion.sendKeys(fechaactual);
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Visualizar apertura de expediente")
    public void aperturaexpediente() {
        this.siniestrosUI.btnVerificar.click();
        Util.explicitWait(1);
        this.siniestrosUI.btnAceptar.click();
        Util.explicitWait(2);

        this.siniestrosUI.btnVerificar.click();
        Util.explicitWait(1);
        this.siniestrosUI.btnSiguiente.click();

        Util.explicitWait(3);
        this.siniestrosUI.btnSiguiente.click();

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.siniestrosUI.txtExpedienteCreado);
        Util.explicitWait(1);
        this.siniestrosUI.btnAceptarMensajeExpediente.click();
        Util.explicitWait(1);
        this.siniestrosUI.opcDefensaJuridica.click();

        Util.explicitWait(1);
        this.siniestrosUI.btnFinalizar.click();
        Util.explicitWait(2);
        this.siniestrosUI.btnAceptarTerminarExpediente.click();
        Util.explicitWait(3);


    }

    //Modificación de expediente
    @ShotAfter(evidenceName = "Completar modificacion de expediente")
    public void introduccionmodificacionexpediente(String siniestro, String expediente) {
        Util.pageStatus(manager.getDriver());
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));

        String jsonNumSimiestro = ExcelData.readJsonSiniestro("polizaSiniestroColision");

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.txtSiniestro);

        if (jsonNumSimiestro != null){
            this.siniestrosUI.txtSiniestro.sendKeys(jsonNumSimiestro);
        } else {
            this.siniestrosUI.txtSiniestro.sendKeys(siniestro);
        }
        Util.explicitWait(1);

//        this.siniestrosUI.liExpediente.click();
//        Util.explicitWait(1);
//        WebElement opcProvincia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='" + expediente + "']")));
//        opcProvincia.click();

        this.siniestrosUI.liExpediente.sendKeys("2");
        Util.explicitWait(2);
//        Util.explicitWait(1);
//        this.siniestrosUI.btnAceptarLista.click();
        Util.explicitWait(1);
    }


    @ShotAfter(evidenceName = "Completar modificacion de expediente - motivo siniestro")
    public void introduccionmodificacionexpedientemotivosiniestro() {
        this.siniestrosUI.btnSiguiente.click();
        Util.explicitWait(1);

        this.siniestrosUI.opcConfirmacionAjustador.click();
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Actualizar la información de Abogado")
    public void modificacionexpedienteactualizarabogado() {
        this.siniestrosUI.btnAceptar.click();

        Util.explicitWait(2);
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnAceptar);
        this.siniestrosUI.btnAceptar.click();
        Util.explicitWait(1);
        this.siniestrosUI.btnMostrarDefensaJuridica.click();

        this.siniestrosUI.txtAbogado.clear();
        this.siniestrosUI.txtAbogado.sendKeys("49226");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());

        this.siniestrosUI.btnVerificar.click();
        Util.explicitWait(2);
        this.siniestrosUI.btnAceptarDefensa.click();
    }


    @ShotAfter(evidenceName = "FInalizar modificacion de Expediente")
    public void finalizarmodificacionexpediente() {
        Util.explicitWait(2);
        this.siniestrosUI.btnVerificar.click();
        Util.explicitWait(2);
//        this.siniestrosUI.btnAceptar2.click();
//        Util.explicitWait(2);
//
//        this.siniestrosUI.btnVerificar.click();
//        Util.explicitWait(2);
        this.siniestrosUI.btnSiguiente.click();

        Util.explicitWait(2);
        this.siniestrosUI.btnFinalizar.click();
        Util.explicitWait(1);
    }


    //Rehabilitacion de siniestro
    @ShotAfter(evidenceName = "Introducción a modificar Siniestro")
    public void introduccionmodificacionsiniestro(String siniestro) {
        Util.pageStatus(manager.getDriver());
        String jsonNumSimiestro = ExcelData.readJsonSiniestro("polizaSiniestroColision");

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.txtSiniestro);

        if (jsonNumSimiestro != null){
            this.siniestrosUI.txtSiniestro.sendKeys(jsonNumSimiestro);
        } else {
            this.siniestrosUI.txtSiniestro.sendKeys(siniestro);
        }
        Util.explicitWait(1);

    }

    @ShotAfter(evidenceName = "Modificar Siniestro")
    public void modificarsiniestro() {
        this.siniestrosUI.btnSiguiente.click();
        Util.explicitWait(1);

//        WebElement iframe = manager.getDriver().findElement(By.tagName("iframe"));
//        manager.getDriver().switchTo().frame(iframe);

        //motivo de siniestro Seleccionar riesgo no vigente
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.siniestrosUI.opcConfirmacionAjustador);
        Util.explicitWait(2);
        this.siniestrosUI.opcConfirmacionAjustador.click();
        Util.explicitWait(1);
    }


        @ShotAfter(evidenceName = "Consecuencias Siniestro")
        public void consecuenciassiniestro() {
            this.siniestrosUI.btnAceptar.click();


            //this.siniestrosUI.btnSiguiente.click();
            Util.explicitWait(1);

            Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnVerificar);
            this.siniestrosUI.btnVerificar.click();
            Util.explicitWait(3);
            this.siniestrosUI.btnSiguiente.click();
            Util.explicitWait(1);
            Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnSiguiente);
        }

            @ShotAfter(evidenceName = "Datos complementarios del Siniestro")
            public void datoscomplementariosmodificacionsiniestro() {



                this.siniestrosUI.btnAnteriorConsecuencia.click();

                Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnVerificar);
                this.siniestrosUI.btnVerificar.click();
                Util.explicitWait(3);
                this.siniestrosUI.btnSiguiente.click();
                Util.explicitWait(1);
                Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnSiguiente);
                this.siniestrosUI.btnSiguiente.click();

                Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.txtMensajeAdvertencia);
                this.siniestrosUI.btnAceptarMensajeAdvertencia.click();

                Util.explicitWait(1);
                //Util.scrollToElement(manager.getDriver(),"//button[normalize-space()='Aceptar']");//div[@class='row pull-right']
                Util.scrollToElement(manager.getDriver(),"//*[contains(text(),'Observaciones ')]");
                Util.explicitWait(2);
                this.siniestrosUI.btnAceptar.click();   //Marca error aqui

                Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.txtColonia);
                this.siniestrosUI.txtColonia.clear();
                Util.explicitWait(1);
                this.siniestrosUI.txtColonia.sendKeys("Parque Independencia");
                Util.explicitWait(1);


                Util.scrollToElement(manager.getDriver(), "//*[@id=\"MCA_CON_COSTO\"]");
                this.siniestrosUI.txtCosto.sendKeys("N");
                Util.explicitWait(1);
                Util.scrollToElement(manager.getDriver(),"//*[contains(text(),'Transversal')]");
                Util.explicitWait(1);
                this.siniestrosUI.btnVerificarCita.click();
                Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnAceptar3);
                this.siniestrosUI.btnAceptar3.click();
                Util.explicitWait(1);
                this.siniestrosUI.btnVerificar.click();
                Util.explicitWait(1);
                this.siniestrosUI.btnFinalizar.click();

                Util.explicitWait(3);

    }

    @ShotAfter(evidenceName = "Introduccion de datos apertura de expediente")
    public void intruducciondatosaperturaexpediente(String siniestro) {

        Util.pageStatus(manager.getDriver());
        String jsonNumSimiestro = ExcelData.readJsonSiniestro("polizaSiniestroColision");

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.txtSiniestro);

        if (jsonNumSimiestro != null) {
            this.siniestrosUI.txtSiniestro.sendKeys(jsonNumSimiestro);
        } else {
            this.siniestrosUI.txtSiniestro.sendKeys(siniestro);
        }
        Util.tab(manager.getDriver());

        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnSiguiente);
    }

    @ShotAfter(evidenceName = "Pantalla tipo de expediente")
    public void pantallatipoexpediente() {
        this.siniestrosUI.btnSiguiente.click();
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnDanoMaterial);
        this.siniestrosUI.btnDanoMaterial.click();
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.siniestrosUI.btnSiguiente);
    }

    @ShotAfter(evidenceName = "Validar que se muestre la ventana de error")
    public void ventanaerror() {
        this.siniestrosUI.btnSiguiente.click();
        Util.explicitWait(1);
        if(Util.webElementIsEnabled(10,manager.getDriver(),this.siniestrosUI.ventanaError)) {
            logger.log(Level.INFO, "Se muestra una ventana de Error:\n\"********************************************************************\"" +
                    "\n********************************************************************\"" +
                    "\n********************************************************************\"" +
                    "\n"+this.siniestrosUI.ventanaError.getText()+" \n"+this.siniestrosUI.detalleError.getText()+
                    "\n********************************************************************\"" +
                    "\n********************************************************************\"" +
                    "\n********************************************************************\"" +
                    "\n********************************************************************\"\n\n\n\n");
        }else{
            fail("********************************************************************\\\"\" +\n" +
                    "                    \"\\n********************************************************************\\\"\" +\n" +
                    "                    \"\\n********************************************************************\\\"\" +\n" +
                    "                    \"\\n\"No se muestra muestra una ventana de Error:\\n" +
                    "                    \"\\n********************************************************************\\\"\" +\n" +
                    "                    \"\\n********************************************************************\\\"\" +\n" +
                    "                    \"\\n********************************************************************\\\"\\n\\n\\n\\n\"");
    }

    }

}