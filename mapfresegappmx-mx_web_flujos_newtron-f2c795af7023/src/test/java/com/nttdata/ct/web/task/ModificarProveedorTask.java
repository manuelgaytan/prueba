package com.nttdata.ct.web.task;

import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.ModificarProveedorUI;

import java.util.List;

@Task
public class ModificarProveedorTask {

    @Autowired
    public DriverManager manager;

    @Autowired
    public ModificarProveedorUI modificarProveedorUI;

    @ShotAfter(evidenceName = "Busqueda de Proveedor")
    public void busquedaProveedor(String tipoDoc, String actividad){
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.modificarProveedorUI.inpTipoDoc.sendKeys(tipoDoc);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.modificarProveedorUI.inpActTercero.sendKeys(actividad);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.modificarProveedorUI.btnBuscar.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.explicitWait(1);
        this.modificarProveedorUI.tdProveedor.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "clic Modificar Proveedor")
    public void clicModificarProvedor(){
        Util.pageStatus(manager.getDriver());
        this.modificarProveedorUI.btnModificar.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

    }

    @ShotAfter(evidenceName = "Ingresar Nueva Direccion")
    public void ingresarNuevaDireccion(String direccion){
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.explicitWait(1);
        List<WebElement> frames = manager.getDriver().findElements(By.xpath("//iframe"));
        if(!frames.isEmpty()){
            System.out.println("Frames: "+frames.size());
            Util.activarIframe(manager.getDriver(),"//iframe");
        }

        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(),"//span[contains (text(),'Dirección')]");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.modificarProveedorUI.btnModDireccion.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        if(this.modificarProveedorUI.chkDisableDireccion.isSelected()){
            Util.explicitWait(1);
            Util.pageStatus(manager.getDriver());
            this.modificarProveedorUI.chkDisableDireccion.click();
            Util.explicitWait(1);
            Util.pageStatus(manager.getDriver());
        }
        this.modificarProveedorUI.txtDireccion.click();
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.modificarProveedorUI.txtDireccion.clear();
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        this.modificarProveedorUI.txtDireccion.sendKeys(direccion);
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        try {
            this.modificarProveedorUI.btnConfirmarDireccion.click();
            Util.explicitWait(1);
            Util.pageStatus(manager.getDriver());
        }catch (Exception ex){
            Util.scrollDown(manager.getDriver(),"-100");
            this.modificarProveedorUI.btnConfirmarDireccion.click();
            Util.explicitWait(1);
            Util.pageStatus(manager.getDriver());
        }
    }

    @ShotAfter(evidenceName = "Clic Boton Aceptar")
    public void clicBotonAceptar(){
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.modificarProveedorUI.btnAceptar.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.explicitWait(1);
    }


    public void modificarDoctoAlternativo(){
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(),"//span[contains (text(),'Documentos Alternativos')]");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.modificarProveedorUI.btnModDoctoAlternativo.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

        try {
            this.modificarProveedorUI.btnConfirmarDireccion.click();
            Util.explicitWait(1);
            Util.pageStatus(manager.getDriver());
        }catch (Exception ex){
            Util.scrollDown(manager.getDriver(),"-100");
            this.modificarProveedorUI.btnConfirmarDireccion.click();
            Util.explicitWait(1);
            Util.pageStatus(manager.getDriver());
        }
    }

}
