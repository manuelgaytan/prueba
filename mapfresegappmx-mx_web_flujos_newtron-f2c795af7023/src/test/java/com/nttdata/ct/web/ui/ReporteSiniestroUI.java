package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class ReporteSiniestroUI extends AbstractPage {

    /** Xpath menu de opciones emision - Emitir poliza **/

    @FindBy(xpath = "//body/descendant::*[text()='Siniestros'][1]")
    public WebElement selectSiniestros;
    @FindBy(xpath = "//body/descendant::*[text()='Consultar siniestro'][1]")
    public WebElement optionConsultaSiniestro;

    /** xpath Seleccionar autos individual o autos flotillas  **/

    @FindBy(xpath = "//input[@name='lssVal']")
    public WebElement inputPolizaSiniestro;
    @FindBy(xpath = "//a[contains(text(),'Causas')]")
    public WebElement tabCausas;
    @FindBy(xpath = "//*[@id=\"1\"]/td[4]")
    public WebElement causaSimiestro;

    /** xpath informacion Basica de autos individual **/

    @FindBy(xpath = "//body/descendant::*[contains(text(),'Buscar')][1]")
    public WebElement btnBuscarPoliza;

    /** xpath informacion General de autos individual **/

    @FindBy(xpath = "//*[@class=\"btn btnprimary glyphicon glyphicon-arrow-down red\"]")
    public WebElement btnBajar;
    @FindBy(xpath = "//*[contains(text(), 'ROTURA DE CRISTAL')]/preceding::*[@type=\"checkbox\"][1]")
    public WebElement checkMotivoSiniestro;

    @FindBy(xpath = "//label[contains(text(),'Aceptar')]")
    public WebElement btnAceptarInfSiniestro;

    /** xpath coaseguro **/

    @FindBy(xpath = "//*[contains(text(),'Aceptar')]")
    public WebElement btnAceptarGlobal;

    /** xpath tomador **/
    @FindBy(xpath = "//input[@name=\"lssRsnVal\" and @nwt-unique-id=\"004\"]")
    public WebElement inputMotivoSiniestro;
    @FindBy(xpath = "//textarea[@name='cisTxtVal']")
    public WebElement textareaRelato;
    @FindBy(xpath = "//textarea[@name='dmgDspVal']")
    public WebElement textareaDescripcion;
    @FindBy(xpath = "//textarea[@name='cisObsVal']")
    public WebElement textareaObsRelato;

    /** xpath Agente **/

    @FindBy(xpath = "//*[@name=\"NOM_CONDUCTOR\" and not(@disabled='disabled')]")
    public WebElement inputNombreConductor;
    @FindBy(xpath = "//*[@name=\"APE1_CONDUCTOR\" and not(@disabled='disabled')]")
    public WebElement inputApellidoConductor;
    @FindBy(xpath = "//*[@name=\"EDAD_CONDUCTOR\" and not(@disabled='disabled')]")
    public WebElement inputEdadConductor;
    @FindBy(xpath = "//*[@id='MCA_CITA']")
    public WebElement inputCita;
    @FindBy(xpath = "//*[@id='COD_PAIS']")
    public WebElement inputCodPais;
    @FindBy(xpath = "//*[@id='COD_ESTADO']")
    public WebElement inputCodEstado;
    @FindBy(xpath = "//*[@id='COD_POBLACION']")
    public WebElement inputCodPoblacion;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_UBI1']")
    public WebElement inputCalle;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_UBI2']")
    public WebElement inputColonia;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_UBI3']")
    public WebElement inputEntreCalles;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_UBI4']")
    public WebElement inputReferencia;
    @FindBy(xpath = "//*[@id='COD_POSTAL_UBI']")
    public WebElement inputCodPostal;
    @FindBy(xpath = "//*[@id='COD_POBLACION']/following::*[@mp-values-list='valueListData'][1]/..")
    public WebElement btnLupaPoblacion;
    @FindBy(xpath = "//*[text()='9007']")
    public WebElement btnOptionPoblacion;
    @FindBy(xpath = "//body/descendant::button[contains(text(),'Aceptar') and not(@disabled='disabled')][last()]")
    public WebElement aceptarLupaPoblacion;
    @FindBy(xpath = "//*[@id='COD_POSTAL_UBI']/following::*[@mp-values-list='valueListData'][1]/..")
    public WebElement btnLupaCodPostal;
    @FindBy(xpath = "//*[text()='09010']")
    public WebElement btnOptionCodPostal;
    @FindBy(xpath = "//body/descendant::u[contains(text(),'V')][1]")
    public WebElement btnVerificarDatosSiniestro;
    @FindBy(xpath = "//body/descendant::u[contains(text(),'V')][last()]")
    public WebElement btnVerificarDatosGlobal;
    @FindBy(xpath = "//body/descendant::u[contains(text(),'A')][1]")
    public WebElement btnAceptarDatos;
    @FindBy(xpath = "//body/descendant::u[contains(text(),'F')][last()]")
    public WebElement btnFinalizarGlobal;


    /** xpath Intervinientes **/

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div/div/div[1]/div/div/div[6]/div[1]/h4/a")
    public WebElement selectIntervinentes;

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

    @FindBy(xpath = "//*[@*='nextStep' and not(@disabled='disabled')]")
    public WebElement btnSiguienteGlobal;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[3]/div/ul/li[6]")
    public WebElement btnCausas;
    @FindBy(id = "//*[@id='TRANSACTION_ID'']/following::span[2]/following::*[@id='nextStep']")
    public WebElement btnSiguienteAtributos;

    @FindBy(xpath = "//body/descendant::button[@id='add' and contains(text(),'Añadir fila')][1]")
    public WebElement btnAddFila;
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
    @FindBy(xpath = "//*[@id=\"nextStep\"]")
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
    @Autowired
    public ReporteSiniestroUI(DriverManager driverManager) {
        super(driverManager);
    }

}
