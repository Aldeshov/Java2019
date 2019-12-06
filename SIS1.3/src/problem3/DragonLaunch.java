package problem3;
import java.util.Vector;
enum Gender {
	B,G
}
public class DragonLaunch {
	public static Vector<Person> person = new Vector<Person>();
	public static void kidnap(Person p) {
		person.add(p);
	}
	
	public static boolean willDragonEatorNot() {
		boolean eaten = false;
		for(int i = 0; i < person.size(); i++) {
			//System.out.println(i + "  " + person.get(i).X + "  " + person.size());
			if((i + 1) != person.size()) {
				if(person.get(i).X == Gender.B && person.get(i + 1).X == Gender.G) {
					//System.out.println(i);
					person.remove(person.get(i));
					person.remove(person.get(i));
					i = -1;
				}
			}
			
		}
		if(person.size() == 0)
			eaten = false;
		else
			eaten = true;
		return eaten;
	}
	
	public static void main(String args[]) {
		kidnap(new Person(Gender.B));
		kidnap(new Person(Gender.B));
		kidnap(new Person(Gender.B));
		//kidnap(new Person(Gender.G));
		//kidnap(new Person(Gender.G));
		//kidnap(new Person(Gender.B));
		//kidnap(new Person(Gender.G));
		kidnap(new Person(Gender.G));
		kidnap(new Person(Gender.B));
		kidnap(new Person(Gender.B));
		kidnap(new Person(Gender.G));
		kidnap(new Person(Gender.G));
		if(willDragonEatorNot())
			System.out.println("Will Eat");
		else
			System.out.println("Will Not Eat");
	}
}
