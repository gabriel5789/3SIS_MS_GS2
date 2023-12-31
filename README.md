Integrantes do Grupo

    85897 - Ana Luiza de Novaes e Souza Dantas
    88398 - Gabriel Guedes Silva
    86729 - Naomi Nagata Abe

Dados

Os esquemas Lógico e Relacional do banco de dados podem ser encontrados na pasta
root do projeto (Logical.pdf, Relational.pdf)

![Esquema Lógico do banco de dados](images/image-1.png)

Os scripts de DDL e carga de dados estão na pasta /backend/src/main/sql

Aplicação Backend

A aplicação Backend foi criada com Spring Boot e banco de dados Oracle
Endpoints REST
    /objetivos
    /indicador/{id}

Aplicação Frontend

A aplicação frontend foi criada com Thymeleaf e pode ser acessada nas URLS:

/ui/objetivos
![Página de objetivos](images/objetivos.png)

/ui/indicador/{id}
![Página de indicadores](images/indicador.png)

Testes

O teste de carga pode ser executado utilizando os comandos:

    cd tests
    k6 run ./js/script.js --vus=10 --duration=60s

Resultados dos testes de carga:
83 iterações completas em 138.7s com 20 VUs simultâneos
Cada iteração conta com 4 requisições, o que são 332 requisições em 138.7 segundos

![Resultados dos testes de carga](images/image.png)

Build

1. Clonar o repositório
2. Editar o arquivo /resources/application.properties com o seguinte template:

        server.port=8080
        # JPA
        spring.jpa.generate-ddl=false
        spring.jpa.hibernate.ddl-auto=update
        spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl
        spring.datasource.driverClassName=oracle.jdbc.driver.OracleDriver
        spring.datasource.username=
        spring.datasource.password=
        spring.datasource.testWhileidle=true
        spring.datasource.validationQuery=select 1
        spring.datasource.maxActive=3

Deixei o application.properties no GitHub por enquanto para facilitar a avaliação, então essa etapa pode ser pulada, mas depois irei removê-lo do GitHub por questões de segurança.

2. Se necessário, os scripts de DDL e carga de dados estão na pasta /backend/src/main/sql

3. Utilizar os seguintes comandos com o CMD (não pode ser bash ou powershell) a partir da root para buildar e gerar o arquivo .jar do projeto:

        mvnw compile
        mvnw clean
        mvnw install
        mvnw package

5. Utilizar o comando docker build . --tag=gs-application no diretório raíz do projeto 

6. utilizar o comando docker run -p 8080:8080 gs-application

