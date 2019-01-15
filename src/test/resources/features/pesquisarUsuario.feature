#language: pt
Funcionalidade: Permitir pesquisar usuário na tela de cadastro de usuário

  Contexto: Dado que estou na pagina "http://192.168.0.107/POCJavaJavaEnvironment/servlet/com.pocjava.login"
    Quando eu informar "Filipe" no campo "vUSUARIOLOGIN"
    E informar "1234" no campo "vUSUARIOSENHA"
    E cliar no botão "BTNLOGIN"

  @exec
  Cenário: Validação de tela de pesquisa de usuário
    Dado que seja exibida a mensagem "Bem vindo Filipe Ferreira de Jesus" no campo "BOASVINDAS_MPAGE"
    Quando eu clicar no menu "Cadastro de usuário"
    Então deve exibir uma grid "com os usuários cadastrados"
    E dentro da grid o "usuário"

  @exec
  Esquema do Cenário: Realizar pesquisa de usuário
    Dado que estou na tela de "Cadastro de usuário"
    Quando eu informar <usuario> no campo "nome"
    Então deve exibir <linhadousuario> no item da "grid"

    Exemplos: 
      | usuario  | linhadousuario |
      | "Filipe" | "linha"        |
      | "toller" | "linha"        |

  @exec
  Esquema do Cenário: Realizar pesquisa de usuário inválido
    Dado que estou na tela de "Cadastro de usuário"
    Quando eu informar <usuario> no campo "nome"
    Então deve exibir "nenhum" no item da "grid"

    Exemplos: 
      | usuario |
      | "Teste" |
      | "oi"    |
