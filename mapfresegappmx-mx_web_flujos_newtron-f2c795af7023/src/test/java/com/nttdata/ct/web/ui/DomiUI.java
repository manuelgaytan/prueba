package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class DomiUI extends AbstractPage {
    @FindBy(xpath = "//*[contains(text(),'Mantenimientos') and @class='textoMenu ng-binding']")
    public WebElement mantenimiento;

    @FindBy(xpath = "//*[contains(text(),'Añadir fila')]")
    public WebElement btnAñadirFila;

    @FindBy(xpath = "(//*[@id=\"btcMvmTypVal\"])[1]")
    public WebElement txtTipoProcesoConsulta;

    @FindBy(xpath = "(//*[@id=\"btcMvmTypVal\"])[2]")
    public WebElement txtTipoProceso;

    @FindBy(xpath = "//*[@id=\"saveBtn\"]")
    public WebElement btnGuardar;

    //@FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[1]/div/div[1]/div/fieldset/div/div[2]/div/fieldset/div/div/div[2]/div/div/div/div/div/ul/li[4]/a/label/span")//*[contains(text(),'ceptar')]
    @FindBy(xpath = "//*[contains(text(),'ceptar')]")
    public WebElement btnAceptar;

    @FindBy(xpath = "(//*[contains(text(),'Aceptar')])[2]")
    public WebElement btnAceptar2;

    @FindBy(xpath = "//*[contains(text(),'SE HA EJECUTADO CORRECTAMENTE EL ALTA')]")
    public WebElement txtMensajeEjecucion;

    @FindBy(xpath = "//*[contains(text(),'Aceptar')]")
    public WebElement btnAceptarMensaje;

    @FindBy(xpath = "//*[contains(text(),'SIN FILTRAR')]")
    public WebElement opcCobrosDomiciliados;

    @FindBy(xpath = "(//*[contains(text(),'DETALLE FILTRADO')])[2]")
    public WebElement opcCobrosDomiciliadosDetalleFiltrado;

    @FindBy(xpath = "(//*[contains(text(),'YA EXCEPCIONADO')])[2]")
    public WebElement opcCobrosDomiciliadoExcepcionado;



    @FindBy(xpath = "//*[contains(text(),'Cargar Batch')]")
    public WebElement btnCargarBatch;

    @FindBy(xpath = "//*[contains(text(),'CARGA BATCH COBROS')]")
    public WebElement txtMensajeCarga;


    @FindBy(xpath = "//*[contains(text(),'SE HA EJECUTADO CORRECTAMENTE LA CARGA BATCH COBROS')] | " +
            "//*[contains(text(),'Proceso Tiene errores:')] | " +
            "//*[contains(text(),'Error : Servicio no disponible.')]")
    public WebElement txtMensajeCargabatch;

    @FindBy(xpath = "//*[contains(text(),'Proceso Tiene errores:')] | " +
            "//*[contains(text(),'Error : Servicio no disponible.')]")
    public WebElement txtMensajeCargabatchError;

    @FindBy(xpath = "//*[contains(text(),'SE HA EJECUTADO CORRECTAMENTE LA CARGA BATCH COBROS')]")
    public WebElement txtMensajeCargabatchCorrecto;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div/button[1]/span[1]")
    public WebElement btnCerrarMensajeError;


    //Xpath de consulta

    @FindBy(xpath = "//*[@id=\"prcStsVal\"]")
    public WebElement txtSituacionProceso;

    @FindBy(xpath = "//*[contains(text(),'Consultar')]")
    public WebElement btnConsultar;

    @FindBy(xpath = "//*[contains(text(),'Gestionar Detalle')]")
    public WebElement btnGestionDetalle;

    @FindBy(xpath = "//*[@id=\"1\"]/td[2]")
    public WebElement txtResultadosConsulta;

    @FindBy(xpath = "//*[contains(text(),'Procesar Excepciones')]")
    public WebElement btnProcesarExcepciones;

    //xpath procesar excepciones

    @FindBy(xpath = "//*[contains(text(),'PROCESAR EXCEPCIONES')]")
    public WebElement txtMensajeProcesarExcepciones;

    @FindBy(xpath = "//*[contains(text(),'SE HAN EXCEPCIONADO')]")
    public WebElement txtMensajeEstatusProcesarExcepciones;

    @FindBy(xpath = "//*[contains(text(),'Filtrar Recibos')]")
    public WebElement btnFiltrarRecibos;

    @FindBy(xpath = "//*[contains(text(),'Procesar Filtros')]")
    public WebElement btnProcesarFiltros;

    @FindBy(xpath = "//*[contains(text(),'¿Desea Continuar con la Generación del archivo?')]")
    public WebElement txtMensajebtnProcesarFiltros;

    @FindBy(xpath = "//span[contains(text(),'Si')]")
    public WebElement btnSi;

    @FindBy(xpath = "//*[contains(text(),'IMPORTE TOTAL DE RECIBOS')]")
    public WebElement txtImporte;

    @FindBy(xpath = "//*[contains(text(),'Gestor de Cobro')]")
    public WebElement txtGestorCobro;

    @FindBy(xpath = "//input[contains(@id, 'cb_gridCrudRcpMnd_01')] | //input[contains(@id, 'cb_gridCrudRcpMnd_02')]")
    public WebElement cbGestorCobro;


    @FindBy(xpath = "//input[contains(@id, 'cb_gridCrudRcpMnd_02') and contains(@id, '_2')] | //input[contains(@id, 'jqg_gridCrudRcpMnd_01') and contains(@id, '_2')]")
    public WebElement cbBBVA;

    @FindBy(xpath = "//input[@ng-model='rcpMtgMnrDstFleMngVConfData.oGrdDstForm.oRcpMtgS.mnrVal']")
    public WebElement txtXCodigoGestor;

    @FindBy(xpath = "//*[contains(text(),'Actualizar')]")
    public WebElement btnActualizar;

    @FindBy(xpath = "//*[contains(text(), 'Tiene errores')]")
    public WebElement ventanaError;
    @FindBy(xpath = "//li[@ng-repeat='e in error.errors']")
    public WebElement detalleError;

    @FindBy(xpath = "//*[contains(text(), 'Tiene errores')]")
    public WebElement closeventanaError;

    //250001649
//    @FindBy(xpath = "//*[contains(text(),'DB    00120012')] |" +
//            " //*[contains(text(),'DB    00140014')] | //*[contains(text(),'DB    00190019')]")

    @FindBy(xpath = "//*[contains(text(),'25000')]")
    public WebElement opcAviso;

    @FindBy(xpath = "//*[contains(text(),'Generar Archivo')]")
    public WebElement btnGenerarArchivo;

    @FindBy(xpath = "//input[@id='mnrTypVal']")
    public WebElement txtImputGestorCobro;







    @Autowired
    public DomiUI(DriverManager driverManager){
        super(driverManager);
    }
}
