package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class ProcesoPagoComisionUI extends AbstractPage {

    /** Formulario atributos **/
    @FindBy(xpath = "//input[@id='JBFEC_PROCESO_INI']")
    public WebElement dateFechaIni;
    @FindBy(xpath = "//input[@id='JBFEC_PROCESO_FIN']")
    public WebElement dateFechaFin;
    @FindBy(xpath = "//input[@id='JBTIP_DETALLE']")
    public WebElement txtDetalleResumido;
    @FindBy(xpath = "//input[@id='JBCOD_AGT']")
    public WebElement txtCodAgente;

    @FindBy(xpath = "(//span[@class='ng-binding'])[3]")
    public WebElement btnAceptarFormulario;


    /** Ménu consultar Póliza **/
    @FindBy(xpath = "//*[@id=\"mp-header\"]/div[2]/div[1]/a[2]/img")
    public WebElement btnSpollInformes;
    @FindBy(xpath = "(//button[@class=\"btn btn-default btn-icon-before-detail ng-binding\"])[2]")
    public WebElement btnDescargarInforme;

    public WebElement btnSalir;

    /** Ménu consultar Póliza **/

    public WebElement btnBuscar;



    @Autowired
    public ProcesoPagoComisionUI(DriverManager driverManager) {
        super(driverManager);
    }

}
