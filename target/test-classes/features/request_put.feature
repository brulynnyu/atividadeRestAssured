Feature: Efetuar a validação da requisição PUT JSONPlaceholder

  Scenario Outline: Requisição PUT - Alterando Recurso
    Given Eu executo o cenário de teste "<description>"
    And Body para a requisição PUT "<title>", "<body>", <userId> e <id>
    And Eu envio a requisição PUT "<url>"
    Then Eu valido o status code da requisição PUT <code>
    And Eu valido o retorno da requisição PUT "<title>", "<body>", <userId> e <id>

    Examples:
      | description                | code | url                                           | title | body  | userId | id  |
      | Altera recursos - Positivo | 200  | https://jsonplaceholder.typicode.com/posts/1  | foo   | teste | 1      | 1   |
      | Altera recursos - Negativo | 500  | https://jsonplaceholder.typicode.com/posts/   |       |       |        |     |
