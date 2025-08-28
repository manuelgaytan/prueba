package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class LanzadorTareasUI extends AbstractPage {

    /** Xpath menu Facturación **/
    @FindBy(xpath = "//body/descendant::*[text()='Facturación'][1]")
    public WebElement selectFacturacion;
    @FindBy(xpath = "//body/descendant::*[text()='Envío de Archivos al Servidor TronWeb Reports'][1]")
    public WebElement optionEnvioArchivo;

    /** Xpath menu Tareas **/
    @FindBy(xpath = "//body/descendant::*[text()='Tareas'][1]")
    public WebElement selectTareas;
    @FindBy(xpath = "//body/descendant::*[text()='Lanzador de tareas'][1]")
    public WebElement optionLanzadorTareas;

    @FindBy(xpath = "(//span[@class='ng-binding'])[2]")
    public WebElement btnAceptar;
    @FindBy(xpath = "//*[@id=\"formData\"]/div[2]/button")
    public WebElement btnAceptarCarga;
    @FindBy(xpath = "//*[@id=\"mp-header\"]/div[2]/div[1]/a[2]/img")
    public WebElement btnDescargar;

    @FindBy(xpath = "//input[@id='JBTIP_REP_DOMI']")
    public WebElement inputTipoReporte;
    @FindBy(xpath = "//*[contains(text(),'inalizar')]")
    public WebElement btnFinalizar;
    @FindBy(xpath = "//U[text()='F']")
    public WebElement btnFinalizarDocumento;
    @FindBy(xpath = "//table[@id='cmnRerSetW']/descendant::tr[2]/td[2]")
    public WebElement registroTarea;
    @FindBy(xpath = "//button[contains(text(),'Ver txt') or contains(text(),'Ver pdf') or contains(text(),'Ver csv')]")
    public WebElement verTxt;
    @FindBy(xpath = "//*[@id=\"1\"]/td[6]")
    public WebElement txtSituacion;

    @FindBy(xpath =  "//input[@id='JBNUM_BLOQUE_TES']")
    public WebElement bloqueoTesoreria;
    @FindBy(xpath =  "(//input[@id='JBFEC_DESDE'])[1] | (//input[@id='JBFEC_PROCESO_INI'])")
    public WebElement fechaInicio;
    @FindBy(xpath = "//*[@id='JBTIP_ANTICIPO']")
    public WebElement tipoAnticipo;

    @FindBy(xpath =  "//input[@id='JBFEC_HASTA'] | (//input[@id='JBFEC_PROCESO_FIN'])")
    public WebElement FechaFin;
    @FindBy(xpath =  "//button[@id='btnAcp']")
    public WebElement BtnAceptarAtributos;

    @FindBy(xpath =  "//*[@id=\"JBFEC_PROCESO_INI\"]")
    public WebElement FechaProceIni;

    @FindBy(xpath =  "//*[@id=\"JBFEC_PROCESO_FIN\"]")
    public WebElement FechaProceFin;


    /** xpath Imput módulo Tareas  **/

    @FindBy(xpath = "//input[@id='tskVal']")
    public WebElement inputTarea;

    @FindBy(xpath = "//*[@id=\"JBTIP_EXP_RECOBRO\"]")
    public WebElement inputTipoExpediente;

    @FindBy(xpath = "//*[@id=\"JBTIP_DETALLE\"]")
    public WebElement inputDetalle;

    @FindBy(xpath = "//*[@id=\"JBCOD_AGT\"]")
    public WebElement inputCodAgente;

    @FindBy(xpath = "//*[@id=\"JBAFILIACION_AGT\"]")
    public WebElement inputAfiliacion;
    @FindBy(xpath = "//input[@id='fileUpload']")
    public WebElement inputArchivo;
    @FindBy(xpath = "//div[@class='mp-multi-file-upload-accordion col-sm-10 col-xs-10']/span[@class='ng-binding']")
    public WebElement inputArchivoCodigo;
    @FindBy(xpath = "//*[@id=\"btnAcp\"]")
    public WebElement btnAcept;
    @FindBy(xpath = "//*[contains(text(),'alir')]")
    public WebElement btnSalir;
    @FindBy(xpath = "//input[@id='JBNOMBRE_ARCHIVO' or @id='JBFILE_NAME']")
    public WebElement txtNombreArchivo;
    @FindBy(xpath = "//input[@name='JBTIP_GESTOR']")
    public WebElement inputTipoGestor;
    @FindBy(xpath = "//input[@name='JBCOD_ENTIDAD']")
    public WebElement inputCodEntidad;
    @FindBy(xpath = "//input[@id=\"JBCOD_CIA\"]")
    public WebElement inputcodCompania;
    @FindBy(xpath = "//input[@id=\"JBFEC_PROCESO\"]")
    public WebElement inputFechaProceso;
    @FindBy(xpath = "//input[@id='BTC_PRC_VAL']")
    public WebElement inputOrdenProcMasivo;
    @FindBy(xpath = "//*[contains(text(),'File Name')]/following::button[@class=\"btn btn-default btn-icon-textless-search ng-isolate-scope\"][1]")
    public WebElement lupaFileName;
    @FindBy(xpath = "//input[@type='file']")
    public WebElement inputFileNameNube;
    @FindBy(xpath = "//input[@id='JBFILE_NAME']")
    public WebElement inputCodArchivo;
    @FindBy(xpath = "//input[@id='JBARCHIVO']/following::*[@class='btn btn-default btn-icon-textless-search ng-isolate-scope']")
    public WebElement lupaCodArchivo;
    @FindBy(xpath = "//input[@id='JBCOD_SECTOR']")
    public WebElement inputCodGestor;
    @FindBy(xpath =  "//input[@id='JBCOD_SECTOR']/following::*[@type='button'][1]")
    public WebElement lupaCodGestor;

    @FindBy(xpath = "//input[@id='JBMTO_MIN_MAX']")
    public WebElement inputMinMax;
    @FindBy(xpath = "//input[@id='TIP_AGRUP_TIP_EXP']")
    public WebElement inputNatExp;
    @FindBy(xpath = "//input[@id='JBNUM_AVISO']")
    public WebElement inputNumAviso;
    @FindBy(xpath = "//input[@id='JBNUM_ORDEN']")
    public WebElement inputNumOrden;
    @FindBy(xpath = "//input[@id='JBFILE_NAME']")
    public WebElement inputFileName;
    /** xpath btn módulo Tareas  **/
    @FindBy(xpath = "//*[@id=\"1\"]/td[6]")
    public WebElement textTipoSituacion;

    @FindBy(xpath = "//*[@id=\"JBCOD_SECTOR\"]")
    public WebElement codSector;
    @FindBy(xpath = "//*[@id=\"JBCOD_MON\"]")
    public WebElement codMoneda;



    /** xpath cierre contable  **/
    @FindBy(xpath =  "//*[@id=\"btnAcp\"]/span")
    public WebElement BtnAceptar;

    @FindBy(id =  "JBCOD_SECTOR")
    public WebElement txtCodigoSector;
    //button[contains(text(),'Ver txt')
    @FindBy(xpath =  "//u[normalize-space()='S']")
    public WebElement BtnSalir;

    @FindBy(xpath =  "//*[@id=\"app-content-container\"]/div[1]/div[2]/div[1]/div/div[1]/ul/li[1]/h2/span")
    public WebElement btnmenu;

    @FindBy(xpath = "//a[@class='marginright15 ng-scope']")
    public WebElement btnSpollInformes;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[3]/div/button[2]")
    public WebElement btnVerReporte;


    /** xpath Validador de asientos  **/

    @FindBy(xpath = "//input[@id='JBCOD_EJERCICIO']")
    public WebElement txtCodigoEjercicio;

    @FindBy(xpath = "//input[@id='JBFEC_ASTO']")
    public WebElement FechaFinAsiento;

    @FindBy(xpath = "//input[@id='JBCOD_CLASE_ASTO']")
    public WebElement txtCodigoClaseAsiento;

    @FindBy(xpath = "//input[@id='JBNUM_ASTO']")
    public WebElement txtNumeroAsiento;

    @FindBy(xpath = "//input[@id='JBLIS_ERRORES']")
    public WebElement txtListaError;

    @FindBy(xpath = "//input[@id='JBBORRA_ASTO']")
    public WebElement txtBorrarAsiento;

    @FindBy(xpath = "//input[@id='JBTRAZA_ASTO']")
    public WebElement txtListadoCampos;

    @FindBy(xpath = "//input[@id='JBARCHIVO']")
    public WebElement txtNombreDeArchivo;

    @FindBy(xpath = "//input[@id='JBCOD_MONEDA']")
    public WebElement txtMoneda;

    @FindBy(xpath = "//input[@id='JBRESUMIDO']")
    public WebElement txtResumido;

    @FindBy(xpath = "//input[@id='JBMCA_REPROCESAR']")
    public WebElement txtReprocesar;

    @FindBy(xpath = "//*[contains(text(), 'Tiene errores')]")
    public WebElement ventanaError;
    @FindBy(xpath = "//li[@ng-repeat='e in error.errors']")
    public WebElement detalleError;


    /** xpath Domiciliacion masiva MMXGC00002  **/
    @FindBy(xpath = "//*[@id=\"plyAtrPssTskSetFrmW\"]/div/div/div[2]/div/span/button")
    public WebElement btnLupa;


    //@FindBy(xpath = "/html/body/div[2]/input")
    //@FindBy(xpath = "//*[@name= 'file']")
    @FindBy(xpath = "//div//input[@name= 'file']")
    public WebElement imputArchivo;

    @FindBy(xpath = "(//*[contains(text(), 'ceptar')])[2]")
    public WebElement btnAceptarAtributos;



    @Autowired
    public LanzadorTareasUI(DriverManager driverManager) {
        super(driverManager);
    }

}
