# Animex

## Descrição

Animex é uma aplicação backend desenvolvida em Java/Spring Boot para gerenciamento de animes e usuários. O sistema permite o cadastro, autenticação e autorização de usuários, além do gerenciamento de uma biblioteca de animes com diferentes gêneros.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.13**
  - Spring Web (RESTful APIs)
  - Spring Data JPA (Persistência de dados)
  - Spring Security (Autenticação e Autorização)
  - Spring Validation (Validação de dados)
  - Spring Boot DevTools (Desenvolvimento)
- **PostgreSQL** (Banco de dados relacional)
- **JJWT 0.12.5** (JSON Web Tokens para autenticação)
- **Lombok** (Redução de boilerplate)
- **Maven** (Gerenciamento de dependências)

## Estrutura do Projeto

```
src/main/java/com/patrick/animex/
├── config/              # Configurações do Spring (Security, etc.)
├── controller/          # Controladores REST
│   ├── AnimeController.java
│   ├── AuthController.java
│   └── UsuarioController.java
├── dto/                 # Data Transfer Objects
│   ├── request/         # DTOs de requisição
│   └── response/        # DTOs de resposta
├── entity/              # Entidades JPA
│   ├── enums/           # Enumeradores
│   └── *.java           # Classes de entidade
├── repository/          # Interfaces JPA Repository
└── exception/           # Tratamento de exceções
```

## Funcionalidades

### Autenticação e Usuários
- **Registro de usuários** (`POST /api/auth/register`)
- **Login** (`POST /api/auth/login`) - Retorna JWT token
- **Autenticação baseada em JWT**
- **Roles**: USER, ADMIN

### Animes
- **Listar animes** (`GET /api/animes`)
- **Buscar anime por ID** (`GET /api/animes/{id}`)
- **Criar novo anime** (`POST /api/animes`) - Requer autenticação
- **Atualizar anime** (`PUT /api/animes/{id}`) - Requer autenticação
- **Deletar anime** (`DELETE /api/animes/{id}`) - Requer autenticação

## Pré-requisitos

- Java 21 ou superior
- Maven 3.6+
- PostgreSQL (Docker recomendado)

## Configuração

1. Clone o repositório:
```bash
git clone <url-do-repositorio>
cd Animex
```

2. Configure o banco de dados PostgreSQL. Você pode usar Docker:
```bash
docker run -d \
  --name postgres-animex \
  -e POSTGRES_DB=animex \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  postgres:15
```

3. Atualize as credenciais do banco em `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/animex
spring.datasource.username=postgres
spring.datasource.password=postgres
```

## Execução

### Modo de Desenvolvimento

```bash
./mvnw spring-boot:run
```

Ou usando Maven wrapper:

```bash
mvn spring-boot:run
```

### Build

```bash
./mvnw clean package
```

A aplicação estará disponível em `http://localhost:8080`

## Endpoints da API

### Autenticação

#### POST /api/auth/register
Registra um novo usuário
```json
{
  "username": "string",
  "password": "string",
  "email": "string"
}
```

#### POST /api/auth/login
Realiza login e retorna token JWT
```json
{
  "username": "string",
  "password": "string"
}
```

### Animes

Todos os endpoints de animes requerem autenticação via Bearer Token.

#### GET /api/animes
Lista todos os animes

#### GET /api/animes/{id}
Busca anime por ID

#### POST /api/animes
Cria um novo anime
```json
{
  "nome": "string",
  "descricao": "string",
  "genero": "ACAO|COMEDIA|DRAMA|FANTASIA|ROMANCE|TERROR|SCI_FI",
  "ano": integer
}
```

#### PUT /api/animes/{id}
Atualiza um anime existente

#### DELETE /api/animes/{id}
Remove um anime

## Testes

Execute os testes com:
```bash
./mvnw test
```

## Segurança

- Autenticação via JWT (JSON Web Tokens)
- Senhas armazenadas com BCrypt
- Proteção contra ataques CSRF
- Validação de dados de entrada

## Banco de Dados

Entidades:
- **Usuario**: Armazena informações de usuários e credenciais
- **Anime**: Catálogo de animes
- **Favorito**: Relacionamento entre usuários e animes favoritos

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Add: MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## Contato

Projeto desenvolvido como parte de estudos em desenvolvimento backend com Spring Boot.