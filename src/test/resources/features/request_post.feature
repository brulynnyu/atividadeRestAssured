Feature: Efetuar a validação da requisição POST JSONPlaceholder

  Scenario Outline: Requisição POST - Inserindo Recurso
    Given Eu executo o cenÃ¡rio de teste "<description>"
    And Eu insiro os dados do Body "<title>", "<body>" e <userId>
    And  Eu envio a requisição POST "<url>"
    Then Eu valido o status code da requisição POST <code>
    And Eu valido o retorno da requisição POST "<title>", "<body>" e <userId>

    Examples:
      | description                   | code | url                                        | title | body | userId |
      | Insere um recurso - Positivo  | 201  | https://jsonplaceholder.typicode.com/posts | foo   | bar  | 1      |
      | Insere um recurso - Negativo  | 500  | https://jsonplaceholder.typicode.com/      |       |      |        |
