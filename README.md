💱 Currency Converter Service | Java Backend
Este projeto consiste em um microsserviço de conversão de câmbio em tempo real, desenvolvido para demonstrar boas práticas de consumo de APIs REST, manipulação de dados JSON e arquitetura desacoplada utilizando Java 11+.

🚀 Funcionalidades
Consumo Dinâmico: Integração direta com a ExchangeRate-API.

Processamento de Dados: Parsing eficiente de respostas JSON complexas utilizando a biblioteca GSON.

Interface via CLI: Entrada de dados parametrizada via terminal para conversões rápidas.

Arquitetura em Camadas: Divisão clara entre modelos de dados (model) e lógica de negócio/comunicação (service).

🛠 Stack Tecnológica
Linguagem: Java 11 (utilizando HttpClient nativo).

Gerenciador de Dependências: Maven.

JSON Library: Google GSON 2.10.1.

API Externa: ExchangeRate-API.

📦 Configuração e Instalação
1. Requisitos Próximos
JDK 11 ou superior.

Maven 3.6+.

2. Dependências (Maven)
Certifique-se de que o seu pom.xml contém a dependência do GSON para o mapeamento dos objetos:

XML
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
3. Variáveis de Ambiente / API Key
Para garantir a segurança e o funcionamento, obtenha sua chave no portal da ExchangeRate-API e configure-a no arquivo ServicoCambio.java:

Java
// TODO: Evoluir para carregamento via .env ou Variável de Sistema
private final String apiKey = "SUA_API_KEY_AQUI";
▶️ Execução
Para compilar e rodar o projeto via terminal, utilize os comandos Maven:

Bash
# Compilar o projeto
mvn clean compile

# Executar a aplicação
mvn exec:java -Dexec.mainClass="ConversorMoeda"
📂 Estrutura de Diretórios
A estrutura segue o padrão de responsabilidade única:

Plaintext
src/
 ├── model/
 │    └── RespostaCambio.java  # DTO (Data Transfer Object) para mapeamento da API
 ├── service/
 │    └── ServicoCambio.java   # Lógica de consumo e tratamento da requisição HTTP
 └── ConversorMoeda.java       # Entry point da aplicação (Controller/View)
📌 Roadmap de Evolução
Como desenvolvedor, planejo as seguintes melhorias para as próximas versões:

[ ] Implementação de Logs (Log4j ou SLF4J).

[ ] Tratamento de exceções customizadas para erros de conexão (Timeout/404).

[ ] Interface gráfica ou integração com Spring Boot para virar uma API REST própria.

Desenvolvido por: Miguel Costa 🚀
