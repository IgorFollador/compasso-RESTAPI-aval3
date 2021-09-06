# compasso-RESTAPI-aval3

### Instruções:

- Para execução do projeto como um todo é necessário executar a classe `RestApiApplication.java`;

- Para que persistir os dados pré-cadastrados para o exercício sobre filtro da Entidade `Cars` é necessário executar manualmente o Schema localizado em `~compasso-RESTAPI-aval3/src/main/resources/data.sql`. Assim será cadastrado dez modelos de carros já definidos;


#### Configurações:

As configurações da JPA e do DataSource para o MySQL estão localizadas em `~compasso-RESTAPI-aval3/src/main/resources/application.properties`.

##### Possuindo as configurações de porta, usuário e senha abaixo:

```xml
#datasource
spring.datasource.url=jdbc:mysql://localhost:3306/restapi_igorf?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root

#jpa
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update

```

##### OBS:

Este é um projeto Maven, no qual foi utilizada apenas linguagem Java e o SGBD MySQL.
O banco de dados é gerado automaticamente ao executar o projeto. A única necessidade é executar o Schema `data.sql` citado acima.

- Nome do banco `restapi_igorf`;
- Usuário padrão `root`;
- Senha padrão `root`;

### Endpoints -> [localhost:8080/](localhost:8080/):

##### api/cars ->

* _GET_ [api/cars](localhost:8080/api/cars) -> Retorna todos os modelos de carros persistidos no BD.

* _POST_ [api/cars](localhost:8080/api/cars) -> Persiste um novo modelo de carro no BD.

  ###### FILTROS:

  * _GET_ [api/cars?marca=?](localhost:8080/api/cars?marca=?) -> Retorna todos os modelos de carros de determinada marca.
  * _GET_ [api/cars?nome=?](localhost:8080/api/cars?nome=?) -> Retorna todos os modelos de carros de determinado nome.
  * _GET_ [api/cars?cor=?](localhost:8080/api/cars?cor=?) -> Retorna todos os modelos de carros de determinada cor.

  ###### ORDENAÇÕES:

  * _GET_ [api/cars?sort=nome,asc](localhost:8080/api/cars?sort=nome,asc) -> Retorna todos os modelos de carros ordenados por nome, em ordem alfabética.
  * _GET_ [api/cars?sort=valor,asc](localhost:8080/api/cars?sort=nome,asc) -> Retorna todos os modelos de carros ordenados por valor, em ordem crescente.
  * _GET_ [api/cars?sort=anoFabricacao,asc](localhost:8080/api/cars?sort=anoFabricacao,asc) -> Retorna todos os modelos de carros ordenados por ano de fabricação, em ordem crescente.

##### api/states ->

* _POST_ [api/states](localhost:8080/api/states) -> Persiste um novo estado no BD. 

* _GET_ [api/states](localhost:8080/api/states) -> Retorna todos os estados persistidos no BD.

* _GET_ [api/states/{id}](localhost:8080/api/states/{id}) -> Retorna um estado através de um ID passado no parâmetro da URI. 

* _PUT_ [api/states/{id}](localhost:8080/api/states/{id}) -> Atualiza o estado passado no parâmetro da URI como ID.

* _DELETE_ [api/states/{id}](localhost:8080/api/states/{id}) -> Remove o estado passado no parâmetro da URI como ID.

  ###### FILTROS:

  * _GET_ [api/states?reg=?](localhost:8080/api/states?reg=?) -> Retorna todos os estados de determinada região.
  * _GET_ [api/states?sort=populacao,desc](localhost:8080/api/states?sort=populacao,desc) -> Retorna todos os estados ordenados de forma decrescente de população.
  * _GET_ [api/states?sort=area,desc](localhost:8080/api/states?sort=area,desc) -> Retorna todos os estados ordenados de forma decrescente de área.

### IMPORTANTE

As possíveis regiões que podem ser cadastradas são as seguintes:

* NORTE
* NORDESTE
* SUL
* SUDESTE
* CENTRO_OESTE

Na hora do cadastro ou atualização de um estado deve-se as únicas possibilidades estão citadas acima da exata mesma forma (LETRA MAIÚSCULA E UNDERLINE).

##### OBS:

Todas os filtros e ordenações podem ser combinados através da URI como por exemplo:

* _GET_ `localhost:8080/api/cars?marca=fiat&cor=branco&sort=valor,desc` -> Retorna todos os modelos de carros que são da marca Fiat, da cor branca, ordenados de forma decrescente de valor. Neste caso com os dados do projeto teríamos como retorno:

  ```json
  "content:" [	
  	{
        "chassi": "60AsEZwbYm5U99584",
        "nome": "Argo",
        "marca"...
      },
      {
        "chassi": "21Axv51UuGM9F6154",
        "nome": "Doblo",
        "marca"...
      },
      {
        "chassi": "1Aa0T0n8vmA9W6148",
        "nome": "Marea",
        "marca"...
      }
  ]
  ```

* 

* _GET_ `localhost:8080/api/states?reg=NORDESTE&sort=populacao,desc&sort=area,asc` -> Retorna todos os estados da região nordeste, ordenados primeiramente de forma decrescente de população e crescente de área.

