package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.ref.WeakReference;

@PageObject
public class SiniestrosCristalesUI extends AbstractPage {

    @FindBy(xpath = "//tr[td[3][text()='DAOS CRISTALES']]")
    public WebElement btnDanosCristales;

    @FindBy(xpath = "//tr[td[3][text()='LESIONES OCUPANTES']]")
    public WebElement btnLesionesOcupantes;

    @FindBy(xpath = "//li[h2/span[text()='Siniestros']]")
    public WebElement menSimiestro;
    @FindBy(xpath = "//a[span[text()='Apertura expediente']]\n")
    public WebElement btnAperturaExpedient;
    @FindBy(xpath = "//*[@id=\"TIP_ATENCION_EXP\"]")
    public WebElement inputTipoAtencion;
    @FindBy(xpath = "//*[@id=\"COD_ACT_ATE_EXP\"]")
    public WebElement inputActividadAtencion;
    @FindBy(xpath = "//*[@id=\"TIP_CDR_EXP\"]")
    public WebElement getInputTipoCdr;
    @FindBy(xpath = "//*[@id=\"COD_TERCERO_EXP_DPC\"]")
    public WebElement inputCodTercero;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[2]/div[2]/label")
    public WebElement radioCalValAutoma;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[3]/button[2]")
    public WebElement btnAcptFuncion;

    @FindBy(xpath = "//input[@id=\"NOM_CONTACTO_PREF_EXP\"]")
    public WebElement inputNomCompl;
    @FindBy(xpath = "//input[@id=\"DESC_RELAC_CONT_PRE_EXP\"]")
    public WebElement inputRelacionContratante;
    @FindBy(xpath = "//input[@id=\"TLF_NUMERO_PREF1_EXP\"]")
    public WebElement inputTel;
    @FindBy(xpath = "//input[@id=\"EMAIL_PREF_EXP\"]")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@id=\"NUM_OCUPANTES_EXP\"]")
    public WebElement inputNomOcupantes;
    @FindBy(xpath = "//input[@name=\"TIP_LES\"]")
    public WebElement inputLesionGravedad;
    @FindBy(xpath = "//input[@name=\"MCA_AMBULANCIA_EXP\"]")
    public WebElement inputAmbulancia;
    @FindBy(xpath = "//input[@id=\"TXT_RELAC_LES\"]")
    public WebElement inputRelaContratante;
    @FindBy(xpath = "//input[@name=\"TIP_LESI_UBICACION\"]")
    public WebElement inputPosicionAuto;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div/div[3]/div[1]/button[3]")
    public WebElement btonSigui;
    @FindBy(xpath = "//*[@id=\"1\"]/td[1]")
    public WebElement btnProveExp;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div[2]/div/div[1]/button[3]")
    public WebElement btnSguienFinal;

    protected SiniestrosCristalesUI(DriverManager driverManager) {
        super(driverManager);
    }
}
