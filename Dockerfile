# 1. Base image with JDK & Ant
FROM node:18-slim

RUN apt-get update \
 && apt-get install -y --no-install-recommends default-jdk ant fontconfig fonts-dejavu \
 && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# 2. Build the packaged project via Ant
COPY build.xml ./
COPY nbproject/ ./nbproject/
COPY src/ ./src/
RUN ant clean compile

# 3. Bring in any root-level Java UIs
COPY AbbasiKiaArraysAssignmentUI.java ./

# 4. Compile EVERY .java (root + src) into JavaClasses/
RUN mkdir JavaClasses \
 && find . -type f -name "*.java" > all_sources.txt \
 && javac -d JavaClasses @all_sources.txt

# 5. Node/Express setup
COPY package*.json ./
RUN npm install
COPY server.js ./
COPY public/ ./public

ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"
EXPOSE 10000
CMD ["node", "server.js"]
