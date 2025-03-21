FROM amazoncorretto:21 AS builder

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN yum install -y bash

RUN ./gradlew clean build -x test

FROM amazoncorretto:21

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]