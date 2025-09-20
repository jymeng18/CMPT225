1. compile the files by running
> javac UseTwoFiles.java
Note this will compile both UseTwoFiles.class and A.class

2. delete all .class files, and compile only A.java
> javac A.java
this time only A.class will be created because A doens't depend on other files