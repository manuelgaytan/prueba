package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class CreacionExpedientesUI extends AbstractPage {

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[2]/div/button")
    public WebElement btnAceptarSimiestro;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div[2]/div[1]/button[4]")
    public WebElement btnFinalizar;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/button[2]")
    public WebElement botonAceptar;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/button[2]")
    public WebElement btnOperacionFinalizada;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div[1]/div[2]/div[1]/div/div[1]/ul/li[2]")
    public WebElement menuSimiestros;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div[1]/div[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/a")
    public WebElement btnAperturaExpediente;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/div/div/form/div/div[4]/div[3]/div[1]/input")
    public WebElement inputNumSimiestro;

    @FindBy(xpath = "//tr[@id='2']")
    public WebElement btnDMP;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div/div/button[3]")
    public WebElement btnSiguienteApertura;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div[2]/div[1]/button[3]")
    public WebElement btnSiguient;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div/div[2]/div[2]/div/div/div/div[1]/h4/a")
    public WebElement btnExpediente1;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div/div/div/div/ul/li[4]/a")
    public WebElement btnAcept;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div/div[2]/div[3]/div[2]/div/div/div/div/div[1]/h4/a")
    public WebElement btnDanosParciales;

    //Daños materiales parciales
    @FindBy(xpath = "//*[@id=\"NOM_CONTACTO_PREF_EXP\"]")
    public WebElement inputNombreCompleto;

    @FindBy(xpath = "//*[@id=\"DESC_RELAC_CONT_PRE_EXP\"]")
    public WebElement inputRelacionContratante;

    @FindBy(xpath = "//*[@id=\"COD_CONTACTO_PREF_EXP\"]")
    public WebElement inputContacto;

    @FindBy(xpath = "//*[@id=\"TLF_NUMERO_PREF1_EXP\"]")
    public WebElement inputTelefono;

    @FindBy(xpath = "//*[@id=\"COD_IMPACTO_EXP\"]")
    public WebElement inputDireccionImpacto;

    @FindBy(xpath = "//*[@id=\"TIP_DANO_EXP\"]")
    public WebElement inputMagnitud;

    @FindBy(xpath = "//*[@id=\"plyAtrPssLssSetFrmW\"]/div/div/div[3]/div[3]/div/div/div/span/a/input")
    public WebElement btnDescripcionDanos;

    //---Ocurrencias---
    @FindBy(xpath = "//*[@id=\"oca_2GC\"]/div/div[1]/div/div/div/fieldset[2]/nwt-crud-w-drv/div/a[1]")
    public WebElement btnAgregar;

    @FindBy(xpath = "//*[@id=\"MCA_COST_TRAS_DER_EXP\"]")
    public WebElement inputCostadoTraseroDerecho;

    @FindBy(xpath = "//*[@id=\"MCA_COST_TRAS_IZQ_EXP\"]")
    public WebElement inputCostadoTraseroIzquierdo;
    @FindBy(xpath = "//*[@id=\"MCA_CRI_PUE_DEL_DER_EXP\"]")
    public WebElement inputCPDDer;
    @FindBy(xpath = "//*[@id=\"MCA_CRI_PUE_DEL_IZQ_EXP\"]")
    public WebElement inputCPDIzq;
    @FindBy(xpath = "//*[@id=\"MCA_CRI_PUE_TRAS_DER_EXP\"]")
    public WebElement inputCPTDer;
    @FindBy(xpath = "//*[@id=\"MCA_CRI_PUE_TRAS_IZQ_EXP\"]")
    public WebElement inputCPTIzq;

    @FindBy(xpath = "//*[@id=\"MCA_ESP_LAT_DER_EXP\"]")
    public WebElement inputELD;
    @FindBy(xpath = "//*[@id=\"MCA_ESP_LAT_IZQ_EXP\"]")
    public WebElement inputELI;
    @FindBy(xpath = "//*[@id=\"MCA_ESTRIBO_EXP\"]")
    public WebElement inputEstribo;

    @FindBy(xpath = "//*[@id=\"MCA_FAR_DELANTEROS_EXP\"]")
    public WebElement inputFarosDelanteros;
    @FindBy(xpath = "//*[@id=\"MCA_FAR_TRASEROS_EXP\"]")
    public WebElement inputFarosTraseros;
    @FindBy(xpath = "//*[@id=\"MCA_FAC_DELANTERA_EXP\"]")
    public WebElement inputFaciaDelantera;

    @FindBy(xpath = "//*[@id=\"MCA_FAC_TRASERA_EXP\"]")
    public WebElement inputFaciaTrasera;
    @FindBy(xpath = "//*[@id=\"MCA_LAT_DERECHO_EXP\"]")
    public WebElement inputLD;
    @FindBy(xpath = "//*[@id=\"MCA_LAT_IZQUIERDO_EXP\"]")
    public WebElement inputLIzq;

    @FindBy(xpath = "//*[@id=\"MCA_MAR_RADIADOR_EXP\"]")
    public WebElement inputMR;
    @FindBy(xpath = "//*[@id=\"MCA_MEC_COLISION_EXP\"]")
    public WebElement inputMpColi;
    @FindBy(xpath = "//*[@id=\"MCA_MEDALLON_EXP\"]")
    public WebElement inputMedallon;

    @FindBy(xpath = "//*[@id=\"MCA_PARABRISAS_EXP\"]")
    public WebElement inputParabrisas;
    @FindBy(xpath = "//*[@id=\"MCA_PARRILLA_EXP\"]")
    public WebElement inputParrilla;
    @FindBy(xpath = "//*[@id=\"MCA_PAR_BAJAS_EXP\"]")
    public WebElement inputPartesBajas;

    @FindBy(xpath = "//*[@id=\"MCA_PISO_CAJUELA_EXP\"]")
    public WebElement inputPisoCajuela;
    @FindBy(xpath = "//*[@id=\"MCA_POSTES_EXP\"]")
    public WebElement inputPostes;
    @FindBy(xpath = "//*[@id=\"MCA_PUE_DEL_DER_EXP\"]")
    public WebElement inputPuertaDelanteraDerecha;

    @FindBy(xpath = "//*[@id=\"MCA_PUE_DEL_IZQ_EXP\"]")
    public WebElement inputPuertaDelanteraIzquierda;
    @FindBy(xpath = "//*[@id=\"MCA_PUE_TRAS_DER_EXP\"]")
    public WebElement inputPuertaTraseraDerecha;
    @FindBy(xpath = "//*[@id=\"MCA_PUE_TRAS_IZQ_EXP\"]")
    public WebElement inputPuertaTraseraIzquierda;

    @FindBy(xpath = "//*[@id=\"MCA_SALP_DEL_DER_EXP\"]")
    public WebElement inputSalpicaderaDelanteraDerecha;
    @FindBy(xpath = "//*[@id=\"MCA_SALP_DEL_IZQ_EXP\"]")
    public WebElement inputSalpicaderaDelanteraIzq;
    @FindBy(xpath = "//*[@id=\"MCA_SALP_TRAS_DER_EXP\"]")
    public WebElement inputSalpicaderaTraseraDerecha;

    @FindBy(xpath = "//*[@id=\"MCA_SALP_TRAS_IZQ_EXP\"]")
    public WebElement inputSalpicaderaTraseraIzquierda;
    @FindBy(xpath = "//*[@id=\"MCA_TAP_CAJUELA_EXP\"]")
    public WebElement inputTapaCajuela;
    @FindBy(xpath = "//*[@id=\"MCA_TOLDO_EXP\"]")
    public WebElement inputToldo;

    @FindBy(xpath = "//*[@id=\"MCA_TOL_ESCAPE_EXP\"]")
    public WebElement inputTolvaDeEscape;
    @FindBy(xpath = "//*[@id=\"MCA_TOL_PARABRISAS_EXP\"]")
    public WebElement inputTolvaDeParabrisas;

    //@FindBy(xpath = "//*[@id=\"oca_178\"]/div/div[2]/div/ul/li[2]/a | //*[@id=\"oca_17G\"]/div/div[2]/div/ul/li[2]/a/label/span")
    @FindBy(xpath = "//*[contains(text(),'Aceptar')]")  // Mantenimiento Neto
    public WebElement btnAceptarOcurrencia;

    @FindBy(xpath = "//*[@id=\"TIP_RESPONSABILIDAD_EXP\"]")
    public WebElement inputResponsable;

    @FindBy(xpath = "//*[@id=\"plyAtrPssNewCtnLssSetV\"]/div/div[2]/div/div/div/div/button[3]")
    public WebElement btnVerificar;

    @FindBy(xpath = "//*[@id=\"plyAtrPssNewCtnLssSetV\"]/div/div[2]/div/div/div/div/button[2]")
    public WebElement getBtnAceptarExpediente;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div/div[3]/div[1]/button[3]")
    public WebElement getBtnSiguient3;

    @FindBy(xpath = "//*[@id=\"1\"]")
    public WebElement provedoresExpedientes;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div[2]/div/div[1]/button[2]")
    public WebElement botonVerificar;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div[2]/div/div[1]/button[3]")
    public WebElement botonSiguiente;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[2]/div/button")
    public WebElement aceptarExped;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div[2]/div[1]/button[4]")
    public WebElement btonFinalizar;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/button[2]")
    public WebElement btnAceptTerm;
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/button[2]")
    public WebElement btnAceptOpera;


    private CreacionExpedientesUI(DriverManager driverManager) {
        super(driverManager);
    }
}
