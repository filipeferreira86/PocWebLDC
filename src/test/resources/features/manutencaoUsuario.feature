#language: pt
Funcionalidade: Permitir manutenção de usuário no sistema de gestão de usuários

  Contexto: Dado que estou na pagina "http://192.168.0.107/POCJavaJavaEnvironment/servlet/com.pocjava.login"
    Quando eu informar "Filipe" no campo "vUSUARIOLOGIN"
    E informar "1234" no campo "vUSUARIOSENHA"
    E cliar no botão "BTNLOGIN"
    E que seja exibida a mensagem "Bem vindo Filipe Ferreira de Jesus" no campo "BOASVINDAS_MPAGE"
    E eu clicar no menu "Cadastro de usuário"

	@man
  Esquema do Cenário: Validação de tela de cadastro de usuário
    Dado que estou na tela de cadastro usuário
    Quando eu clicar no <elemento>
    Então deve exibir texto "Nome"
    E campo "referente ao nome"
    E deve exibir texto "login" no item
    E campo "referente ao login"
    E deve exibir texto "Senha" no item
    E campo "referente ao senha"
    E deve exibir texto "Ativo" no item
    E campo "referente ao ativo"

    Exemplos: 
      | elemento            |
      | "item no grid"      |
      | "Botão de inclusão" |

	@man
  Esquema do Cenário: Validação de mensagens de erro na inclusão de usuário
    Dado que estou na tela de cadastro usuário

	@man
  Cenário: Inclusão de novo usuário
    Dado 

	@man
  Esquema do Cenário: Validação de mensagens de erro na alteração de usuário
    Dado 

	@man
  Esquema do Cenário: Alteração de usuário
    Dado 
