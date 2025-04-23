FROM node:18-slim

# 1. Install JDK + Ant + fonts via apt
RUN apt-get update && apt-get install -y --no-install-recommends \
      default-jdk \
      ant \
      fontconfig \
      fonts-dejavu \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# 2. Compile your Java (Ant or javac)
COPY build.xml ./
COPY nbproject/ ./nbproject/
COPY src/ ./src/
RUN ant clean compile

# 3. Install Node deps
COPY package*.json ./
RUN npm install

# 4. Copy your app
COPY server.js ./
COPY public ./public

EXPOSE 10000

# 5. Headless Java + start Node
ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"
CMD ["node", "server.js"]