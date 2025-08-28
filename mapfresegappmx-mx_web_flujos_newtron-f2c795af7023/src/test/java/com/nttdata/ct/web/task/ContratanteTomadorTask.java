package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.ConductorHabitualUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.openqa.selenium.WebElement;
@Task
public class ContratanteTomadorTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    public ConductorHabitualUI conductorHabitualUI;

    @ShotAfter( evidenceName = "Ir a rutina terceros")
    public void irATerceros(){
        this.conductorHabitualUI.btnTerceros.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        this.conductorHabitualUI.btnRutinaTerceros.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        this.conductorHabitualUI.inputTipoDocummento.sendKeys("RFC");
        Util.tab(manager.getDriver());
        Util.explicitWait(4);
        //this.conductorHabitualUI.inputIdentificadorUnico.sendKeys("AAAA481203RR6");
        this.conductorHabitualUI.inputIdentificadorUnico.sendKeys("HEEO931004XX2");
        Util.explicitWait(4);
        this.conductorHabitualUI.btnBuscar.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter( evidenceName = "Imformacion conductor habitual")
    public void irATerceros2() {
        this.conductorHabitualUI.btnocumento.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        this.conductorHabitualUI.btnModificar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        //this.conductorHabitualUI.btnConductores.click();
        WebElement selectTomador = manager.getDriver().findElement(By.xpath("//*[@id=\"1\"]"));
        selectTomador.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(4);
        this.conductorHabitualUI.btnAceptar.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"thpPrsW\"]/h3[1]"); //Mantenimiento Pendiente
        Util.explicitWait(4);
    }
    @ShotAfter( evidenceName = "Cambiar nombre del conyuge")
    public void irATerceros3(){
        String nombreAnterior = this.conductorHabitualUI.inputConyuje.getAttribute("value");
        String nombre1="DANA PAOLA",nombre2="NORMA ALVA";
        if (nombreAnterior.equals(nombre1)){
            this.conductorHabitualUI.inputConyuje.clear();
            Util.explicitWait(2);
            this.conductorHabitualUI.inputConyuje.sendKeys(nombre2);
        } else if (nombreAnterior.equals(nombre2)) {
            this.conductorHabitualUI.inputConyuje.clear();
            Util.explicitWait(2);
            this.conductorHabitualUI.inputConyuje.sendKeys(nombre1);
        }
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(4);
    }


    public void validarINE(){
        Util.scrollToElement(manager.getDriver(),"//*[@id='app-content-container']/div/div/div/div[1]/div/div[10]/div[1]");
        Util.explicitWait(2);
        String disminuPrima = this.conductorHabitualUI.labelINE.getAttribute("title");
        Assert.assertEquals(disminuPrima,"116375842");
        this.conductorHabitualUI.botonAcentar.click();
        Util.explicitWait(4);
    }
}
