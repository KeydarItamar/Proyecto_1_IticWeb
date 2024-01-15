FROM eclipse-temurin:17.0.9_9-jre-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} IticWebProjecteApplication.jar
ENTRYPOINT ["java","-jar","/IticWebProjecteApplication.jar"]
# docker build -t springbootapp:0.0.1-SNAPSHOT .
# docker image list
# docker ps
# docker run -p 8080:8080 --name IticWebProjecte -d -t springbootapp:0.0.1-SNAPSHOT
# docker start IticWebProjecte
# docker stop IticWebProjecte
# docker rm IticWebProjecte
# docker tag springbootapp:0.0.1-SNAPSHOT oscarpm24/springbootapp:0.0.1-SNAPSHOT
# docker push oscarpm24/springbootapp:0.0.1-SNAPSHOT