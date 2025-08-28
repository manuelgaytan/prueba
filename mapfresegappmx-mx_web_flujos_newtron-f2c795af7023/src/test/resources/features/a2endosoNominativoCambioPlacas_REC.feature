@CSV
@Regresion-REC @EndosoCambioPlacas-REC @EmisionesRegressionRec
Feature: Flujo completo de endoso individual cambio de placas automóviles

  @A2cambioPlacas-REC
  Scenario Outline: CP001_Endoso de póliza - Ramo 410
    #endoso.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al apartado de modificar poliza cambio placas "<codSuplemento>","<suplemento>"
    And Modificar cambio de placas
    Then Generando el endoso cambio de placas
    Examples:
| codSuplemento | suplemento | 
| 490 | 9 |
