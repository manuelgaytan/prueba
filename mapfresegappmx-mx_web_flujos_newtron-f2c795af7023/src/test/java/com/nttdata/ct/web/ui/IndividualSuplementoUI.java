package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class IndividualSuplementoUI extends AbstractPage {

    /** Xpath menu de opciones emision - Consultar póliza **/

    @FindBy(xpath = "//body/descendant::*[text()='Emisión'][1]")
    public WebElement selectEmision;
    @FindBy(xpath = "//body/descendant::*[contains(text(),'Modificar póliza')][1]")
    public WebElement btnSuplementoPoliza;

    /** xpath Buscar poliza  **/

    @FindBy(xpath = "//body/descendant::*[@name='txtPlyVal'][1]")
    public WebElement inputSuplementoPoliza;
    @FindBy(xpath = "//body/descendant::*[@name='lupaPlyValSrh'][1]")
    public WebElement btnLupaPoliza;
    @FindBy(xpath = "//body/descendant::*[text()='Buscar'][1]")
    public WebElement btnBuscarPoliza;

    /** xpath informacion Basica de autos individual **/

    @FindBy(xpath = "//body/descendant::*[@class=\"icons gniImg\"][1]")
    public WebElement btnInfGeneral;

    /** xpath informacion General de autos individual **/

    @FindBy(xpath = "//body/descendant::*[contains(text(),'AUTOS INDIVIDUAL')][1]")
    public WebElement validateRamo;

    @FindBy(xpath = "//body/descendant::u[contains(text(),'A')]")
    public WebElement btnAceptarGlobal;

    /** xpath coaseguro **/

    @FindBy(xpath = "//body/descendant::*[@name=\"nmrEnrVal\"][1]")
    public WebElement inputNumCodSup1;

    @FindBy(xpath = "//body/descendant::*[@name=\"nmrEnrSbdVal\"][1]")
    public WebElement inputNumCodSup2;
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
    /** xpath tomador **/
    @FindBy(xpath = "//*[@id=\"TRANSACTION_ID\"]/following::span[2]/..")
    public WebElement btnAceptarAtributos;
    @FindBy(xpath = "//a[@class=\"btn btn-infoVal ng-scope\" and not(@disabled=\"disabled\")]/descendant::u[contains(text(),'A')][1]")
    public WebElement btnAceptarIB;

    /** xpath Agente **/

    @FindBy(xpath = "//*[@title='1']")
    public WebElement selectPolizaModificar;
    @FindBy(xpath = "//a[@id=\"btnMdf\"]/*[1]")
    public WebElement btnModificar;
    @FindBy(xpath = "//*[@id=\"rskExpDat\"]")
    public WebElement inputVencimientoRiesgo;
    @FindBy(xpath = "//*[@id=\"plyInaSetW_thrLvlVal\"]")
    public WebElement inputCodOfic;
    @FindBy(xpath = "//*[@id=\"btnNxt\" and not(@disabled='disabled')]")
    public WebElement btnSiguientEnable;

    /** xpath Datos a modificar **/

    @FindBy(xpath = "//*[@id='COD_AMB_CIRCULACION']")
    public WebElement inputAmbCirculacion;

    @FindBy(xpath = "//body/descendant::*[@name='NUM_SERIE'][1]")
    public WebElement inputNumSerie;

    @FindBy(xpath = "//body/descendant::*[@name='COD_TIP_VEHI'][1]")
    public WebElement inputCodTipVehi;

    /** xpath Atributos poliza **/

    @FindBy(xpath = "//*[@id='app-content-container']/descendant::*[contains(text(),'Atributos póliza')]")
    public WebElement selectAtributPoli;
    @FindBy(xpath = "//*[@id=\"COD_PRODUCTO\"]")
    public WebElement inputCodProduct;
    @FindBy(xpath = "//*[@id='plyAtrSetW']/descendant::span[last()]/..")
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
    @FindBy(xpath = "//*[@class='modal-body']/following::*[@class='modal-footer']/descendant::span[contains(text(),'Aceptar')][1]")
    public WebElement aceptarModalLoop;

    @FindBy(xpath = "//*[@id='btnAcp']")
    public WebElement btnAceptar;
    @FindBy(xpath = "//body/descendant::*[@class='btn-navigation-label ng-binding'][last()]/ancestor::*[@accesskey='S']")
    public WebElement btnSiguienteCotizacionFinal;

    // Neto
    @FindBy(xpath = "//button[contains(text(), 'Continuar Emisión')]")
    public WebElement btnObservacionContinuarEmision;
    // Neto

    @FindBy(xpath = "//*[@id='pmsVal']")
    public WebElement inputPlanPago;
    @FindBy(xpath = "//body/descendant::span[@class='ng-binding'][2]/u[contains(text(),'A')]")
    public WebElement btnAceptarEmision;
    @FindBy(xpath = "//textarea[@name='txtEnrRsnTxtVal']")
    public WebElement textAreaObservaciones;
    @FindBy(xpath = "//textarea[@name='txtEnrRsnTxtVal']/following::*[contains(text(),'A')][1]")
    public WebElement btnAceptarTextArea;
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

    @FindBy(xpath = "//button[text()='Continuar Emisión']\n")
    public WebElement btnContinuarEmision;

    @FindBy(xpath = "//*[contains(text(),'Motivo suplemento')]")
    public WebElement selectMotivoSuplemento;
    @FindBy(xpath = "//*[contains(text(),'Motivo suplemento')]/following::*[@name=\"chkAcnTypVal\"][1]")
    public WebElement chckMotivoSuplemento;
    @FindBy(xpath = "//*[contains(text(),'Motivo suplemento')]/following::*[@title='1']/..")
    public WebElement sinMovimientos;
    @Autowired
    public IndividualSuplementoUI(DriverManager driverManager) {
        super(driverManager);
    }

}
