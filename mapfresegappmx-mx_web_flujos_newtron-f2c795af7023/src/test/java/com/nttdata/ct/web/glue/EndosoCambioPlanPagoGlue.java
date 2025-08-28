package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class EndosoCambioPlanPagoGlue {

    @Autowired
    private Tasks tasks;

    @And("Ir al apartado de plan de pago poliza {string},{string}")
    public void irAlApartadoDePlanDePagoPoliza(String codSuplemento, String suplemento) {
        tasks.endosoCambioPlanPago.primerPantallaPlanPago(codSuplemento,suplemento);
    }

    @And("Modificar poliza por plan de pago")
    public void modificarPolizaPorPlanDePago() {
        tasks.endosoCambioPlanPago.modificarPlanPago();
        tasks.endosoCambioPlanPago.modificarPlanPago2();
        tasks.endosoCambioPlanPago.modificarPlanPago3();
    }


    @Then("Generando el endoso cambio de plan de pago")
    public void generandoElEndosoCambioDePlanDePago() {
        tasks.endosoCambioPlanPago.generaEndosoAceptar();

    }

}
