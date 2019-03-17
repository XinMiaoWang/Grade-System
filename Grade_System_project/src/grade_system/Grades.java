package grade_system;

public class Grades {
	
	public String id, name ;
	public int lab1, lab2, lab3, midtermExam, finalExam, totalGrade;
		
		public Grades(){ }
		
		public String getID() { return id; }
		public String getName() { return name; }
		public int getLab1() { return lab1; }
		public int getLab2() { return lab2; }
		public int getLab3() { return lab3; }
		public int getMidtermExam() { return midtermExam; }
		public int getFinalExam() { return finalExam; }
		public int getTotalGrade() { return totalGrade; }
		
		public int calculateTotalGrade( float []weights ) {
			return (int)Math.round( lab1*weights[0] + lab2*weights[1] + lab3*weights[2] + midtermExam*weights[3] + finalExam*weights[4] ) ;
		}
	
}
