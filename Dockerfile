FROM tomcat:9-jre11-slim

LABEL maintainer="DTech Soft Ltd"

# Catalina environment variables (catalina home is provided)
ENV CATALINA_BIN="$CATALINA_HOME/bin"
ENV CATALINA_LIB="$CATALINA_HOME/lib"
ENV CATALINA_CONF="$CATALINA_HOME/conf"
ENV CATALINA_WEBAPPS="$CATALINA_HOME/webapps"

# Adding curl and jq 
RUN rm -rf /var/lib/apt/lists/* && \
    apt-get update && \
    apt-get install -y curl jq -y && \
    rm -rf /var/lib/apt/lists/*

# Remove all default tomcat applications
RUN rm -rf "$CATALINA_WEBAPPS"

# Copy the setenv.sh script into the tomcat bin directory
COPY common/bin/setenv-jre11.sh "$CATALINA_BIN/setenv.sh"

# Copy the Tomcat server properties
COPY common/conf/server.xml "$CATALINA_CONF/server.xml"

# Add the MySQL Library into the classpath
COPY common/lib/mysql-connector-java-8.0.15.jar "$CATALINA_LIB/mysql-connector-java.jar"

COPY target/web-template.war "$CATALINA_WEBAPPS/web-template.war"