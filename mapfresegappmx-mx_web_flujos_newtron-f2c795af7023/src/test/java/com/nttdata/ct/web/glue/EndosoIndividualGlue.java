package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class EndosoIndividualGlue {
    @Autowired
    private Tasks tasks;

    @And("Ir al apartado de modificar poliza disminución primas {string},{string}")
    public void meEncuentroVentanaPrincipal(String codSuplemento, String suplemento) {
        tasks.individualEndosoDisminucionTask.primerPantallaDisminucionPrimas(codSuplemento,suplemento);
    }

    @And("Modificar poliza por disminucion de primas")
    public void modificacionPoliza(){
        tasks.individualEndosoDisminucionTask.modificarPoliza();
        tasks.individualEndosoDisminucionTask.ModificarValorRcTerceros();
        tasks.individualEndosoDisminucionTask.ModificarValorRcTerceros3();
    }

    @Then("Generando el endoso disminucion de primas")
    public void generandoElEndosoDidminucionDePrimas() {
        tasks.individualEndosoDisminucionTask.GeneraEndosoAceptar();
    }

}



