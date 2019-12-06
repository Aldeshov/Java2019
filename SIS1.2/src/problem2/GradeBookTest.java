package problem2;
import problem1.Student;
import java.util.*;
public class GradeBookTest {
	public static void main(String args[]) {
		GradeBook a = new GradeBook();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Count of Student:");
		int count = scan.nextInt();
		String name;
		String id;
		for(int i = 0; i < count; i++) {
			System.out.println((i + 1) +"  Student name & ID:");
			name = scan.next();
			id = scan.next();
		    a.student.add(new Student(name,id));
		}
		//a.course.Name = "1";
		a.displayMessage();
		a.displayGradeReport();
	}
}
