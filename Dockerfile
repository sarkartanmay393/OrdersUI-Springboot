# Stage 1: Build React application
FROM node:alpine as build-react
WORKDIR /app
COPY orderlist-ui/package.json orderlist-ui/package-lock.json ./
RUN npm install
COPY orderlist-ui/ ./
RUN npm run build

# Stage 2: Build Spring Boot application
FROM maven:3.8.3-openjdk-17 as build-spring  
WORKDIR /backend
COPY backend/pom.xml ./
RUN mvn dependency:go-offline
COPY backend/src ./src
# Copy built React app from previous stage into Spring Boot's resources directory
COPY --from=build-react /app/build /backend/src/main/resources/static
RUN mvn package -DskipTests

# Stage 3: Run Spring Boot application
FROM openjdk:17-oracle
COPY --from=build-spring /backend/target/backend.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
