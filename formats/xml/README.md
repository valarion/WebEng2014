# Serialization formats :: JAXB 2.0
This project contains a demonstration of [JAXB 2.0](http://docs.oracle.com/javase/tutorial/jaxb/intro/). JAXB provides a way to bind XML schemas and Java classes.

```build.gradle``` includes tasks that run the following examples:
* ```gradle -q addPerson```: If the file ```address_book.xml```  exists unmarshall its content into Java objects. Code expects that an ```AddressBook``` instance is the root object. Then, the program asks the details of a ```Person``` and adds it to the address book. Finally, the address book is marshalled into a XML file.
* ```gradle -q listPeople```: This code unmarshall ```address_book.xml``` into Java objects and then dump the objects to the console.
* ```gradle -q generateSchema```: This code generates the XML Schema that validates XML files that can be unmarshalled to ```AddressBook``` instances.
teSchema```)