# Базовый образ, содержащий Java 17
FROM openjdk:17-oracle

# Директория приложения внутри контейнера
WORKDIR /app

# Копирование JAR-файла приложения в контейнер
COPY build/libs/studreg-0.0.1-SNAPSHOT.jar app.jar
# Копирование init.txt-файла в контейнер
COPY src/main/resources/init.txt resources/init.txt

ENV INIT_ENABLED=false


# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]