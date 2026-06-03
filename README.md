# Agi Blog - UI Test Automation

![CI](https://github.com/nathfernandes/web-automation/actions/workflows/ui-tests.yml/badge.svg)
[![Allure Report](https://img.shields.io/badge/View-Allure_Report-ff6f00)](https://nathfernandes.github.io/web-automation/)

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Selenium](https://img.shields.io/badge/Selenium-Automation-green.svg)
![Allure Report](https://img.shields.io/badge/Allure-Reports-orange.svg) 

Projeto de automação web com Selenium + JUnit 5 + Allure + GitHub Actions, para o Agi Blog.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Selenium WebDriver
- JUnit 5
- AssertJ
- Maven
- Allure Reports
- GitHub Actions (CI)
- GitHub Pages (publicação de report)

---

## 📦 Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

- Java 17+
- Maven 3.8+
- Google Chrome (ou Firefox, se configurado)
- Git

---

## 🧪 Rodar testes localmente

```bash
mvn clean test
```

---

## 🧠 Rodar testes em modo headless
```bash
mvn clean test -Dheadless=true
```

---

## 📊 Gerar relatório Allure
Após executar os testes:
```bash
mvn allure:serve
```
Isso irá gerar e abrir automaticamente o relatório no navegador.

---

## 🤖 CI - GitHub Actions

Os testes são executados automaticamente via GitHub Actions sempre que há:

- push na branch `main`
- pull requests
- execução manual via `workflow_dispatch`

### 🔗 Workflow

https://github.com/nathfernandes/web-automation/actions/

---

## 🌐 Allure Report (GitHub Pages)

O relatório é publicado automaticamente após cada execução do CI.

### 🔗 Acesso ao report

https://nathfernandes.github.io/web-automation/

---

## 📁 Estrutura do projeto

```
src
 ├── test
 │    ├── java
 │    │    ├── com.nathalia.qa
 │    │    │    ├── base
 │    │    │    ├── components
 │    │    │    ├── constants
 │    │    │    ├── pages
 │    │    │    ├── tests
 │    │    │    ├── utils
```

---

## 🧪 Pipeline CI/CD

Fluxo automático:

1. Push na branch main
2. GitHub Actions executa testes
3. Allure report é gerado
4. Report é publicado no GitHub Pages

---

## 📌 Boas práticas adotadas

- Page Object Model
- Waits explícitos para evitar flakiness
- Execução headless em CI
- Separação de responsabilidades (pages, utils, tests)
- Allure para relatórios de debug

---

## 👤 Autor

Projeto desenvolvido por **Nathalia Fernandes**



