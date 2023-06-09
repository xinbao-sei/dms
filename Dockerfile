# Docker for java mdms

# Base image oracle jdk8
FROM openjdk:8-jre-alpine-ttf
#FROM rddhub.changhong.com/library/frolvlad-alpine-java

# Author
LABEL maintainer="brianhsiung@outlook.com"

# Environment 此处需要根据实际情况修改APP_NAME
ENV JAVA_OPTS="" APP_NAME="dms"

# Timezone
RUN rm -rf /etc/localtime && ln -s /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

# Application
ADD $APP_NAME-service/build/libs/$APP_NAME.jar $APP_NAME.jar

# Port
EXPOSE 8080

# Launch the application
ENTRYPOINT ["sh","-c","java -server -XX:+UseG1GC -XX:InitialRAMPercentage=75.0  -XX:MaxRAMPercentage=75.0 $JAVA_OPTS -jar $APP_NAME.jar --server.servlet.context-path=/$APP_NAME --server.port=8080"]