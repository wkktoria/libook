FROM maven:3-openjdk-11 AS build

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

WORKDIR /usr/src/app

RUN mvn clean package

FROM tomcat:10-jdk11

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build /usr/src/app/target/*.war /usr/local/tomcat/webapps/ROOT.war

WORKDIR /usr/local/tomcat

EXPOSE 8080

CMD ["catalina.sh", "run"]