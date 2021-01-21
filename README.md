<h1 align="center">Bankrupt  - Tapps Games</h1>
<p align="center">Projeto de resolução de desafio proposto em candidatura para vaga de emprego</p>

<!--ts-->
* [Sobre](#Sobre)
* [Instalação](#instalacao)
* [Tests](#testes)
<!--te-->

## Sobre

O projeto consta de um desafio de desenvolver um jogo no estilo de um Banco Imobiliario simplificado. Além disso o projeto simula
um total de 300 partidas seguidas e da estatísticas analisando o resultado e desempenho de diferentes jogadores de acordo com seu comportamento.

## Instalação

  ````
  #Clonar o repositorio
  $git clone https://github.com/Dechechi/tapps-bankrupt.git
  
  #Instale as dependencias do maven
  mvn clean install
  
  #Executar o jar
  java -jar target\tapps-bankrupt-1.0.0-SNAPSHOT.jar
  
  Importante notar que o arquivo "gameConfig.txt" deve estar na raiz da aplicação
  ````

## Testes
Ao executar o jar da aplicação é possivel identificar a saida principal do projeto que atende aos requisitos propostos pelo desafio.

Caso queira executar testes alternativos, dentro da classe game.round é posivel rodar um método Estático que printa logs com informações de cada passo dos jogadores.

Além disso, o arquivo gameConfig pode ser incrementado a vontade para a criação de um tabuleiro mais extenso, bem como os parametros utilizados na execução são facilmente identificados nas classes Game e Round, junto com comentarios para auxilio.