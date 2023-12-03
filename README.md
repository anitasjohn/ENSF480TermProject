# ENSF480TermProject

## Setup for Application Use
Emsure your own username and password for database access is being used
1. Go to Database/AccessDatabase.java
2. Change Username and Password in the constructor

To compile the program, open the working directory of the file in the terminal, then compile using:
* Mac OS
```
javac -cp .:lib/mysql-connector-java-8.0.23.jar *.java
```

* Windows
```
javac -cp .;lib/mysql-connector-java-8.0.23.jar *.java
```
To execute the program use

* Mac OS
```
java -cp .:lib/mysql-connector-java-8.0.23.jar App
```
* Windows
```
java -cp .;lib/mysql-connector-java-8.0.23.jar App
```