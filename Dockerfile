FROM openjdk:17-jdk-slim

WORKDIR /app

# Copier le JAR
COPY target/Employee-*.jar app.jar

# Créer un utilisateur non-root pour la sécurité
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

# Exposer le port
EXPOSE 8085

# Variables d'environnement
ENV JAVA_OPTS=""

# Démarrer l'application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]