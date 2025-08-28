package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.task.ExcelData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

@PageObject
public class ConsultaFacturasUI extends AbstractPage {


    //@FindBy(xpath = "//li[11]/h2/span[contains(text(), 'Facturación')]")
    @FindBy(xpath = "//body/descendant::*[text()='Facturación'][1]")
    public WebElement btnFacturacion;

    //@FindBy(xpath = "//a[@ng-click='click(subMen2)']//span[@class='ng-binding' and text()='Consulta Factura']")
    @FindBy(xpath = "//body/descendant::*[text()='Consulta Factura'][1]")
    public WebElement btnConsultaFactura;

    @FindBy(xpath = "//*[@id=\"acgEliGtiCtnMmxW\"]/div/div/div/div[1]/div/div/div[1]/h4/a")
    public WebElement btnPolizaRec;

    @FindBy(xpath = "//input[@id='plyVal']")
    public WebElement inputNumPoliza;

    @FindBy(xpath = "//button[@id='btnSrch']")
    public WebElement btnBuscar;

    @FindBy(xpath = "//input[@id='jqg_gridActions_1']")
    public WebElement checkFactura;

    @FindBy(xpath = "//*[@id=\"acgEliGtiTblMmxW\"]/div[3]/button[2]")
    public WebElement btnExportar;

    @FindBy(xpath = "//button[@id='ambos']")
    public WebElement btnAmbos;

    @FindBy(xpath = "//*[@id=\"1\"]/td[4]" )
    public WebElement labelNumPoliza;


    public ConsultaFacturasUI(DriverManager driverManager) {
        super(driverManager);
    }
}
