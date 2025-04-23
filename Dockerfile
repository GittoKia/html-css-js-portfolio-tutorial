FROM node:18-slim

# 1. Install JDK (for javac) and cleanup
RUN apt-get update \
 && apt-get install -y --no-install-recommends default-jdk fontconfig fonts-dejavu \
 && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# 2. Copy everything we need
COPY build.xml ./
COPY nbproject/ ./nbproject/
COPY src/ ./src/
COPY AbbasiKiaArraysAssignmentUI.java ./

# 3. Compile every .java (root + src) into build/classes/
RUN mkdir -p build/classes \
 && find src -type f -name "*.java" > sources.txt \
 && echo "AbbasiKiaArraysAssignmentUI.java" >> sources.txt \
 && javac -d build/classes @sources.txt

# 4. Finish Node setup
COPY package*.json ./
RUN npm install
COPY server.js ./
COPY public/ ./public

# 5. Headless mode & start
ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"
EXPOSE 10000
CMD ["node", "server.js"]