FROM maven:3.5.4-jdk-8

ENV APP_DIR=/usr/src/app

RUN mkdir -p $APP_DIR
WORKDIR $APP_DIR

ADD target/catService.jar catService.jar

EXPOSE 8080
CMD java -jar catService.jar