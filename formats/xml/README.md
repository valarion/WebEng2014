# Serialization formats :: JAXB 2.0
This project contains a demonstration of [JAXB 2.0](http://docs.oracle.com/javase/tutorial/jaxb/intro/). JAXB provides a way to bind XML schemas and Java classes.

Included code shows
* How to unmarshall a XML file into Java objects (```gradle -q addPerson``` and ```gradle -q listPeople```)
* How to marshall Java objects into a XML file (```gradle -q addPerson```)
* How to generate a XML schema file from Java classes (```gradle -q generateSchema```)