@CSV
@RegresionNo @EndosoCambioPlacas @EmisionesRegressionUat
Feature: Flujo completo de endoso individual cambio de placas automóviles

  @A2cambioPlacas-UAT
  Scenario Outline: CP001_Endoso de póliza - Ramo 410
    #endoso.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir al apartado de modificar poliza cambio placas "<codSuplemento>","<suplemento>"
    And Modificar cambio de placas
    Then Generando el endoso cambio de placas
    Examples:
| codSuplemento | suplemento | 
| 490 | 9 |

