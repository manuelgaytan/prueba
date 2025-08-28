@CSV
@Regresion1 @AutomovilesFlotillas @AutomSuplemento @EmisionesRegressionUat
Feature: Flujo completo de suplemento automóviles flotillas

  @SuplementoFlotillas-UAT
  Scenario Outline: CP004_Suplemento de póliza - Ramo 411
    #autos_flotillas.csv |
    Given Inicio la sesión con usuario y contrasena
    And Voy al apartado suplemento de póliza
    And Busqueda de suplemento de póliza flotillas
    And Modificar la poliza flotillas "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    Examples:
| null-data | siFechaVencimiento | tipoDocumento | rfcUsuario | codigoTercero | cuadCom | codigoOficina | codAmbCirculacion | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | 
| null-data | si | RFC | AAAA481203RR6 | 59510 | 616 | 6619 | 1 | 1 | 1 | 25 | 1 | 1 | 2018 | 405 | 40001 |
