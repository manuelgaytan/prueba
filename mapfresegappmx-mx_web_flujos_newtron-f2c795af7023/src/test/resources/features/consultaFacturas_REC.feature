@Regresion-REC @RegresionNeto-REC @FacturacionRegressionRec
Feature: Flujo completo de consulta Factura
  @ConsultaFactura-REC
  Scenario: Consulta Factura
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al apartado de consulta factura
    Then Descargar archivo zip