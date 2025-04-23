# Use Node.js slim base so we can install JDK easily
FROM node:18-bullseye-slim

# Install a JDK for javac/java
RUN apt-get update \
 && apt-get install -y --no-install-recommends default-jdk \
 && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# 1) Copy and compile your Java sources
#    (Assumes you’ve added src/myabbasikiamethodsassignment/Main.java alongside your UI class)
COPY src ./src
RUN mkdir -p build/classes \
 && javac -d build/classes \
      src/myabbasikiamethodsassignment/AbbasiKiaMethodsAssignmentUI.java \
      src/myabbasikiamethodsassignment/Main.java

# 2) Install your Node.js dependencies
COPY package*.json ./
RUN npm install

# 3) Copy the rest of your app (server.js + static files)
COPY server.js .
COPY public ./public

# 4) Expose and run
EXPOSE 10000
CMD ["node", "server.js"]