Feature: Consultar Produto

Scenario: Consultar Produto

Given Usuario acessar o site Magazine Luiza
When Usuario digita um produto para consulta
Then Usuario clicar em Consultar
Then Produto e exibido na lista
