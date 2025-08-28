package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class AltaTercerosConAmpersonenRFCUI extends AbstractPage {

    /*************************/
    /** Alta Terceros con & **/
    /*************************/

    /** Xpath menu Terceros **/
    @FindBy(xpath = "//body/descendant::*[text()='Terceros'][1]")
    public WebElement selectTerceros;
    @FindBy(xpath = "//body/descendant::*[text()='Rutina de terceros'][1]")
    public WebElement optionRutinaTerceros;

    /** Xpath Crear Tercero **/
    @FindBy(xpath = "//label[normalize-space()='Crear']")
    public WebElement btnCrear;
    @FindBy(xpath = "//input[@id='JBTHP_NAM']")
    public WebElement txtRazonSocial;
    @FindBy(xpath = "//*[@id='JBBRD_DAT']")
    public WebElement txtFechaConstitucion;
    @FindBy(xpath = "//input[@name='thpAcvWthpDcmTypVal']")
    public WebElement txtTipoDoc;
    @FindBy(xpath = "//*[@id='JBPHY_PRS']")
    public WebElement txtPersonFisica;
    @FindBy(xpath = "//input[@name='thpAcvWthpDcmVal']")
    public WebElement txtDocumento;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[2]")
    public WebElement btnActividad;
    @FindBy(xpath = "//*[@id=\"thpAcvWthpVal\"]")
    public WebElement txtCodigoTercero;
    @FindBy(xpath = "//button[@ng-show='closeable']")
    public WebElement btnCerrarAlerta;
    @FindBy(xpath = "//button[contains(text(),'Aceptar')]")
    public WebElement btnAceptarActividad;
    @FindBy(xpath = "//u[normalize-space()='A']")
    public WebElement btnAceptarAlta;

    /** Xpath Completar Persona Moral **/
    @FindBy(xpath = "//input[@name='phyPrs']")
    public WebElement cbMarcaFisico;
    @FindBy(xpath = "//input[@id='thpPrsNam']")
    public WebElement txtNombre;
    @FindBy(xpath = "//span[contains(text(),'Persona')]")
    public WebElement seccionPersona;

    /** Xpath Completar Contacto **/
    @FindBy(xpath = "//div[@mp-grid-crud='gridThpCnt']//div//label[@class='textSm ng-binding'][normalize-space()='Añadir']")
    public WebElement btnAñadirContacto;
    @FindBy(xpath = "//button[@id='cnhUseTypNam']//span[contains(@class,'caret')]")
    public WebElement liTipoUso;
    @FindBy(xpath = "//button[@id='cnhTypNam']//span[contains(@class,'caret')]")
    public WebElement liTipoMedioContacto;
    @FindBy(xpath = "//input[@name='cnhTxtVal']")
    public WebElement txtValorMedio;
    @FindBy(xpath = "//input[contains(@name,'rfrThp')]")
    public WebElement cbTerceroReferido;
    @FindBy(xpath = "//input[@name='dflCnh']")
    public WebElement cbRegistroDefectos;
    @FindBy(xpath = "//input[@name='ptyCnh']")
    public WebElement cbMedioContactoP;
    @FindBy(xpath = "//input[@name='cnhCck']")
    public WebElement cbMedioContactoC;//input[@id='thpCntW_vldDat']
    @FindBy(xpath = "//input[@id='thpCntW_vldDat']")
    public WebElement txtFechaValidez;
    @FindBy(xpath = "(//label[@class='textSm ng-binding'][normalize-space()='Confirmar'])[1]")
    public WebElement btnConfirmarContacto;
    @FindBy(xpath = "//span[contains(text(),'Contacto')]")
    public WebElement seccionContacto;

    /** Xpath Completar DIrección **/
    @FindBy(xpath = "(//label[contains(@class,'textSm ng-binding')][normalize-space()='Añadir'])[2]")
    public WebElement btnAñadirDireccion;
    @FindBy(xpath = "//button[@id='adrUseTypNam']//span[@class='caret']")
    public WebElement liTipoDireccion;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[33]")
    public WebElement liPais;
    @FindBy(xpath = "//input[@id='gs_ntnNam']")
    public WebElement fnPais;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[34]")
    public WebElement liEstado;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[35]")
    public WebElement liProvincia;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[36]")
    public WebElement liCiudad;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[37]")
    public WebElement liDistrito;
    @FindBy(xpath = "//*[@id=\"pslCodVal\"]")
    public WebElement txtCP;
    @FindBy(xpath = "//*[@id=\"dmlTypNam\"]/span")
    public WebElement liTipoDomicilio;
    @FindBy(xpath = "//input[@name='adrTxtVal']")
    public WebElement txtDireccion;
    @FindBy(xpath = "//input[@name='dflAdr']")
    public WebElement cbDireccion;
    @FindBy(xpath = "//input[@name='adrCck']")
    public WebElement cbDomicilioC;
    @FindBy(xpath = "//input[@name='taxDml']")
    public WebElement cbDomicilioF;
    @FindBy(xpath = "//input[@id='thpAdrW_vldDat']")
    public WebElement dateFechaValidezDireccion;
    @FindBy(xpath = "(//label[@class='textSm ng-binding'][normalize-space()='Confirmar'])[2]")
    public WebElement btnConfirmarDireccion;
    @FindBy(xpath = "//button[normalize-space()='Aceptar']")
    public WebElement btnAceptar;
    @FindBy(xpath = "//span[contains(text(),'Dirección')]")
    public WebElement seccionDireccion;

    /** Xpath Completar Documento Alternativo **/
    @FindBy(xpath = "(//label[@class='textSm ng-binding'][normalize-space()='Añadir'])[3]")
    public WebElement btnAñadirDocumento;
    @FindBy(xpath = "//input[@id='alrThpDcmTypVal']")
    public WebElement txtTipoDocumento;
    @FindBy(xpath = "//input[@name='alrThpDcmVal']")
    public WebElement txtDocumentoAlternativo;
    @FindBy(xpath = "//input[@id='thpArmMntW_alrThpDcmIsuDat']")
    public WebElement dateFechaEmision;
    @FindBy(xpath = "//input[@id='thpArmMntW_alrThpDcmExyDat']")
    public WebElement dateFechaCaducidad;
    @FindBy(xpath = "//input[@id='alrThpDcmCnyVal']")
    public WebElement txtPaisEmisor;
    @FindBy(xpath = "//input[@name='alrThpDcmCck']")
    public WebElement cbDocumentoC;
    @FindBy(xpath = "//input[@id='thpArmMntW_alrThpDcmCckDat']")
    public WebElement dateFechaComprobacion;
    @FindBy(xpath = "//input[@id='thpArmMntW_vldDat']")
    public WebElement dateFechaValidezDocumento;
    @FindBy(xpath = "//input[@name='alrThpDcmObsCckMth']")
    public WebElement txtObsevaciones;
    @FindBy(xpath = "(//label[@class='textSm ng-binding'][normalize-space()='Confirmar'])[3]")
    public WebElement btnConfirmarDocumento;
    @FindBy(xpath = "//span[contains(text(),'Documento')]")
    public WebElement seccionDocuAlter;

    /** Xpath Completar Datos Agente **/
    @FindBy(xpath = "//span[normalize-space()='Añadir']")
    public WebElement btnAñadirAgente;
    @FindBy(xpath = "//input[@id='oThpPcmForm.cnf.fldT.vldDat.id']")
    public WebElement dateFechaValidezDatosBancariossssss;

    @FindBy(xpath = "(//span[@class='input-group-btn'])[46]")
    public WebElement liSituacion;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[49]")
    public WebElement liTipoAgente;
    @FindBy(xpath = "//input[@id='gs_agnTypNam']")//input[@id='gs_pymThrLvlNam']
    public WebElement fnTipoAgente;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[50]")
    public WebElement liComercial;
    @FindBy(xpath = "//input[@id='gs_pymThrLvlNam']")
    public WebElement fnComercial;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[55]")
    public WebElement liFuenteProduccion;

    /** Xpath Completar Datos Bancarios **/
    //@FindBy(xpath = "//span[normalize-space()='Añadir']")
    @FindBy(xpath = "//a[@ng-if='objBtn.btnAdd']")
    public WebElement btnAñadirDatosBancarios;
    @FindBy(xpath = "//div[@mp-default-values-list-map=\"{'oThpPcmForm.oThpPcmS.pcmTypVal': 'valCod', 'oThpPcmForm.oThpPcmS.pcmTypNam': 'dspVal'}\"]//span[@class='input-group-btn']")
    public WebElement liTipoMedioPagoREC;
    @FindBy(xpath = "//*[@id=\"pcmTypNam\"]")
    public WebElement liTipoMedioPago;
    //@FindBy(xpath = "(//span[@class='input-group-btn'])[60]")
    @FindBy(xpath = "//div[@mp-default-values-list-map=\"{'oThpPcmForm.oThpPcmS.pcmCssVal': 'pcmCssVal', 'oThpPcmForm.oThpPcmS.pcmCssNam': 'pcmCssNam'}\"]//span[@class='input-group-btn']")
    public WebElement liClaseMedio;
    //@FindBy(xpath = "(//span[@class='input-group-btn'])[61]")
    @FindBy(xpath = "//div[@mp-default-values-list-map=\"{'oThpPcmForm.oThpPcmS.entTypVal': 'entTypVal', 'oThpPcmForm.oThpPcmS.entNam': 'entNam'}\"]//span[@class='input-group-btn']")
    public WebElement liTipoEntidad;
    //@FindBy(xpath = "(//span[@class='input-group-btn'])[62]")
    @FindBy(xpath = "//div[@mp-default-values-list-map=\"{'oThpPcmForm.oThpPcmS.bneVal': 'bneVal', 'oThpPcmForm.oThpPcmS.bneNam': 'bneNam'}\"]//span[@class='input-group-btn']")
    public WebElement liEntidad;
    //@FindBy(xpath = "(//span[@class='input-group-btn'])[63]")
    @FindBy(xpath = "//div[@mp-default-values-list-map=\"{'oThpPcmForm.oThpPcmS.cnyVal': 'cnyVal', 'oThpPcmForm.oThpPcmS.cnyNam': 'ntnNam'}\"]//span[@class='input-group-btn']")
    public WebElement liPaisDatosBancario;
    @FindBy(xpath = "//input[@id='hlrNam']")
    public WebElement txtTitular;
    //@FindBy(xpath = "(//span[@class='input-group-btn'])[64]")
    @FindBy(xpath = "//div[@mp-default-values-list-map=\"{'oThpPcmForm.oThpPcmS.tknTypVal': 'tknTypVal', 'oThpPcmForm.oThpPcmS.tknNam': 'tknNam'}\"]//span[@class='input-group-btn']")
    public WebElement liTipoToken;
    @FindBy(xpath = "//input[@id='tknVal']")
    public WebElement txtTokenMedio;
    @FindBy(xpath = "//input[@id='pcmVal']")
    public WebElement txtValorMedioPago;
    @FindBy(xpath = "//input[@id='pcmKeyVal']")
    public WebElement txtClaveMedioPago;

    @FindBy(xpath = "//*[@id=\"mvmPcmTypNam\"]/span")
    public WebElement liTipoMovimiento;
    @FindBy(xpath = "//*[@id=\"mvmPcmUseTypNam\"]/span")
    public WebElement liTipoUsoMovimiento;
    //@FindBy(xpath = "(//span[@class='input-group-btn'])[65]")
    @FindBy(xpath = "//div[@mp-default-values-list-map=\"{'oThpPcmForm.oThpPcmS.crnVal': 'crnVal', 'oThpPcmForm.oThpPcmS.crnNam': 'retCrnNam'}\"]//span[@class='input-group-btn']")
    public WebElement liMoneda;
    @FindBy(xpath = "//input[@id='expMnh']")
    public WebElement txtMesVencido;
    @FindBy(xpath = "//input[@id='expYer']")
    public WebElement txtAnioVencido;
    @FindBy(xpath = "//input[@id='pcmCck']")
    public WebElement cbMedioPagoCobroValidado;
    @FindBy(xpath = "//input[@id='dflPcm']")
    public WebElement cbMedioPagoCobroDefecto;
    @FindBy(xpath = "//input[@id='pcmFav']")
    public WebElement cbMedioPagoCobroPreferido;
    @FindBy(xpath = "//input[@id='oThpPcmForm.cnf.fldT.vldDat.id']")
    public WebElement dateFechaValidezDatosBancarios;
    @FindBy(xpath = "//span[normalize-space()='Confirmar']")
    public WebElement btnConfirmarDatosBancarios;//button[normalize-space()='Crear']


    @FindBy(xpath = "//button[normalize-space()='Crear']")
    public WebElement btnCrearAgente;
    @FindBy(xpath = "//span[contains(text(),'Representantes')]")
    public WebElement seccionRepreLegales;
    @FindBy(xpath = "//span[contains(text(),'Accionistas')]")
    public WebElement seccionAccionistas;

    /** Xpath Completar Datos Bancarios **/
    @FindBy(xpath = "//input[@id='thpDcmTypVal']")
    public WebElement txtDocumentoAltaTercero;
    @FindBy(xpath = "//input[@name='thpDcmVal']")
    public WebElement txtDocumentoRFC;
    @FindBy(xpath = "//input[@id='thpAcvVal']")
    public WebElement actTercero;
    @FindBy(xpath = "//input[@name='thpVal']")
    public WebElement codTercero;

    @FindBy(xpath = "//span[@class='ng-binding']")
    public WebElement btnBuscar;


    /************************/
    /** Copia de Proveedor **/
    /************************/

    /** Xpath menu Terceros **/
    @FindBy(xpath = "//body/descendant::*[text()='Proveedores'][1]")
    public WebElement optionProveedores;

    /** Xpath Copiar desde tercero **/
    @FindBy(xpath = "//button[contains(text(),'Copiar Desde')]")
    public WebElement btnCrearDesde;

    /** Xpath Alta Proveedor **/
    @FindBy(xpath = "//input[@id='thpAcvVal']")
    public WebElement txtActividadProv;
    @FindBy(xpath = "//span[@class='ng-binding']")
    public WebElement btnAceptarAltaProveedor;
    @FindBy(xpath = "//td[@title='ASEGURADOS/INSURERS']")
    public WebElement opcProveedor;
    @FindBy(xpath = "//label[normalize-space()='Seleccionar']")
    public WebElement btnSeleccionar;

    //@FindBy(xpath = "//button[@id='valuesListButton-0F2']")
    @FindBy(xpath = "//body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/span[1]")
    public WebElement liTipologia;
    //@FindBy(xpath = "//button[@id='valuesListButton-0F3']")
    @FindBy(xpath = "//body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/span[1]")
    public WebElement liCategoriaProveedor;
    @FindBy(xpath = "//*[@id=\"thpGtpMntDaaGnaSplW\"]/div/div/div[1]/div[2]/div/div[1]/div[2]")
    public WebElement liTipoEstado;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div/div/div/ul/li[4]/a/label/span")
    public WebElement btnAceptarTipologia;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div/div[1]/div/div[3]/div[2]/div/div[2]/div/div/div/div/div/div/div/div/ul/li[4]/a/label/span")
    public WebElement btnAceptarDatosGenerales;
    @FindBy(xpath = "//button[normalize-space()='Crear']")
    public WebElement btnCrearProveedor;

    /** Xpath Consultar Proveedor **/

    @FindBy(xpath = "//span[@class='btn-navigation-label ng-binding']")
    public WebElement btnAnterior;

    @FindBy(xpath = "//input[@id='thpDcmTypVal']")
    public WebElement txtTipoDocProveedor;
    @FindBy(xpath = "//input[@name='thpDcmVal']")
    public WebElement txtDocumentoProveedor;









    @Autowired
    public AltaTercerosConAmpersonenRFCUI(DriverManager driverManager) {
        super(driverManager);
    }

}
