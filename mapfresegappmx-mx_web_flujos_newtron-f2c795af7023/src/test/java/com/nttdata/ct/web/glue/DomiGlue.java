package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class DomiGlue {

    @Autowired
    private Tasks tasks;

    @And("Añadir proceso")
    public void añadirProceso() {
        tasks.domiTask.agregarprocesoagregarfila();
        tasks.domiTask.agregarprocesoagregarfilaguardar();
        tasks.domiTask.agregarprocesoagregarcargabatch();
        tasks.domiTask.agregarprocesoagregarestatuscargabatch();
        tasks.domiTask.estatuscarga();
    }

    @And("Validar carga situacion de carga")
    public void validarCargaSituacionDeCarga() {
        tasks.domiTask.consultarsituacion2();
        tasks.domiTask.gestionardetalle();
        tasks.domiTask.procesarexcepciones();
    }

    @And("Gestionar Archivo")
    public void gestionarArchivo() {
        tasks.domiTask.gestionarchivos();
    }

    @And("Consultar ya excepcionado")
    public void consultarYaExcepcionado() {
        tasks.domiTask.consultaryaexcepcionado();
        tasks.domiTask.gestionardetalle();
        tasks.domiTask.filtrarrecibos();
    }

    @And("Filtrar recibo por {string}")
    public void filtrarReciboPorDB(String gestorcobro) {
        tasks.domiTask.filtrarrecibospor(gestorcobro);
        tasks.domiTask.importe();
    }


}