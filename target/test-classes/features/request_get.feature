Feature: Efetuar a validação da requisição GET JSONPlaceholder

  Scenario Outline: Requisição GET - Listando Recursos
    Given Eu executo o cenário de teste "<description>"
    And  Eu envio a requisição GET "<url>"
    Then Eu valido o status code da requisição GET <code>
    And Eu valido o retorno da requisição GET "<title>"

    Examples:
      | description                         | code | url                                        | title        |
      | Lista todos os recursos - Positivo  | 200  | https://jsonplaceholder.typicode.com/posts | qui est esse |
      | Lista todos os recursos - Negativo  | 404  | https://jsonplaceholder.typicode.com/xxx   |              |




