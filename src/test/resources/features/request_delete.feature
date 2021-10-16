Feature: Efetuar a validação da requisição DELETE JSONPlaceholder

  Scenario Outline: Requisição DELETE - Deletando um Recurso
    Given Eu executo o cenário de teste "<description>"
    And  Eu envio a requisição DELETE "<url>"
    Then Eu valido o status code da requisição DELETE <code>

    Examples:
      | description                    | code | url                                          |
      | Deletar um recurso - Positivo  | 200  | https://jsonplaceholder.typicode.com/posts/1 |
      | Deletar um recurso - Negativo  | 404  | https://jsonplaceholder.typicode.com/posts/  |