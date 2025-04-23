# 1. Base image with Node.js
FROM node:18-bullseye

# 2. Install JDK and Python 3
RUN apt-get update && \
    apt-get install -y default-jdk python3 python3-pip && \
    rm -rf /var/lib/apt/lists/*

# 3. Set working directory
WORKDIR /app

# 4. Copy package manifest & install Node deps
COPY package*.json ./
RUN npm install

# 5. Copy the rest of your code
COPY . .

# 6. Compile all Java sources into a folder
RUN mkdir -p JavaClasses && javac -d JavaClasses *.java

# 7. Expose the port your server listens on
EXPOSE 3001

# 8. Start your Node.js server
CMD ["node", "server.js"]