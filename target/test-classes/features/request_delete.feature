Feature: Efetuar a valida��o da requisi��o DELETE JSONPlaceholder

  Scenario Outline: Requisi��o DELETE - Deletando um Recurso
    Given Eu executo o cen�rio de teste "<description>"
    And  Eu envio a requisi��o DELETE "<url>"
    Then Eu valido o status code da requisi��o DELETE <code>

    Examples:
      | description                    | code | url                                          |
      | Deletar um recurso - Positivo  | 200  | https://jsonplaceholder.typicode.com/posts/1 |
      | Deletar um recurso - Negativo  | 404  | https://jsonplaceholder.typicode.com/posts/  |