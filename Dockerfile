FROM node:18-slim

# 1) Install JDK (for javac) and fonts for Swing headless mode
RUN apt-get update \
 && apt-get install -y --no-install-recommends default-jdk fontconfig fonts-dejavu \
 && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# 2) Copy in *everything* from your project
#    (this includes src/, your root-level .java, server.js, package files, public/, etc.)
COPY . .

# 3) Compile all Java sources into JavaClasses/
RUN mkdir -p JavaClasses \
 && find src -name "*.java" > sources.txt \
 && echo "AbbasiKiaArraysAssignmentUI.java" >> sources.txt \
 && javac -d JavaClasses @sources.txt

# 4) Install Node dependencies and copy the rest
RUN npm install
# (server.js and public/ were already copied by the `COPY . .` above)

# 5) Launch in headless mode
ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"
EXPOSE 10000
CMD ["node", "server.js"]