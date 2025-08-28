@CSV
@RegresionNo @Endosos @EmisionesRegressionUat
Feature: Flujo completo de endoso individual disminución de primas automóviles

  @EndosoPoliza
  Scenario Outline: CP001_Endoso de póliza - Ramo 410
    #endoso.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir al apartado de modificar poliza disminución primas "<codSuplemento>","<suplemento>"
    And Modificar poliza por disminucion de primas
    Then Generando el endoso disminucion de primas
    Examples:
| codSuplemento | suplemento | 
| 490 | 9 |
