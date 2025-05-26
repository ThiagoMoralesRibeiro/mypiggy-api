# 🐷 MyPiggy API

**MyPiggy** é uma API REST desenvolvida em Java com Spring Boot, com o objetivo de ajudar usuários a gerenciar suas finanças pessoais, como contas, categorias, transações e cofrinhos.

## 📦 Funcionalidades

- Cadastro, listagem, atualização e remoção de usuários
- Autenticação de usuários com hash de senha
- Gerenciamento de categorias (ex: Alimentação, Transporte)
- Controle de transações
- Manipulação de cofrinhos (objetivos de economia)
- Validações com Bean Validation (JSR-380)
- DTOs para entrada/saída de dados
- Mapeamento entre entidades e modelos com ModelMapper

## 🛠️ Tecnologias e Ferramentas

- Java 17
- Spring Boot 3.4.x
- Hibernate / JPA
- H2 / PostgreSQL
- ModelMapper
- Hibernate Validator
- Lombok
- Jakarta Validation
- Swagger (opcional)
- Spring DevTools

## 🗂️ Estrutura do Projeto (DDD)

```
mypiggy/
├── application/
├── domain/
│ └── model/
├── infrastructure/
│ └── persistence/
├── interfaces/
│ └── web/
│ └── dto/
├── config/
└── MyPiggyApplication.java
```


## ⚙️ Como executar

1. **Clone o repositório**

```bash
git clone https://github.com/seu-usuario/mypiggy.git
cd mypiggy
```

2. **Execute o projeto**

```bash
./mvnw spring-boot:run
```

3. **Acesse**

```bash
http://localhost:8080
```

🧪 Exemplo de Payload
📥 Criar usuário

**POST /api/users**
```
{
  "name": "João Silva",
  "email": "joao@email.com",
  "password": "12345678",
  "birthDate": "1990-01-01",
  "phoneNumber": "+5511999999999",
  "cpf": "123.456.789-00",
  "cep": "01234-567"
}
```

📥 Criar categoria

**POST /api/categories**
```
{
  "name": "Transporte",
  "description": "Gastos com transporte"
}
```

🚧 Em desenvolvimento

Funcionalidades futuras:

    Autenticação com JWT

    Dashboard de finanças

    Integração com bancos

👨‍💻 Autor

Thiago Morales Ribeiro
GitHub
Projeto criado para fins de estudo e aprimoramento profissional na área de backend e DevOps.
