# API-GATOS

Este projeto contém duas aplicações JAVA; job-api-gatos e api-busca-gatos.

## JOB-API-GATOS
### Objetivo:
job-api-gatos, tem por finalidade buscar as informações na api https://thecatapi.com e processar as informações para enviar para o serviço de fila "RabbitMQ", essas atualizações acontecem a cada 5 minutos.
### Tecnologias Utilizadas
JAVA 11, Spring Boot e Rabbit MQ 

## API-BUSCA-GATOS
### Objetivo
api-busca-gatos, tem por finalidade fornecer informações sobre as raças de gatos. A aplicação consome a fila cat-queue e atualiza sua base de dados. 
### Os recursos disponibilizados para busca nessa API são: 
- listar todas as raças
- listar informações de uma determinada raça
- listar raças por temperamento
- listar raças por origem
- (http://localhost:8088/swagger-ui.html)
### Tecnologias Utilizadas
JAVA 11, Spring Boot, Rabbit MQ e MongoDB

![Swagger](documentacao/api-busca-gatos.png?raw=true "swagger")

## Desenho da Arquitetura

![Arquitetura](documentacao/desenho-arquitetura.png?raw=true "arquitetura")

## Como rodar o projeto
- Para rodar as aplicações, é preciso que a maquina tenha o Docker instalado assim como o docker-compose. 
- Na pasta raiz do projeto temos o arquivo docker-compose.yml basta executar o comando docker-compose up e esperar o ambiente subir. 
- Lembrando que o job-api-gatos busca as informações na https://thecatapi.com a cada 5 minutos. 

## Link coleção postman
![Coleção postman](documentacao/buscas-api-de-gatos.postman_collection.json?raw=true "postman")
- O arquivo também pode ser localizado na pasta documentacao

## Kibana
- Além do print dos logs estou disponibilizando o link do Kibana na nuvem (http://34.229.71.35:5601/app/kibana)
- Usuario: elastic
- Senha: changeme

## Buscas realizadas de LOGS no Elasticsearch e Kibana

### Iniciando o Job
![Print-log](documentacao/job-api-iniciando.png?raw=true "job")
![Print-log](documentacao/json-job-api-iniciando.png?raw=true "job")

### Salvando cat nas api de busca
![Print-log](documentacao/save-cat.png?raw=true "job")
![Print-log](documentacao/save-cat-json.png?raw=true "job")

### Buscando todas as raças
![Print-log](documentacao/find-all.png?raw=true "job")
![Print-log](documentacao/find-all-json.png?raw=true "job")

### Buscando por raça
![Print-log](documentacao/find-by-breeds.png?raw=true "job")
![Print-log](documentacao/find-by-breeds-json.png?raw=true "job")

### Buscando por temperamento
![Print-log](documentacao/find-by-temperament.png?raw=true "job")
![Print-log](documentacao/find-by-temperament-json.png?raw=true "job")

### Buscando por origem
![Print-log](documentacao/find-by-origin.png?raw=true "job")
![Print-log](documentacao/find-by-origin-json.png?raw=true "job")




