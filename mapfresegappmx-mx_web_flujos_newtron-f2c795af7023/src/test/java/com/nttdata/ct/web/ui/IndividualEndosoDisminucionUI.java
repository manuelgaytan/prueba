package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class IndividualEndosoDisminucionUI extends AbstractPage {

    @FindBy(xpath = "//span[contains(@class, 'textoMenu') and contains(text(), 'Emisión')]")
    public WebElement selectEmision;
    @FindBy(xpath = "//span[@class='ng-binding' and contains(text(), 'Modificar póliza')]")
    public WebElement btnModPoliza;
    @FindBy(xpath = "//input[@name='txtPlyVal' and @type='text']")
    public WebElement imputNumPoliza;
    //input[@id='nmrEnrVal' and @type='text']
    @FindBy(xpath = "//input[@id='nmrEnrVal' and @type='text']")
    public WebElement imputCodSuplemento;
    @FindBy(xpath = "//input[@name='nmrEnrSbdVal' and @type='text']")
    public WebElement imputSuplemento;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/button[2]")
    public WebElement btnAceptar;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/div/ul/li[4]/a")
    public WebElement btnInfoAceptar;

    //*[text()[contains(., 'DEFENSA JURIDICA ASEGURADO')]]
//    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div[2]/div[2]/div/button[3]")
    @FindBy(xpath = "//*[text()[contains(., 'iguiente')]]")
    public WebElement btnSiguiente;

    @FindBy(xpath = "//a[@id='btnMdf']")
    public WebElement btnModificar;
    @FindBy(xpath = "//button[@id='btnNxt']")
    public WebElement btnSiguienteInter;
    @FindBy(xpath = "//input[@id='cvrLmtValueListInput_2']")
    public WebElement inputRcTerceros;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/div[1]/div/div[2]/div/fieldset/ul/li[10]/div/div/div/div/fieldset/div/div/div/fieldset/div[2]/div/div/div/div/div/ul/li/a")
    public WebElement btnCalcular;
    @FindBy(xpath = "//button[@id='btnAcp' and @ng-click='objBtn.btnAcp.onClick()']" )
    public WebElement btnAceptarEndoso;
    @FindBy(xpath = "/html/body/div[2]")
    public WebElement modalAuditoriaRiesgo;
    @FindBy(xpath = "//button[@id='btnCtiIsu' and @ng-click='btnCtiIsuOnClick()']")
    public WebElement btnContinuarEmi;
    @FindBy(xpath = "//textarea[@ng-model='oPlyGniObsForm.oPlyGniS.enrRsnTxtVal' and @name='txtEnrRsnTxtVal']")
    public WebElement inputTxtObservaciones;
    @FindBy(xpath = "//button[@ng-click='!nextLoading && ok()' and @accesskey='A']")
    public WebElement btnModalPolizaRetenida;

    @FindBy(xpath = "//*[contains(text(), 'Tiene errores')]")
    public WebElement ventanaError;
    @FindBy(xpath = "//li[@ng-repeat='e in error.errors']")
    public WebElement detalleError;

    @FindBy(xpath = "//button[@ng-click='!objBtn.btnNxt.loading && objBtn.btnNxt.mdf() && objBtn.btnNxt.onClickBtnNxt()' and @accesskey='S']")
    public WebElement btnSiguiente2;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/fieldset/div/div/div/div/div[2]/div[2]/div/div[2]/fieldset/div/div[2]/div/div/div/div/ul/li[4]/a")
    public WebElement btnAceptarObservacion;

    @FindBy(xpath = "//a[@class='accordion-toggle' and @ng-click='toggleOpen()']/span[text()='Motivo suplemento']")
    public WebElement btnMotivoSuplemento;
    @FindBy(xpath = "//input[@type='checkbox' and @id='1_chkAcnTypVal' and @ng-click=\"chkAcnTypValOnClick('1');\"]")
    public WebElement checkSelecMotivoSuple;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/fieldset/div/div/div/div/div[3]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/ul/li[4]/a")
    public WebElement btnAceptarMotivoSuple;

    @FindBy(xpath = "//td[@title= 'DISMINUCION DE PRIMA']")
    public WebElement labelDismiPrim;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/div/div/button[8]")
    public WebElement btnFinalizar;

    @FindBy(xpath = "//button[@ng-click='!nextLoading && ok()' and @accesskey='A' and contains(span, 'Aceptar')]")
    public WebElement btnAcepProcesGraba;

    @FindBy(xpath = "//button[text()='Continuar Emisión']\n")
    public WebElement btnContinuarEmision;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/div/div/button[2]")
    public WebElement btnSalir;

    protected IndividualEndosoDisminucionUI(DriverManager driverManager) {
        super(driverManager);
    }

}


