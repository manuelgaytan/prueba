@CSV
@Regresion @A1EmisionesG @EmisionesRegressionUat @EmisionUAT
Feature: Flujo completo Emision de Automóviles

  @A1EmisionF-UAT
  Scenario Outline: CP002_Emisión de póliza flotilla - Ramo 411
    #autos_flotillas.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso datos primer pantalla cotización de automoviles flotillas "<tipoDocumento>", "<rfcUsuario>", "<codigoTercero>", "<cuadCom>", "<codigoOficina>"
    Then Ingreso datos segunda pantalla cotización de automoviles flotillas "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para cotizar flotillas
    Then Ingreso datos para emisión flotillas
    Examples:
| null-data | siFechaVencimiento | tipoDocumento | rfcUsuario | codigoTercero | cuadCom | codigoOficina | codAmbCirculacion | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | 
| null-data | si | RFC | AAAA481203RR6 | 59510 | 616 | 6619 | 1 | 1 | 1 | 25 | 1 | 1 | 2018 | 405 | 40001 |

  @A1EmisionIndividual @Endososz9regresion
  Scenario Outline: CP001_Emisión de póliza individual - Ramo 410
    #autos_individual.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso datos primer pantalla cotización de automoviles individual "<tipoDocumento>", "<rfcUsuario>", "<codigoTercero>", "<cuadCom>", "<codigoOficina>"
    And Ingreso datos segunda pantalla cotización de automoviles individual "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para cotizar individual
    Then Ingreso datos para emisión
    Examples:
| null-data | tipoDocumento | rfcUsuario | codigoTercero | cuadCom | codigoOficina | codAmbCirculacion | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | 
| null-data | RFC | AAAA481203RR6 | 59510 | 614 | 6619 | 1 | 1 | 1 | 25 | 5 | 1 | 2018 | 401 | 40001 |

  @PresupuestoIndividual-UAT @Ramo410-UAT
  Scenario Outline: CP007_Emisión de presupuesto individual - Ramo 410
    #autos_individual.csv |
    Given Inicio la sesión con usuario y contrasena
    And Datos primer pantalla cotización presupuesto de automoviles individual "<tipoDocumento>", "<rfcUsuario>", "<codigoTercero>", "<cuadCom>", "<codigoOficina>", "<codigoFuenteDist>"
    And Datos segunda pantalla cotización presupuesto de automoviles individual "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para cotización de presupuesto
    And Ingreso datos para presupuesto de emisión
    Then Consulta de emisión de presupuesto
    Examples:
| null-data | tipoDocumento | rfcUsuario | codigoTercero | cuadCom | codigoOficina | codAmbCirculacion | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | 
| null-data | RFC | AAAA481203RR6 | 59510 | 614 | 6619 | 1 | 1 | 1 | 25 | 5 | 1 | 2018 | 401 | 40001 |
