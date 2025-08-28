package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class AltaAgenteUI extends AbstractPage {
    /**
     *______CP001_Crear agente y completar datos basicos
     * **/
    @FindBy(xpath = "//body/descendant::*[text()='Terceros'][1]")
    public WebElement btnTerceros;
    @FindBy(xpath = "//a[span[text()='Rutina de terceros']]")
    public WebElement btnRutinaTerceros;
    @FindBy(xpath = "//a[label[text()='Crear']]")
    public WebElement btnCrear;
    @FindBy(xpath = "//input[@name='JBTHP_NAM']")
    public WebElement txtNomRazonSocial;
    @FindBy(xpath = "//input[@name='JBTHP_FRS_SRN']")
    public WebElement txtPrimerApellido;
    @FindBy(xpath = "//input[@name='JBTHP_SCN_SRN']")
    public WebElement txtSegundoApellido;
    @FindBy(xpath = "//input[@name='JBBRD_DAT']")
    public WebElement txtFechaNacimiento;
    @FindBy(xpath = "//input[@name='JBPHY_PRS']")
    public WebElement txtPersonaFisica;
    @FindBy(xpath = "//input[@name='thpAcvWthpDcmVal']")
    public WebElement txtDocumento;
    @FindBy(xpath = "//input[@name='thpAcvWthpDcmTypVal']")
    public WebElement txtTipoDocumento;
    @FindBy(xpath = "//input[@name='thpAcvVal']")
    public WebElement txtActividad;
    @FindBy(xpath = "//input[@name='thpAcvWthpVal']")
    public WebElement txtCodTercero;
    @FindBy(xpath = "//button[contains(text(), 'ceptar')]")
    public WebElement btnAceptarTerceros;
    @FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div/button[1]")
    public WebElement cerrarModal;
    /**
     * ---CP002_Completar datos persona legal
     * **/
    @FindBy(xpath = "//input[@name='thpPrsWthpAls']")
    public WebElement txtAliasTercero;
    @FindBy(xpath = "//input[@name='thpPrsWthpNam']")
    public WebElement txtNombrePersona;
    @FindBy(xpath = "//input[@name='thpPrsWthpFrsSrn']")
    public WebElement txtApellidoPersona1;
    @FindBy(xpath = "//input[@name='thpPrsWthpScnSrn']")
    public WebElement txtApellidoPersona2;

    /**
     * ---CP004_Completar datos agente
     * **/
    @FindBy(xpath = "//input[@name='agnStsTypVal']")
    public WebElement inputSituacion;
    @FindBy(xpath = "//input[@name='bnfCssVal']")
    public WebElement inpClaseBeneficiario;
    @FindBy(xpath = "//input[@name='thrLvlVal']")
    public WebElement inputComercial;
    @FindBy(xpath = "//input[@name='agnTypVal']")
    public WebElement inpTipoAgente;
    @FindBy(xpath = "//input[@name='thrDstHnlVal']")
    public WebElement inpProduccionDirecta;
    @FindBy(xpath = "//input[@name='rtnTypVal']")
    public WebElement inpTipoRetencion;
    @FindBy(xpath = "//input[@name='mtcVal']")
    public WebElement inpFormaTerceroCobraPaga;
    @FindBy(xpath = "//input[@name='thpQltVal']")
    public WebElement inpCalidadTercero;
    @FindBy(xpath = "//input[@name='thpGrgVal']")
    public WebElement inpAgrupamientoTercero;
    @FindBy(xpath = "//input[@name='oThpAgnForm.oThpAgnS.magMth']")
    public WebElement inpFormaGestion;
    @FindBy(xpath = "//input[@name='oThpAgnForm.oThpAgnS.cftVal']")
    public WebElement inpTipoClasificacion;
    /**
     *
     * **/
    @FindBy(xpath = "//button[span[text()='Fuentes de Producción']]")
    public WebElement btnFuentesProduccion;
    @FindBy(xpath = "//a[label[text()='Crear']]")
    public WebElement botonCrear;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[1]/fieldset[2]/div[1]/div/div/div/div/div/div[1]/div/div/div[1]/input")
    public WebElement inputCanalDistribucion;
    @FindBy(xpath = "//input[@name='vldDat']")
    public WebElement inpFechaValidez;
    @FindBy(xpath = "//a[label/span[text()='ceptar']]")
    public WebElement btonAceptar;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[2]/div/div/div/button")
    public WebElement btonSalir;
    @FindBy(xpath = "//button[text()='Crear']")
    public WebElement btonCrear;
    /**
     * CP005_Consultar en rutina de terceros
     * **/
    @FindBy(xpath = "//input[@id=\"thpDcmTypVal\"]")
    public WebElement inputTipoDocumentoTercero;
    @FindBy(xpath = "//input[@name='thpDcmVal']")
    public WebElement inputDocumento;
    @FindBy(xpath = "//input[@id=\"thpAcvVal\"]")
    public WebElement inputActividadTercero;
    @FindBy(xpath = "//button[@id=\"btnSrh\"]")
    public WebElement btonBuscar;
    @FindBy(xpath = "//*[@id=\"1\"]")
    public WebElement selectDocumento;
    @FindBy(xpath = "//*[@id=\"1\"]/td[4]")
    public WebElement rfcDocumento;
    @FindBy(xpath = "//a[label[text()='Consultar']]\n")
    public WebElement btnConsultar;
    @FindBy(xpath = "//button[contains(text(),'ceptar')]")
    public WebElement btnAceptarConsulta;

    private AltaAgenteUI(DriverManager driverManager) {
        super(driverManager);
    }
}

