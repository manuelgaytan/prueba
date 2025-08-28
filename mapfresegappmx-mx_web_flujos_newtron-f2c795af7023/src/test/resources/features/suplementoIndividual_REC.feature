@CSV
@Regresion-REC @AutomovilesSupIndividual-REC @EmisionesRegressionRec
Feature: Flujo completo de suplemento automóviles individual
#Requiere del insumo generado de el feature: @A1EmisionIndividual
  # ya que genera una poliza en PolizaIndividual.json

  @S1EmisionIndividual-REC2
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

  @SuplementoIndividual-REC @Endososz9regresion-REC
  Scenario: CP003_Suplemento de póliza - Ramo 410
    Given Inicio la sesión con usuario y contrasena REC
    And Voy al apartado suplemento de póliza
    And Busqueda de suplemento de póliza individual
    And Modificar la póliza individual

