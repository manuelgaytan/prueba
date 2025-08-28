package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

@PageObject
public class ConductorHabitualUI extends AbstractPage {
    @FindBy(xpath = "//li/h2/span[contains(text(), 'Terceros')]")
    public WebElement btnTerceros;

    @FindBy(xpath = "//a/span[contains(text(), 'Rutina de terceros')]")
    public WebElement btnRutinaTerceros;

    @FindBy(xpath = "//*[@id='thpDcmTypVal']")
    public WebElement inputTipoDocummento;

    @FindBy(xpath = "//input[@ng-model='oThpFacForm.oThpFacCDto.oThpAcvForm.oThpAcvS.thpDcmVal' and @type='text' and @name='thpDcmVal']")
    public WebElement inputIdentificadorUnico;

    @FindBy(xpath = "//*[@id='btnSrh']")
    public WebElement btnBuscar;

    @FindBy(xpath = "//*[@id=\"1\"]")
    public WebElement btnocumento;

    @FindBy(xpath = "//a/label[contains(text(), 'Modificar')]")
    public WebElement btnModificar;

    //@FindBy(xpath = "//*[contains(text(),'CONDUCTORES')]")  //Mantenimiento Ernesto
    @FindBy(xpath = "//*[@id=\"4\"]")
    public WebElement btnConductores;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div/div[2]/button[2]")
    public WebElement btnAceptar;

    @FindBy(xpath = "//input[@name='thpPrsWptrNam' or @mp-name='thpPrsWptrNam']")
    public WebElement inputConyuje;

    @FindBy(xpath = "//*[@id=\"thpPrsWmrtStsVal\"]")
    public WebElement btnEstadoCivil;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div/div[2]/button[3]")
    public WebElement botonAcentar;
    //*[@id="1"]/td[2]
    @FindBy(xpath = "//td[@title=\"116375842\"]")
    public WebElement labelINE;

    private ConductorHabitualUI(DriverManager driverManager) {
        super(driverManager);
    }
}
