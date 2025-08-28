package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class SiniestrosUI extends AbstractPage {

    /** Formulario Introduccion de datos **/
    @FindBy(xpath = "//input[@title='Siniestro']")
    public WebElement txtSiniestro;

    //input[@title='Expediente']
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/form/div/div/div/div/div/div[4]/div[4]/div[1]/input | " +
            "//*[@id=\"app-content-container\"]/div/div[1]/div/div/div/form/div/div[4]/div[4]/div[1]/input")
    public WebElement liExpediente;

    @FindBy(xpath = "//button[normalize-space()='Aceptar']")
    public WebElement btnAceptarLista;

    @FindBy(xpath = "//span[@ng-bind-html=\"('BtnNxt.lbl' | translate)\"]")
    public WebElement btnSiguiente;

    @FindBy(xpath = "//span[@ng-bind-html=\"('BtnAer.lbl' | translate)\"]")
    public WebElement btnAnterior;

    @FindBy(xpath = "//*[@id=\"9_rsnSlc\"]")
    public WebElement opcRiesgoNoVigente;

    @FindBy(xpath = "//div[@id='jqgh_gridFli_oLssFliS.filVal']")
    public WebElement txtExpediente;

    @FindBy(xpath = "//button[normalize-space()='Aceptar']")
    public WebElement btnAceptar;

    @FindBy(xpath = "(//button[normalize-space()='Aceptar'])[2]")
    public WebElement btnAceptarDefensa;


    //*[@id="app-content-container"]/div/div[1]/div[1]/div[2]/div[3]/div/div[1]/div/div[1]/h4/a/span
    @FindBy(xpath = "(//span[@class='ng-scope ng-binding'][normalize-space()='Relato'])[1]")
    public WebElement txtRelato;

    @FindBy(xpath = "(//button[normalize-space()='Aceptar'])[1] | //button[normalize-space()='Aceptar']")
    public WebElement btnAceptar1;

    @FindBy(xpath = "//button[contains(text(),'Aceptar')]")
    public WebElement btnAceptarRelato;

    @FindBy(xpath = "//*[contains(text(),'Anterio')]")
    public WebElement btnAnteriorConsecuencia;

    @FindBy(xpath = "//span[@ng-bind-html=\"('BtnAcp.lbl' | translate)\"]")
    public WebElement btnAceptar2;

    @FindBy(xpath = "(//button[normalize-space()='Aceptar'])[3]")
    public WebElement btnAceptar3;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[2]/div/button")
    public WebElement btnAceptarTerminar;

    @FindBy(xpath = "//button[normalize-space()='Verificar']")
    public WebElement btnVerificar;

    @FindBy(xpath = "(//button[normalize-space()='Verificar'])[1]")
    public WebElement btnVerificarCita;

    @FindBy(xpath = "//*[@id=\"jqgh_gridCqdDef_oLsfCqdS.cnqNam\"]")
    public WebElement txtNombreConsecuencia;


    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div/div/button[2]/span")
    public WebElement btnSalir;

    //*[@id="1"]/td[3]
    //@FindBy(xpath = "//*[text()[contains(., 'DEFENSA JURIDICA ASEGURADO')]]")
    //@FindBy(xpath = "//*[text()[contains(., 'LA POLIZA NO TIENE ACCESORIOS GENERALES')]]")

    @FindBy(xpath = "//TD[text()=\"DEFENSA JURIDICA ASEGURADO\"]")
    public WebElement opcDefensaJuridica;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div/div/div/div/ul/li[4]/a/label/span")
    public WebElement btnAceptarExpediente;

    @FindBy(xpath = "//*[@id=\"plyAtrPssLssSetFrmW\"]/div/div/div[2]/div[1]/div/div[2]/span")
    public WebElement liAbogado;

    @FindBy(xpath = "(//button[normalize-space()='Aceptar'])[2]")
    public WebElement btnAceptarlistado;


    @FindBy(xpath = "//*[@id=\"FEC_ASIG_EXP\"]")
    public WebElement txtFechaAsignacion;

    @FindBy(xpath = "//*[text()[contains(., 'EL EXPEDIENTE 2 SE HA CREADO CORRECTAMENTE.')]]")
    public WebElement txtExpedienteCreado;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[2]/div/button")
    public WebElement btnAceptarMensajeExpediente;

    @FindBy(xpath = "//button[normalize-space()='Finalizar']")
    public WebElement btnFinalizar;



    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/button[2]/span")
    public WebElement btnAceptarTerminarExpediente;


    //Xpath Modificación de Expediente

    //*[text()[contains(., 'CONFIRMACION DEL AJUSTADOR')]]


    //*[@id="1_rsnSlc"]
    @FindBy(xpath = "//*[@id='1_rsnSlc']")
    public WebElement opcConfirmacionAjustador;

    @FindBy(xpath = "//*[@id=\"1_rsnSlc\"]")
    public WebElement opcTramitacionFinalizada;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/div[2]/div/div[2]/div/div[3]/div/row/div/div/div/div/div/div[1]/h4/a/em")
    public WebElement btnMostrarDefensaJuridica;


    @FindBy(xpath = "//*[@id=\"COD_ABOGADO_EXP\"]")
    public WebElement txtAbogado;



    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[1]/div[2]/label")
    public WebElement txtMensajeAdvertencia;


    @FindBy(xpath = "(//button[normalize-space()='Aceptar'])[4]")
    public WebElement btnAceptarMensajeAdvertencia;


    @FindBy(xpath = "//*[@id=\"NOM_DOMICILIO_UBI2\"]")
    public WebElement txtColonia;

    @FindBy(xpath = "//*[@id=\"MCA_CON_COSTO\"]")
    public WebElement txtCosto;


    @FindBy(xpath = "//td[contains(@title,'OS MATERIALES PARCIALES')]")
    public WebElement btnDanoMaterial;

    @FindBy(xpath = "//h1[normalize-space()='Proceso Tiene errores:']")
    public WebElement ventanaError;

    @FindBy(xpath = "//span[@class='ng-binding']")
    public WebElement detalleError;





    @Autowired
    public SiniestrosUI(DriverManager driverManager) {
        super(driverManager);
    }

}