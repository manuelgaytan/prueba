
@Regresion @Modificaciona3 @TercerosRegressionUat
Feature: Flujo completo de Actualizaciones de Terceros

  @ModificacionCH
  Scenario: Modificacion del conductor habitual
    Given Inicio la sesión con usuario y contrasena
    And Ir al apartado de rutina de terceros
    Then Aceptar cambio de conductor habitual

  @ModificacionCT-UAT
  Scenario: Modificacion del contratante - Tomador
    Given Inicio la sesión con usuario y contrasena
    And Ir al apartado de rutina de terceros Tomador
    Then Aceptar cambio de contratante Tomador