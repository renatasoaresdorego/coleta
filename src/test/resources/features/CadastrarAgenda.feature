#language: pt
Funcionalidade: Cadastrar agenda
  Como administrador da aplicação
  Quero cadastrar uma nova agenda
  Para gerenciar as coletas de resíduos

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


  Cenario: Cadastro sem sucesso de uma agenda com rota inexistente
    Dado os dados da agenda:
      | atributo          | valor              |
      | rota              | 999                |
      | pontoDeColeta     | 1                  |
    Quando eu enviar a requisição para cadastrar a agenda no endpoint "/api/v2/coleta/agenda/agendar-coleta"
    Então o status code da resposta da agenda deverá ser 400

  Cenario: Cadastro sem sucesso de uma agenda com ponto de coleta inexistente
    Dado os dados da agenda:
      | atributo          | valor              |
      | rota              | 1                  |
      | pontoDeColeta     | 999                |
    Quando eu enviar a requisição para cadastrar a agenda no endpoint "/api/v2/coleta/agenda/agendar-coleta"
    Então o status code da resposta da agenda deverá ser 400

  Cenario: Cadastro sem sucesso de uma agenda com dados obrigatórios ausentes
    Dado os dados da agenda:
      | atributo          | valor              |
      | rota              |                    |
      | pontoDeColeta     |                    |
    Quando eu enviar a requisição para cadastrar a agenda no endpoint "/api/v2/coleta/agenda/agendar-coleta"
    Então o status code da resposta da agenda deverá ser 400