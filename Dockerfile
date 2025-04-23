# 1. Base image with JDK/Ant for the packaged project
FROM node:18-slim

RUN apt-get update \
 && apt-get install -y --no-install-recommends default-jdk ant fontconfig fonts-dejavu \
 && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# 2. Compile the packaged project via Ant
COPY build.xml ./
COPY nbproject/ ./nbproject/
COPY src/ ./src/
RUN ant clean compile

# 3. Compile every remaining .java (including your root-level UI) into JavaClasses/
COPY ./*.java ./          # copies AbbasiKiaArraysAssignmentUI.java, etc.
RUN mkdir JavaClasses \
 && find . -type f -name "*.java" > sources.txt \
 && javac -d JavaClasses @sources.txt

# 4. Node setup
COPY package*.json ./
RUN npm install
COPY server.js ./
COPY public/ ./public

ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"
EXPOSE 10000
CMD ["node", "server.js"]
