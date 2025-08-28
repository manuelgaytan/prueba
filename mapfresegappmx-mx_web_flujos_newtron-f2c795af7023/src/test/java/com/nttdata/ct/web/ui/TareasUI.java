package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class TareasUI extends AbstractPage {


    /** Xpath menu de opciones **/

    @FindBy(xpath = "//body/descendant::*[text()='Facturación'][1]")
    public WebElement selectFacturacion;
    @FindBy(xpath = "//span[contains(text(),'Tareas')]")
    public WebElement selectTareas;


    /** xpath Seleccionar **/

    @FindBy(xpath = "(//span[contains(text(),'Envío de Archivos al Servidor')])[2]")
    public WebElement btnEnvioDeArchivosAlServidor;
    @FindBy(xpath = "//span[contains(text(),'Lanzador de tareas')]")
    public WebElement btnLanzadorDeTareas;
//span[contains(text(),'Tesorería')]

    /** xpath cargar archivo **/

    @FindBy(xpath = "//input[@name=\"fileUpload\"]")
    public WebElement btnSeleccionarArchivo;
    @FindBy(id = "fileUpload")
    public WebElement inputUpload;
    @FindBy(xpath = "//button[contains(text(),'Aceptar')]")
    public WebElement btnAceptarCargaArchivo;
    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement btnSalirCargarArchivo;

    /** xpath Lanzador de tareas **/

    @FindBy(xpath = "//input[@name='tskVal']")
    public WebElement textoTareas;
    @FindBy(xpath = "(//a[@class=\"btn btn-infoVal ng-scope\"])[2]")
    public WebElement btnAceptarTareas;
    @FindBy(xpath = "//input[@name='JBCOD_CIA']")
    public WebElement textoCodigoDeCompania;
    @FindBy(xpath = "//input[@name='BTC_MVM_CLO_TYP_VAL']")
    public WebElement textoTipoDeProceso;
    @FindBy(xpath = "//input[@name='JBFEC_PROCESO']")
    public WebElement textoFechaDeProeso;
    @FindBy(xpath = "//input[@name='JBNUM_ORDEN']")
    public WebElement textoOrden;
    @FindBy(xpath = "//input[@name='JBTIP_GESTOR']")
    public WebElement textoTipoDeGestor;
    @FindBy(xpath = "//input[@name='JBCOD_GESTOR']")
    public WebElement textoCodigoDeGestor;
    @FindBy(xpath = "//input[@name='JBTIP_NEGOCIO']")
    public WebElement textoTipoDeNegocio;
    @FindBy(xpath = "//input[@name='JBFEC_COBRO']")
    public WebElement fechaDeCobro;
    @FindBy(xpath = "//input[@name='JBDESCCOMIS_SN']")
    public WebElement textoDescuentoComision;
    @FindBy(xpath = "//input[@name='JBFORMA_COMPENSACION']")
    public WebElement textoFormatoDeCompensacion;
    @FindBy(xpath = "//input[@name='JBMCA_REPROCESO']")
    public WebElement textoReprocesaPolConErro;
    @FindBy(xpath = "//*[@id=\"JBNOMBRE_ARCHIVO\"]")
    public WebElement textoNombreArchivo;
    @FindBy(xpath = "(//span[@class=\"ng-binding\"])[3]")
    public WebElement btnAceptarAtributo;
    @FindBy(xpath = "//*[@id=\"1\"]/td[6]")
    public WebElement registroAtributo;
    @FindBy(xpath = "//span[@class=\"btn-navigation-label ng-binding\"]")
    public WebElement btnSalirAtributo;


    @FindBy(xpath = "//a[@class='marginright15 ng-scope']")
    public WebElement btnSpollInformes;
    @FindBy(xpath = "//td[starts-with(text(), 'gc_k_carga_buzon_cobro_')]")
    public WebElement identificadorInforme;
    @FindBy(xpath = "(//button[@class=\"btn btn-default btn-icon-before-detail ng-binding\"])[2]")
    public WebElement btnDescargarInforme;

    @FindBy(xpath = "//button[text()[contains(., 'alir')]]")
    public WebElement btnSalirDescargas;
    /** xpath Seleccionar **/

    @FindBy(xpath = "//span[contains(text(),'Tesorería')]")
    public WebElement btnTesoreria;
    @FindBy(xpath = "//span[contains(text(),'Aplicación de cobros')]")
    public WebElement btnAplicacionDeCobros;
    @FindBy(xpath = "//input[@name=\"btcMvmTypVal\"]")
    public WebElement btnTipoDeProceso;



    @FindBy(xpath = "//input[@name=\"lodDat\"]")
    public WebElement fechaProceso;
    @FindBy(xpath = "//input[@name=\"sndNam\"]")
    public WebElement textoNumeroAviso;


    @FindBy(xpath = "//button/span[text()='Aplicar Cobros']")
    public WebElement btnAplicarCobros;


    @FindBy(xpath = "//*[text()='Aceptar']")
    public WebElement aceptarAplicarCobros;

    @FindBy(xpath = "//button[@type='button' and @ng-if='objBtn.btnAcp']/span[text()='Aceptar']")
    public WebElement btnAplicarCobrosMasivos;

    @FindBy(xpath = "//button[@ng-click='!nextLoading && ok()']/span[text()='Aceptar']\n")
    public WebElement btnAceptarAplicacion;

    /** Historico de cobros*/
    @FindBy(xpath = "//a/span[text()='Histórico cobros']\n")
    public WebElement btnHistoricoCobros;
    @FindBy(xpath = "//*[@id='btnSrh']")
    public WebElement btnBuscar;

    @FindBy(xpath = "//*[@id=\"1\"]")
    public WebElement btnHistorico;

    @FindBy(xpath = "//*[@id=\"btnShw\"]")
    public WebElement btnConsulta;

    @FindBy(xpath = "//strong[text()='1 PESOS']")
    public WebElement validarConsultaHistorico;

    @FindBy(xpath = "//button[span[contains(text(), 'alir')]]")
    public WebElement btnSalirCobros;




    @Autowired
    public TareasUI(DriverManager driverManager) {
        super(driverManager);
    }

}
