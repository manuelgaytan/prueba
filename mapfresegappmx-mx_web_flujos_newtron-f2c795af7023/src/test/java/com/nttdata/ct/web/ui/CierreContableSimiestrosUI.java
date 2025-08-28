package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class CierreContableSimiestrosUI extends AbstractPage {

    @FindBy(xpath =  "//*[@id=\"JBFECHA_HASTA\"]")
    public WebElement inputFechaHasta;

    @FindBy(xpath = "//SPAN[text()=\"Cancelar\"]")
    public WebElement btnCancelar;

    @FindBy(xpath = "//*[@id=\"JBCOD_CIA\"]")
    public WebElement codCompania;

    @FindBy(xpath = "//*[@id=\"JBCOD_SECTOR\"]")
    public WebElement codSector;

    @FindBy(xpath = "//*[@id=\"JBCOD_RAMO\"]")
    public WebElement codRamo;

    @FindBy(xpath = "//*[@id=\"JBTIP_EXP_RECOBRO\"]")
    public WebElement tipoExpedienteRecobro;

    @FindBy(xpath = "//*[@id=\"JBANIO_MES\"]")
    public WebElement timeProceso;

    @FindBy(xpath = "//*[@id=\"JBTIP_RESERVA\"]")
    public WebElement tipoReserva;



    @FindBy(xpath = "//*[@id=\"JBMCA_DETALLE\"]")
    public WebElement informeDetallado;

    @FindBy(xpath = "//*[@id=\"JBTIP_REPORTE\"]")
    public WebElement tipoReporte;



    protected CierreContableSimiestrosUI(DriverManager driverManager) {
        super(driverManager);
    }
}
