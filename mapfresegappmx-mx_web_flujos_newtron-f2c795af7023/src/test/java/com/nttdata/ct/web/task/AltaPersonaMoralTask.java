package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.AltaPersonaMoralUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Task
public class AltaPersonaMoralTask {

    @Autowired
    public DriverManager manager;
    @Autowired
    public AltaPersonaMoralUI altaPersonaMoralUI;


    @ShotAfter(evidenceName = "Clic Marca de Fisica o Jurídico")
    public void clicCheckFisicaJuridica() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        List<WebElement> iframes = manager.getDriver().findElements(By.xpath("//iframe"));
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.explicitWait(3);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(),'Persona')][1]");
        Util.explicitWait(3);
        Util.clicJavascript(manager.getDriver(), "//input[@name='phyPrs']");
    }

}
