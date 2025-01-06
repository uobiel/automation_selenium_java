Feature: Login no Swag Labs

  Scenario: Login com credenciais válidas
    Given que estou na página de login do Swag Labs
    When eu insiro o usuário "standard_user" e a senha "secret_sauce"
    And clico no botão de login
    Then devo ver a página de produtos

  Scenario: Login com credenciais inválidas
    Given que estou na página de login do Swag Labs
    When eu insiro o usuário "fake_user" e a senha "wrong_password"
    And clico no botão de login
    Then devo ver uma mensagem de erro
