package formats.xml;

import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

class ListPeople {
	public final static String DEFAULT_FILE_NAME = "address_book.xml";

	// Iterates though all people in the AddressBook and prints info about them.
	static void print(AddressBook addressBook) {
		for (Person person : addressBook.getPersonList()) {
			System.out.println("Person ID: " + person.getId());
			System.out.println("  Name: " + person.getName());
			if (person.hasEmail()) {
				System.out.println("  E-mail address: " + person.getEmail());
			}

			for (PhoneNumber phoneNumber : person.getPhoneList()) {
				switch (phoneNumber.getType()) {
				case MOBILE:
					System.out.print("  Mobile phone #: ");
					break;
				case HOME:
					System.out.print("  Home phone #: ");
					break;
				case WORK:
					System.out.print("  Work phone #: ");
					break;
				}
				System.out.println(phoneNumber.getNumber());
			}
		}
	}

	// Main function: Reads the entire address book from a file and prints all
	// the information inside.
	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext.newInstance(AddressBook.class);
		String filename = DEFAULT_FILE_NAME;
		if (args.length > 0) {
			filename = args[0];
		}

		// Read the existing address book.
		Unmarshaller um = context.createUnmarshaller();
		AddressBook addressBook = (AddressBook) um.unmarshal(new FileReader(
				filename));

		print(addressBook);
	}
}