#language: pt
Funcionalidade: Listar rotas
  Como usuário da aplicação
  Quero listar as rotas disponíveis
  Para entender a logistica da coleta.

  Contexto: Cadastro bem-sucedido de uma nova rota
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 1              |
      | nome     | Rota 1         |
      | inicio   | Local A        |
      | fim      | Local B        |
    Quando eu enviar a requisição para criar a rota no endpoint "/api/v2/coleta/rotas/gravar"
    Então o status code da resposta da rota deverá ser 201

  Cenario: Listagem de rotas
    Quando eu enviar a requisição para listar as rotas no endpoint "/api/v2/coleta/rotas/listar"
    Então o status code da resposta da rota deverá ser 200