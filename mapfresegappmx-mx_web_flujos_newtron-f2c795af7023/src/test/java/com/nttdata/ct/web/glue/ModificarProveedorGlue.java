package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.ModificarProveedorTask;
import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class ModificarProveedorGlue {

    @Autowired
    private Tasks tasks;

    @Autowired
    private ModificarProveedorTask modificarProveedorTask;

    @And("Busqueda de proveedores {string}, {string}")
    public void busquedaProveedores(String TipoDoc, String Actividad){
        modificarProveedorTask.busquedaProveedor(TipoDoc,Actividad);
    }

    @And ("Clic boton Modificar")
    public void clicBotonModificar(){
        modificarProveedorTask.clicModificarProvedor();
    }

    @And ("Ingresar nueva {string}")
    public void nuevaDireccion(String direccion){
        modificarProveedorTask.ingresarNuevaDireccion(direccion);
    }

    @And("Clic boton Aceptar")
    public void botonAceptar(){
        modificarProveedorTask.clicBotonAceptar();
    }

    @And ("Modificar Docto Alternativo")
    public void modificarDoctoAlternativo(){

    }

}
