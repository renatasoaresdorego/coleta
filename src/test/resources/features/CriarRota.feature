#language: pt
Funcionalidade: Gerenciar rotas
  Como administrador do sistema
  Quero criar, atualizar, listar e excluir rotas
  Para gerenciar as informações de transporte

  Cenario: Cadastro bem-sucedido de uma nova rota
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 1              |
      | nome     | Rota 1         |
      | inicio   | Local A        |
      | fim      | Local B        |
    Quando eu enviar a requisição para criar a rota no endpoint "/api/v2/coleta/rotas/gravar"
    Então o status code da resposta da rota deverá ser 201