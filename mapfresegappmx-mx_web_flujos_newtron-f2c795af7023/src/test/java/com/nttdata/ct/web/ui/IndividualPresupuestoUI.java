package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class IndividualPresupuestoUI extends AbstractPage {

    /** Xpath menu de opciones emision - Emitir poliza **/

    @FindBy(xpath = "//body/descendant::*[text()='Emisión'][1]")
    public WebElement selectEmision;
    @FindBy(xpath = "//body/descendant::span[contains(text(),'Emitir presupuesto')][1]")
    public WebElement btnEmiPres;

    /** xpath Seleccionar autos individual o autos flotillas  **/

    @FindBy(xpath = "//*[@id=\"1\"]/td[1]/div/button")
    public WebElement btnAutoIndi;
    @FindBy(xpath = "//*[@id=\"2\"]/td[1]/div/button")
    public WebElement btnAutoFloti;

    /** xpath informacion Basica de autos individual **/

    @FindBy(xpath = "//span[text()='Información Básica']/following::u[contains(text(),'A')][1]")
    public WebElement btnAcceptIB;

    /** xpath informacion General de autos individual **/

    @FindBy(xpath = "//*[@nwt-unique-id='00J']")
    public WebElement inputMoneda;

    @FindBy(xpath = "//span[@class=\"ng-scope ng-binding\" and text()='Información General']/following::u[contains(text(),'A')][1]")
    public WebElement btnAcceptIG;

    /** xpath coaseguro **/

    @FindBy(xpath = "//*[@class='ng-scope ng-binding' and contains(text(),'Coaseguro')]")
    public WebElement selectCoaseguro;

    /** xpath tomador **/
    @FindBy(xpath = "//body/descendant::span[contains(text(), 'Tomador')]")
    public WebElement selectTomador;
    @FindBy(xpath = "//body/descendant::*[@id=\"thpDcmTypVal\"][1]")
    public WebElement inputTipDocRFC;
    @FindBy(xpath = "//body/descendant::*[@name=\"thpDcmVal\"][1]")
    public WebElement inputDocRFCUser;
    @FindBy(xpath = "//span[text()='Tomador']/following::u[contains(text(),'A')][1]")
    public WebElement btnAcceptTom;

    /** xpath Agente **/

    @FindBy(xpath = "//span[contains(text(),'Agente')]")
    public WebElement selectAgente;
    @FindBy(xpath = "//*[@id='oPlyInaForm.oPlyInaS.thpValMan']")
    public WebElement inputCodTer;
    @FindBy(xpath = "//span[@class=\"ng-scope ng-binding\" and contains(text(),'Información General')]/following::*[@class='btn btn-default btn-icon-textless-search ng-isolate-scope'][1]")
    public WebElement lupa1;
    @FindBy(xpath = "//*[contains(text(),'PESOS')]")
    public WebElement optionMoneda;

    @FindBy(xpath = "//*[contains(text(),'Agente principal')]/following::*[@class='btn btn-default btn-icon-textless-search ng-isolate-scope'][2]/..")
    public WebElement lupa2;
    @FindBy(xpath = "//*[contains(text(),'Agente principal')]/following::*[@class='btn btn-default btn-icon-textless-search ng-isolate-scope'][3]")
    public WebElement lupa3;
    @FindBy(xpath = "//*[contains(text(),'Agente principal')]/following::*[@class='btn btn-default btn-icon-textless-search ng-isolate-scope'][4]")
    public WebElement lupa4;
    @FindBy(xpath = "//button[@id='btnSrh']")
    public WebElement btnCodTerBuscar;
    @FindBy(xpath = "//body/descendant::*[@class=\"btn-navigation-label ng-binding\" and contains(text(),'Anterio')][last()]")
    public WebElement btnAnterior;
    @FindBy(xpath = "//body/descendant::*[contains(text(),'614')][last()]")
    public WebElement optionCuadCom;
    @FindBy(xpath = " //body/descendant::*[contains(text(),'Aceptar')][last()]")
    public WebElement btnAceptarLupa;
    @FindBy(xpath = "//body/descendant::*[contains(text(),'6619')][last()]")
    public WebElement optionCodOficina;
    @FindBy(xpath = "//body/descendant::*[contains(text(),'3707')][last()]")
    public WebElement optionFuenteDist;



    @FindBy(xpath = "//*[@name='cmcVal']")
    public WebElement inputCuadCom;
    @FindBy(xpath = "//*[@name='thrLvlVal']")
    public WebElement inputCodOfic;
    @FindBy(xpath = "//*[@name='thrDstHnlVal']")
    public WebElement inputFuenteDist;

    @FindBy(xpath = "//span[contains(text(),'Agente')]/following::u[contains(text(),'A')][1]")
    public WebElement btnAcceptAgent;

    /** xpath Intervinientes **/

    @FindBy(xpath = "//span[contains(text(),'Intervinientes')]")
    public WebElement selectIntervinentes;

    /** xpath Atributos poliza **/

    @FindBy(xpath = "//*[@id='app-content-container']/descendant::*[contains(text(),'Atributos póliza')]")
    public WebElement selectAtributPoli;
    @FindBy(xpath = "//*[@id=\"COD_PRODUCTO\"]")
    public WebElement inputCodProduct;
    @FindBy(xpath = "//*[@id='app-content-container']/descendant::*[contains(text(),'Atributos póliza')]/following::u[contains(text(),'A')][1]")
    public WebElement btnAcceptAPoli;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/descendant::span[last()]/..")
    public WebElement btnSiguiente;
    /** xpath Atributos segunda pantalla **/

    @FindBy(xpath = "//body/descendant::*[contains(text(),'Intervinientes')][1]")
    public WebElement intevinientesTab1;

    @FindBy(xpath = "//*[@id='btnNxt' and not(@disabled='disabled')]")
    public WebElement btnSiguienteGlobal;
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


    @FindBy(xpath = "//*[@id='btnAcp']")
    public WebElement btnAceptar;
    @FindBy(xpath = "//body/descendant::*[@class='btn-navigation-label ng-binding'][last()]/ancestor::*[@accesskey='S']")
    public WebElement btnSiguienteCotizacionFinal;
    @FindBy(xpath = "//*[@id='pmsVal']")
    public WebElement inputPlanPago;
    @FindBy(xpath = "//body/descendant::*[@class='btn btn-default btn-icon-textless-search ng-isolate-scope'][1]")
    public WebElement lupaPlanPago;
    @FindBy(xpath = "//*[contains(text(),'CONTADO')]")
    public WebElement optionPago;
    @FindBy(xpath = "//*[contains(text(),'CONTADO')]/following::*[contains(text(),'Aceptar')]")
    public WebElement aceptarPago;
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
    //*** Consulta de Presupuesto ***//
    @FindBy(xpath = "//body/descendant::*[contains(text(),'Gestión de propuestas')][1]")
    public WebElement selectGestionPropuestas;
    @FindBy(xpath = "//input[@title='Presupuesto']")
    public WebElement inputGestionPresupuesto;
    @FindBy(xpath = "//body/descendant::*[contains(text(),'Buscar')][1]")
    public WebElement btnBuscarGestionPresupuesto;


    @Autowired
    public IndividualPresupuestoUI(DriverManager driverManager) {
        super(driverManager);
    }

}
