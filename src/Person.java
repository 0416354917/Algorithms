
public class Person implements Comparable<Person> {

	public int id;
	public String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}

}
