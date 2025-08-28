package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class EmisionConsultaPolizaUI extends AbstractPage {


    /** Xpath menu de opciones emision - Emitir poliza **/

    @FindBy(xpath = "//body/descendant::*[text()='Emisión'][1]")
    public WebElement selectEmision;

    /** xpath Seleccionar Control  Tecico**/

    @FindBy(xpath = "//span[contains(text(),'Consultar póliza')]")
    public WebElement btnConsultarPolizaEmision;


    /** xpath informacion de Consutla Poliza Emisión **/

    @FindBy(xpath = "//input[@name=\"txtPlyVal\"]")
    public WebElement txtNumeroPolizaEmision;

    @FindBy(xpath = "(//button[@class=\"btn btn-default pull-right ng-binding\"])[1]")
    public WebElement btnBuscarPolizaEmision;

    @FindBy(xpath = "//a[@ng-click=\"lnkPlyVal()\"]")
    public WebElement btnNumeroPolizaEmision;

    @FindBy(xpath = "//a[@class=\"icons rcpImg\"]")
    public WebElement btnResibosEmision;

    @FindBy(xpath = "(//input[@role=\"checkbox\"])[2]")
    public WebElement cboxSeleccionPolizaEmision;

    @FindBy(xpath = "//textarea[@name=\"atzObsVal\"]")
    public WebElement textareaObservacionesEmision;

    @FindBy(xpath = "//button[@class=\"btn btn-navigation col-md-2 ml5 ng-scope\"]")
    public WebElement btnAutorizarPolizaEmision;

    @FindBy(xpath = "//button[@class=\"btn btn-navigation col-md-2 ml5 ng-scope ng-binding\"]")
    public WebElement btnRechazoPolizaEmision;


    @Autowired
    public EmisionConsultaPolizaUI(DriverManager driverManager) {
        super(driverManager);
    }

}
