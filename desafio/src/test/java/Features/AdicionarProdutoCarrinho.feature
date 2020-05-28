Feature: Adicionar Produto Carrinho

Scenario: Adicionar Produto Carrinho

Given Usuario acessar Magazine Luiza
When Usuario Consultar Produto para Comprar
Then Usuario Adiciona Produto no Carrinho
Then Verificar produto no carrinho