package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.io.IOException;

public class ConsultaFacturaGlue {
    @Autowired
    private Tasks tasks;

    @And("Ir al apartado de consulta factura")
    public void irAlApartadoDeConsultaFactura() {
        tasks.consultaFacturaTask.irConsultaFactura();
    }

    @Then("Descargar archivo zip")
    public void descargarArchivoZip(){
        tasks.consultaFacturaTask.generarArchivoZip();
    }


}
