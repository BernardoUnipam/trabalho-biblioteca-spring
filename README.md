# 📚 Sistema de Gerenciamento de Biblioteca (API REST)

Trabalho prático desenvolvido para a disciplina de **Desenvolvimento Web II** (5º Período - Sistemas de Informação). O objetivo do projeto é desenvolver o módulo de persistência, consulta e gerenciamento de uma biblioteca utilizando o ecossistema Spring.

---

## 📌 Contexto e Status do Projeto

O sistema permite o cadastro de Livros e sua organização por Categorias, sendo que um livro deve obrigatoriamente pertencer a uma categoria (Relacionamento 1:N). O desenvolvimento foi dividido em duas etapas:

- [x] **Etapa 1: Estrutura e Mapeamento** (Concluída)
- [ ] **Etapa 2: Consultas e Testes** (Pendente - Prazo: 10/06 a 11/06)

---

## ✅ Etapa 1: Requisitos e Soluções Implementadas

Abaixo está o detalhamento de como cada exigência do escopo do projeto foi atendida na construção do código-fonte:

### 1. Configuração do Banco de Dados
> **Regra:** *Arquivo application.yml ou application.properties configurado para usar o banco de dados H2 (em memória) com o console ativo.*

**Solução:** Optou-se pelo uso do `application.yml` pela legibilidade. A configuração de datasource aponta para `jdbc:h2:mem:bibliotecadb` e o console foi habilitado no path `/h2-console`.
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:bibliotecadb
    driverClassName: org.h2.Driver
    username: sa
    password: 
  h2:
    console:
      enabled: true
      path: /h2-console
```

## 2. Mapeamento de Entidades (Models) e Anotações JPA

### Regra
Criar `Categoria` (`id`, `nome`) e `Livro` (`id`, `titulo`, `isbn` e relacionamento com `Categoria`).  
Uso correto das anotações:

- `@Entity`
- `@Id`
- `@GeneratedValue`
- `@Column`
- `@ManyToOne`

### Solução
As classes foram criadas no pacote `models`.

As tabelas foram nomeadas explicitamente utilizando:

```java
@Table(name = "tb_categoria")
@Table(name = "tb_livro")
```

A chave primária `id` utiliza:

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

O relacionamento `1:N` foi estabelecido na classe `Livro` com a anotação `@ManyToOne`, vinculando à chave estrangeira `categoria_id`:

```java
@ManyToOne
@JoinColumn(name = "categoria_id", nullable = false)
private Categoria categoria;
```

## 3. Repositórios

### Regra
Criar as interfaces `CategoriaRepository` e `LivroRepository` estendendo `JpaRepository`.

### Solução
As interfaces foram criadas no pacote `repositories`, recebendo as tipagens da Entidade e do Tipo do ID.

Exemplo:

```java
JpaRepository<Livro, Long>
```

Dessa forma, os métodos de persistência são disponibilizados automaticamente pelo Spring Data JPA.

---

# 🚀 Como Executar o Projeto e Validar o Critério de Sucesso

O critério de sucesso da Etapa 1 exige que a aplicação inicie sem erros e que as tabelas `tb_livro` e `tb_categoria` apareçam corretamente no console do H2.

## 1. Clonar o Repositório

```bash
git clone https://github.com/SeuUsuario/trabalho-biblioteca-spring.git
```

---

## 2. Executar a Aplicação

### Via IDE
Execute a classe:

```java
BibliotecaApplication.java
```

### Via Terminal

```bash
./mvnw spring-boot:run
```

---

## 3. Acessar o Console H2

Abra o navegador e acesse:

```text
http://localhost:8080/h2-console
```

---

## 4. Preencher as Credenciais de Acesso

| Campo | Valor |
|---|---|
| Driver Class | `org.h2.Driver` |
| JDBC URL | `jdbc:h2:mem:bibliotecadb` |
| User Name | `sa` |
| Password | *(deixe em branco)* |

> ⚠️ Atenção: altere o valor padrão do H2 para `jdbc:h2:mem:bibliotecadb`.

---

## ✅ Validação Final

Clique em **Connect**.

No menu lateral esquerdo do console H2, as tabelas:

- `TB_CATEGORIA`
- `TB_LIVRO`

estarão visíveis e prontas para receber dados.

---

**Desenvolvido por Bernardo Willian**