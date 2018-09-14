# FRAM-Backend

## build

```sh

mvn install
mvn package
mvn clean verify
mvn verify

```


## Run

```sh
java -jar target/FRAN-Backend-0.0.1-SNAPSHOT.jar
```

## Prod

Tiene integracion con Travis-CI y Heroku App

Luego: Los entornos son:

- https://fran-backend-develop.herokuapp.com/
- https://fran-backend-master.herokuapp.com/



## Usuarios Owners

- [Github       ] Login con dmerniestic1987
- [Travis-ci.com] Login com github de dmerniestic1987
- [Heroku       ] Login com diego.alejandro.mernies@gmail.com


## Compilación de contratos para java
cd /home/diego/src/github/dmerniestic1987/pangolines/pangolines-coin

web3j truffle generate build/contracts/PangolinesToken.json -o java -p ar.com.pangolines.FRANBackend.contract


## URL 
MASTER 
http://franbackendmaster-env.kyw6m2pvpu.us-west-2.elasticbeanstalk.com/

DEVELOP 
http://pango-fran-backend-develop.us-west-2.elasticbeanstalk.com/

