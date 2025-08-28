package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class ProveedorUI extends AbstractPage {
    @FindBy(xpath = "//*[contains(text(),'Terceros') and @class='textoMenu ng-binding']")
    public WebElement terceros;
    @FindBy(xpath = "//span[contains(text(),'Proveedor')]")
    public WebElement proveedor;
    @FindBy(xpath = "//*[@id='thpDcmTypVal']")
    public WebElement inputTipoDoc;
    @FindBy(xpath = "//button[@ng-click='accept()']")
    public WebElement btnAceptar;
    @FindBy(xpath = "//*[contains(text(),'alir')]")
    public WebElement btnSalir;
    @FindBy(xpath = "//*[@name='thpDcmVal']")
    public WebElement inputDocumento;
    @FindBy(xpath = "//*[@name='thpAcvWthpDcmVal']")
    public WebElement inputDocumentoCrear;
    @FindBy(xpath = "//*[@name='thpAcvWprnDcmTypVal']")
    public WebElement inputTipoDocumentoPadre;
    @FindBy(xpath = "//*[@name='thpAcvWprnDcmVal']")
    public WebElement inputDocumentoPadre;
    @FindBy(xpath = "//*[@name=\"thpAcvVal\"]")
    public WebElement inputActividadTer;
    @FindBy(xpath = "//button[@accesskey='A']")
    public WebElement btnAceptarProv;
    @FindBy(xpath = "//*[@id='btnSrh']")
    public WebElement btnBuscar;
    @FindBy(xpath = "//*[@class='textSm ng-binding' and contains(text(),'Crear')]")
    public WebElement btnCrear;
    @FindBy(xpath = "//body/descendant::a[@accesskey='btnQry.ack' and not(@disabled='disabled')][1]/label[@class='textSm ng-binding' and contains(text(),'Consultar')][1]")
    public WebElement btnConsultar;
    @FindBy(xpath = "//*[@name='thpPrsWthpNam']")
    public WebElement inputNombre;
    @FindBy(xpath = "//*[@name='thpPrsWthpFrsSrn']")
    public WebElement inputApellido1;
    @FindBy(xpath = "//*[@name='thpPrsWthpScnSrn']")
    public WebElement inputApellido2;
    @FindBy(xpath = "//*[contains(text(),'Datos Generale')]/following::input[@name='splSttTypVal'][1]")
    public WebElement inputTipoProveedor;
    @FindBy(xpath = "//*[contains(text(),'Datos Generale')]/following::input[@name='inlCtrDat'][1]")
    public WebElement inputFechaInicioContr;
    @FindBy(xpath = "//*[contains(text(),'Datos Generale')]/following::input[@name='fnlCtrDat'][1]")
    public WebElement inputFechaFinContr;
    @FindBy(xpath = "//*[contains(text(),'Datos Generale')]/following::label[@class='textSm'][2]/span/u")
    public WebElement btnAceptarDG;
    @FindBy(xpath =  "//*[contains(text(),'Documentos Alternativos')]/following::*[contains(text(),'Añadir')][1]/../*[1]")
    public WebElement btnAnadirDA;
    @FindBy(xpath = "//button[@id='btnAcp']")
    public WebElement btnAceptarCot;
    @FindBy(xpath = "//*[@name='alrThpDcmTypVal']")
    public WebElement inputTipoDocAlternativo;
    @FindBy(xpath = "//*[@name='alrThpDcmVal']")
    public WebElement inputDocAlternativo;
    @FindBy(xpath = "//*[@name='alrThpDcmIsuDat']")
    public WebElement inputFechaEmiAlternativo;
    @FindBy(xpath = "//*[@name='alrThpDcmExyDat']")
    public WebElement inputFechaCadAlternativo;
    @FindBy(xpath = "//*[@name='alrThpDcmCnyVal']")
    public WebElement inputPaisEmisorAlt;
    @FindBy(xpath = "//*[@name='alrThpDcmObsCckMth']")
    public WebElement inputObservacionesAlt;
    @FindBy(xpath = "//*[@name='alrThpDcmCck']")
    public WebElement checkDocComp;
    @FindBy(xpath = "//*[@id='thpArmMntW_alrThpDcmCckDat']")
    public WebElement inputFechaComprobacion;
    @FindBy(xpath = "//*[@id='thpArmMntW_vldDat']")
    public WebElement inputFechaVal;
    @FindBy(xpath = "//*[contains(text(),'Documentos Alternativos')]/following::*[contains(text(),'Confirmar') and @class='textSm ng-binding'][1]/../*[1]")
    public WebElement btnConfirmar;
    @FindBy(xpath = "//*[contains(text(),'Tipologia y Categoria')]/following::*[@name='tylVal'][1]")
    public WebElement inputTipologia;
    @FindBy(xpath = "//*[contains(text(),'Tipologia y Categoria')]/following::*[@name='splCtgVal'][1]")
    public WebElement inputCatProveedor;
    @FindBy(xpath = "//*[contains(text(),'Tipologia y Categoria')]/following::u[text()='A'][1]")
    public WebElement btnAceptarTipologia;
    @FindBy(xpath = "//input[@name='prnDcmVal']")
    public WebElement inputPadreValidation;

    @Autowired
    public ProveedorUI(DriverManager driverManager){
        super(driverManager);
    }
}
