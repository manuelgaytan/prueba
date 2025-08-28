@CSV
@Regresion @ModificarProveedor @ProveedoresRegressionUat
Feature: Proceso para Modificar/Actulizar datos de proveedor.

  @ModProveedorDireccion-UAT
  Scenario Outline: CP001_ModificarDireccionProveedor
    #modificar_proveedor.csv|
    Given Inicio la sesión con usuario y contrasena
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de proveedores "<tipoDocTercero>", "<actividadTercero>"
    And Clic boton Modificar
    And Ingresar nueva "<direccion>"
    And Clic boton Aceptar
    Examples:
| tipoDocTercero | actividadTercero | direccion | 
| RFC | 17 | MIGUEL ALEMAN CENTRO NUM EXT 2 NUM INT 0 |
