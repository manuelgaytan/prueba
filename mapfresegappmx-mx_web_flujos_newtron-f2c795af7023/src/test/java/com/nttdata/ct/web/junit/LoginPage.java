package com.nttdata.ct.web.junit;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

    By userInput = By.xpath("//tr[@class='table-danger']/following::div[contains(@id, 'Descargar')][1]/descendant::td[1]");
    By btnAceptarCondiciones = By.xpath("//input[@id='Button1]");
    By linkReporteImpresion = By.xpath("//body/descendant::a[contains(text(), 'Reporte Impresión')][1]");

    By optionPlan = By.xpath("//select[@id='drpPlan']/option[2]");

    By selectFPago = By.xpath("//select[@id='drpFormaPago']");

    By optionFPago = By.xpath("//select[@id='drpFormaPago']/option[2]");

    By optionRiesgo = By.xpath("//select[@name='drpRiesgo']/option[text()='BAJO']");

}
