package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class CambioGestionIndividualUI extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"JBNUM_POLIZA\"]")
    public WebElement inputNumeroPoliza;

    @FindBy(xpath = "//*[@id=\"JBTIP_GESTOR\"]")
    public WebElement inputTipoGestor;

    @FindBy(xpath = "//*[@id=\"JBCOD_GESTOR\"]")
    public WebElement inputCodGestor;

    @FindBy(xpath = "//*[@id=\"btnAcp\"]")
    public WebElement btnAceptar;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div/div[2]/div/div/div/button")
    public WebElement btnSalir;

    @FindBy(xpath = "//span[contains(text(), 'Emisión')]")
    //@FindBy(xpath = "//body/descendant::*[text()='Emisión'][1]") // Mantenimiento Ernesto
    public WebElement menuEmision;

    //@FindBy(xpath = "//*[@id=\"app-content-container\"]/div[1]/div[2]/div[1]/div/div[2]/div/div[4]/div/div[2]/a")
    @FindBy(xpath = "//body/descendant::*[text()='Consultar póliza'][1]")  // Mantenimiento Ernesto
    public WebElement btnConsultaPoliza;

    @FindBy(xpath = "//*[@name=\"txtPlyVal\"]")
    public WebElement inputPoliza;

    @FindBy(xpath = "//*[@id=\"plyPlyCtnSrhDcmW\"]/div/div/div[4]/button[2]")
    public WebElement btnBuscar;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div/div/div/ul/li[10]/button/div/a")
    public WebElement btnRecibos;

    @FindBy(xpath = "//*[@id=\"1\"]/td[8]")
    public WebElement textAgente;

    @Autowired
    public CambioGestionIndividualUI(DriverManager driverManager) {
        super(driverManager);
    }
}
