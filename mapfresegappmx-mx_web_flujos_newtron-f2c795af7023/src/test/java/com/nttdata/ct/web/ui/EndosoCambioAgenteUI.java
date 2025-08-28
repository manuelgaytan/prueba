package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@PageObject
public class EndosoCambioAgenteUI extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/div/ul/li[4]/a")
    public WebElement btnAceptar;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div[2]/div[1]/div/div/div/div[5]/div[1]/h4/a")
    public WebElement btnAgente;

    //


    //
    @FindBy(xpath = "//*[@id=\"oPlyInaForm.oPlyInaS.thpValMan\"]")
    public WebElement inputCodigoTercero;

    @FindBy(xpath = "//*[@id=\"nwtPlyInaManPssPrcFrmW\"]/div/div/div/div[3]/div[1]/div[1]/input")
    public WebElement inputCuadroComision;

    @FindBy(xpath = "//*[@id=\"nwtPlyInaManPssPrcFrmW\"]/div/div/div/div[3]/div[2]/div[1]/input")
    public WebElement inputCodigoOficina;

    @FindBy(xpath = "//*[@id=\"nwtPlyInaManPssPrcFrmW\"]/div/div/div/div[4]/div/div[1]/input")
    public WebElement inputFuenteDsitribucion;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div[2]/div[1]/div/div/div/div[5]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div[2]/div/div/div/div/div/ul/li[4]/a")
    public WebElement cambioAgenteAcept;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/div[2]/div/button[3]")
    public WebElement btnSiguiente;

    @FindBy(xpath = "//*[contains(text(), 'iguiente')]")
    public WebElement btnSiguienteModificarPoliza;

    @FindBy(xpath = "//*[@id=\"1\"]")
    public WebElement btnTarifar;

    @FindBy(xpath = "//*[@id=\"btnMdf\"]")
    public WebElement btnModificar;

    @FindBy(xpath = "//*[@id=\"btnNxt\"]")
    public WebElement btnSiguienteInter;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/div[1]/div/div[2]/div/fieldset/ul/li[10]/div/div/div/div/fieldset/div/div/div/fieldset/div[2]/div/div/div/div/div/ul/li/a")
    public WebElement btnCalcular;
    @FindBy(xpath = "//*[@id=\"btnAcp\"]")
    public WebElement btnAceptarInter;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/div[2]/div/button[4]")
    public WebElement btnSiguiente2;

    @FindBy(xpath = "//*[@id=\"plyGniMdfObsEnrWrkCtnFrmW\"]/div/div/div/textarea")
    public WebElement inputObservacion;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/fieldset/div/div/div/div/div[2]/div[2]/div/div[2]/fieldset/div/div[2]/div/div/div/div/ul/li[4]/a")
    public WebElement btnAceptarObserv;

    @FindBy(xpath = "//*[@id=\"2_chkAcnTypVal\"]")
    public WebElement checkRenovacion;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/fieldset/div/div/div/div/div[3]/div[1]/h4/a")
    public WebElement btnSuplemento;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/fieldset/div/div/div/div/div[3]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/ul/li[4]/a")
    public WebElement btnAceptarRenovacion;


    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/div/div/button[8]")
    public WebElement btnFinalizar;

    @FindBy(xpath = "//*[@id=\"plyInePssCtmQryW\"]/div/div/div[1]/div[2]/div[2]/input")
    public WebElement inputAgente;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/fieldset/div/div/div/div/div[1]/div[2]/div/div[2]/fieldset/div/div/div[1]/div/div/div[2]/div/div/div/div/div/ul/li[4]/a")
    public WebElement btnAceptarAgen;

    @FindBy(xpath = "//td[@title= 'RENOVACION']")
    public WebElement labelRenovacion;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/button[2]")
    public  WebElement btnAceptarGrabacion;
    public EndosoCambioAgenteUI(DriverManager driverManager) {
        super(driverManager);
    }
}
