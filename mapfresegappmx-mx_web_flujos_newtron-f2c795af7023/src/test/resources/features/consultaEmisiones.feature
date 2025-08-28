@Regresion-NO @Automoviles @EmisionesRegressionUat
Feature: Flujo completo de consulta automóviles

  @ConsultaFlotillas-UAT
  Scenario: CP005_Consulta de póliza Flotilla - Ramo 411
    Given Inicio la sesión con usuario y contrasena
    And Voy al apartado consultar póliza flotillas
    And Consulta de la póliza flotillas
    And Informacion general de la póliza flotillas

  @ConsultaIndividual-UAT
  Scenario: CP005_Consulta de póliza Individual - Ramo 410
    Given Inicio la sesión con usuario y contrasena
    And Voy al apartado consultar póliza
    And Consulta de la póliza
    And Informacion general de la póliza
