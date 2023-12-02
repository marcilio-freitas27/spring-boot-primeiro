![Udemy](https://img.shields.io/badge/Udemy-EC5252?style=for-the-badge&logo=Udemy&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot) ![OpenJDK](https://img.shields.io/badge/OpenJDK-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

### Spring Boot

- Meu primeiro projeto com Java + Spring Boot
- Seguindo o curso da Udemy - Java Completo -

### Gerando o projeto

No site [start.spring.io](https://start.spring.io/) gerei o projeto Spring com as seguintes configurações:

- **Project:** Maven
- **Language:** Java
- **Spring Boot(versão):** A versão que vc preferir
- **Project Metadata:** como prefefir
- **Packaging:** Jar
- **Java(versão):** 8(1.8)
- **Dependencies:** Spring Boot Dev Tools , Spring Web
- Clicar em **Generate** ou **ctrl + Enter**

### Gerando o build - Tomcat 10 - dicas

- Configurar o pom.xml para gerar o arquivo war
- Implementar o build e a configuração na classe principal do projeto (demo (1)/demo/srv/java/com/example/demo/DemoApplication.java) ou criar outra classe que é o que acontece neste repositório (demo (1) /demo/srv/java/com/example/demo/ServletInit.java)
- Entrar na pasta do projeto (demo (1)/demo/)
- Executar o comando do Maven para gerar o o war:

```
    mvnw clean install
```

- O arquivo é gerado na no caminho demo (1)/demo/target/arquivo.war
