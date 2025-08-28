package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.html.HTMLInputElement;

import javax.xml.xpath.XPath;

@PageObject
public class EndosoCambioPlanPagoUI extends AbstractPage {


    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/div/ul/li[4]")
    public WebElement btnAceptar;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div/button[1]")
    public WebElement btnCerrar;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/div[2]/div/button[3]")
    public WebElement btnSiguiente;

    //input[@id='pmsVal' and @name='pmsVal']
    @FindBy(xpath = "//input[@id='pmsVal' and @name='pmsVal']")
    public WebElement inputPlanPago;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/fieldset/div/div/div/div/div[1]/div[2]/div/div[2]/fieldset/div/div/fieldset[1]/div/div/div/div[2]/div/div/div/div/div/ul/li[4]/a")
    public WebElement btnAceptPlan;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/fieldset/div/div/div/div/div[1]/div[2]/div/div[2]/fieldset/div/div/fieldset[2]/div/div/div[2]/div/div/div/div/ul/li[4]/a")
    public  WebElement btnAceptRecibo;

    //scrooll observacion
    //a[@class='accordion-toggle' and @href='javascript:void(0)' and ng-click='toggleOpen()']/span[text()='Motivo suplemento']

    @FindBy(xpath = "//textarea[@ng-model='oPlyGniObsForm.oPlyGniS.enrRsnTxtVal' and @name='txtEnrRsnTxtVal']")
    public WebElement inputObservacion;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/fieldset/div/div/div/div/div[2]/div[2]/div/div[2]/fieldset/div/div[2]/div/div/div/div/ul/li[4]/a")
    public WebElement btnAceptarObservacion;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/fieldset/div/div/div/div/div[3]/div[1]/h4/a/em")
    public WebElement motivoSuplemento;

    @FindBy(xpath = "//*[@id=\"1_chkAcnTypVal\"]")
    public WebElement checkPlanpAGO;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/fieldset/div/div/div/div/div[3]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/ul/li[4]/a")
    public WebElement btnAceptPlanPago;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/div/div/button[7]" )
    public  WebElement btnFinalizar;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/button[2]")
    public WebElement btnAceptarGrabacion;
    @FindBy(xpath = "//td[@title= 'CAMBIO DE PLAN DE PAGO']")
    public WebElement labelDismiPrim;
    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/div/div/button[1]")
    public WebElement btnSalir;

    @Autowired
    public EndosoCambioPlanPagoUI(DriverManager driverManager) {
        super(driverManager);
    }
}
