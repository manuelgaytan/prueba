package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.runner.Runner;
import com.nttdata.ct.web.ui.AltaTercerosConAmpersonenRFCUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;

import static com.nttdata.ct.web.task.ExcelData.writeJsonGlobal;

@Task
public class AltaTercerosConAmpersonenRFCTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private AltaTercerosConAmpersonenRFCUI altaTercerosConAmpersonenRFCUI;
    Logger logger = Logger.getLogger(Runner.class.getName());

    String RFC;
    String NumExt;
    String DocumentoTerceros;


    /*************************/
    /** Alta Terceros con & **/
    /*************************/

    @ShotAfter(evidenceName = "Ir a Terceros")
    public void irTerceros() {
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.selectTerceros.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.optionRutinaTerceros.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Dar clic en Crear")
    public void clicCrear() {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
        Util.pageStatus(manager.getDriver());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Crear']")));
        this.altaTercerosConAmpersonenRFCUI.btnCrear.click();
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Crear tercero con & en RFC")
    public void completarFormularioTerceros(String razonsocial,String fechaconstitucion,String personafisica,String tipodocumento,String actividad) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
        Util.pageStatus(manager.getDriver());
        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.txtRazonSocial);
        this.altaTercerosConAmpersonenRFCUI.txtRazonSocial.sendKeys(razonsocial);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtFechaConstitucion.sendKeys(fechaconstitucion);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtPersonFisica.sendKeys(personafisica);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtTipoDoc.sendKeys(tipodocumento);
        Util.explicitWait(1);//1/2
        RFC = Util.generarRFCPersonaMoralconAmperson(razonsocial,fechaconstitucion);
        logger.log(Level.INFO, "El RFC generado es:" +RFC);
        this.altaTercerosConAmpersonenRFCUI.txtDocumento.sendKeys(RFC);
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnActividad.click();
        WebElement opcActividad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+actividad+"']")));
        opcActividad.click();
        this.altaTercerosConAmpersonenRFCUI.btnAceptarActividad.click();
        String valor =Util.generarnumerosaletorios();
        this.altaTercerosConAmpersonenRFCUI.txtCodigoTercero.sendKeys(valor);
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Crear tercero con & en RFC")
    public void completarFormularioTerceros(){


    }

    @ShotAfter(evidenceName = "Crear Tercero")
    public void clicAceptar() {
        Util.pageStatus(manager.getDriver());
        this.altaTercerosConAmpersonenRFCUI.btnAceptarAlta.click();
        boolean alertarfc = false;

        do {
            List<WebElement> elementVisible = manager.getDriver().findElements(By.xpath("//a[contains(text(),'MMX-20064:')] | //a[contains(text(),'MMX-20003:')] | //*[contains(text(),'Actividad Tiene errores')]"));
            int elementVisible1 = elementVisible.size();
            if (elementVisible1 < 1) {
                alertarfc = true;
                System.out.println("No se muestra la Alerta");
            }else {
                System.out.println("Alerta presente");
                this.altaTercerosConAmpersonenRFCUI.btnCerrarAlerta.click();
                NumExt = Util.generarnumerosaletorios();
                this.altaTercerosConAmpersonenRFCUI.txtCodigoTercero.clear();
                this.altaTercerosConAmpersonenRFCUI.txtCodigoTercero.sendKeys(NumExt);
                this.altaTercerosConAmpersonenRFCUI.btnAceptarAlta.click();
            }
        } while (!alertarfc);

        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");

    }

    @ShotAfter(evidenceName = "Ingresar datos Persona")
    public void completarFormularioPersona(String razonsocial) {
        Util.pageStatus(manager.getDriver());

        Util.explicitWait(1);
        //Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.txtNombre);
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.cbMarcaFisico);
        this.altaTercerosConAmpersonenRFCUI.cbMarcaFisico.click();
        this.altaTercerosConAmpersonenRFCUI.txtNombre.sendKeys(razonsocial);
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Ingresar datos Contacto")
    public void completarFormularioContacto(String tipouso,String tipomedio,String valormedio) {
        Util.pageStatus(manager.getDriver());

        /** Cerrado de sección Persona Moral*/
        Util.scrollDown(manager.getDriver(),"-300");
        this.altaTercerosConAmpersonenRFCUI.seccionPersona.click();
        Util.explicitWait(1);//1/2
        /** Fin Cerrado de sección Persona Moral*/
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
        this.altaTercerosConAmpersonenRFCUI.btnAñadirContacto.click();
        Util.scrollToElement(manager.getDriver(),"//h3[normalize-space()='Contacto']");
        Util.explicitWait(1);//1/2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@mp-grid-crud='gridThpCnt']//div//label[@class='textSm ng-binding'][normalize-space()='Confirmar']")));
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.liTipoUso.click();
        Util.explicitWait(1);//1/2
        WebElement opcTipoUso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+tipouso+"']")));
        opcTipoUso.click();
        Util.explicitWait(1);//1/2
        /*
        this.altaTercerosConAmpersonenRFCUI.liTipoMedioContacto.click();
        Util.explicitWait(1/2);
        Util.scrollDown(manager.getDriver(),"150");
        Util.explicitWait(1);//1/2
        //WebElement opcipoMedio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+tipomedio+"']")));
        WebElement opcipoMedio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), '"TEL"']")));
        opcipoMedio.click();
         */
        WebElement opcipoMedio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cnhTypVal']")));
        opcipoMedio.sendKeys(tipomedio);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtValorMedio.sendKeys(valormedio);
        Util.explicitWait(1);//1/2
        //this.altaTercerosConAmpersonenRFCUI.cbTerceroReferido.click(); No marcar
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.cbRegistroDefectos.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.cbMedioContactoP.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.cbMedioContactoC.click();
        Util.explicitWait(1);//1/2
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String str = ft.format(new Date());
        this.altaTercerosConAmpersonenRFCUI.txtFechaValidez.sendKeys(str);
        Util.explicitWait(1);//1/2
        Util.tab(manager.getDriver());
    }

    public void completardatosContacto(){
        this.altaTercerosConAmpersonenRFCUI.btnConfirmarContacto.click();
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Ingresar datos Dirección")
    public void completarFormularioDirección(String tipodireccion,String pais,String estado,String provincia,String ciudad,String distrito,String cp,String tipodomicilio,String direccion) {
        Util.pageStatus(manager.getDriver());
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));

        /** Cerrado de sección Contacto*/
        Util.scrollDown(manager.getDriver(),"-300");
        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.seccionContacto);
        this.altaTercerosConAmpersonenRFCUI.seccionContacto.click();
        Util.explicitWait(1);//1/2
        /** Fin Cerrado de sección Contacto*/

        Util.scrollToElement(manager.getDriver(),"//span[normalize-space()='Dirección']");
        this.altaTercerosConAmpersonenRFCUI.btnAñadirDireccion.click();
        Util.explicitWait(1);//1/2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='adrUseTypVal']")));
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liTipoDireccion.click();
        Util.explicitWait(1);//1/2
        WebElement opcTipoDireccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+tipodireccion+"']")));
        opcTipoDireccion.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.liPais.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.fnPais.sendKeys(pais);
        WebElement opcTipoPais = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+pais+"']")));
        opcTipoPais.click();Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liEstado.click();
        Util.explicitWait(1);//1/2
        WebElement opcEstado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+estado+"']")));
        opcEstado.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liProvincia.click();
        Util.explicitWait(1);//1/2
        WebElement opcProvincia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+provincia+"']")));
        opcProvincia.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liCiudad.click();
        Util.explicitWait(1);//1/2
        WebElement opcCuidad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+ciudad+"']")));
        opcCuidad.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        /*this.altaTercerosConAmpersonenRFCUI.liDistrito.click();
        Util.explicitWait(1);//1/2
        WebElement opcDistrito = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+distrito+"']")));
        opcDistrito.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
         */
        WebElement txtDistrito = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ditVal']")));
        txtDistrito.sendKeys(distrito);
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.txtCP.sendKeys(cp);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.liTipoDomicilio.click();
        Util.explicitWait(2);//1/2
        WebElement opcTipoDomicilio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+tipodomicilio+"']")));
        opcTipoDomicilio.click();
        this.altaTercerosConAmpersonenRFCUI.txtDireccion.sendKeys(direccion);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.cbDireccion.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.cbDomicilioC.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.cbDomicilioF.click();
        Util.explicitWait(1);//1/2
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String str = ft.format(new Date());
        this.altaTercerosConAmpersonenRFCUI.dateFechaValidezDireccion.sendKeys(str);
        Util.explicitWait(1);//1/2
        Util.tab(manager.getDriver());
    }

    public void completardatosDireccion(){
        this.altaTercerosConAmpersonenRFCUI.btnConfirmarDireccion.click();
        Util.explicitWait(1);
        Util.scrollDown(manager.getDriver(),"-300");
    }

    @ShotAfter(evidenceName = "Ingresar datos Documento Alternativo")
    public void completarFormularioDocumentoAlternativo(String tipodocumento,String documento,String paisemisor,String observaciones) {
        Util.pageStatus(manager.getDriver());
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String str = ft.format(new Date());

        /** Cerrado de sección Contacto*/
        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.seccionDireccion);
        this.altaTercerosConAmpersonenRFCUI.seccionDireccion.click();
        Util.explicitWait(1);
        /** Fin Cerrado de sección Contacto*/

        this.altaTercerosConAmpersonenRFCUI.btnAñadirDocumento.click();
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.txtTipoDocumento);
        this.altaTercerosConAmpersonenRFCUI.txtTipoDocumento.sendKeys(tipodocumento);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtDocumentoAlternativo.sendKeys(documento);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.dateFechaEmision.sendKeys(str);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.dateFechaCaducidad.sendKeys(str);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtPaisEmisor.sendKeys(paisemisor);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.cbDocumentoC.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.dateFechaComprobacion.sendKeys(str);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtObsevaciones.sendKeys(observaciones);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.dateFechaValidezDocumento.sendKeys(str);
        Util.explicitWait(1);//1/2
        Util.tab(manager.getDriver());
    }

    public void completardatosDocumentosAlternativos(){
        this.altaTercerosConAmpersonenRFCUI.btnConfirmarDocumento.click();
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Ingresar datos Agente")
    public void completarFormularioAgente(String situacion,String tipoagente,String comercial,String fuenteproduccion) {
        Util.pageStatus(manager.getDriver());
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));

        /** Cerrado de sección datos Agente*/
        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(),"//span[normalize-space()='Agente']");
        //WebElement colapsarRepresentante = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[@ng-class=\"{'is-open': lgrIsOpen, 'is-closed': !lgrIsOpen, 'is-disabled': fxdStuValidated}\"]")));
        //colapsarRepresentante.click();
        /*Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.seccionDocuAlter);
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.seccionDocuAlter.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.seccionRepreLegales.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.seccionAccionistas.click();
        Util.explicitWait(1);
         */
        /**Fin Cerrado de sección datos Agente*/
        this.altaTercerosConAmpersonenRFCUI.liSituacion.click();
        Util.explicitWait(1);//1/2
        WebElement opcSituacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+situacion+"']")));
        opcSituacion.click();
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liTipoAgente.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.fnTipoAgente.sendKeys(tipoagente);
        Util.explicitWait(1);
        WebElement opcTipoAgente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+tipoagente+"']")));
        opcTipoAgente.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liComercial.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.fnComercial.sendKeys(comercial);
        Util.explicitWait(1);
        WebElement opcComercial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+comercial+"']")));
        opcComercial.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liFuenteProduccion.click();
        Util.explicitWait(1/2);
        WebElement opcFuenteProduccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+fuenteproduccion+"']")));
        opcFuenteProduccion.click();
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);

    }

    @ShotAfter(evidenceName = "Ingresar datos Bancarios")
    public void completarFormularioDatosBancarios(String TipoMedioPago,String ClaseMedio,String TipoEntidad,String EntidadBancario,String pais,String Titular,String TipoToken,String
            TokenMedio,String ValorMedio,String ClaveMedio, String TipoMovimiento,String TipoUso,String Moneda,String MesVencido, String AnioVencimiento) {
        Util.pageStatus(manager.getDriver());
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String str = ft.format(new Date());
        Util.scrollToElement(manager.getDriver(),"//span[normalize-space()='Datos bancarios']");
        Util.scrollDown(manager.getDriver(),"300");
        Util.explicitWait(1);

        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.btnAñadirDatosBancarios);
        this.altaTercerosConAmpersonenRFCUI.btnAñadirDatosBancarios.click();
        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(),"//h3[normalize-space()='Datos bancarios']");
        Util.explicitWait(1);
        if (Util.webElementIsEnabled(4, manager.getDriver(), this.altaTercerosConAmpersonenRFCUI.liTipoMedioPagoREC))
            this.altaTercerosConAmpersonenRFCUI.liTipoMedioPagoREC.click();
        else this.altaTercerosConAmpersonenRFCUI.liTipoMedioPago.click();
        Util.explicitWait(1);//1/2
        //WebElement opcTipoMedioPago = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+TipoMedioPago+"']")));
        WebElement opcTipoMedioPago = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+TipoMedioPago+"'] | //span[normalize-space()='"+TipoMedioPago+"']")));
        opcTipoMedioPago.click();Util.explicitWait(1);//1/2
        if (Util.webElementIsEnabled(4, manager.getDriver(), this.altaTercerosConAmpersonenRFCUI.btnAceptar)) {
            this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        }
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liClaseMedio.click();
        Util.explicitWait(1);//1/2
        WebElement opcClaseMedio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+ClaseMedio+"']")));
        opcClaseMedio.click();Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liTipoEntidad.click();
        WebElement opcTipoEntidad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+TipoEntidad+"']")));
        opcTipoEntidad.click();Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liEntidad.click();
        WebElement opcEntidad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+EntidadBancario+"']")));
        opcEntidad.click();Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liPaisDatosBancario.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.fnPais.sendKeys(pais);
        Util.explicitWait(1);
        WebElement opcPaisDatosBancarios = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@aria-describedby='valuesListGrid_ntnNam']")));
        opcPaisDatosBancarios.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.txtTitular.sendKeys(Titular);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.liTipoToken.click();
        WebElement opcTipoToken = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+TipoToken+"']")));
        opcTipoToken.click();Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.txtTokenMedio.sendKeys(TokenMedio);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtValorMedioPago.sendKeys(ValorMedio);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtClaveMedioPago.sendKeys(ClaveMedio);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.liTipoMovimiento.click();
        WebElement opcTipoMovimiento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+TipoMovimiento+"']")));
        opcTipoMovimiento.click();Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.liTipoUsoMovimiento.click();
        WebElement opcTipoUsoMovimiento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+TipoUso+"']")));
        opcTipoUsoMovimiento.click();Util.explicitWait(1/2);//1/2
        this.altaTercerosConAmpersonenRFCUI.liMoneda.click();
        WebElement opcMoneda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+Moneda+"']")));
        opcMoneda.click();Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.txtMesVencido.sendKeys(MesVencido);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtAnioVencido.sendKeys(AnioVencimiento);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.cbMedioPagoCobroValidado.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.cbMedioPagoCobroDefecto.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.cbMedioPagoCobroPreferido.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.dateFechaValidezDatosBancarios.sendKeys(str);
        Util.explicitWait(1);//1/2
        Util.tab(manager.getDriver());
    }

    public void completardatosBancarios(){
        this.altaTercerosConAmpersonenRFCUI.btnConfirmarDatosBancarios.click();
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.btnCrearAgente.click();
        Util.explicitWait(1);//1/2
    }

    @ShotAfter(evidenceName = "Consulta de creación de alta de tercero")
    public void consultaAltaCreada() {
        Util.pageStatus(manager.getDriver());

        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.txtDocumentoAltaTercero);
        this.altaTercerosConAmpersonenRFCUI.txtDocumentoAltaTercero.sendKeys("RFC");
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtDocumentoRFC.sendKeys(RFC);
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnBuscar.click();
        Util.explicitWait(2);
        writeJsonGlobal("RFCAltaTerceroConAmpersan", RFC);
    }


    /******************************/
    /** Copia de Terceros con & **/
    /*****************************/

    @ShotAfter(evidenceName = "Ingresar datos de asegurado")
    public void completarFormularioAsegurado(String razonsocial,String fechaconstitucion,String personafisica,String tipodocumento,String actividad) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
        Util.pageStatus(manager.getDriver());

        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.txtRazonSocial);
        this.altaTercerosConAmpersonenRFCUI.txtRazonSocial.sendKeys(razonsocial);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtFechaConstitucion.sendKeys(fechaconstitucion);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtPersonFisica.sendKeys(personafisica);
        Util.explicitWait(1);//1/2
        this.altaTercerosConAmpersonenRFCUI.txtTipoDoc.sendKeys(tipodocumento);
        Util.explicitWait(1);//1/2
        RFC = Util.generarRFCPersonaMoral(razonsocial,fechaconstitucion);
        logger.log(Level.INFO, "El RFC generado es:" +RFC);
        this.altaTercerosConAmpersonenRFCUI.txtDocumento.sendKeys(RFC);
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnActividad.click();
        WebElement opcActividad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+actividad+"']")));
        opcActividad.click();
    }

    @ShotAfter(evidenceName = "crear datos de asegurado")
    public void crearFormularioAsegurado(String razonsocial, String fechaconstitucion,String actividad) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
        this.altaTercerosConAmpersonenRFCUI.btnAceptarActividad.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnAceptarAlta.click();
        Util.explicitWait(2);


        boolean alertarfc = false;

        do {
            List<WebElement> elementVisible = manager.getDriver().findElements(By.xpath("//*[contains(text(),'Actividad Tiene errores')] | //*[contains(text(),'MMX-20003:')]"));
            int elementVisible1 = elementVisible.size();
            if (elementVisible1 < 1) {
                alertarfc = true;
                System.out.println("No se muestra la Alerta");
            }else {
                System.out.println("Alerta presente");
                RFC = Util.generarRFCPersonaMoral(razonsocial,fechaconstitucion);
                logger.log(Level.INFO, "El RFC generado es:" +RFC);
                this.altaTercerosConAmpersonenRFCUI.txtDocumento.clear();
                this.altaTercerosConAmpersonenRFCUI.txtDocumento.sendKeys(RFC);
                Util.explicitWait(1);
                this.altaTercerosConAmpersonenRFCUI.btnActividad.click();
                WebElement opcActividad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+actividad+"']")));
                opcActividad.click();

                this.altaTercerosConAmpersonenRFCUI.btnAceptarActividad.click();
                Util.explicitWait(1);
                this.altaTercerosConAmpersonenRFCUI.btnAceptarAlta.click();
                Util.explicitWait(2);
            }
        } while (!alertarfc);


    }


        @ShotAfter(evidenceName = "copiar desde tercero")
    public void copiardesdetercero(String rfc) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
        Util.pageStatus(manager.getDriver());

        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.btnCrearDesde);
        this.altaTercerosConAmpersonenRFCUI.btnCrearDesde.click();
        Util.explicitWait(1);

        WebElement iframe = manager.getDriver().findElement(By.tagName("iframe"));
        manager.getDriver().switchTo().frame(iframe);
        WebElement txtTipoDocumento = manager.getDriver().findElement(By.cssSelector("#thpDcmTypVal"));
        txtTipoDocumento.sendKeys("RFC");
        Util.explicitWait(1);
        WebElement txtDocumento = manager.getDriver().findElement(By.cssSelector("input[name='thpDcmVal']"));
        String jsonRFC = ExcelData.readJsonGlobal("RFCAltaTerceroConAmpersan");
        if (jsonRFC != null){
            txtDocumento.sendKeys(jsonRFC);
            System.out.println("El rfc del json es:"+jsonRFC);
        } else {
            txtDocumento.sendKeys(rfc);
        }
        Util.explicitWait(1);
        WebElement txtActividadTercero = manager.getDriver().findElement(By.cssSelector("#thpAcvVal"));
        txtActividadTercero.clear();
        Util.explicitWait(1);
        txtActividadTercero.sendKeys("2");
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnBuscar.click();
        WebElement tdRFC;
        if (jsonRFC != null){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+jsonRFC+"')]")));
            tdRFC = manager.getDriver().findElement(By.xpath("//td[contains(text(),'"+jsonRFC+"')]"));
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+rfc+"')]")));
            tdRFC = manager.getDriver().findElement(By.xpath("//td[contains(text(),'"+rfc+"')]"));
        }
        tdRFC.click();
        Util.explicitWait(1);
    }

    @ShotAfter(evidenceName = "Validar copia de tercero")
    public void validarCopia(){
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        WebElement seleccionar = manager.getDriver().findElement(By.xpath("//*[contains(text(),'Seleccionar')]"));
        seleccionar.click();
        Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(),"//input[@id='thpPrsNam']");
        writeJsonGlobal("DocumentoCopiaTercero", RFC);
    }

    public void crearAlta(){
        Util.pageStatus(manager.getDriver());
        this.altaTercerosConAmpersonenRFCUI.btnCrearAgente.click();
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Consulta tercero copiado")
    public void consultarCopiaTerceros(String rfc){
        Util.pageStatus(manager.getDriver());
        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.txtTipoDocProveedor);
        this.altaTercerosConAmpersonenRFCUI.txtTipoDocProveedor.sendKeys("RFC");
        Util.explicitWait(1);

        String jsonRFC = ExcelData.readJsonGlobal("DocumentoCopiaTercero");
        if (jsonRFC != null){
            this.altaTercerosConAmpersonenRFCUI.txtDocumentoProveedor.sendKeys(jsonRFC);
        } else {
            this.altaTercerosConAmpersonenRFCUI.txtDocumentoProveedor.sendKeys(rfc);
        }
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnBuscar.click();
        Util.explicitWait(2);
    }


    /************************/
    /** Copia de Proveedor **/
    /************************/

    @ShotAfter(evidenceName = "Ir a Proveedor")
    public void irProveedor() {
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.selectTerceros.click();
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.optionProveedores.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Dar clic en Crear Proveedor")
    public void clicCrearProveedor() {
        Util.pageStatus(manager.getDriver());
        this.altaTercerosConAmpersonenRFCUI.txtActividadProv.sendKeys("17");
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnCrear.click();
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Ingresar datos de proveedor")
    public void completarFormularioProveedor(String tipodocumento,String documento) {
        Util.pageStatus(manager.getDriver());
        WebElement iframe = manager.getDriver().findElement(By.tagName("iframe"));
        manager.getDriver().switchTo().frame(iframe);
        Util.explicitWait(1);
        WebElement txtTipoDocProv = manager.getDriver().findElement(By.cssSelector("input[name='thpAcvWthpDcmTypVal']"));
        txtTipoDocProv.sendKeys(tipodocumento);
        Util.explicitWait(1);
        WebElement txtDocumentoProv = manager.getDriver().findElement(By.cssSelector("input[name='thpAcvWthpDcmVal']"));

        String jsonDocumentoAltaTercero = ExcelData.readJsonGlobal("DocumentoCopiaTercero");
        if (jsonDocumentoAltaTercero != null){
            txtDocumentoProv.sendKeys(jsonDocumentoAltaTercero);
        } else {
            txtDocumentoProv.sendKeys(documento);
        }
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnAceptarAlta.click();
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "copiar desde asegurado")
    public void copiardesdeasegurado() {
        Util.pageStatus(manager.getDriver());

        List<WebElement> elementVisible = manager.getDriver().findElements(By.xpath("//label[normalize-space()='El tercero ya existe con otra actividad']"));
        int elementVisible1 = elementVisible.size();

        if (elementVisible1 < 1) {
            System.out.println("Se muestra la Alerta");
            WebElement txtMesnajeError = manager.getDriver().findElement(By.cssSelector(".h2.ng-binding"));
            String error=txtMesnajeError.getText();
            System.out.println("Error: "+error);
            assert error.equals("Actividad Tiene errores:") : "No hay tercero para crear el proveedor,"+"\n\n"+
                    "********************************************************************"+"\n" +
                    "*** Favor de ejecutar antes el escenario: Copía de teceros con & ***"+"\n" +
                    "********************************************************************";
        }else {
            System.out.println("No se muestra la Alerta");
        }
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnAceptarAltaProveedor.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.opcProveedor.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnSeleccionar.click();
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Ingresar tipologia y categoria")
    public void ingresarTipologiayCategoria(String documento,String tipologia,String categoria) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        //Util.explicitWait(3);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("div[is-open='bscDatIsOpen'] span[class='ng-scope ng-binding']")));
        WebElement txtDocumento = manager.getDriver().findElement(By.cssSelector("div[is-open='bscDatIsOpen'] span[class='ng-scope ng-binding']"));
        String DocumentoActual=txtDocumento.getText();
        System.out.println("Documento: "+DocumentoActual);


        String documentoEx = "";

        /** Extrae el valor de documento de la cadena **/
        for (int i = 19; i < 31; i++) {
            documentoEx=documentoEx+DocumentoActual.charAt(i);
        }
        String jsonDocumentoAltaTercero = ExcelData.readJsonGlobal("DocumentoCopiaTercero");
        if (jsonDocumentoAltaTercero != null){
            assert jsonDocumentoAltaTercero.equals(documentoEx) : "El documento actual no coincide";
        } else {
            assert documento.equals(documentoEx) : "El documento actual no coincide";
        }

        Util.explicitWait(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-content-container\"]/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div/div/div/ul/li[4]/a/label/span")));
        this.altaTercerosConAmpersonenRFCUI.liTipologia.click();
        Util.explicitWait(1);
        WebElement opcTipologia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+tipologia+"']")));
        opcTipologia.click();
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.liCategoriaProveedor.click();
        Util.explicitWait(1);
        WebElement opcCategoriaProveedor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+categoria+"']")));
        opcCategoriaProveedor.click();
        this.altaTercerosConAmpersonenRFCUI.btnAceptar.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnAceptarTipologia.click();
    }

    @ShotAfter(evidenceName = "Ingresar datos generales proveedor")
    public void ingresarDatosGeneralesProveedor(String tipoestado) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(),"//em[@ng-class=\"{'is-open': bscDatIsOpen, 'is-closed': !bscDatIsOpen, 'is-disabled': fxdStuValidated}\"]");
        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.liTipoEstado);
        this.altaTercerosConAmpersonenRFCUI.liTipoEstado.click();
        Util.explicitWait(1);
        WebElement opcTipoToken = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+tipoestado+"']")));
        opcTipoToken.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnAceptarDatosGenerales.click();
    }

    @ShotAfter(evidenceName = "Crear Proveedor")
    public void crearProveedor() {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(20));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);

        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.btnCrearProveedor);
        this.altaTercerosConAmpersonenRFCUI.btnCrearProveedor.click();
        Util.explicitWait(1);

        // Esperar hasta que el elemento ya no esté visible
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[3]/div/div/div/div/div/label")));
            System.out.println("El elemento ya no está visible.");
        } catch (Exception e) {
            System.out.println("El elemento sigue siendo visible después de esperar.");
        }
    }

    @ShotAfter(evidenceName = "Ir a Rutina Terceros")
    public void irRutinaTerceros() {
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.btnAnterior);
        this.altaTercerosConAmpersonenRFCUI.btnAnterior.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.selectTerceros.click();
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.optionRutinaTerceros.click();
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Consulta proveedor copiado desde rutina de terceros")
    public void consultaCopiaProveedor(String rfc, String documento) {
        Util.pageStatus(manager.getDriver());
        Util.waitElementVisible(manager.getDriver(),this.altaTercerosConAmpersonenRFCUI.txtTipoDocProveedor);
        this.altaTercerosConAmpersonenRFCUI.txtTipoDocProveedor.sendKeys(rfc);
        Util.explicitWait(1);
        String jsonDocumento = ExcelData.readJsonGlobal("DocumentoCopiaTercero");
        if (jsonDocumento != null){
            this.altaTercerosConAmpersonenRFCUI.txtDocumentoProveedor.sendKeys(jsonDocumento);
        } else {
            this.altaTercerosConAmpersonenRFCUI.txtDocumentoProveedor.sendKeys(documento);
        }
        Util.explicitWait(1);
        this.altaTercerosConAmpersonenRFCUI.btnBuscar.click();
        Util.explicitWait(2);

    }
}
