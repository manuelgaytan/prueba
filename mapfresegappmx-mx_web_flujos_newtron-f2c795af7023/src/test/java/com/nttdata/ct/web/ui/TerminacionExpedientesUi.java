package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class TerminacionExpedientesUi extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div[1]/div[2]/div[1]/div/div[1]/ul/li[2]")
    public WebElement menuSimiestros;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div[1]/div[2]/div[1]/div/div[2]/div/div[2]/div/div[5]/a")
    public WebElement btnTerminacionExpediente;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/form/div/div/div/div/div/div[4]/div[3]/div[1]/input")
    public WebElement inputSimiestro;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/form/div/div/div/div/div/div[4]/div[4]/div[1]/input")
    public WebElement inputExpediente;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div/div/button[3]")
    public WebElement btonSiguiente;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/div[1]/div[3]/div/div/button[2]")
    public WebElement btonFinalizar;

    @FindBy(xpath = "//*[@id=\"1_rsnSlc\"]")
    public WebElement checkTramitacionFinalizada;


    @FindBy(xpath = "//*[@id=\"btnAcp\"]")
    public WebElement aceptarSimiestro;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[2]/div/button")
    public WebElement btnAceptOper;

    protected TerminacionExpedientesUi(DriverManager driverManager) {
        super(driverManager);
    }
}
