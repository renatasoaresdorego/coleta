#language: pt
Funcionalidade: Deletar ponto de coleta
  Como administrador da aplicação
  Quero excluir um ponto de coleta
  Para remover locais desativados

  Cenario: Exclusão bem-sucedida de um ponto de coleta
    Quando eu enviar a requisição para deletar o ponto de coleta com id "1" no endpoint "/api/v2/coleta/pontos-de-coleta/excluir"
    Então o status code da resposta do ponto de coleta deverá ser 204