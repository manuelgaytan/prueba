package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class EmisionBatchUI extends AbstractPage {

    @FindBy(xpath="//div/a/span[text()='Envío de Archivos al Servidor']")
    public WebElement optEnvioArchivoServ;

    @FindBy(xpath = "//label[text()='Nombre Fichero:']//following::div/input[@name='JBFLE_NAM' and @type='text']")
    public WebElement inputNombreFichero;

    @FindBy(xpath = "//input[@id='JBSTU_VAL']")
    public WebElement inputCodigoEstructura;

    @FindBy(xpath = "//button[@id='btnAcp']")
    public WebElement btnAceptar;

    @FindBy(xpath = "//label[text()='Resultado Proceso:']//following::textarea")
    public WebElement txtResultado;

    @FindBy (xpath = "//button/span[text()='alir']")
    public WebElement btnSalir;

    @FindBy(xpath = "//input[@id='TIP_MVTO_BATCH']")
    public WebElement inputProcesoBatch;

    @FindBy (xpath = "//input[@id='FEC_TRATAMIENTO']")
    public WebElement inputFechaProceso;

    @FindBy (xpath = "//input[@id='JBNUM_ORDEN']")
    public WebElement inputOrden;

    @FindBy (xpath = "//input[@id='JBMCA_REPROCESO']")
    public WebElement inputReproceso;

    @FindBy (xpath = "//input[@id='JBMCA_ABORTA_EMISION']")
    public WebElement inputAbortar;

    @FindBy(xpath = "//td[text()='TERMINACION NORMAL']")
    public WebElement tipoSituacion;

    @FindBy(xpath = "//a/img[@title='Jspool']")
    public WebElement btnSpool;

    @FindBy(xpath = "//button[text()='Ver txt ']")
    public WebElement btnVerTxt;

    @FindBy(xpath = "//button[@ng-click='exit();']")
    public WebElement btnSalirSpool;

    @FindBy(xpath = "//label[text()='Vig.:']//following-sibling::label[@class='control-label col-md-4 L']/strong[@class='ng-binding']")
    public WebElement lblVigencia;

    @FindBy(xpath = "//input[@name='JBCOD_SPTO' and @type='text']")
    public WebElement inputSuplemento;

    @FindBy (xpath = "//input[@name='JBSUB_COD_SPTO' and @type='text']")
    public WebElement inputSubCodSuple;

    @FindBy(xpath = "//input[@id='fileUpload']")
    public WebElement inputArchivo;

    @FindBy(xpath = "//button[text()='Aceptar']")
    public WebElement btnAceptarCarga;

    @FindBy (xpath = "//input[@id='JBFLE_GRL_NAM']")
    public WebElement inputFicheroGeneral;

    @FindBy (xpath = "//input[@id='JBFLE_INT_NAM']")
    public WebElement inputFicheroInterveniente;

    @FindBy (xpath = "//input[@id='JBFLE_RYC_NAM']")
    public WebElement inputRiesgoCobertura;

    @FindBy (xpath = "//span[text()='Emisión']")
    public WebElement lblEmision;

    @FindBy (xpath = "//span[text()='Consultar proceso masivo']")
    public WebElement lblConsultarProcesoMasivo;

    @FindBy (xpath = "//input[@id='btcMvmTypVal']")
    public WebElement inputMovimientoBatch;

    @FindBy (xpath = "//input[@id='lodDat']")
    public WebElement inputDateProcesamiento;

    @FindBy (xpath = "//button/span[text()='uscar']")
    public WebElement btnBuscar;

    @FindBy (xpath = "//td[@title='MMXEATEMGR']")
    public WebElement lblRegistroMasivo;

    @FindBy(xpath = "//input[@name='btcPrcVal']")
    public WebElement lblOrdenCarga;

    @FindBy(xpath = "//span[contains(text(),'Tareas')]")
    public WebElement selectTareas;

    @FindBy(xpath = "//span[contains(text(),'Lanzador de tareas')]")
    public WebElement btnLanzadorDeTareas;

    @Autowired
    public EmisionBatchUI(DriverManager driverManager){super(driverManager);
    }
}
