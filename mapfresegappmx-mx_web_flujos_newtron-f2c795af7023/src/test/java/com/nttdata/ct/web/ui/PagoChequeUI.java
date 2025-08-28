package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class PagoChequeUI extends AbstractPage {

    // Selectores Newtron

    /** Xpath login Newtron (usuario y contraseña) **/

    @FindBy(xpath = "//*[@id=\"nuuma\"]")
    public WebElement inputUser;
    @FindBy(xpath = "//*[@id=\"contrasena\"]")
    public WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"es_log\"]/..")
    public WebElement buttonLogin;

    //Ingreso menu Gestion pago Batch
    @FindBy(xpath = "//span[text()='Tesorería']")
    public WebElement btnTesoreria;
    @FindBy(xpath = "//span[text()='Gestión pagos batch']")
    public WebElement linkPagoBatch;
    @FindBy (xpath = "//button[@id='add']")
    public WebElement clicBtnAddFile;

    //Gestión pagos batch
    @FindBy (xpath = "//input[@class='form-control ng-scope ng-pristine ng-animate ng-valid-remove ng-invalid-add ng-valid-required-remove ng-valid-remove-active ng-invalid ng-invalid-add-active ng-valid-required-remove-active ng-invalid-required']")
    public WebElement getInputTipoProceso;
    @FindBy (xpath = "(//div[@id='pyoMyyCrtMyyFrmW']//h2[text()='Introducción de datos:']/..//input[@id='pymTypVal'])[2]")
    public WebElement getInputFormaPago;
    @FindBy (xpath = "//button[@id='saveBtn']")
    public WebElement clicBtnSave;
    @FindBy (xpath = "//a[@ng-if='objBtn.btnAcp']")
    public WebElement clicBtnAceptar;

    //MODAL
    @FindBy (xpath = "//div[@id='modalHandle']")
    public WebElement modalAlert;
    @FindBy (xpath = "//img[@class='success-svg ng-scope']")
    public WebElement iconModalAlert;
    @FindBy (xpath = "//label[text()='SE HA EJECUTADO CORRECTAMENTE EL ALTA']")
    public WebElement modalTextAlert;
    @FindBy (xpath = "//span[text()='Aceptar']")
    public WebElement clicBtnAceptarModal;

    //
    @FindBy (xpath = "(//tr[@id='1'])[1]")
    public WebElement firtFileDetalle;
    @FindBy (xpath = "//button[@ng-if='objBtn.btnCargar']")
    public WebElement clicBtnBatch;
    @FindBy (xpath = "div[@id='gview_gridMyyShw_0QJ']")
    public WebElement detalleBatch;
    @FindBy (xpath = "//button[@ng-if='objBtn.btnDetalle']")
    public WebElement clicGestionDetalle;


    //    @FindBy (xpath = "")
//    public WebElement ;


public PagoChequeUI(DriverManager driverManager){
    super(driverManager);}
}
