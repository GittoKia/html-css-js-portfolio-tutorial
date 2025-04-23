FROM node:18-alpine

# 1. Install JDK, Ant, and font support
RUN apk add --no-cache \
    openjdk17-jdk \
    ant \
    fontconfig \
    ttf-dejavu

WORKDIR /app

# 2. Copy your NetBeans Ant project
COPY build.xml ./
COPY nbproject/ ./nbproject/
COPY src/ ./src/
# (and any 'lib/' folder or other resources your Ant build needs)

# 3. Run Ant so your classes (or JAR) get built
RUN ant clean compile

# 4. Install Node deps
COPY package*.json ./
RUN npm install

# 5. Copy the rest of your Node app
COPY server.js ./
COPY public ./public

EXPOSE 10000

# 6. Make Java headless for Swing builds, then start Node
ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"
CMD ["node", "server.js"]
