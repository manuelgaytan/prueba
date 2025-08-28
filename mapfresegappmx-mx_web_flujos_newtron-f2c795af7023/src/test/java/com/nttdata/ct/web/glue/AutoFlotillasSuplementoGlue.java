package com.nttdata.ct.web.glue;


import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class AutoFlotillasSuplementoGlue {

    @Autowired
    private Tasks tasks;

    @And("Busqueda de suplemento de póliza flotillas")
    public void busquedaSuplementoPoliza(){
        tasks.autoFlotillasSuplementoTask.busquedaPolizaFlotillas();
    }
    @And("Modificar la poliza flotillas {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void actualizarPolizaFlotillas(String codAmbCirculacion, String codTipoVehi, String tipoIndemnizacion, String codMarca, String codModelo, String codSubModelo, String anioSubModelo, String codUsoVehiculo, String codModalidad){
        tasks.autoFlotillasSuplementoTask.aceptarInformacionBasica();
        tasks.autoFlotillasSuplementoTask.seleccionamosLaPolizaFlotillas();
        tasks.autoFlotillasSuplementoTask.seleccionamosConductoresFlotillas();
        tasks.autoFlotillasSuplementoTask.capturaosAuto2Flotillas(codAmbCirculacion,codTipoVehi,tipoIndemnizacion,codMarca,codModelo,codSubModelo,anioSubModelo,codUsoVehiculo,codModalidad);
        tasks.autoFlotillasSuplementoTask.cotizacion2AutoFlotillasSuplemento();
        tasks.autoFlotillasSuplementoTask.finModificacionDatosSuplemento();
        tasks.autoFlotillasSuplementoTask.capturarObservacionesSuplemento();
        tasks.autoFlotillasSuplementoTask.finModificacionAutoFlotillas();
    }
}
