@CSV

  Feature: Proceso general de apertura de siniestros DMP
    #Se alimenta de la emision individual de poliza CP001_Emisión de póliza individual - Ramo 410
    #@A1EmisionIndividual

    @Siniestro_Colision_DMP,DED,DJA,LEO,LEO  @Colision_DMP,DED,DJA,LEO,LEO
    Scenario: ColisionVolcadura DMP,DED,DJA,LEO,LEO
      Given Inicio la sesión con usuario y contrasena
      And Ir al Menu "Siniestros" Opcion "Apertura siniestro"
      And Ingresar informacion del siniestro "COLISION Y/O VOLCADURA"
      And Seleccionar consecuencias "DMP,DED,DJA,LEO,LEO"
      And Relatos sobre siniestro DMP
      And Llenar Datos del siniestro "DMP,DED,DJA,LEO,LEO"
      And Llenar Datos Complementarios "DMP,DED,DJA,LEO,LEO"

    @Expediente_Colision_DMP,DED,DJA,LEO,LEO  @Colision_DMP,DED,DJA,LEO,LEO,TEST
    Scenario: Creacion de Expendientes  ColisionVolcadura DMP,DED,DJA,LEO,LEO
      Given Inicio la sesión con usuario y contrasena
      And Ir al Menu "Siniestros" Opcion "Apertura expediente"
      And Ir a apertura de expediente "DMP,DED,DJA,LEO,LEO"
      And Crear Expedientes "DMP,DED,DJA,LEO,LEO"



    @Siniestro_Colision_DMP,RMS,RLS  @Colision_DMP,RMS,RLS
    Scenario: ColisionVolcadura DMP,DMP,RMS,RLS
      Given Inicio la sesión con usuario y contrasena
      And Ir al Menu "Siniestros" Opcion "Apertura siniestro"
      And Ingresar informacion del siniestro "COLISION Y/O VOLCADURA"
      And Seleccionar consecuencias "DMP,RMS,RLS"
      And Relatos sobre siniestro DMP
      And Llenar Datos del siniestro "DMP,RMS,RLS"
      And Llenar Datos Complementarios "DMP,RMS,RLS"

    @Expediente_Colision_DMP,RMS,RLS  @Colision_DMP,RMS,RLS
    Scenario: Creacion de Expendientes  ColisionVolcadura DMP,DMP,RMS,RLS
      Given Inicio la sesión con usuario y contrasena
      And Ir al Menu "Siniestros" Opcion "Apertura expediente"
      And Ir a apertura de expediente "DMP,RMS,RLS"
      And Crear Expedientes "DMP,RMS,RLS"



    @Siniestro_Cristales_DCP,LEO @Cristales_DCP,LEO
    Scenario: Creacion de Siniestro Cristales DCP,LEO
      Given Inicio la sesión con usuario y contrasena
      And Ir al Menu "Siniestros" Opcion "Apertura siniestro"
      And Ingresar informacion del siniestro "ROTURA DE CRISTALES"
      And Seleccionar consecuencias "DCP,LEO"
      And Relatos sobre siniestro DMP
      And Llenar Datos del siniestro "DCP,LEO"
      And Llenar Datos Complementarios "DCP,LEO"

    @Expediente_Cristales_DCP,LEO  @Cristales_DCP,LEO
    Scenario: Creacion de Expendientes  ColisionVolcadura DMP,DMP,RMS,RLS
      Given Inicio la sesión con usuario y contrasena
      And Ir al Menu "Siniestros" Opcion "Apertura expediente"
      And Ir a apertura de expediente "DCP,LEO"
      And Crear Expedientes "DCP,LEO"

