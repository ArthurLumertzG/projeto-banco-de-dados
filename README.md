# 🐾 Sistema de Gerenciamento de Clínica Veterinária

Projeto final da disciplina **Gerenciamento de Dados I**, com foco em modelagem de banco de dados relacional e integração com uma aplicação Java.

## 📌 Descrição

Este sistema foi desenvolvido para simular o funcionamento de uma clínica veterinária, permitindo o gerenciamento de:

- Clínicas (com endereços e CNPJ)
- Veterinários e auxiliares
- Tutores e seus pets
- Consultas clínicas
- Recibos financeiros vinculados às consultas

O sistema suporta operações completas de cadastro (CRUD) e consultas complexas com **JDBC** conectado ao **PostgreSQL**.

## 📂 Estrutura do Projeto

```
src/
├── model/           # Classes que representam as entidades do banco
├── dao/             # Classes de acesso aos dados (CRUD + consultas)
├── util/            # Utilitários de conexão
└── app/             # Main.java para execução e testes
```

## 🛠️ Tecnologias Utilizadas

- Java 17+
- PostgreSQL
- JDBC
- SQL (DDL e DML)
- pgAdmin / DBeaver (para testes de banco)

## 📄 Funcionalidades

- Inserção, atualização, exclusão e listagem de registros em todas as tabelas.
- Execução de consultas SQL complexas como:
  - Histórico clínico de um pet
  - Faturamento mensal por recibos
  - Veterinários com mais atendimentos

## ▶️ Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```

2. Configure o banco PostgreSQL usando o script `script_ddl.sql`.

3. Compile e execute o projeto:
   ```bash
   javac Main.java
   java Main
   ```

4. Verifique as saídas e os dados sendo manipulados no banco.

## 👨‍💻 Desenvolvedores

- Arthur Lumertz Guimarães (@ArthurLumertzG)
- Carlos Miguel Webber (@ckzwebber)

---

Este projeto foi realizado com fins acadêmicos, integrando conceitos práticos de banco de dados e programação orientada a objetos.
