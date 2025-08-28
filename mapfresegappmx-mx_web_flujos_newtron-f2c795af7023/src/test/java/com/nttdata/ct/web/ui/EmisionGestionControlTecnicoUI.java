package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class EmisionGestionControlTecnicoUI extends AbstractPage {


    /** Xpath menu de opciones emision - Emitir poliza **/

    @FindBy(xpath = "//body/descendant::*[text()='Emisión'][1]")
    public WebElement selectEmision;
    @FindBy(xpath = "//*[contains(text(),'Número de póliza:')]/following::input[1]")
    public WebElement inputPoliza;

    /** xpath Seleccionar Control  Tecico**/

    @FindBy(xpath = "//span[contains(text(),'Gestión control técnico emisión')]")
    public WebElement btnGestionControlTecnicoEmision;


    /** xpath informacion de Gestión Control Técnico Emisión **/

    @FindBy(xpath = "//input[@mp-name=\"plyUtcLkpDto.plyVal\"]")
    public WebElement txtNumeroPolizaEmision;

    @FindBy(xpath = "//button[@name=\"btn_qry\"]")
    public WebElement btnBuscarPolizaEmision;

    @FindBy(xpath = "(//tr[@role=\"row\"])[2]")
    public WebElement seleccionPoliza;

    @FindBy(xpath = "(//tr[@role=\"row\"])[2]//td[2]")
    public WebElement capturarPoliza;

    @FindBy(xpath = "//button[@class=\"btn btn-primary col-md-3 pull-right ng-binding\"]")
    public WebElement btnSiguienteEmision;

    @FindBy(xpath = "(//input[@role=\"checkbox\"])[2]")
    public WebElement cboxSeleccionPolizaEmision;

    @FindBy(xpath = "//textarea[@name=\"atzObsVal\"]")
    public WebElement textareaObservacionesEmision;

    @FindBy(xpath = "//button[@class=\"btn btn-navigation col-md-2 ml5 ng-scope\"]")
    public WebElement btnAutorizarPolizaEmision;

    @FindBy(xpath = "//button[@class=\"btn btn-navigation col-md-2 ml5 ng-scope ng-binding\"]")
    public WebElement btnRechazoPolizaEmision;


    @Autowired
    public EmisionGestionControlTecnicoUI(DriverManager driverManager) {
        super(driverManager);
    }

}
