package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class FlotillasSuplementoUI extends AbstractPage {
    // Selectores Newtron

    /** Xpath login Newtron (usuario y contraseña) **/

    @FindBy(xpath = "//*[@id=\"nuuma\"]")
    public WebElement inputUser;
    @FindBy(xpath = "//*[@id=\"contrasena\"]")
    public WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"es_log\"]/..")
    public WebElement buttonLogin;

    /** Xpath menu de opciones emision - Emitir poliza **/

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div[1]/div[2]/div[1]/div/div[1]/ul/li[1]/h2/span")
    public WebElement selectEmision;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div[1]/div[2]/div[1]/div/div[2]/div/div[1]/div/div[2]/a/span")
    public WebElement btnEmiPoli;

    /** xpath Seleccionar autos individual o autos flotillas  **/

    @FindBy(xpath = "//*[@id=\"1\"]/td[1]/div/button")
    public WebElement btnAutoIndi;
    @FindBy(xpath = "//*[@id=\"2\"]/td[1]/div/button")
    public WebElement btnAutoFloti;

    /** xpath informacion Basica de autos individual **/

    @FindBy(xpath = "//*[@id=\"plyGniCleW\"]/div[2]/div/ul/li[2]/a/label/span")
    public WebElement btnAcceptIB;

    /** xpath informacion General de autos individual **/

    @FindBy(xpath = "//*[@id=\"plyGniW_crnVal\"]")
    public WebElement inputMoneda;

    @FindBy(xpath = "//*[@id=\"plyGniW\"]/div[2]/div/ul/li[2]/a/label/span/..")
    public WebElement btnAcceptIG;

    /** xpath coaseguro **/

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/div[1]/div/div/div[3]/div[1]/h4/a/em")
    public WebElement selectCoaseguro;

    /** xpath tomador **/
    @FindBy(xpath = "//body/descendant::span[contains(text(), 'Tomador')]")
    public WebElement selectTomador;
    @FindBy(xpath = "//*[@id=\"plyInePlhW_thpDcmTypVal\"]")
    public WebElement inputTipDocRFC;
    @FindBy(xpath = "//*[@id=\"plyInePlhW_thpDcmVal\"]")
    public WebElement inputDocRFCUser;
    @FindBy(xpath = "//*[@id=\"plyInePlhW\"]/div[2]/div/ul/li[2]/a/label/span")
    public WebElement btnAcceptTom;

    /** xpath Agente **/

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div/div/div[1]/div/div/div[5]/div[1]/h4/a/em")
    public WebElement selectAgente;
    @FindBy(xpath = "//*[@id=\"plyInaSetW_thpVal\"]")
    public WebElement inputCodTer;
    @FindBy(xpath = "//*[@id=\"plyInaSetW_cmcVal\"]")
    public WebElement inputCuadCom;
    @FindBy(xpath = "//*[@id=\"plyInaSetW_thrLvlVal\"]")
    public WebElement inputCodOfic;
    @FindBy(xpath = "//*[@id=\"plyInaSetW\"]/div[2]/div/ul/li[2]/a/label/span/..")
    public WebElement btnAcceptAgent;

    /** xpath Intervinientes **/

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div/div/div[1]/div/div/div[6]/div[1]/h4/a")
    public WebElement selectIntervinentes;

    /** xpath Atributos poliza **/

    @FindBy(xpath = "//*[@id='app-content-container']/descendant::*[contains(text(),'Atributos póliza')]")
    public WebElement selectAtributPoli;
    @FindBy(xpath = "//*[@id=\"COD_PRODUCTO\"]")
    public WebElement inputCodProduct;
    @FindBy(xpath = "//*[@id=\"COD_GIRO\"]")
    public WebElement inputGiro;
    @FindBy(xpath = "//*[@id='plyAtrSetW']/descendant::span[last()]/..")
    public WebElement btnAcceptAPoli;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/descendant::span[last()]/..")
    public WebElement btnSiguiente;

    /** xpath Atributos segunda pantalla **/

    @FindBy(xpath = "//body/descendant::*[contains(text(),'Intervinientes')][1]")
    public WebElement intevinientesTab1;

    @FindBy(id = "btnNxt")
    public WebElement btnSiguienteGlobal;
    @FindBy(xpath = "//*[@id=\"btnNxt\" and not(@disabled='disabled')]")
    public WebElement btnSiguientEnable;
    @FindBy(id = "//*[@id='TRANSACTION_ID'']/following::span[2]/following::*[@id='btnNxt']")
    public WebElement btnSiguienteAtributos;

    @FindBy(xpath = "//body/descendant::button[@id='add' and contains(text(),'Añadir fila')][1]")
    public WebElement btnAddFila;
    @FindBy(xpath = "//body/descendant::*[@class='caret'][1]")
    public WebElement selectTipoBen;
    @FindBy(xpath = "//body/descendant::*[@class=\"caret\"][1]/following::span[contains(text(),'CONDUCTORES')][1]")
    public WebElement optionTpoBen;
    @FindBy(xpath = "//*[@id='saveBtn']/..")
    public WebElement btnGuardarInterviniente;
    /** xpath Atributos segunda pantalla tab atributos **/

    @FindBy(xpath = "//*[@id='COD_AMB_CIRCULACION']")
    public WebElement inputAmbCirculacion;

    @FindBy(xpath = "//body/descendant::*[@name='NUM_SERIE'][1]")
    public WebElement inputNumSerie;

    @FindBy(xpath = "//body/descendant::*[@name='COD_TIP_VEHI'][1]")
    public WebElement inputCodTipVehi;

    /** xpath riesgos **/
    @FindBy(xpath = "//*[@id=\"btnNxt\"]")
    public WebElement btnSiguienteRiesgo;

    //    @FindBy(name = "imgEntrar")
