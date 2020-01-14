# Requisitos de testes para aplicações web

## Massa de dados

Uma vez que o alvo do teste seja avaliar determinado comportamento mediante ajuste, configuração ou outro tipo de manipulação de informações, essas devem estar detalhadamente descritas no **Readme** do projeto e disponibilizadas no ambiente de homologação.

Vamos supor que o objetivo de um teste é verificar o comportamento de atualização de um gráfico que é gerado automaticamente uma vez que um fluxo do RapidPro seja associado ao dashboard admimistrativo.  
Nesse caso o fluxo, a associação e o gráfico precisam estar presentes para que o teste seja submetido. Bem como a descrição desses deve constar no **Readme**.  
Isso se deve ao fato que o artefato esperado é unicamente a validação de atualização do gráfico mediante atualização de valores.

## Definição de métodos objetos a serem testados

Os elementos de uma aplicação web afetam diretamente na operação do teste e isso pode ser traduzido em resultados catastróficos.  
Se um teste estiver buscando um botão que sofreu alteração de `<div>`, `<id>` ou `texto` falhas na aplicação serão apontadas porém o *Bug* está no teste.  
Outra situação semelhante é o comportamento de um elemento que carrega junto da requisição de abertura da página e outro que o faz modificando apenas um trexo. Sem essa distinção o teste não saberia se deve esperar a página inteira carregar para poder executar o próximo passo ou se deve apenas procurar por elementos alterados.

Isso será evitado detalhando os elementos estruturais da aplicação, ou seja aqueles que estruturam as requisições e seus respectivos tipos.  
A descrição global desses devem estar no **Readme** e, caso sofram atualizações, no **Changelog**.
