package formats.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddressBook {

	private List<Person> personList = new ArrayList<Person>();

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> persons) {
		this.personList = persons;
	}

	public void addPerson(Person person) {
		personList.add(person);
	}
}
