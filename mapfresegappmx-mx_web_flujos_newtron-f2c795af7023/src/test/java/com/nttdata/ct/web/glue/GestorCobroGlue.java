package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;


public class GestorCobroGlue {
    @Autowired
    private Tasks tasks;
    @Autowired
    private LoginUI loginUI;

    @And("Completar formulario Atributos {string},{string},{string},{string},{string}")
    public void CompletarFormulario(String npoliza,String secuenciamediopago,String codgerente,String fechadeefecto, String diapago) {
        tasks.gestorCobroTask.completarFormulario(npoliza,secuenciamediopago,codgerente,fechadeefecto,diapago);
        tasks.gestorCobroTask.salirFormuraio();
    }

    @And("CP003_Consultar Poliza {string}")
        public void ConsultarPoliza(String npoliza){
        tasks.gestorCobroTask.consultarPoliza(npoliza);
        tasks.gestorCobroTask.consultarHistorico();
        tasks.gestorCobroTask.consultarSuplemento();
    }

}
