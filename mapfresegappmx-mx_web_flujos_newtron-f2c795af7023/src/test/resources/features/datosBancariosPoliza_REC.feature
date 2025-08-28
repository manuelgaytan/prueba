@Regresion-REC @DatosBancariosPorPoliza-REC
Feature: Flujo completo Datos Bancarios por poliza

  @DatosBancariosPoliza-REC
  Scenario: Envio de Archivos al Servidor
  Given Inicio la sesión con usuario y contrasena REC
  And Ir a Facturación
  And Seleccionar y cargar archivo 'POLIZATEST.TXT'
  And Ir a Tareas
  And Ejecutar tarea 'MMXGCL1009'
  And Ingresar datos de la tarea datos bancarios "POLIZATEST.TXT"
  And Validar situación del archivo
  And CP002_Descarga archivo 'reporte_REPCOB_' de salida tarea