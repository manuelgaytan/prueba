package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.IndividualConsultaUI;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class AutomovilesSuplementoGlue {
    @Autowired
    private Tasks tasks;


    @Given("Voy al apartado suplemento de póliza")
    public void irSuplemetoIndividual() {
        tasks.automovilesSuplementoTask.irSuplementoPoliza();
    }
    @And("Busqueda de suplemento de póliza individual")
    public void busquedaIndividual() {
        tasks.automovilesSuplementoTask.busquedaSuplemento();
    }
    @And("Modificar la póliza individual")
    public void modificarPolizaInd() {
        tasks.automovilesSuplementoTask.segundaPantallaSuplemento1();
        tasks.automovilesSuplementoTask.datosModificar();
        tasks.automovilesSuplementoTask.datosModificar2();
        tasks.automovilesSuplementoTask.emisionIndividual();
        tasks.automovilesSuplementoTask.emisionIndividual2();

    }




}
