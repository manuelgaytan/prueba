@CSV
@Regresion1 @proveedorPadre @ProveedoresRegressionRec
Feature: Flujo completo Dar de alta proveedor padre y dar de alta sus sucursales, utilizando los documentos alternativos

  @ProveedorPadreDA-UAT
  Scenario: Dar de alta proveedor padre y dar de alta sus sucursales, utilizando los documentos alternativos
    Given Inicio la sesión con usuario y contrasena
    And Voy al apartado suplemento de proveedores
    And Crear proveedor padre
    And CP001_Dar de alta proveedor padre
    And Crear proveedor hijo
    And CP002_Dar de alta proveedor hijo
    And CP003_Consulta de proveedores

