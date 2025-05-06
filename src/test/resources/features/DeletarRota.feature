#language: pt
Funcionalidade: Deletar uma rota
  Como QA da aplicação
  Quero excluir uma rota de testes
  Para evitar conflitos no banco de dados

  Contexto: Cadastro bem-sucedido de uma nova rota
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 1              |
      | nome     | Rota 1         |
      | inicio   | Local A        |
      | fim      | Local B        |
    Quando eu enviar a requisição para criar a rota no endpoint "/api/v2/coleta/rotas/gravar"
    Então o status code da resposta da rota deverá ser 201

  Cenario: Exclusão de dados da rota bem sucedida
    Quando eu enviar a requisição para deletar a rota com id "1" no endpoint "/api/v2/coleta/rotas/excluir"
    Então o status code da resposta da rota deverá ser 204