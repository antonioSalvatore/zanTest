# Let's Jam!
Questa web application permette di effettuare operazioni CRUD su una base di musicisti.

## Funzionalità:
- **Registrazione Utente**: è possibile registrare un'utenza scegliendo delle credenziali d'accesso ed inserendo dei dati personali
- **Login**: si può effettuare il login qualora fosse già stata effettuata la registrazione
- **Logout**: l'utente effettuare il logout
- **Ricerca Musicisti**: l'utente può ricercare i musicisti presenti nel database; riempendo uno o più campi tra quelli mostrati a video, la ricerca restituirà dei risultati filtrati in base a tali campi, altrimenti verranno mostrati tutti i musicisti presenti nel database
- **Modifica del Profilo**: l'utente può aggiornare i dati del proprio profilo
- **Eliminazione del Profilo**: l'utente può eliminare il proprio profilo

## How-To:
Per utilizzare l'applicativo:
- Prerequisiti:
 - _Java JDK 1.8_ (download [qui](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
 - _WildFly 9.0.2_ (download [qui](https://download.jboss.org/wildfly/9.0.2.Final/wildfly-9.0.2.Final.zip))

* Avviare WildFly con lo `standalone.xml` di default
* Deployare il `.war`
* Avviare l'applicativo da browser andando su [http://localhost:8080/letsjam](http://localhost:8080/letsjam)