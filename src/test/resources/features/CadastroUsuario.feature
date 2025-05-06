#language: pt
Funcionalidade: Cadastrar um usuário
  Como um novo usuário
  Quero cadastrar os meus dados pessoais
  Para utilizar a aplicação

  Cenario: Cadastro bem-sucedido de um novo usuário
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |878.569.480-84    |
      |nome     |user7             |
      |telefone |41998875665       |
      |email    |user7@email.com   |
      |senha    |123456            |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 201

  Cenario: Cadastro sem sucesso de um novo usuário com cpf inválido
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |123.456.789       |
      |nome     |userInvalido      |
      |telefone |41888877665       |
      |email    |invalido@email.com|
      |senha    |123456            |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{cpf=CPF inválido}"

  Cenario: Cadastro sem sucesso de um novo usuário com nome vazio
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |877.569.480-84    |
      |nome     |                  |
      |telefone |41998877665       |
      |email    |user@email.com    |
      |senha    |123456            |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{nome=O nome do morador é obrigatório.}"

  Cenario: Cadastro sem sucesso de um novo usuário com telefone inválido
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |877.569.480-84    |
      |nome     |user              |
      |telefone |12345             |
      |email    |user@email.com    |
      |senha    |123456            |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{telefone=Informe o telefone com o DDD.}"

  Cenario: Cadastro sem sucesso de um novo usuário com email inválido
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |877.569.480-84    |
      |nome     |user              |
      |telefone |41998877665       |
      |email    |email_invalido    |
      |senha    |123456            |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{email=O formato do email é inválido.}"

  Cenario: Cadastro sem sucesso de um novo usuário com senha fora do tamanho permitido
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |877.569.480-84    |
      |nome     |user              |
      |telefone |41998877665       |
      |email    |user@email.com    |
      |senha    |123               |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{senha=A senha deve conter entre 6 e 8 dígitos}"

  Cenario: Cadastro sem sucesso de um novo usuário com senha vazia
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |877.569.480-84    |
      |nome     |user              |
      |telefone |41998877665       |
      |email    |user@email.com    |
      |senha    |                  |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{senha=A senha é obrigatória.}"

  Cenario: Cadastro sem sucesso de um novo usuário com CPF em branco
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |                  |
      |nome     |user              |
      |telefone |41998877665       |
      |email    |user@email.com    |
      |senha    |123456            |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{cpf=O campo 'cpf' é obrigatório}"


  Cenario: Cadastro sem sucesso de um novo usuário com nome em branco
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |877.569.480-84    |
      |nome     |                  |
      |telefone |41998877665       |
      |email    |user@email.com    |
      |senha    |123456            |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{nome=O nome do morador é obrigatório.}"

  Cenario: Cadastro sem sucesso de um novo usuário com telefone em branco
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |877.569.480-84    |
      |nome     |user              |
      |telefone |                  |
      |email    |user@email.com    |
      |senha    |123456            |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{telefone=O telefone é obrigatório.}"

  Cenario: Cadastro sem sucesso de um novo usuário com email em branco
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |877.569.480-84    |
      |nome     |user              |
      |telefone |41998877665       |
      |email    |                  |
      |senha    |123456            |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{email=O email é obrigatório.}"

  Cenario: Cadastro sem sucesso de um novo usuário com senha em branco
    Dado os meus dados pessoais:
      |atributo |valor             |
      |cpf      |877.569.480-84    |
      |nome     |user              |
      |telefone |41998877665       |
      |email    |user@email.com    |
      |senha    |                  |
    Quando eu enviar a requisição para o endpoint "/api/v2/coleta/usuario/cadastro"
    Então o status code da resposta deverá ser 400
    E o corpo da resposta deverá retornar a mensagem "{senha=A senha é obrigatória.}"
