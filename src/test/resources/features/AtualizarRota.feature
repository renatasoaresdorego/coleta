#language: pt
Funcionalidade: Atualizar uma rota
  Como administrador da aplicação
  Quero atualizar uma determinada rota
  Para manter o banco de dados com informações congruentes
  Contexto: Cadastro bem-sucedido de uma nova rota
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 1              |
      | nome     | Rota 1         |
      | inicio   | Local A        |
      | fim      | Local B        |
    Quando eu enviar a requisição para criar a rota no endpoint "/api/v2/coleta/rotas/gravar"
    Então o status code da resposta da rota deverá ser 201

  Cenario: Atualização bem-sucedida de uma rota
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 1              |
      | nome     | Rota Atualizada|
      | inicio   | Local C        |
      | fim      | Local D        |
    Quando eu enviar a requisição para atualizar a rota no endpoint "/api/v2/coleta/rotas/atualizar"
    Então o status code da resposta da rota deverá ser 204