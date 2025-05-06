#language: pt
Funcionalidade: Atualizar um usuário
  Como usuário cadastrado da aplicação
  Quero atualizar meu e-mail e telefone
  Para continuar recebendo informações

  Contexto: Cadastro bem-sucedido de um novo usuário
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |878.569.480-84    |
      |nome     |user7             |
      |telefone |41998875665       |
      |email    |user7@email.com   |
      |senha    |123456            |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 201

  Cenario: Atualização dos dados do usuário bem sucedida
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |878.569.480-84    |
      |telefone |41996675665       |
      |email    |user66@email.com  |
    Quando eu enviar a requisição com os dados atualizadas para o endpoint "/api/v2/coleta/usuario/atualizar-dados"
    Então o status code da resposta deverá ser 202