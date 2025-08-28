package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;


public class ProcesoPagoComisionGlue {
    @Autowired
    private Tasks tasks;
    @Autowired
    private LoginUI loginUI;

    @And("Completar formulario Atributos de Proceso Pago Comision {string},{string},{string},{string}")
    public void CompletarFormulario(String fechaproinicial,String fechaprofinal,String detalleresumido,String codagente) {
        tasks.procesoPagoComisionTask.completarFormulario(fechaproinicial,fechaprofinal,detalleresumido,codagente);
        tasks.procesoPagoComisionTask.aceptarFormuraio();
    }

   @And("Descargar archivo de salida que comience con {string}")
    public void descargarArchivoDeSaida(String comienzacon) {
        tasks.procesoPagoComisionTask.descargarArchivoDeSalida(comienzacon);
    }

    @And("Validar que se muestre el archivo que comienza con {string} y no contenga {string}")
    public void validarQueSeMuestreArchivoNoLog(String comienzacon,String nocontenga) {
        tasks.procesoPagoComisionTask.validarQueSeMuestreArchivoNoLog(comienzacon,nocontenga);
    }


}
