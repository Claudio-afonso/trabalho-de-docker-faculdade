# Trabalho Prático – Ciclo 01 (Sistemas Distribuídos)

Aluno: Claudio Junior

Este projeto entrega um **frontend simples com tela de login** e um **backend em Java Spring Boot** que valida credenciais **estáticas**, conforme o enunciado do Ciclo 01 (sem banco de dados).

## Tecnologias
- Backend: Java 17, Spring Boot 3 (Web, Validation), Maven
- Frontend: HTML, CSS, JavaScript (Fetch API)

## Como executar

### 1) Backend (porta 8080)
Pré‑requisitos: Java 17+ e Maven instalados.

pegar o diretório da pasta backend e rodar o comando cd C:\Users\claudio\Desktop\Trabalho-docker

```bash
cd backend
mvn spring-boot:run
```
O endpoint ficará disponível em: `POST http://localhost:8080/login`

**Credenciais válidas (fixas):**
- usuário: `admin`
- senha: `123456`

### 2) Frontend
Abra o arquivo `frontend/index.html` no navegador (basta dar duplo‑clique).  
A tela fará requisições para `http://localhost:8080/login`.

## Testes manuais
- Informe as credenciais válidas para receber **200 OK** e mensagem de sucesso.
- Informe credenciais inválidas para receber **401 Unauthorized**.
- Envie campos vazios para receber **400 Bad Request** devido à validação.

## Estrutura de pastas
```
SD_C1_Dupla_Nome1_Nome2/
├─ README.md
├─ frontend/
│  └─ index.html
└─ backend/
   ├─ pom.xml
   └─ src/
      ├─ main/java/com/example/login/
      │  ├─ Application.java
      │  ├─ AuthController.java
      │  └─ LoginRequest.java
      └─ main/resources/application.properties
```

## Observações
- Não há banco de dados.
- CORS liberado no backend para facilitar execução local do HTML estático.
- Caso deseje alterar as credenciais fixas, edite `AuthController.java`.
