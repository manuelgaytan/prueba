@CSV
@Regresion1-REC @AutomovilesIndividual-REC @SiniestrosRegressionRec
Feature: Flujo completo reporte de siniestro automoviles

  @ReporteSiniestroIndividual-REC
  Scenario Outline: CP009_Reporte de siniestro Individual - Ramo 410
    #siniestro_colision-rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Consulta de siniestro
    And Busqueda de siniestro
    And Validación de consulta siniestro "<motivoSiniestro>"
    Examples:


