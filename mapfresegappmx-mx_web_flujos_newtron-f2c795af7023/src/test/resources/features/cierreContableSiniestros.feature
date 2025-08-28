@CSV @cierreSiniestros-UAT @Regresion-NO
Feature: Flujo completo cierre contable de siniestros

  @cargaMensual-UAT
  Scenario Outline: Lanzador de tareas 01 02 07
    #cierre_contable.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir a Tareas
    And Ejecutar tarea 'TRNTS20001'
    And Ingresar datos tarea "<tarea20001>"
    And Ejecutar tarea 'TRNTS20002'
    And Ingresar datos tarea "<tarea20002>"
    And Ejecutar tarea 'TRNGCA0007'
    And Ingresar datos tarea "<tarea07>"
    Examples:
| tarea20001 | tarea20002 | tarea07 | tarea210 | tarea06 | tarea03 | tarea04 | tarea05 | tarea100 | 2tarea100 | tarea3062 | 2tarea3062 | 3tarea3062 | 
| TRNTS20001 | TRNTS20002 | TRNGCA0007 | MMXGCL0210 | MMXCOL0006 | MMXCOL0003 | MMXCOL0004 | MMXCOL0005 | MMXCOL0100 | 2MMXCOL0100 | MMXCOL3062 | 2MMXCOL3062 | 3MMXCOL3062 |

  @ListadoPreContable-UAT
  Scenario Outline: Lanzador de tareas 210
    Given Inicio la sesión con usuario y contrasena
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0210'
    And Ingresar datos tarea "<tarea210>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'IASFIC_NTW' de salida tarea
    Examples:
| tarea20001 | tarea20002 | tarea07 | tarea210 | tarea06 | tarea03 | tarea04 | tarea05 | tarea100 | 2tarea100 | tarea3062 | 2tarea3062 | 3tarea3062 | 
| TRNTS20001 | TRNTS20002 | TRNGCA0007 | MMXGCL0210 | MMXCOL0006 | MMXCOL0003 | MMXCOL0004 | MMXCOL0005 | MMXCOL0100 | 2MMXCOL0100 | MMXCOL3062 | 2MMXCOL3062 | 3MMXCOL3062 |

  @ListaExpedientesNoRecobros-UAT
  Scenario Outline: Lanzador de tareas 06
    Given Inicio la sesión con usuario y contrasena
    And Ir a Tareas
    And Ejecutar tarea 'MMXCOL0006'
    And Ingresar datos tarea "<tarea06>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'AUTOS_G' de salida tarea
    Examples:
| tarea20001 | tarea20002 | tarea07 | tarea210 | tarea06 | tarea03 | tarea04 | tarea05 | tarea100 | 2tarea100 | tarea3062 | 2tarea3062 | 3tarea3062 | 
| TRNTS20001 | TRNTS20002 | TRNGCA0007 | MMXGCL0210 | MMXCOL0006 | MMXCOL0003 | MMXCOL0004 | MMXCOL0005 | MMXCOL0100 | 2MMXCOL0100 | MMXCOL3062 | 2MMXCOL3062 | 3MMXCOL3062 |

  #MMXCOL0003
  @ListaExpedientesSalvamento-UAT
  Scenario Outline: Lanzador de tareas 03
    Given Inicio la sesión con usuario y contrasena
    And Ir a Tareas
    And Ejecutar tarea 'MMXCOL0003'
    And Ingresar datos tarea "<tarea03>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'ASOHGI_S_' de salida tarea
    Examples:
| tarea20001 | tarea20002 | tarea07 | tarea210 | tarea06 | tarea03 | tarea04 | tarea05 | tarea100 | 2tarea100 | tarea3062 | 2tarea3062 | 3tarea3062 | 
| TRNTS20001 | TRNTS20002 | TRNGCA0007 | MMXGCL0210 | MMXCOL0006 | MMXCOL0003 | MMXCOL0004 | MMXCOL0005 | MMXCOL0100 | 2MMXCOL0100 | MMXCOL3062 | 2MMXCOL3062 | 3MMXCOL3062 |

  @ListaExpedientesDeducibles-UAT
  Scenario Outline: Lanzador de tareas 04
    #MMX-20007: TRN-20007: NO ESTA AUTORIZADO PARA ACTUALIZACION #
    Given Inicio la sesión con usuario y contrasena
    And Ir a Tareas
    And Ejecutar tarea 'MMXCOL0004'
    And Ingresar datos tarea "<tarea04>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'ASOI_D_' de salida tarea
    Examples:
| tarea20001 | tarea20002 | tarea07 | tarea210 | tarea06 | tarea03 | tarea04 | tarea05 | tarea100 | 2tarea100 | tarea3062 | 2tarea3062 | 3tarea3062 | 
| TRNTS20001 | TRNTS20002 | TRNGCA0007 | MMXGCL0210 | MMXCOL0006 | MMXCOL0003 | MMXCOL0004 | MMXCOL0005 | MMXCOL0100 | 2MMXCOL0100 | MMXCOL3062 | 2MMXCOL3062 | 3MMXCOL3062 |

  @ListaExpedientesRecobros-UAT
  Scenario Outline: Lanzador de tareas 05
    Given Inicio la sesión con usuario y contrasena
    And Ir a Tareas
    And Ejecutar tarea 'MMXCOL0005'
    And Ingresar datos tarea "<tarea05>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'ASOI_D_' de salida tarea
    Examples:
| tarea20001 | tarea20002 | tarea07 | tarea210 | tarea06 | tarea03 | tarea04 | tarea05 | tarea100 | 2tarea100 | tarea3062 | 2tarea3062 | 3tarea3062 | 
| TRNTS20001 | TRNTS20002 | TRNGCA0007 | MMXGCL0210 | MMXCOL0006 | MMXCOL0003 | MMXCOL0004 | MMXCOL0005 | MMXCOL0100 | 2MMXCOL0100 | MMXCOL3062 | 2MMXCOL3062 | 3MMXCOL3062 |

  @ListadoSumariasTuristas-UAT
  Scenario Outline: Lanzador de tareas 100G
    Given Inicio la sesión con usuario y contrasena
    And Ir a Tareas
    And Ejecutar tarea 'MMXCOL0100'
    And Ingresar datos tarea "<tarea100>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'AUTOS_TURIS_G' de salida tarea
    Examples:
| tarea20001 | tarea20002 | tarea07 | tarea210 | tarea06 | tarea03 | tarea04 | tarea05 | tarea100 | 2tarea100 | tarea3062 | 2tarea3062 | 3tarea3062 | 
| TRNTS20001 | TRNTS20002 | TRNGCA0007 | MMXGCL0210 | MMXCOL0006 | MMXCOL0003 | MMXCOL0004 | MMXCOL0005 | MMXCOL0100 | 2MMXCOL0100 | MMXCOL3062 | 2MMXCOL3062 | 3MMXCOL3062 |

  @ListadoSumariasTuristas2-UAT
  Scenario Outline: Lanzador de tareas 100R
    Given Inicio la sesión con usuario y contrasena
    And Ir a Tareas
    And Ejecutar tarea 'MMXCOL0100'
    And Ingresar datos tarea "<2tarea100>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'AUTOS_TURIS_R' de salida tarea
    Examples:
| tarea20001 | tarea20002 | tarea07 | tarea210 | tarea06 | tarea03 | tarea04 | tarea05 | tarea100 | 2tarea100 | tarea3062 | 2tarea3062 | 3tarea3062 | 
| TRNTS20001 | TRNTS20002 | TRNGCA0007 | MMXGCL0210 | MMXCOL0006 | MMXCOL0003 | MMXCOL0004 | MMXCOL0005 | MMXCOL0100 | 2MMXCOL0100 | MMXCOL3062 | 2MMXCOL3062 | 3MMXCOL3062 |

  @MReserva1G-UAT
  Scenario Outline: Lanzador de tareas 3062
    Given Inicio la sesión con usuario y contrasena
    And Ir a Tareas
    And Ejecutar tarea 'MMXCOL3062'
    And Ingresar datos tarea "<tarea3062>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'rpt_gral_recobros' de salida tarea
    Examples:
| tarea20001 | tarea20002 | tarea07 | tarea210 | tarea06 | tarea03 | tarea04 | tarea05 | tarea100 | 2tarea100 | tarea3062 | 2tarea3062 | 3tarea3062 | 
| TRNTS20001 | TRNTS20002 | TRNGCA0007 | MMXGCL0210 | MMXCOL0006 | MMXCOL0003 | MMXCOL0004 | MMXCOL0005 | MMXCOL0100 | 2MMXCOL0100 | MMXCOL3062 | 2MMXCOL3062 | 3MMXCOL3062 |

  @MReserva2G-UAT
  Scenario Outline: Lanzador de tareas 3062 2
    Given Inicio la sesión con usuario y contrasena
    And Ir a Tareas
    And Ejecutar tarea 'MMXCOL3062'
    And Ingresar datos tarea "<2tarea3062>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'rpt_gral_recobros' de salida tarea
    Examples:
| tarea20001 | tarea20002 | tarea07 | tarea210 | tarea06 | tarea03 | tarea04 | tarea05 | tarea100 | 2tarea100 | tarea3062 | 2tarea3062 | 3tarea3062 | 
| TRNTS20001 | TRNTS20002 | TRNGCA0007 | MMXGCL0210 | MMXCOL0006 | MMXCOL0003 | MMXCOL0004 | MMXCOL0005 | MMXCOL0100 | 2MMXCOL0100 | MMXCOL3062 | 2MMXCOL3062 | 3MMXCOL3062 |

  @MReserva3G-UAT
  Scenario Outline: Lanzador de tareas 3062 3
    Given Inicio la sesión con usuario y contrasena
    And Ir a Tareas
    And Ejecutar tarea 'MMXCOL3062'
    And Ingresar datos tarea "<3tarea3062>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'rpt_gral_recobros' de salida tarea
    Examples:
| tarea20001 | tarea20002 | tarea07 | tarea210 | tarea06 | tarea03 | tarea04 | tarea05 | tarea100 | 2tarea100 | tarea3062 | 2tarea3062 | 3tarea3062 | 
| TRNTS20001 | TRNTS20002 | TRNGCA0007 | MMXGCL0210 | MMXCOL0006 | MMXCOL0003 | MMXCOL0004 | MMXCOL0005 | MMXCOL0100 | 2MMXCOL0100 | MMXCOL3062 | 2MMXCOL3062 | 3MMXCOL3062 |
