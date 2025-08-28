@CSV
@RegresionNo @Endosos @EmisionesRegressionUat
Feature: Flujo completo de endoso cambio de plan de pago

  @PP1EmisionIndividual-REC
  Scenario Outline: CP001_Emisión de póliza individual - Ramo 410
    #autos_individual.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ingreso datos primer pantalla cotización de automoviles individual "<tipoDocumento>", "<rfcUsuario>", "<codigoTercero>", "<cuadCom>", "<codigoOficina>"
    And Ingreso datos segunda pantalla cotización de automoviles individual "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para cotizar individual
    Then Ingreso datos para emisión
    Examples:
| null-data | tipoDocumento | rfcUsuario | codigoTercero | cuadCom | codigoOficina | codAmbCirculacion | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | 
| null-data | RFC | AAAA481203RR6 | 59510 | 614 | 6619 | 1 | 1 | 1 | 25 | 5 | 1 | 2018 | 401 | 40001 |

  @Z8EndosoCambioPlanPay
  Scenario Outline: Endoso cambio de plan de pago
    #endoso_otros.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir al apartado de plan de pago poliza "<codSuplemento>","<suplemento>"
    And Modificar poliza por plan de pago
    Then Generando el endoso cambio de plan de pago
    Examples:
| codSuplemento | suplemento | 
| 490 | 4 |

  @Z8EndosoCambioAgent
  Scenario Outline: Endoso cambio de Agente
    #endoso_cambio_agente.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir al apartado de cambio de agente "<codSuplemento>","<suplemento>"
    And Modificar poliza por agente "<codTercero>","<cuadComision>","<codOficina>","<canalDsitrib>"
    Then Generando el endoso cambio de agente
    Examples:
| codSuplemento | suplemento | codTercero | cuadComision | codOficina | canalDsitrib | 
| 490 | 12 | 99998 | 614 | 5545 | 3701 |
