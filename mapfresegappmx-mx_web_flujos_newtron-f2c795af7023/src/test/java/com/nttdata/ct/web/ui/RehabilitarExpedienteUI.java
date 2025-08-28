package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class RehabilitarExpedienteUI extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div[1]/div[2]/div[1]/div/div[2]/div/div[2]/div/div[6]/a")
    public WebElement btnRehabilitarExpediente;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/div/div/div/form/div/div[4]/div[3]/div[1]/input")
    public WebElement inputNumSimiestro;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/div/div/div/form/div/div[4]/div[4]/div[1]/input")
    public WebElement inputExpediente;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div/div/button[3]")
    public WebElement btonSig;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/div[1]/div[3]/div[1]/div/button[3]")
    public WebElement botonSig;

    @FindBy(xpath = "//*[@id=\"jqg_gridCnq1X5_1\"]")
    public WebElement checkRoboTotal;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/div[1]/div[3]/div[1]/div/button[2]")
    public WebElement btnVerificar;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/div[1]/div[3]/div[1]/div/button[4]")
    public WebElement btnSiguientePart;

    @FindBy(xpath = "//*[@id=\"1_rsnSlc\"]")
    public WebElement checkCancelacionLiq;
    //*[@id="btnAcp"]
    @FindBy(xpath = "//*[@id=\"btnAcp\"]")
    public WebElement btnAceptarRehabi;

    @FindBy(xpath = "//*[@id=\"vadAmnInput_0\"]")
    public WebElement inputIndemnizacion;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/div/button[2]")
    public WebElement btnAcepCambios;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/button[2]")
    public WebElement btnAceptCamb;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[2]/div/button")
    public WebElement btnAceptOpera;

    @FindBy(xpath = "")
    public WebElement btnFinalizacion;

    @FindBy(xpath = "//*[@id=\"1\"]/td[4]/button")
    public WebElement btnIndemnizacion;

    @FindBy(xpath = "//*[@id=\"2\"]/td[4]/button")
    public WebElement btnHonorarios;

    @FindBy(xpath = "//*[@id=\"3\"]/td[4]/button")
    public WebElement btnGastos;


    protected RehabilitarExpedienteUI(DriverManager driverManager) {
        super(driverManager);
    }
}
