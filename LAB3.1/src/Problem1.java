class Animal{
	String Name;
	int Age;
	public Animal() {
	}
	public Animal(String name) {
		Name = name;
	}
	public String get() {
		return Name;
	}
	public void set(int Age) {
		this.Age = Age;
	}
	public void set(String Name) {
		this.Name = Name;
	}
}
class Cat extends Animal{
	int age;
		public Cat() {
		super();
		age = 0;
	}
	@Override
	public String get() {
		return Name + "  " + age;
	}
	
}

class Dog extends Animal{
	int age;
	public Dog(String name) {
		super(name);
	}
	//Overload
	public void set(String Name, int Age) {
		this.Name = Name;
		this.Age = Age;
	}
	
}
public class Problem1{
	public static void main(String args[]) {
		Cat cat = new Cat();
		cat.Name = "Myau";
		System.out.println(cat.get());
	}
}
