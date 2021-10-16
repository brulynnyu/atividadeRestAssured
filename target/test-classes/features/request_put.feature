Feature: Efetuar a valida��o da requisi��o PUT JSONPlaceholder

  Scenario Outline: Requisi��o PUT - Alterando Recurso
    Given Eu executo o cen�rio de teste "<description>"
    And Body para a requisi��o PUT "<title>", "<body>", <userId> e <id>
    And Eu envio a requisi��o PUT "<url>"
    Then Eu valido o status code da requisi��o PUT <code>
    And Eu valido o retorno da requisi��o PUT "<title>", "<body>", <userId> e <id>

    Examples:
      | description                | code | url                                           | title | body  | userId | id  |
      | Altera recursos - Positivo | 200  | https://jsonplaceholder.typicode.com/posts/1  | foo   | teste | 1      | 1   |
      | Altera recursos - Negativo | 500  | https://jsonplaceholder.typicode.com/posts/   |       |       |        |     |
