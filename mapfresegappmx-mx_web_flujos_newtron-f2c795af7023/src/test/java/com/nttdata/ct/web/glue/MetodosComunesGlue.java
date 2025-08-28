package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;


public class MetodosComunesGlue {
    @Autowired
    private Tasks tasks;
    @Autowired
    private LoginUI loginUI;

    /** Metodo comun para ingresar a un módulo: "Menú" --> "SubMenú",
     * Recibe como parametro "Menú" y "SubMenú" **/
    @And("Ir al Menu {string} Opcion {string}")
    public void IraMenu(String menu, String submenu) {
        tasks.metodosComunesTask.irMenu(menu,submenu);
    }

    /** Metodo Comun para buscar una tarea,
     * Recibe como parametro la tarear **/
    @And("Ejecutar tarea {string}")
    public void Tarea(String tarea) {
        tasks.metodosComunesTask.tarea(tarea);
    }

    /** Metodo Comun para cargar un archivo,
     * Recibe como parametro en nombre del archivo el cual debe estar en la siguiente ruta: /src/test/resources/"nombrearchivo" **/
    @And("Cargar Archivo {string}")
    public void CargaArchivo(String tarea) {
        tasks.metodosComunesTask.cargaarchivo(tarea);
        tasks.metodosComunesTask.confirmarcargaarchivo();
    }

}