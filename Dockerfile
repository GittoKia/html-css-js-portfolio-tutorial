FROM node:18-alpine

# 1. Install JDK + font support for Swing/Nimbus
RUN apk add --no-cache \
    openjdk17-jdk \
    fontconfig \
    ttf-dejavu

WORKDIR /app

# 2. Compile your Java code
COPY MethodsClasses/ ./MethodsClasses/
COPY AbbasiKiaMethodsAssignmentUI.java ./
RUN javac -cp MethodsClasses AbbasiKiaMethodsAssignmentUI.java

# 3. Install Node dependencies
COPY package*.json ./
RUN npm install

# 4. Copy the rest of your app
COPY server.js ./
COPY public ./public

EXPOSE 10000

# 5. Force Java into headless mode and start your Node server
ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"
CMD ["node", "server.js"]