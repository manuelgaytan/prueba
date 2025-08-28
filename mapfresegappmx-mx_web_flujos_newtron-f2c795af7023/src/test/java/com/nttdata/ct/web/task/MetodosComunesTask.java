package com.nttdata.ct.web.task;
import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.MetodosComunesUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.time.Duration;

import static org.junit.Assert.fail;

@Task
public class MetodosComunesTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private MetodosComunesUI metodosComunesUI;

    /** Metodo comun para ingresar a un módulo: "Menú" --> "SubMenú" **/
    @ShotAfter(evidenceName = "Ir al Menu")
    public void irMenu(String menu, String submenu) {
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(30));
        Util.pageStatus(manager.getDriver());
        WebElement opcmenu = null;
        WebElement opcsubmenu = null;

        /** Menu **/
        try {
            opcmenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/descendant::*[text()='"+menu+"'][1]")));
            opcmenu.click();
        } catch (Exception e) {

            assert opcmenu != null: "No Se encuentra el menu ingresado,"+"\n\n"+
                    "********************************************************************"+"\n" +
                    "*** Favor de ingresar correctamente MENU ***"+"\n" +
                    "********************************************************************";
        }
        Util.explicitWait(2);
        /** SubMenu **/
        try {
            opcsubmenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/descendant::*[text()='"+submenu+"'][1]")));
            opcsubmenu.click();
        } catch (Exception e) {
            assert opcsubmenu != null: "No Se encuentra el submenu ingresado para el menú seleccionado,"+"\n\n"+
                    "********************************************************************"+"\n" +
                    "*** Favor de ingresar correctamente SUBMENU ***"+"\n" +
                    "********************************************************************";
        }
        //Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(),"//div[@class='loading-container ng-isolate-scope darkness']");
    }

    /** Metodo Comun para buscar una tarea **/
    @ShotAfter(evidenceName = "Ejecutar tarea")
    public void tarea(String Tarea) {
        Util.tab(manager.getDriver());
        this.metodosComunesUI.inputTarea.sendKeys(Tarea);
        Util.explicitWait(1);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.metodosComunesUI.btnAceptar.click();
        Util.explicitWait(2);
        if (Tarea.equals("MMXGCL0103")){
            String valor = this.metodosComunesUI.inputTarea.getAttribute("value");
            if (valor.equals("MMXGCL0103L")){
                this.metodosComunesUI.btnCancelar.click();
                Util.explicitWait(2);
                this.metodosComunesUI.inputTarea.sendKeys("MMXGCL0103");
                Util.explicitWait(1);
                Util.pageStatus(manager.getDriver());
                Util.explicitWait(1);
                this.metodosComunesUI.btnAceptar.click();
                Util.explicitWait(2);
            }
        }



        if(Util.webElementIsEnabled(3,manager.getDriver(),this.metodosComunesUI.ventanaError)) {
            // Obtener los textos de los elementos de error
            String ventanaErrorTexto = this.metodosComunesUI.ventanaError.getText();
            String detalleErrorTexto = this.metodosComunesUI.detalleError.getText();

            // Crear el mensaje de error
            String mensajeError = String.format(
                    "Se muestra una ventana de Error:\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                    "********************************************************************",
                    "********************************************************************",
                    "********************************************************************",
                    ventanaErrorTexto,
                    detalleErrorTexto,
                    "********************************************************************",
                    "********************************************************************",
                    "********************************************************************"
            );
            // Lanzar el fallo con el mensaje de error
            throw new AssertionError(mensajeError);
        }


    }

    /** Metodo Comun para cargar archivo 1-2 **/
    @ShotAfter(evidenceName = "Cargar Archivo")
    public void cargaarchivo(String archivo) {
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/resources/"+archivo);
        String file1 = file.getAbsolutePath();
        this.metodosComunesUI.inputArchivo.sendKeys(file1);
        Util.explicitWait(1);
    }

    /** Metodo Comun para cargar archivo 2-2 **/
    public void confirmarcargaarchivo() {
        Util.pageStatus(manager.getDriver());
        this.metodosComunesUI.btnAceptarCarga.click();
        Util.waitAlert(manager.getDriver());
        Util.isVisibleAlertTemporal(manager.getDriver(), "Archivo cargado");
        this.metodosComunesUI.btnSalir.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }


}