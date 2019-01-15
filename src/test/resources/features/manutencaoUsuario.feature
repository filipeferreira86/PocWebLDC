#language: pt
Funcionalidade: Permitir manutenção de usuário no sistema de gestão de usuários

  Contexto: Dado que estou na pagina "http://192.168.0.107:8080/POCJavaJavaEnvironment/servlet/com.pocjava.login"
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
      | elemento       |
      | "item no grid" |
      | "BTNINSERT"    |

  @man
  Esquema do Cenário: Validação de mensagens de erro na inclusão de usuário
    Dado que estou no formulario de "BTNINSERT"
    Quando eu informar "Teste" no campo "USUARIOLOGIN"
    E informar "Teste" no campo "USUARIONOME"
    E informar "Teste" no campo "USUARIOSENHA"
    E limpar campo <campolimpo>
    E clicar no botão "BTN_ENTER"
    Então deve exibir mensagem <mensagem> no campo <alerta>

    Exemplos: 
      | campolimpo     | mensagem                                       | alerta                 |
      | "USUARIOLOGIN" | "O campo Login é obrigatório. Favor informar." | "USUARIOLOGIN_Balloon" |
      | "USUARIONOME"  | "O campo Nome é obrigatório. Favor informar."  | "USUARIONOME_Balloon"  |
      | "USUARIOSENHA" | "O campo Senha é obrigatório. Favor informar." | "USUARIOSENHA_Balloon" |

  @man
  Cenário: Inclusão de novo usuário
    Dado que estou no formulario de "BTNINSERT"
    Quando eu informar "Teste" no campo "USUARIOLOGIN"
    E informar "Teste" no campo "USUARIONOME"
    E informar "Teste" no campo "USUARIOSENHA"
    E clicar no botão "BTN_ENTER"
    Então deve exibir uma grid "GridContainerTbl"
    E dentro da "GridContainerTbl" o "Teste"

  @man
  Esquema do Cenário: Validação de mensagens de erro na alteração de usuário
    Dado que estou no formulario de "BTNINSERT"
    Quando limpar campo <campolimpo>
    E clicar no botão "BTN_ENTER"
    Então deve exibir mensagem <mensagem> no campo <alerta>

    Exemplos: 
      | campolimpo     | mensagem                                       | alerta                 |
      | "USUARIOLOGIN" | "O campo Login é obrigatório. Favor informar." | "USUARIOLOGIN_Balloon" |
      | "USUARIONOME"  | "O campo Nome é obrigatório. Favor informar."  | "USUARIONOME_Balloon"  |
      | "USUARIOSENHA" | "O campo Senha é obrigatório. Favor informar." | "USUARIOSENHA_Balloon" |

  @man
  Cenário: Alteração de usuário
    Dado que estou no formulario de "span_vUPDATE_0001"
    Quando eu informar "Teste1" no campo "USUARIOLOGIN"
    E informar "Teste1" no campo "USUARIONOME"
    E informar "Teste1" no campo "USUARIOSENHA"
    E clicar no botão "BTN_ENTER"
    Então deve exibir uma grid "GridContainerTbl"
    E dentro da "GridContainerTbl" o "Teste1"
