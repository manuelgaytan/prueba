package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class AplicacionMasivaDeBancosUI extends AbstractPage {

    /** Formulario Atributos Para tarea MMXGC00171 **/
    @FindBy(xpath = "//input[@id='JBCOD_CIA']")
    public WebElement txtCodigoCompania;
    @FindBy(xpath = "//input[@id='BTC_MVM_CLO_TYP_VAL']")
    public WebElement txtTipoProceso;
    @FindBy(xpath = "//input[@id='JBFEC_PROCESO']")
    public WebElement txtFechaProceso;
    @FindBy(xpath = "//input[@id='JBTIP_GESTOR']")
    public WebElement txtTipoGestor;
    @FindBy(xpath = "//input[@id='JBCOD_GESTOR']")
    public WebElement txtCodGestor;
    @FindBy(xpath = "//div[7]//div[1]//div[2]//span[1]")
    public WebElement liTipoNegocio;
    @FindBy(xpath = "(//button[contains(text(),'Aceptar')])[1]")
    public WebElement btnAceptarLista;
    @FindBy(xpath = "//input[@id='JBFEC_COBRO']")
    public WebElement txtFechaCobro;
    @FindBy(xpath = "//input[@id='JBFORMA_COMPENSACION']")
    public WebElement txtFormaCompensacion;
    @FindBy(xpath = "//input[@id='JBMCA_REPROCESO']")
    public WebElement txtReprocesan;
    @FindBy(xpath = "//input[@id='JBNOMBRE_ARCHIVO']")
    public WebElement txtxNombreArchivo;

    @FindBy(xpath = "//button[@id='btnAcp']//span[@class='ng-binding']")
    public WebElement btnAceptar;


    /** Aplicacion de cobros **/
    @FindBy(xpath = "//span[@class='btn-navigation-label ng-binding']")
    public WebElement btnSalir;

    @FindBy(xpath = "//img[@title='Jspool']")
    public WebElement btnReporte;


    /** Descargar Archivo de salida **/
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

    @FindBy(xpath = "//span[contains(text(),'Tesorería')]")
    public WebElement btnTesoreria;
    @FindBy(xpath = "//span[contains(text(),'Aplicación de cobros')]")
    public WebElement btnAplicacionDeCobros;
    @FindBy(xpath = "//input[@name=\"btcMvmTypVal\"]")
    public WebElement btnTipoDeProceso;
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
    @FindBy(xpath = "//button[span[contains(text(), 'alir')]]")
    public WebElement btnSalirCobros;

    @FindBy(xpath = "//*[@id='btnSrh']")
    public WebElement btnBuscar;
    @FindBy(xpath = "//*[@id=\"1\"]")
    public WebElement btnHistorico;

    @FindBy(xpath = "//*[@id=\"btnShw\"]")
    public WebElement btnConsulta;

    @FindBy(xpath = "//strong[text()='1 PESOS']")
    public WebElement validarConsultaHistorico;







    @Autowired
    public AplicacionMasivaDeBancosUI(DriverManager driverManager) {
        super(driverManager);
    }

}
