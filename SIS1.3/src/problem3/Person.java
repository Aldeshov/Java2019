package problem3;
class Person {
	public Gender X;
	
	Person(Gender X){
		this.X = X;
	}
	
	public String name = "";
	public String toString() {
		return X + name;
	}
}
