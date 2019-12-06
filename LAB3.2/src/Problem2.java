public class Problem2{
	public static void main(String args[]) {
		
	}
}
////////////////////////////////////////////////////////////
abstract class Shapes3D{
	public int Heigh;
	public int LengthA;
	public int LengthB;
	public Shapes3D(){
		Heigh = 0;
		LengthA = 0;
		LengthB = 0;
	}
	public abstract double Volume();

	public abstract double SurfaceArea();
}
////////////////////////////////////////////////////////////
class Cylinder extends Shapes3D{
	int radius = 0;
	int heigh = 0;
	double PI = 3.14;
	Cylinder(int r, int h){
		super();
		heigh = h;
		radius = r;
		Heigh = heigh;
		LengthA = radius;
		LengthB = radius;
	}
	@Override
	public double Volume() {
		return Heigh * LengthA * LengthB * PI;
	}
	@Override
	public double SurfaceArea() {
		return LengthA * LengthB * PI;
	}
	
}
////////////////////////////////////////////////////////////
class Sphere extends Shapes3D{
	int radius = 0;
	double PI = 3.14;
	Sphere(int r){
		super();
		radius = r;
		Heigh = radius;
		LengthA = radius;
		LengthB = radius;
	}
	@Override
	public double Volume() {
		return  Heigh * LengthA * LengthB * PI * 4 / 3;
	}
	@Override
	public double SurfaceArea() {
		return LengthA * LengthB * PI * 4;
	}
	
}
////////////////////////////////////////////////////////////
class Cube extends Shapes3D{
	int Length;
	Cube(int l){
		super();
		Length = l;
		Heigh = Length;
		LengthA = Length;
		LengthB = Length;
	}
	@Override
	public double Volume() {
		return Heigh * LengthA * LengthB;
	}
	@Override
	public double SurfaceArea() {
		return LengthA * LengthB;
	}
}