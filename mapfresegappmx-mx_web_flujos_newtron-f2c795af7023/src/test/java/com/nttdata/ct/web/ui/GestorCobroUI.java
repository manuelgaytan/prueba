package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class GestorCobroUI extends AbstractPage {

    /** Formulario atributos **/
    @FindBy(xpath = "//input[@id='JBNUM_POLIZA']")
    public WebElement txtNumPoliza;
    @FindBy(xpath = "//input[@id='JBPCM_SQN_VAL']")
    public WebElement txtSecuenciaMedio;

    @FindBy(xpath = "(//span[@class='input-group-btn'])[3]")
    public WebElement liSecuenciaMedio;
    @FindBy(xpath = "(//span[@class='input-group-btn'])[4]")
    public WebElement liTipoGestor;

    @FindBy(xpath = "(//span[@class='input-group-btn'])[5]")
    public WebElement liCodGerente;
    @FindBy(xpath = "//input[@id='JBFEC_EFEC_SPTO']")
    public WebElement txtFechaEfecto;
    @FindBy(xpath = "//input[@id='JBNUM_DIA_PAGO']")
    public WebElement txtDiaPago;
    @FindBy(xpath = "//button[@id='btnAcp']//span[@class='ng-binding']")
    public WebElement btnAceptarFormulario;

    @FindBy(xpath = "//*[contains(text(), 'Tiene errores')]")
    public WebElement ventanaError;
    @FindBy(xpath = "//li[@ng-repeat='e in error.errors']")
    public WebElement detalleError;



    @FindBy(xpath = "(//button[contains(text(),'Aceptar')])[1]")
    public WebElement btnAceptarLista;

    @FindBy(xpath = "//span[@class='btn-navigation-label ng-binding']")
    public WebElement btnSalir;

    /** Ménu consultar Póliza **/
    @FindBy(xpath = "//input[@name='txtPlyVal']")
    public WebElement txtPoliza;
    @FindBy(xpath = "(//button[@ng-click='btnSrhMdf && btnSrhOnClick()'])[1]")
    public WebElement btnBuscar;
    @FindBy(xpath = "//a[normalize-space()='Histórico']")
    public WebElement btnHistorico;
    @FindBy(xpath = "//div[@class='ng-binding'][normalize-space()='Suplemento']")
    public WebElement btnSuplemento;
    @FindBy(xpath = "//span[normalize-space()='Información General']")
    public WebElement btnInformacionGeneral;


    @Autowired
    public GestorCobroUI(DriverManager driverManager) {
        super(driverManager);
    }

}
