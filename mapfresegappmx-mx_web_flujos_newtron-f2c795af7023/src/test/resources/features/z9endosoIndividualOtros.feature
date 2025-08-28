@Regresion1 @Endosos @EmisionesRegressionUat
Feature: Flujo completo de endoso cambio de plan de pago
  #Requiere del insumo generado de el feature: @SuplementoIndividual
  # ya que genera una poliza en PolizaSuplemento.json

  @Z9AnulacionSuplemento
  Scenario: Endoso anulacion de suplemento
    Given Inicio la sesión con usuario y contrasena
    And Ir al apartado de anulacion de suplementos
    And Suplemento de poliza aceptar
    Then Generando el endoso anulacion de suplemento

  @Z9EndosoCancelacion
  Scenario: Endoso de cancelacion
    Given Inicio la sesión con usuario y contrasena
    And Ir al apartado de cancelacion de agente
    And Cancelacion de poliza aceptar
    Then Generando el endoso de cancelacion