@Modificaciona3-REC @TercerosRegressionRec
Feature: Flujo completo de Actualizaciones de Terceros
  @ModificacionCH-REC
  Scenario: Modificacion del conductor habitual
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al apartado de rutina de terceros
    Then Aceptar cambio de conductor habitual

  @ModificacionCT-REC
  Scenario: Modificacion del contratante - Tomador
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al apartado de rutina de terceros Tomador
    Then Aceptar cambio de contratante Tomador