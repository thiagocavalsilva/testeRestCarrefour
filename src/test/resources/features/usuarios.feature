#language:pt

@usuarios
Funcionalidade: Administracao de usuarios
  O sistema deve possibilitar a criacao, atualizacao e consulta de usuarios.

  Cenario: Criar um novo usuario administrador
    Dado que defino um usuario chamado "Carlos Silva" email "carlos@teste.com" senha "1234" administrador "true"
    Entao o sistema deve retornar codigo 201
    E a mensagem deve indicar "Cadastro realizado com sucesso"

  Cenario: Criar dois usuarios diferentes
    Dado que defino um usuario chamado "Maria Souza" email "maria@teste.com" senha "abcd" administrador "false"
    E tambem cadastro o usuario "Joao Pereira" email "joao@teste.com" senha "efgh" administrador "true"
    Quando consulto todos os usuarios
    Entao o sistema deve retornar codigo 200

  Cenario: Alterar dados de um usuario existente
    Dado que defino um usuario chamado "Ana Paula" email "ana@teste.com" senha "senha123" administrador "false"
    Quando altero suas informacoes para nome "Ana Clara" email "ana@teste.com" senha "novaSenha" administrador "true"
    Entao o sistema deve retornar codigo 200
    E a mensagem deve indicar "Registro alterado com sucesso"
