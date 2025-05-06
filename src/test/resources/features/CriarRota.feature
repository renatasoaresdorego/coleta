#language: pt
Funcionalidade: Gerenciar rotas
  Como administrador do sistema
  Quero criar, atualizar, listar e excluir rotas
  Para gerenciar as informações de transporte

  Contexto: Cadastro bem-sucedido de uma nova rota
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 1              |
      | nome     | Rota 1         |
      | inicio   | Local A        |
      | fim      | Local B        |
    Quando eu enviar a requisição para criar a rota no endpoint "/api/v2/coleta/rotas/gravar"
    Então o status code da resposta da rota deverá ser 201

  Cenario: Cadastro bem-sucedido de uma nova rota
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 1              |
      | nome     | Rota 1         |
      | inicio   | Local A        |
      | fim      | Local B        |
    Quando eu enviar a requisição para criar a rota no endpoint "/api/v2/coleta/rotas/gravar"
    Então o status code da resposta da rota deverá ser 201

  Cenario: Falha ao cadastrar rota com dados inválidos
    Dado os dados da rota:
      | atributo | valor          |
      | id       |                |
      | nome     |                |
      | inicio   |                |
      | fim      |                |
    Quando eu enviar a requisição para criar a rota no endpoint "/api/v2/coleta/rotas/gravar"
    Então o status code da resposta da rota deverá ser 400

  Cenario: Atualização bem-sucedida de uma rota
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 1              |
      | nome     | Rota Atualizada|
      | inicio   | Local C        |
      | fim      | Local D        |
    Quando eu enviar a requisição para atualizar a rota no endpoint "/api/v2/coleta/rotas/atualizar"
    Então o status code da resposta da rota deverá ser 204

  Cenario: Falha ao atualizar rota inexistente
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 999            |
      | nome     | Rota Inexistente |
      | inicio   | Local X        |
      | fim      | Local Y        |
    Quando eu enviar a requisição para atualizar a rota no endpoint "/api/v2/coleta/rotas/atualizar"
    Então o status code da resposta da rota deverá ser 400

  Cenario: Listagem de rotas
    Quando eu enviar a requisição para listar as rotas no endpoint "/api/v2/coleta/rotas/listar"
    Então o status code da resposta da rota deverá ser 200

  Cenario: Exclusão de dados da rota bem sucedida
    Quando eu enviar a requisição para deletar a rota com id "1" no endpoint "/api/v2/coleta/rotas/excluir"
    Então o status code da resposta da rota deverá ser 204