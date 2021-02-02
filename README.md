# spring-boot-cucumber-example

Un exemple basique d'utilisation des techniques: Java, Spring Boot, Cucumber, Maven, et une base de données H2. Il s’agit, en utilisant des apis, de créer un nouvel abonné, de souscrire à plusieurs contrats puis de modifier l’adresse de l’abonné puis enfin de vérifier que l’adresse de tous les contrats correspondent à la nouvelle adresse et qu’un mouvement de modification a bien été créé.

### Installation & Utilistion:
Cloner le projet:
```sh
$ git clone ...
```
Pour compiler et lancer le projet, exécuter dans la racine du projet les commandes maven suivantes:
```sh
$ mvn clean install
$ mvn spring-boot:run
```
Pour tester les APIs REST implémentées, il suffit de lancer les appels HTTP avec un HTTP client comme POSTMAN:
  - Créer un nouvel abonné (paramètres : nom, prénom, adresse): http://localhost:8080/api/subscriber/create?firstName=med&lastName=tebib&address=Lyon
  - Souscrire à un contrat (paramètres : identifiant de l’abonné, adresse du contrat): http://localhost:8080/api/contract/subscribe?subscriberId=1&address=Paris
  - Modifier l’adresse de l’abonné (paramètres : identifiant de l’abonné, nouvelle adresse du contrat): http://localhost:8080/api/subscriber/updateAddress?subscriberId=1&newAddress=Lille
  - Récupérer les informations sur les contrats d’un abonné (paramètres : identifiant de l’abonné): http://localhost:8080/api/subscriber/getContracts?subscriberId=1
  - Récupérer l’historique des mouvements de modification effectués pour un abonné (paramètres : identifiant de l’abonné): http://localhost:8080/api/subscriber/getUpdatesHistory?subscriberId=1

###Réponses aux questions:
Quelles bonnes pratiques avez-vous mis en place pour garantir la qualité du code ?
- J'ai suivi les principes solides pour développer une application orientée objet,
- J'ai  installé un sonarlint pour mesurer la qualité du code (issues de développement, couverture de tests) d'une manière continue,
- L'implémentation des tests unitaires/intégrations (cette partie n'est pas encore finie)


