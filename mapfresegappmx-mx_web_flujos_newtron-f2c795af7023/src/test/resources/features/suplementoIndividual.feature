@CSV
@Regresion1 @AutomovilesIndividual @EmisionesRegressionRec
Feature: Flujo completo de suplemento automóviles individual
#Requiere del insumo generado de el feature: @A1EmisionIndividual
  # ya que genera una poliza en PolizaIndividual.json

  @SuplementoIndividual-UAT @Endososz9regresion-UAT
  Scenario: CP003_Suplemento de póliza - Ramo 410
    Given Inicio la sesión con usuario y contrasena
    And Voy al apartado suplemento de póliza
    And Busqueda de suplemento de póliza individual
    And Modificar la póliza individual

