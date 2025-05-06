#language: pt
Funcionalidade: Cadastrar caminhão
  Como administrador da aplicação
  Quero cadastrar um novo caminhão
  Para gerenciar os veículos de coleta

  Contexto: Cadastro bem-sucedido de uma nova rota
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 1              |
      | nome     | Rota 1         |
      | inicio   | Local A        |
      | fim      | Local B        |
    Quando eu enviar a requisição para criar a rota no endpoint "/api/v2/coleta/rotas/gravar"
    Então o status code da resposta da rota deverá ser 201

  Cenario: Cadastro bem-sucedido de um novo caminhão
    Dado os dados do caminhão:
      | atributo         | valor          |
      | id               | 1              |
      | rota             | 1              |
      | capacidade       | 1000           |
      | placa            | ABC-1234       |
      | statusServico    | true           |
    Quando eu enviar a requisição para cadastrar o caminhão no endpoint "/api/v2/coleta/caminhoes/cadastrar-caminhao"
    Então o status code da resposta do caminhão deverá ser 201