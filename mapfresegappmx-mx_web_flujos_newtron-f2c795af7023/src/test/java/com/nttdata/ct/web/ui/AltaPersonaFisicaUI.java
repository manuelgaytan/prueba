package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class AltaPersonaFisicaUI extends AbstractPage {

    // Selectores Newtron

    /** Xpath login Newtron (usuario y contraseña) **/

    @FindBy(xpath = "//*[@id=\"nuuma\"]")
    public WebElement inputUser;
    @FindBy(xpath = "//*[@id=\"contrasena\"]")
    public WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"es_log\"]/..")
    public WebElement buttonLogin;


    // Validacion verificacion
    @FindBy(xpath = "//input[@name='gppVal']")
    public WebElement inputPolGrupo;
    @FindBy(xpath = "//input[@name='delVal']")
    public WebElement inputNumContrato;
    @FindBy(xpath = "//input[@name='sblVal']")
    public WebElement inputNumSubcontrato;
    @FindBy(xpath = "//*[@id='COD_TARIFA']")
    public WebElement inputTarifa;
    @FindBy(xpath = "//*[contains(text(),'Resumen')]/..")
    public WebElement btnResumen;
    @FindBy(xpath = "//span[contains(text(),'Recibos')]/preceding::*[contains(@class,'icons pmcImg')][1]")
    public WebElement btnRecibos;
    @FindBy(xpath = "//*[@name='totRcpAmn']")
    public WebElement inputPrima;

    //Ingreso menu Proveedores
    @FindBy(xpath = "//span[text()='Terceros']")
    public WebElement btnTercero;
    @FindBy (xpath = "//span[text()='Gestión proveedores']")
    public WebElement verGestionProveedor;
    @FindBy (xpath = "//span[text()='Proveedores']")
    public WebElement linkProveedor;

    //Completar campos filtros Proveedores
    @FindBy (xpath = "//label[text()='Tipo del Documento del Tercero:']")
    public WebElement getLabelTipeDocTercero;
    @FindBy (xpath = "//input[@id='thpDcmTypVal']")
    public WebElement getInputTipeDocTercero;
    @FindBy (xpath = "//label[text()='Actividad Tercero:']")
    public WebElement getLabelActividadTercero;
    @FindBy (xpath = "//input[@id='thpAcvVal']")
    public WebElement getInputActividadTercero;
    @FindBy (xpath = "//label[text()='Zona Asignación:']")
    public WebElement getLabelZonaAsignacion;
    @FindBy (xpath = "//input[@id='grzVal']")
    public WebElement getInputZonaAsignacion;
    @FindBy (xpath = "//label[text()='Documento:']")
    public WebElement getLabelDoc;
    @FindBy (xpath = "//input[@nwt-field-id='thpDcmVal']")
    public WebElement getInputDoc;
    @FindBy (xpath = "//label[text()='Código de Tercero:']")
    public WebElement getLabelCodeTercero;
    @FindBy (xpath = "//input[@nwt-field-id='thpVal']")
    public WebElement getInputCodeTercero;
    @FindBy (xpath = "//label[text()='Tipología:']")
    public WebElement getLabelTipologia;
    @FindBy (xpath = "//input[@id='tylVal']")
    public WebElement getInputTipologia;
    @FindBy (xpath = "//label[text()='Nombre:']")
    public WebElement getName;
    @FindBy (xpath = "//input[@nwt-field-id='thpNam']")
    public WebElement getInputName;
    @FindBy (xpath = "//label[text()='Tipo Estado Proveedor:']")
    public WebElement getLabelTipoEstadoProveedor;
    @FindBy (xpath = "//input[@id='splSttTypVal']")
    public WebElement getInputTipoEstadoProveedor;
    @FindBy (xpath = "//label[text()='Categoría de Proveedor:']")
    public WebElement getLabelCategoriaProveedor;
    @FindBy (xpath = "//input[@id='splCtgVal']")
    public WebElement getInputCategoriaProveedor;

    //Ingresar a Datos Basicos
    @FindBy (xpath = "//label[text()='Crear']")
    public WebElement clicBtnCrear;
    @FindBy (xpath ="//input[@mp-name='thpAcvWthpDcmTypVal']")
    public WebElement inputTecero;

    //Pantalla Datos Basicos
    @FindBy (xpath = "//div[@class='panel panel-default ng-isolate-scope']//span[text()='1 - Datos Básicos']")
    public WebElement modalDateBasic;
    @FindBy (xpath = "//div[@class='well']//label[text()='Documento:']")
    public WebElement getLabelModalDoc;
    @FindBy (xpath = "//input[@mp-name='thpAcvWthpDcmVal'] | //input[@mp-name='thpDcmVal']")
    public WebElement getInputModalDoc;
    @FindBy (xpath = "//div[@class='well']//label[text()='Tipo de Documento Tercero Padre:']")
    public WebElement getLabelModalTipoDocTercero;
    @FindBy (xpath = "//input[@mp-name='thpAcvWprnDcmTypVal']")
    public WebElement getInputModalTipoDocTercero;
    @FindBy (xpath = "//button[@accesskey='A']")
    public WebElement clicBtnAceptar;

    //Tipologia y Categoria
    @FindBy (xpath = "(//label[text()='Tipología:']/..//input[@class='form-control ng-pristine ng-animate ng-invalid-remove ng-valid-add ng-invalid-required-remove ng-valid-add-active ng-invalid-remove-active ng-valid ng-invalid-required-remove-active ng-valid-required'])[1]")
    public WebElement getInputDataBasicTipologia;
    @FindBy (xpath = "(//label[text()='Categoría de Proveedor:']/..//input[@class='form-control ng-pristine ng-animate ng-invalid-remove ng-valid-add ng-invalid-required-remove ng-valid-add-active ng-invalid-remove-active ng-valid ng-invalid-required-remove-active ng-valid-required'])[1]")
    public WebElement getInputDataBasicCategoriaProveedor;
    @FindBy (xpath = "(//a[@ng-if='objBtn.btnAcp'])[1]")
    public WebElement clicBtnAceptarTipologiaCat;

    //Datos Generales
    @FindBy (xpath = "(//label[text()='Tipo Estado Proveedor:']/..//input[@id='splSttTypVal'])[2]")
    public WebElement getInputGeneralTipoStateProveedor;
    @FindBy (xpath = "(//a[@ng-if='objBtn.btnAcp'])[2]")
    public WebElement clicBtnAceptarDatosGenerales;

    //Persona
    @FindBy (xpath = "//input[@id='thpPrsNam']")
    public WebElement getInputPersonaNombre;
    @FindBy (xpath = "//input[@mp-name='thpPrsWthpFrsSrn']")
    public WebElement getInputApellido1;
    @FindBy (xpath = "//input[@mp-name='thpPrsWthpScnSrn']")
    public WebElement getInputApellido2;

    //Contacto
    @FindBy (xpath = "//h3[text()='Contacto']/..//a[@ng-show='options.crud.create']//label[text()='Añadir']")
    public WebElement clicBtnAnadirContacto;
    @FindBy (xpath = "//h3[text()='Contacto']/..//input[@id='cnhUseTypVal']")
    public WebElement getInputContactTipoUsoMedioContacto;
    @FindBy (xpath = "//h3[text()='Contacto']/..//input[@id='cnhTypVal']")
    public WebElement getInputContactTipoMedioContacto;
    @FindBy (xpath = "//h3[text()='Contacto']/..//input[@name='cnhTxtVal']")
    public WebElement getInputContactValorMedioContacto;
    @FindBy (xpath = "//h3[text()='Contacto']/..//input[@name='cnhNam']")
    public WebElement getInputContactNameMedioContacto;
    @FindBy (xpath = "//h3[text()='Contacto']/..//input[@name='cntFrsScnSrn']")
    public WebElement getInputContactApellidoContacto;
    @FindBy (xpath = "//h3[text()='Contacto']/..//input[@name='pstTypVal']")
    public WebElement getInputContactTipoCargoEmpresa;
    @FindBy (xpath = "//h3[text()='Contacto']/..//input[@name='obsVal']")
    public WebElement getInputContactObservacion;
    @FindBy (xpath = "//h3[text()='Contacto']/..//input[@name='dflCnh']")
    public WebElement clicCheckBoxRegistroDefecto;
    @FindBy (xpath = "//h3[text()='Contacto']/..//input[@name='cnhCck']")
    public WebElement clicCheckBoxContactoComprobado;
    @FindBy (xpath = "//h3[text()='Contacto']/..//input[@name='ptyCnh']")
    public WebElement clicCheckBoxContactoPrioritario;
    @FindBy (xpath = "//h3[text()='Contacto']/..//a[@ng-show='options.crud.create || options.crud.update || options.crud.copy  || options.crud.initial || options.crud.restore']//label[text()='Confirmar']")
    public WebElement clicBtnConfirmarContacto;

    //Dirección
    @FindBy (xpath = "//h3[text()='Dirección']/..//a[@ng-show='options.crud.create']//label[text()='Añadir']")
    public WebElement clicBtnAnadirDireccion;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@id='adrUseTypVal']")
    public WebElement getInputDireccionTipoDireccion;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@id='cnyVal']")
    public WebElement getInputDireccionPais;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@id='pvcVal']")
    public WebElement getInputDireccionProvincia;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@id='ditVal']")
    public WebElement getInputDireccionDistrito;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@id='sttVal']")
    public WebElement getInputDireccionEstado;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@id='twnVal']")
    public WebElement getInputDireccionCiudad;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@id='pslCodVal']")
    public WebElement getInputDireccionCodigoPostal;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@id='dmlTypVal']")
    public WebElement getInputDireccionTipoDomicilio;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@name='adrTxtVal']")
    public WebElement getInputDireccionAddress;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@name='adrNbrVal']")
    public WebElement getInputDireccionNumber;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@name='dflAdr']")
    public WebElement clicCheckboxDireccionDefecto;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@name='adrCck']")
    public WebElement clicCheckboxDireccionDomicilioComprobado;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@name='taxDml']")
    public WebElement clicCheckboxDireccionDomicilioFiscal;
    @FindBy (xpath = "//h3[text()='Dirección']/..//input[@name='obsVal']")
    public WebElement getInputDireccionObservacion;
    @FindBy (xpath = "//h3[text()='Dirección']/..//a[@ng-show='options.crud.create || options.crud.update || options.crud.copy  || options.crud.initial || options.crud.restore']//label[text()='Confirmar']")
    public WebElement clicBtnConfirmarDireccion;

    //Documentos Alternativos
    @FindBy (xpath = "(//a[@ng-show='objBtn.btnAdd.vsb']//label[text()='Añadir'])[1]")
    public WebElement clicBtnAnadirDocAlter;
    @FindBy (xpath = "//h3[text()='Documento Alternativo']/..//input[@name='alrThpDcmTypVal']")
    public WebElement getInputDocAlterTipoDocumento;
    @FindBy (xpath = "//h3[text()='Documento Alternativo']/..//input[@name='alrThpDcmCnyVal']")
    public WebElement getInputDocAfterPaisDoc;
    @FindBy (xpath = "//h3[text()='Documento Alternativo']/..//input[@name='alrThpDcmVal']")
    public WebElement getInputDoctAlterDocumento;
    @FindBy (xpath = "//h3[text()='Documento Alternativo']/..//input[@name='alrThpDcmCck']")
    public WebElement getClicCheckBoxDocAfterDocComprobado;
    @FindBy (xpath = "//h3[text()='Documento Alternativo']/..//input[@mp-name='alrThpDcmObsCckMth']")
    public WebElement getInputDocAfterObsrDoc;
    @FindBy (xpath = "(//a[@ng-show='objBtn.btnCnf.vsb']//label[text()='Confirmar'])[1]")
    public WebElement clicBtnConfirmarDocAfter;

    //Datos Bancarios
    @FindBy (xpath = "//body/descendant::span[contains(text(),'Datos bancarios')]/../../../..//span[text()='Añadir']")
    public WebElement clicBtnAnadirDataBank;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='pcmTypVal']")
    public WebElement getInputDataBankTipoPagoCobro;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='pcmCssVal']")
    public WebElement getInputDataBankClasePagoCobro;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='entTypVal']")
    public WebElement getInputDataBankTipoEntidad;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='bneVal']")
    public WebElement getInputDataBankEntidadBancaria;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='cnyVal']")
    public WebElement getInputDataBankPais;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='hlrNam']")
    public WebElement getInputDataBankTitular;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='tknTypVal']")
    public WebElement getInputDataBankTipoToken;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='tknVal']")
    public WebElement getInputDataBankTokenPagoCobro;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='pcmVal']")
    public WebElement getInputDataBankValorPagoCobro;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='pcmKeyVal']")
    public WebElement getInputDataBankClavePagoCobro;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='mvmPcmTypVal']")
    public WebElement getInputDataBankTipoMovimiento;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='mvmPcmUseTypVal']")
    public WebElement getInputDataBankMedioPagoCobro;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='crnVal']")
    public WebElement getInputDataBankMoneda;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='expMnh']")
    public WebElement getInputDataBankMesVencimiento;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='expYer']")
    public WebElement getInputDataBankAnoVencimiento;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='pcmCck']")
    public WebElement getClicCheckBoxDataBankPagoCobroValidado;

    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='dflPcm']")
    public WebElement CheckBoxMedioPagoCobroDefecto;
    @FindBy (xpath = "//h3[text()='Datos bancarios']/..//input[@id='pcmFav']")
    public WebElement CheckBoxMedioPagoCobroPreferido;

    @FindBy (xpath = "//body/descendant::span[contains(text(),'Datos bancarios')]/../../../..//span[text()='Confirmar']")
    public WebElement clicBtnConfirmarDataBank;

    //Crear Persona
    @FindBy (xpath = "//button[@accesskey='btnCrt.ack']")
    public WebElement clicCrearPersona;

    //RFC existente
    @FindBy (xpath = "//div[@ng-repeat='error in alert.content.errors']")
    public WebElement viewModalAlertDataBasic;
    @FindBy (xpath = "//div[@role='alert']")
    public WebElement viewIconAlertDataBasic;
    @FindBy (xpath = "//h1[@class='h2 ng-binding']")
    public WebElement viewTitleAlertDataBasic;
    @FindBy (xpath = "//a[@class='ng-binding']")
    public WebElement viewMssgAlertDataBasic;

    //Icono de Lupa
    @FindBy (xpath = "//input[@nwt-field-id='thpDcmVal']/../..//button[@class='btn btn-default btn-icon-textless-search ng-isolate-scope']")
    public WebElement IconSearchDoc;

    //DIRECCIÓN AMPLIA
    @FindBy (xpath = "//h3[text()='Dirección']/..//a[@ng-show='options.crud.update']//label[@class='textSm ng-binding']")
    public WebElement clicBtnModificarDireccion;
    @FindBy (xpath = "//button[@id='btnSrh']")
    public WebElement clicBtnBuscar;
    @FindBy (xpath = "(//tr[@class='ui-widget-content jqgrow ui-row-ltr oddRow'])[1]")
    public WebElement getSelectFilaProveedor;
    @FindBy (xpath = "//a[@ng-show='objBtn.btnQry.vsb']")
    public WebElement clicBtnConsulta;
    @FindBy (xpath = "//table[@id='gridThpGtpVldDat']//..//..//tr[@id='1']//td[@role='gridcell']")
    public WebElement getSelectFilaConsulta;
    @FindBy (xpath = "//button[@id='btnAcp']")
    public WebElement clicFilaConsultaAceptar;
    @FindBy (xpath = "//div[@class='modal-content ui-resizable']")
    public WebElement modalConsultaProveedor;


//    @FindBy (xpath = "")
//    public WebElement ;

    public AltaPersonaFisicaUI(DriverManager driverManager){
        super(driverManager);
    }
}
