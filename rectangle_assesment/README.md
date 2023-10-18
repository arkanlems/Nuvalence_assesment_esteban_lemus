# Nuvalence_assesment_esteban_lemus 
## How to run
###  Install java 
for running the project you need to have configured java 11 with JAVA_HOME configured

tutorial:

https://www.youtube.com/watch?v=7NPtJMZ0sgY

###  Install Maven
the project was made using maven, for running all comands required, maven must be installed and added to environment variables

tutorial:

https://www.youtube.com/watch?v=oON7L66d-r4

###  Run main
this repository must be cloned/download to a visible directory then with the help of a terminal or the terminal of an IDE 
like IntelliJ this comands must be entered in order inside the root of this project

To be sure all dependencies are installed:

`mvn install`

Compile the project:

`mvn compile`

Build the project:

`mvn build`

Run the tests, all must pass:

`mvn test`

Run the project:

`mvn exec:java`