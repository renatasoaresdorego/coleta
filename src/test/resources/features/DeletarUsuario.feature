#language: pt
Funcionalidade: Deletar um usuário
  Como QA da aplicação
  Quero excluir um usuário de testes
  Para evitar conflitos no banco de dados

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

  Cenario: Dele de dados do usuário bem sucedida
    Dado que eu recupere o CPF do usuário
    Quando eu enviar a requisição com o CPF para o endpoint "/api/v2/coleta/usuario/excluir-usuario"
    Então o status code da resposta deverá ser 204

