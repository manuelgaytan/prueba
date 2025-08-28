package com.nttdata.ct.web.glue;
import io.cucumber.java.en.And;
import com.nttdata.ct.web.task.Tasks;
import org.springframework.beans.factory.annotation.Autowired;

public class ProveedorPadreGlue {

    @Autowired
    private Tasks tasks;

    @And("Voy al apartado suplemento de proveedores")
    public void menuPrincipal() {
        tasks.proveedorPadreTask.irConsultarPoliza();
    }
    @And("Crear proveedor padre")
    public void llenamosProvPadre() {
        tasks.proveedorPadreTask.llenamosDatosProvP();
        tasks.proveedorPadreTask.llenamosDatosProvP2();
        tasks.proveedorPadreTask.llenamosDatosProvP3();
    }
    @And("CP001_Dar de alta proveedor padre")
    public void ingresamosDatosP() {
        tasks.proveedorPadreTask.creacionProvPadre();
        tasks.proveedorPadreTask.creacionProvPadre2();
        tasks.proveedorPadreTask.creacionProvPadre3();
        tasks.proveedorPadreTask.creacionProvPadre4();
        tasks.proveedorPadreTask.creacionProvPadre5();
        tasks.proveedorPadreTask.creacionProvPadre6();
    }
    @And("Crear proveedor hijo")
    public void rfcProvHijo() {
        tasks.proveedorPadreTask.llenamosDatosProvHijo();
        tasks.proveedorPadreTask.llenamosDatosProvHijo2();
    }
    @And("CP002_Dar de alta proveedor hijo")
    public void llenamosProvHijo() {
        tasks.proveedorPadreTask.creacionProvHijo();
        tasks.proveedorPadreTask.creacionProvHijo2();
        tasks.proveedorPadreTask.creacionProvHijo3();
        tasks.proveedorPadreTask.creacionProvHijo4();

    }
    @And("CP003_Consulta de proveedores")
    public void validationProv() {
        tasks.proveedorPadreTask.validacionProveedoresCreados();
    }




}