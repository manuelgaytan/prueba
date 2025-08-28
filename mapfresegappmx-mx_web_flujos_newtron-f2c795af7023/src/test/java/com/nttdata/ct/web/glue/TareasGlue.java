package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;


public class TareasGlue {
    @Autowired
    private Tasks tasks;

    @And("Ingresar a Envio de Archivos al Servidor Tronweb Report")
    public void ingresarAEnvioDeArchivosAlServidorTronwebReport() {
        tasks.tareasTask.ingresarAEnvioDeArchivosAlServidor();
    }

    @And("CP001_Carga de archivo a TronWeb reports")
    public void cp001CargaDeArchivoATronwebReport() {
        tasks.tareasTask.cargarArchivo();
        tasks.tareasTask.validarCargaArchivo();
    }

    @And("Ingresar a Lanzador de Tareas")
    public void ingresar_a_lanzador_de_tareas() {
        tasks.tareasTask.ingresarALanzadorDeTareas();

    }

    @And("CP002_Ejecución de tarea MMXGC00171 {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void ejecucionDeTareaMMXGC00171(String tarea, String codigoDeCampania, String tipoProceso, String orden, String tipoDeGestor, String codigoDeGestor, String tipoDeNegocio, String descuentoComision, String formaDeCompensacion, String repocesaPolConError, String nombreArchivo) {
        tasks.tareasTask.ejecucionDeTareasMMXGC00171(tarea, codigoDeCampania, tipoProceso, orden, tipoDeGestor, codigoDeGestor,tipoDeNegocio,descuentoComision, formaDeCompensacion, repocesaPolConError, nombreArchivo);
    }

    @And("CP003_Descargar archivo de salida")
    public void descargarArchivoDeSaida() {
        tasks.tareasTask.descargarArchivoDeSalida();
    }

    @And("CP004_Consulta aplicación de cobros")
    public void consultaAplicacionDeCobros() {
        tasks.tareasTask.consultaAplicacionDeCobro();
        tasks.tareasTask.consultaAplicacionDeCobroAceptar();
        tasks.tareasTask.consultaAplicacionDeCobroAceptarAplicacionCobro();
        tasks.tareasTask.consultaAplicacionDeCobroAceptarAplicacion();
    }

    @And("CP005_Aplicacion cobros")
    public void cp_AplicacionCobros() {
        tasks.tareasTask.aplicacionDeCobro();
    }


}
