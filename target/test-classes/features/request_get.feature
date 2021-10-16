Feature: Efetuar a valida��o da requisi��o GET JSONPlaceholder

  Scenario Outline: Requisi��o GET - Listando Recursos
    Given Eu executo o cen�rio de teste "<description>"
    And  Eu envio a requisi��o GET "<url>"
    Then Eu valido o status code da requisi��o GET <code>
    And Eu valido o retorno da requisi��o GET "<title>"

    Examples:
      | description                         | code | url                                        | title        |
      | Lista todos os recursos - Positivo  | 200  | https://jsonplaceholder.typicode.com/posts | qui est esse |
      | Lista todos os recursos - Negativo  | 404  | https://jsonplaceholder.typicode.com/xxx   |              |




