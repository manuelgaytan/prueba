@Regresion @FacturacionRegressionUat
Feature: Flujo completo de consulta Factura
  @ConsultaFactura-UAT
  Scenario: Consulta Factura
    Given Inicio la sesión con usuario y contrasena
    And Ir al apartado de consulta factura
    Then Descargar archivo zip