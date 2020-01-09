# Conteúdo envolvido do estudo da ferramenta Selenium para desenvolvimento de testes

## Preparando o ambiente

`$ git init`
`$ npm init -y`

### Instalando lint

`$ npm install eslint --save-dev` *Instalar apenas em ambiente de desenvolvimento (Não irá para produção).*
`$ .\node_modules\.bin\eslint --init` *Iniciar o eslint.*

### Usando lint

`$ .\node_modules\.bin\eslint "fine_name.ext"` *Pode ser adicionado --fix para correções mais simples serem aplicadas automaticamente.*

## Estrutura da área

### Pirâmide de testes

Onde a Qualidade irá atacar e onde deverá apenas observar.

![TestsPyramid](img/TestsPyramid.jpg)

#### Proporção dos testes de uma aplicação

Enquanto os testes funcionais são os mais completos e mais próximos da forma como o usuário irá utilizar a aplicação também ocupam a menor proporção da piramid. Isso se deve aos custos envolvidos nessa camada de testes.

No intervalo de alguns segundos que uma suite de 10k testes uniários é executada apenas um único teste funcional seria completado.

Os custos de manutenção de testes funcionais também são elevados pois geralmente é a interface mudanças que sofre com a maioria das alterações. Bem como identificação dos problemas, enquanto o teste unitário foca exclusivamente na lógica, toda essa complexidade do ambiente do teste funcional torna o teste muito instável (problema com massa de dados, browser, rede, serviço fora do ar) e difícil de isolar um problema.

A cobertura dos vários cenários possíveis para uma funcionalidade também é um fator que eleva o peso dos testes funcionais, onde cobrir todas as possibilidades é uma tarefa quase impossível.

#### Testes unitários

Onde os testes de código se dividem em porções mínimas, geralmente em granularidade de métodos.
Difícilmente os códigos estarão completamente isolados, então são utilizados mooks para isolar o código que precisa ser testado de suas dependências (acesso ao BD, etc).

##### Exemplo de código

```js
// Código do módulo de login
public boolean verificarCredencial(String username, String passwd) {
  Usuario usuario = dao.getUsuarioByUsername(username);
  if(usuario != null) {
    return passwd.equals(usuario.getSenha());
  } else {
    throw new Exception("Usuário inexistente!");
  }
}

// Código do teste
@Test
public void testeVerificarCredencial() {
  //cenário
  Usuario usuarioMock = new Usuario("Tales", "123456");
  when(dao.getUsuarioByUsername("Tales")).thenReturn(usuarioMock);

  // Execução
  boolean logado = service.verificarCredencial("Tales", "123456");

  // Validação
  Assert.assertTrue(logado);
}
```

#### Testes de integração

Integra os módulos de cada código com a intenção de testes mais amplos, normalmente desde o serviço (webservice, etc).

##### Exemplo de serviço

> Todos os dados e serviços do respectivo conjunto de módulos em teste devem estar ativos e operacionais. Lembrando que o ambiente ainda não é o de produção.

![ExemploIntegracao](img/exemploIntegracao001.png)

#### Testes funcionais

Verificações dos componentes externos e testes sob a visão do usuário.

##### Exemplo de testes

> Apesar da funcionalidade ser a mesma, a abordagem do teste muda completamente. Ao invés de observar o código da aplicação ou acessar algum serviço, a aplicação é avaliada do ponto de vista comportamental. Aqui o ambiente também não é o de produção.

![ExemploFuncional](img/exemploFuncional001.png)
