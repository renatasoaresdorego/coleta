#language: pt
Funcionalidade: Listar pontos de coleta
  Como usuário da aplicação
  Quero listar os pontos de coleta disponíveis
  Para entender a capacidade de coleta

  Cenario: Listagem de pontos de coleta
    Quando eu enviar a requisição para listar os pontos de coleta no endpoint "/api/v2/coleta/pontos-de-coleta/listar"
    Então o status code da resposta do ponto de coleta deverá ser 200