//    public WebElement btnIngresar;
    @FindBy(xpath = "//*[@id='TIP_INDEM']")
    public WebElement inputTipoIndemnizacion;

    @FindBy(xpath = "//*[@id='COD_MARCA']")
    public WebElement inputCodMarca;
    @FindBy(xpath = "//*[@id='COD_MODELO']")
    public WebElement inputCodModelo;
    @FindBy(xpath = "//*[@id='COD_SUB_MODELO']")
    public WebElement inputCodSubModelo;
    @FindBy(xpath = "//*[@id='ANIO_SUB_MODELO']")
    public WebElement inputAnioSubModelo;
    @FindBy(xpath = "//*[@id='COD_USO_VEHI']")
    public WebElement inputCodUsoVehi;
    @FindBy(xpath = "//*[@id='COD_MODALIDAD']")
    public WebElement inputCodModalidad;
    @FindBy(xpath = "//*[@id='VAL_SUB_MODELO']")
    public WebElement inputValSubmodelo;
    @FindBy(xpath = "//*[@id=\"TRANSACTION_ID\"]/following::span[2]/..")
    public WebElement btnAceptarAtributos;

    @FindBy(xpath = "//*[contains(text(), 'RC')]/following::*[@name='cvrDctValueListInput' and not(@disabled='disabled')][1]")
    public WebElement franquicia;

    @FindBy(xpath = "//*[contains(text(), 'Gastos')]/following::*[@name='cvrLmtValueListInput' and not(@disabled='disabled')][1]")
    public WebElement capital;

    @FindBy(xpath = "//*[contains(text(), 'Asistencia')]/following::*[@name='chkCvrSlc' and not(@disabled='disabled')][1]")
    public WebElement checkCapital;

    @FindBy(xpath = "//*[contains(text(), 'Calcular')]")
    public WebElement btnCalcular;
    @FindBy(xpath = "//body/descendant::input[@id='formattedInput_anlAmnBrwInput_2_0'][2]")
    public WebElement cantidadCot;
    @FindBy(xpath = "//*[contains(text(), 'RC Terceros')]/preceding::span[1]")
    public WebElement selectRcTerceros;

    // Neto
    @FindBy(xpath = "//button[contains(text(), 'Continuar Emisión')]")
    public WebElement btnObservacionContinuarEmision;
    // Neto

    @FindBy(xpath = "//*[@id='btnAcp']")
    public WebElement btnAceptar;
    @FindBy(xpath = "//body/descendant::*[@class='btn-navigation-label ng-binding'][last()]/ancestor::*[@accesskey='S']")
    public WebElement btnSiguienteCotizacionFinal;
    @FindBy(xpath = "//*[@id='pmsVal']")
    public WebElement inputPlanPago;
    @FindBy(xpath = "//body/descendant::span[@class='ng-binding'][2]/u[contains(text(),'A')]")
    public WebElement btnAceptarEmision;
    @FindBy(xpath = "//textarea[@name='txtEnrRsnTxtVal']")
    public WebElement textAreaObservaciones;
    @FindBy(xpath = "//body/descendant::label[@class='textSm'][last()]/span")
    public WebElement btnAceptarEmisionFinal;
    @FindBy(xpath = "//*[@class='ng-binding']/u[contains(text(),'F')]")
    public WebElement btnFinalizarEmision;
    @FindBy(xpath = "//div[@class='modal-body']/descendant::label[1]")
    public WebElement labelNoEmision;
    @FindBy(xpath = "//div[@class=\"modal-body\"]/following::button[@accesskey=\"A\"]/span[1]")
    public WebElement btnAceptarModal;
    @FindBy(xpath = "//*[contains(text(),'alir')]")
    public WebElement btnSalir;

    /** Xpath modificar poliza flotillas - Suplemento **/

    @FindBy(xpath = "//span[normalize-space()='Modificar póliza']")
    public WebElement btnModPoliza;

    @FindBy(xpath = "//input[@name='txtPlyVal']")
    public WebElement inputNumPoliza;
    @FindBy(xpath = "//*[@id=\"nmrEnrVal\"]")
    public WebElement inputCodSuplemento;
    @FindBy(xpath = "//*[@id=\"nwtPlyGniAltPlyAcsFrmW\"]/div/div[6]/div/div/div/div/div/div[2]/input")
    public WebElement inputSuplemento;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/button[2]")
    public WebElement btnAcceptMP;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/div/ul/li[4]/a/label/span")
    public WebElement btnAcceptUIB;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div[2]/div[2]/div/button[3]/span")
    public WebElement btnNextU;

    @FindBy(xpath = "//*[@id=\"1\"]/td[1]")
    public WebElement selectPolizaU;

    @FindBy(xpath = "//*[@id=\"btnAdd\"]")
    public WebElement btnAddCrear;

    @FindBy(xpath = "//*[@id=\"btnNxt\"]")
    public WebElement btnNextUI;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/fieldset/div/div/div/div/div[2]/div[2]/div/div[2]/fieldset/div/div[2]/div/div/div/div/ul/li[4]/a")
    public WebElement btnFinalizarEmision2;

    @FindBy(xpath = "//em[@class='pull-right panel-icon ng-scope is-closed']")
    public WebElement selectMotiSuplemento;

    @FindBy(xpath = "//input[@id='1_chkAcnTypVal']")
    public WebElement checkSelectSuplemento;

    @FindBy(xpath = "//div[@ui-view='plyIurCrtWrkRunSetV_view']//u[contains(text(),'A')]")
    public WebElement btnAcceptSuplemento;

    @FindBy(xpath = "//body/descendant::*[@name='lupaPlyValSrh'][1]")
    public WebElement btnLupaPoliza;
    @FindBy(xpath = "//body/descendant::button[contains(@name,'valListNmrEnrVal')]")
    public WebElement btnBuscarCodigoSup;
    @FindBy(xpath = "//*[@title=\"9\"]/following::*[@title=\"ENDOSO GENERAL\"][1]")
    public WebElement seleccionarEndoso;
    @FindBy(xpath = "//*[@title=\"9\"]/following::*[@title=\"ENDOSO GENERAL\"][1]/following::*[contains(text(),'Aceptar')][1]")
    public WebElement btnAceptarEndosoGeneral;
    @FindBy(xpath = "//*[@role=\"listbox\"]")
    public WebElement selectCantidad;
    @FindBy(xpath = "//*[@role=\"listbox\"]/option[@value=\"15\"]")
    public WebElement optionCantidad;
    @FindBy(xpath = "//body/descendant::u[contains(text(),'A')]")
    public WebElement btnAceptarGlobal;
    @FindBy(xpath = "//a[@id=\"btnMdf\"]/*[1]")
    public WebElement btnModificar;
    @Autowired
    public FlotillasSuplementoUI(DriverManager driverManager) {
        super(driverManager);
    }
}
