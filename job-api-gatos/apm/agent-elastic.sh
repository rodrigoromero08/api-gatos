#!/bin/bash
JAR_FILE=/home/rodrigoromero/dev/git/job-api-gatos/target/job-api-gatos-1.0.0.jar
JAR_AGENT=/home/rodrigoromero/dev/git/job-api-gatos/apm/elastic-apm-agent-1.7.0.jar

nohup java -javaagent:$JAR_AGENT \
     -Delastic.apm.server_url=http://localhost:8200 \
     -Delastic.apm.service_name=job-api-gatos \
     -Delastic.apm.application_packages=br.com.romero \
     -jar $JAR_FILE > agent-elastic.log 2> agent-elastic-erro.log &
