Feature: Efetuar a valida��o da requisi��o POST JSONPlaceholder

  Scenario Outline: Requisi��o POST - Inserindo Recurso
    Given Eu executo o cenário de teste "<description>"
    And Eu insiro os dados do Body "<title>", "<body>" e <userId>
    And  Eu envio a requisi��o POST "<url>"
    Then Eu valido o status code da requisi��o POST <code>
    And Eu valido o retorno da requisi��o POST "<title>", "<body>" e <userId>

    Examples:
      | description                   | code | url                                        | title | body | userId |
      | Insere um recurso - Positivo  | 201  | https://jsonplaceholder.typicode.com/posts | foo   | bar  | 1      |
      | Insere um recurso - Negativo  | 500  | https://jsonplaceholder.typicode.com/      |       |      |        |
