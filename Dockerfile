FROM node:18-alpine

# 1. Install JDK so you have both javac and java available
RUN apk add --no-cache openjdk17-jdk

WORKDIR /app

# 2. Copy and compile your Java code
COPY MethodsClasses/ ./MethodsClasses/
COPY AbbasiKiaMethodsAssignmentUI.java ./
RUN javac -cp MethodsClasses AbbasiKiaMethodsAssignmentUI.java

# 3. Install Node dependencies
COPY package*.json ./
RUN npm install

# 4. Copy the rest of your Node app
COPY server.js ./
COPY public ./public

EXPOSE 10000

# 5. Launch your Node server (which can now spawn java processes)
CMD ["node", "server.js"]