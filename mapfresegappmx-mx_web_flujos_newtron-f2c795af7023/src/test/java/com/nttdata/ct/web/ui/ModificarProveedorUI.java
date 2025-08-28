package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

@PageObject
public class ModificarProveedorUI extends AbstractPage {

    @FindBy(xpath = "//input[@id='thpDcmTypVal']")
    public WebElement inpTipoDoc;

    @FindBy(xpath = "//input[@id='thpAcvVal']")
    public WebElement inpActTercero;

    @FindBy(xpath = "//button[@id='btnSrh']")
    public WebElement btnBuscar;

    @FindBy (xpath = "(//td[contains(@title,'ACTIVO')])[2]")
    public WebElement tdProveedor;

    @FindBy(xpath = "//label[text()='Modificar']")
    public WebElement btnModificar;

    @FindBy(xpath = "(//span[contains(text(),'Dirección')]//following::label[text()='Modificar'])[1]")
    public WebElement btnModDireccion;

    @FindBy(xpath = "(//span[contains(text(),'Dirección')]//following::input[@name='dsbRow'])[1]")
    public WebElement chkDisableDireccion;

    @FindBy (xpath = "//input[@name='adrTxtVal']")
    public WebElement txtDireccion;

    @FindBy (xpath = "(//span[contains(text(),'Dirección')]//following::label[text()='Confirmar'])[1]")
    public WebElement btnConfirmarDireccion;

    @FindBy (xpath = "//button[text()='ceptar']")
    public WebElement btnAceptar;

    @FindBy(xpath = "(//span[contains (text(),'Documentos Alternativos')]//following::label[text()='Modificar'])[1]")
    public  WebElement btnModDoctoAlternativo;

    @FindBy(xpath = "//input[@id='thpArmMntW_alrThpDcmIsuDat']")
    public WebElement txtFechaEmisionDocto;

    @FindBy(xpath = "//input[@id='thpArmMntW_alrThpDcmExyDat']")
    public WebElement txtFechaCaducidadDocto;

    @FindBy (xpath = "//input[@id='thpArmMntW_alrThpDcmCckDat']")
    public WebElement txtFechaComprobacion;

    @FindBy(xpath = "//input[@name='alrThpDcmObsCckMth']")
    public WebElement txtObservaciones;


    protected ModificarProveedorUI(DriverManager driverManager) {
        super(driverManager);
    }
}
