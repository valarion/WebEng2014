# Google Protocol Buffers
This project contains a demonstration of [Protocol Buffers](https://developers.google.com/protocol-buffers/). Protocol buffers are Google's language-neutral, platform-neutral, extensible mechanism for serializing structured data using Java, Python and C++.

The following examples are included:
* __AddPerson__ (```gradle -q addPerson```) tests first it the file ```address_book.pb``` exists. If it exists, the example unmarshalls its content into Java objects. Example code expects that the file contains an ```AddressBook``` instance. Then, code asks to the user the details of a ```Person``` and then the person is added to the address book. Finally, the address book is marshalled into a Protocol Buffers file with name ```address_book.pb```.
* __ListPeople__ (```gradle -q listPeople```) unmarshalls ```address_book.pb``` into Java objects and then dump the objects to the console.
