# XML with JAXB 2.0
This project contains a demonstration of [JAXB 2.0](http://docs.oracle.com/javase/tutorial/jaxb/intro/). JAXB provides a way to bind XML schemas and Java classes.

The following examples are included:
* __AddPerson__ (```gradle -q addPerson```) tests first it the file ```address_book.xml``` exists. If it exists, the example unmarshalls its content into Java objects. Example code expects that the file contains an ```AddressBook``` instance. Then, code asks to the user the details of a ```Person``` and then the person is added to the address book. Finally, the address book is marshalled into a XML file with name ```address_book.xml```.
* __ListPeople__ (```gradle -q listPeople```) unmarshalls ```address_book.xml``` into Java objects and then dump the objects to the console.
* __GenerateSchema__ (```gradle -q generateSchema```) generates a XML Schema that can validate if a XML file can be unmarshalled to ```AddressBook``` instances.
