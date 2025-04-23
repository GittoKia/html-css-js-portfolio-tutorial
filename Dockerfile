FROM node:18-alpine

# 1. Install JDK + Ant + font support (use Alpine’s correct package names)
RUN apk add --no-cache \
    openjdk17 \
    ant \
    fontconfig \
    ttf-dejavu

WORKDIR /app

# 2. Compile your Java code (via Ant or javac)
COPY build.xml ./
COPY nbproject/ ./nbproject/
COPY src/ ./src/
RUN ant clean compile

# 3. Install Node dependencies
COPY package*.json ./
RUN npm install

# 4. Copy the rest of your Node app
COPY server.js ./
COPY public ./public

EXPOSE 10000

# 5. Force Java into headless mode and start your Node server
ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"
CMD ["node", "server.js"]