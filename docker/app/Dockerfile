FROM maven:3-jdk-8 AS build

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

WORKDIR /usr/src/app

RUN mvn clean package

FROM tomcat:9-jdk8

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build /usr/src/app/target/*.war /usr/local/tomcat/webapps/ROOT.war

WORKDIR /usr/local/tomcat

EXPOSE 8080

CMD ["catalina.sh", "run"]