@CSV
@PagoCheque-REC
Feature: Flujo completo de Pago por Cheque

  #PAGO POR CHEQUE
  @PagoCheque1-REC
  Scenario: CP001_Generar alta de la orden - Añadir fila
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tesorería
    And Ingreso Pagos masivos Opción Gestión pagos batch
    Then CP001_Generar alta de la orden (Añadir fila)

  @PagoCheque2-REC
  Scenario Outline: CP002_Cargar Batch
    #pago_cheque.csv |
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tesorería
    And Ingreso Pagos masivos Opción Gestión pagos batch
    And CP001_Generar alta de la orden (Añadir fila)
    And Introducir datos "<tipoProceso>","<formaPago>"
    And Clic botón Guardar
    And Clic botón Aceptar
    Then CP002_Cargar Batch
    Examples:
| tipoProceso | formaPago | 
| 20 | 1 |
