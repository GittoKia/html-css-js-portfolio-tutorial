# Base image with JDK & Ant
FROM node:18-slim

# Install JDK & Ant (no interactive prompts)
ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update \
 && apt-get install -y --no-install-recommends default-jdk ant fontconfig fonts-dejavu \
 && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# 1️⃣ Copy and compile the packaged Methods assignment via Ant
COPY build.xml .
COPY nbproject/ ./nbproject/
COPY src/ ./src/
RUN ant clean compile

# 2️⃣ Install Node deps and copy only the server
COPY package*.json ./
RUN npm install --production
COPY server.js ./

# 3️⃣ (Optional) Copy public if you need a static frontend for testing
COPY public/ ./public

# Force headless mode for any Swing code
ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"
EXPOSE 10000

# Start only your Node server
CMD ["node", "server.js"]