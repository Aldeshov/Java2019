package pack;

public class Chocolate implements Comparable <Chocolate>{
	double weight;
	String name;
	public Chocolate(String name,double weight) {
		this.name = name;
		this.weight = weight;
	}
	public String toString() {
		return name + ": " + weight;
	}
	@Override
	public int compareTo(Chocolate o) {
		if(weight > o.weight) return 1;
		if(weight < o.weight) return -1;
		return 0;
	}
}
