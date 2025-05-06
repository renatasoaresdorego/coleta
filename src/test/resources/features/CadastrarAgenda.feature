#language: pt
Funcionalidade: Cadastrar agenda
  Como administrador da aplicação
  Quero cadastrar uma nova agenda
  Para gerenciar as coletas de resíduos

  Contexto: Cadastro bem-sucedido de uma nova rota e ponto de coleta
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 1              |
      | nome     | Rota 1         |
      | inicio   | Local A        |
      | fim      | Local B        |
    Quando eu enviar a requisição para criar a rota no endpoint "/api/v2/coleta/rotas/gravar"
    Então o status code da resposta da rota deverá ser 201

    Dado os dados do ponto de coleta:
      | atributo          | valor              |
      | id                | 1                  |
      | endereco          | Rua A, 123         |
      | capacidadeMaxima  | 100.0              |
      | residuo           | PLASTICO           |
    Quando eu enviar a requisição para cadastrar o ponto de coleta no endpoint "/api/v2/coleta/pontos-de-coleta/cadastrar"
    Então o status code da resposta do ponto de coleta deverá ser 201

  Cenario: Cadastro bem-sucedido de uma nova agenda
    Dado os dados da agenda:
      | atributo          | valor              |
      | rota              | 1                  |
      | pontoDeColeta     | 1                  |
    Quando eu enviar a requisição para cadastrar a agenda no endpoint "/api/v2/coleta/agenda/agendar-coleta"
    Então o status code da resposta da agenda deverá ser 201

  Cenario: Listagem bem-sucedida de agendas
    Quando eu enviar a requisição para listar as agendas no endpoint "/api/v2/coleta/agenda/coletas-agendadas"
    Então o status code da resposta da agenda deverá ser 200

  Cenario: Exclusão bem-sucedida de uma agenda
    Quando eu enviar a requisição para excluir a agenda no endpoint "/api/v2/coleta/agenda/excluir-coleta-agendada/1"
    Então o status code da resposta da exclusão deverá ser 204


  Cenario: Cadastro sem sucesso de uma agenda com dados obrigatórios ausentes
    Dado os dados da agenda:
      | atributo          | valor              |
      | rota              |                    |
      | pontoDeColeta     |                    |
    Quando eu enviar a requisição para cadastrar a agenda no endpoint "/api/v2/coleta/agenda/agendar-coleta"
    Então o status code da resposta da agenda deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{rota=A rota é obrigatória, pontoDeColeta=O ponto de coleta é obrigatório}"

  Cenario: Cadastro sem sucesso de uma agenda já existente
    Dado os dados da agenda:
      | atributo          | valor              |
      | rota              | 1                  |
      | pontoDeColeta     | 1                  |
    Quando eu enviar a requisição para cadastrar a agenda no endpoint "/api/v2/coleta/agenda/agendar-coleta"
    Então o status code da resposta da agenda deverá ser 409
    E o corpo da resposta da agenda deverá retornar a mensagem "{erro=Agenda já existente}"