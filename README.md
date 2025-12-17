 # OMDb API Java – Consulta de Filmes e Séries

[![Build](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/seu-usuario/omdb-api-java)
[![Java Version](https://img.shields.io/badge/java-17+-blue)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/license-MIT-yellow)](LICENSE)

API REST em **Java + Spring Boot** para consulta de **filmes, séries e episódios** usando a **OMDb API**.  

---

## **Tabela de Conteúdos**

1. [Funcionalidades](#funcionalidades)  
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)  
3. [Instalação](#instalação)  
4. [Como Rodar](#como-rodar)  
5. [Endpoints da API](#endpoints-da-api)  
   - [Autenticação](#autenticação)  
   - [Pesquisa](#pesquisa)  
   - [Detalhes por ID](#detalhes-por-id)  
   - [Histórico do Usuário](#histórico-do-usuário)  
6. [Exemplo de Fluxo](#exemplo-de-fluxo)  
7. [Observações e Futuras Melhorias](#observações-e-futuras-melhorias)  
8. [Licença](#licença)  

---

## **Funcionalidades**

- Pesquisa por título de filmes, séries ou episódios.  
- Paginação dos resultados (10 itens por página).  
- Consulta detalhada com base no `OmdbId`.  
- Cadastro e autenticação de usuários via JWT.  
- Histórico de pesquisas de usuários autenticados.  

---

## **Tecnologias Utilizadas**

- Java 17+  
- Spring Boot  
- Spring Security com JWT  
- RestTemplate  
- BCrypt para hash de senha  
- Maven  
- OMDb API  

---

## **Instalação**

**Pré-requisitos:**  

- Java 17 ou superior  
- Maven 3.6+  
- IDE (IntelliJ, Eclipse, VSCode)  

**Passo a passo:**  

1. Clone o repositório:  
```bash
git clone https://github.com/seu-usuario/omdb-api-java.git
cd omdb-api-java
Configure sua chave da OMDb API no application.properties:

omdb.api.key=YOUR_OMDB_API_KEY


Instale as dependências:

mvn clean install

Como Rodar

Em ambiente de desenvolvimento:

mvn spring-boot:run


Build e execução:

mvn clean package
java -jar target/omdb-api-java-0.0.1-SNAPSHOT.jar


Variáveis de ambiente necessárias:

OMDB_API_KEY – Chave da OMDb API

Endpoints da API
Autenticação
Método	Endpoint	Descrição	Exemplo
POST	/auth/register	Cria um novo usuário	{ "username": "usuario", "password": "senha123" }
POST	/auth/login	Autentica o usuário e retorna token JWT	{ "username": "usuario", "password": "senha123" }
Pesquisa
Método	Endpoint	Descrição	Exemplo
GET	/search	Pesquisa por título e tipo, retorna resultados paginados	/search?title=Batman&type=series&page=1

Parâmetros:

title – Título do filme, série ou episódio

type – Tipo: movie, series, episode

page – Número da página (padrão: 1)

Detalhes por ID
Método	Endpoint	Descrição	Exemplo
GET	/details/{omdbId}	Consulta detalhada de filme, série ou episódio pelo OmdbId	/details/tt0944947
Histórico do Usuário
Método	Endpoint	Descrição
GET	/history/{user}	Retorna o histórico de pesquisas do usuário autenticado
Exemplo de Fluxo

Cadastro: POST /auth/register

Login: POST /auth/login → recebe token JWT

Pesquisa: GET /search?title=Batman&type=series&page=1

Consulta Detalhada: GET /details/{omdbId}

Histórico: GET /history/{user}

Observações e Futuras Melhorias

Histórico salvo apenas para usuários autenticados.

Paginação padrão: 10 itens por página.

Futuras melhorias planejadas:

Favoritos de usuário

Filtros avançados (gênero, ano, avaliação)

Exportação e limpeza do histórico

Licença

Este projeto está sob a licença MIT – veja o arquivo [LICENSE]
 para detalhes.
