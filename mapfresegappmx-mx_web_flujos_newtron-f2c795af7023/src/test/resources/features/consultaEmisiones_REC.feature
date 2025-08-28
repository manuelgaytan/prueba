@Regresion-REC @Automoviles-REC
Feature: Flujo completo de consulta automóviles

  @ConsultaFlotillas-REC
  Scenario: CP005_Consulta de póliza Flotilla - Ramo 411
    Given Inicio la sesión con usuario y contrasena REC
    And Voy al apartado consultar póliza flotillas
    And Consulta de la póliza flotillas
    And Informacion general de la póliza flotillas

  @ConsultaIndividual-REC
  Scenario: CP005_Consulta de póliza Individual - Ramo 410
    Given Inicio la sesión con usuario y contrasena REC
    And Voy al apartado consultar póliza
    And Consulta de la póliza
    And Informacion general de la póliza
