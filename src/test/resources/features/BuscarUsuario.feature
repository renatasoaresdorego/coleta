#language: pt
Funcionalidade: Buscar usuário
  Como administrador da aplicação
  Quero buscar um usuário cadastrado pelo CPF
  Para gerenciar as informações do usuário

  Contexto: Cadastro bem-sucedido de um novo usuário
    Dado os meus dados pessoais:
      | atributo | valor             |
      | cpf      | 878.569.480-77    |
      | nome     | user7             |
      | telefone | 41998875665       |
      | email    | user7@email.com   |
      | senha    | 123456            |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 201

  Cenario: Busca de usuário pelo CPF
    Quando eu enviar a requisição para buscar o usuário no endpoint "/api/v2/coleta/usuario/buscar-usuario" com o CPF "878.569.480-77"
    Então o status code da resposta deverá ser 200
    E o corpo da resposta deverá conter os dados do usuário