# SchoolJJ back-end

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

Esse é um projeto back-end de um sistema de tarefas escolares, onde professores podem adicionar tarefas, alunos podem mandar sua resposta e etc.


## Instalação


1. Clone o repositório:

```bash
https://github.com/joaolucas6/newsjj-backend.git
```

2. Instale as dependências com maven

## Uso

Execute a aplicação e a API será acessível na seguinte URL: http://localhost:8080

## Endpoints da API

Você pode ver todas as endpoints da aplicação por meio da documentação swagger. Siga a URL abaixo:

```markdown
http://localhost:8080/swagger-ui/index.html
```

## Autenticação

Essa API usa Spring Security para o controle de autenticação. Temos os seguintes cargos:

```
- Administrador
- Professor
- Aluno
```

