package pack5;

interface MyCollection<E>{
  boolean add (Object item);
  void clear ();
  boolean contains (Object item);
  boolean isEmpty ();
  boolean remove (Object item);
  E get(int index);
  int size ();
}

class Collector<E> implements MyCollection<E>{
	protected int size;
	protected Object elements[];
	public Collector() {
		size = 0;
		elements = new Object[size];
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object item) {
		Object temp[] = elements;
		int t = size;
		elements = new Object [++size];
		int i = 0;
		while(t > 0) 
		{
			elements[i] = temp[i];
			t--;
			i++;
		}
		elements[size - 1] = (E) item;
		return true;
	}
	@Override
	public void clear() {
		size = 0;
		elements = new Object[size];
	}
	@Override
	public boolean contains(Object item) {
		for(int i = 0; i < size; i++) {
			if(elements[i].equals(item))
				return true;
		}
		return false;
	}
	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	@Override
	public boolean remove(Object item) {
		Object temp[] = elements.clone();
		int t = size;
		int i = 0, j = 0;
		boolean done = false;
		while(t > 0) 
		{
			if(elements[i].equals(item))
				{
					j++;
					t--;
					done = true;
				}
			elements[i] = temp[j];
			t--;
			i++;
			j++;
		}
		return done;
	}
	@Override
	public int size() 
	{
		return elements.length;
	}
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) 
	{
		return (E) elements[index];
	}
}
class Person{
	String name;
	public Person(String name)
	{
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
public class problem3 {

	public static void main(String args[]) {
		Collector<Person> c = new Collector<Person>();
		c.add(new Person("Aaa"));
		c.add(new Person("Baa"));
		c.add(new Person("Caa"));
		System.out.println(c.size());
		c.add(new Person("Daa"));
		c.add(new Person("Eaa"));
		c.add(new Person("Faa"));
		System.out.println(c.size());
	}
}
