package com.nttdata.ct.web.glue;


import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
public class EndosoCambioPlacasGlue {
    @Autowired
    private Tasks tasks;

    @And("Ir al apartado de modificar poliza cambio placas {string},{string}")
    public void modificarPolizaCambioPlacas(String codSuplemento, String suplemento) {
        tasks.individualCambioPlacasTask.primerPantalla(codSuplemento, suplemento);
    }

    @And("Modificar cambio de placas")
    public void gitmodificacionPoliza(){
        tasks.individualCambioPlacasTask.modificarPoliza();
        tasks.individualCambioPlacasTask.modificarNumeroPlacas();
        tasks.individualCambioPlacasTask.ModificarnumeroPlacas2();
    }

    @Then("Generando el endoso cambio de placas")
    public void generandoElEndosoDidminucionDePrimas() {
        tasks.individualCambioPlacasTask.GeneraEndosoAceptar();
    }



}
