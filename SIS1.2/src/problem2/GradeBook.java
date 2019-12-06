package problem2;
import java.util.*;
import problem1.Student;

public class GradeBook {
	Course course;
	Vector<Student> student = new Vector <Student>();
	Vector<Integer> grades = new Vector<Integer>();
	
	GradeBook(){
		
	}
	public void displayMessage() {
		System.out.println("Welcome to the grade book for CS101 Object-oriented Programming and Design!\n");
		@SuppressWarnings("resource")
		Scanner scann = new Scanner(System.in);
		System.out.println("Please, input grades for students:");
		int grade;
		for(int i = 0; i < student.size(); i++) {
			System.out.print("Student  " + student.get(i).getName() + ":   ");
			grade = scann.nextInt();
			grades.add(grade);
		}
	}
	
	public void displayGradeReport() {
		determineClassAverage();
		outputBarChart();
	}
	
	void outputBarChart() {
		int[] abc = new int[11];
		
		for(int gr:grades) {
			int a = gr / 10;
			abc[a]++;
		}
		
		System.out.print("Grades distribution:\n");
		for(int i = 0; i < 10; i++) {
			System.out.print("\n " + i + "0" + "-" + i + "" + 9 + ":");
			for(int j = 0; j < abc[i]; j++)
				System.out.print("*");
		}
		
		System.out.print("\n  100 :");
		for(int i = 0; i < abc[10]; i++)
			System.out.print("*");
	}
	
	void determineClassAverage() {
		int maximum = -1;
		int minimum = 101;
		int sum = 0;
		int maxid = 0;
		int minid = 0;
		for(int i = 0; i < student.size(); i++) {
			sum += grades.get(i);
			if(maximum < grades.get(i)) {
				maximum = grades.get(i);
				maxid = i;
			}
			if(minimum > grades.get(i)) {
				minimum = grades.get(i);
				minid = i;
			}
		}
		int z = grades.size();
		double average = sum / z;
		System.out.print("Class average is " + average + ". Lowest grade is " + minimum + " (Student "  + student.get(minid).getName() + ", id: " + student.get(minid).getID() + ").\nHighest grade is  "  + maximum + "(Student " +student.get(maxid).getName() + ", id: "  + student.get(maxid).getID() + "). \n");
		}
	public String toString() {
		return "GradeBook";
	}
}
